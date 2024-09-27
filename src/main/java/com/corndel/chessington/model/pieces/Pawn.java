package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {

  public Pawn(PlayerColour colour) {
    super(PieceType.PAWN, colour);
  }

  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();

    int direction = getColour().equals(PlayerColour.WHITE) ? -1 : 1;

    // pawn reaches end of board
    boolean whitePawnTopOfBoard = direction == -1 && from.getRow() == 0;
    boolean blackPawnBottomOfBoard = direction == 1 && from.getRow() == 7;
    if (whitePawnTopOfBoard || blackPawnBottomOfBoard) {
      return allowedMoves;
    }
    // no pieces in front of pawn
    if (board.get(from.plus(direction, 0)) == null) {
      allowedMoves.add(new Move(from, from.plus(direction, 0)));
    }

    // start position of pawn
    boolean startingPositionWhite = direction == -1 && from.getRow() == 6;
    boolean startingPositionBlack = direction == 1 && from.getRow() == 1;
    if (startingPositionBlack || startingPositionWhite) {
      allowedMoves.add(new Move(from, from.plus(direction * 2, 0)));
    }

    // can capture diagonally
    if (from.getCol() - 1 >= 0) {
      if (board.get(from.plus(direction, -1)) != null) {
        if (getColour() != board.get(from.plus(direction, -1)).getColour()) {
          allowedMoves.add(new Move(from, from.plus(direction, -1)));
        }
      }
    }
    if (from.getCol() + 1 <= 7) {
      if (board.get(from.plus(direction, 1)) != null) {
        if (getColour() != board.get(from.plus(direction, 1)).getColour()) {
          allowedMoves.add(new Move(from, from.plus(direction, 1)));
        }
      }
    }

    return allowedMoves;
  }
}
