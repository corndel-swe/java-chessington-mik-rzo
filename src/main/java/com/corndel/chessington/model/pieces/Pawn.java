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

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();
    if (getColour().equals(PlayerColour.WHITE)) {
      // pawn reaches end of board
      if (from.getRow() == 0) {
        return allowedMoves;
      }
      // no pieces directly in front
      if (board.get(from.plus(-1, 0)) == null) {
        allowedMoves.add(new Move(from, from.plus(-1, 0)));
      }
      // start position of pawn
      if (from.getRow() == 6) {
        // no pieces two squares in front
        if (board.get(from.plus(-2, 0)) == null) {
          allowedMoves.add(new Move(from, from.plus(-2, 0)));
        }
      }
      // can move diagonally if enemy piece is there and not going out of bounds
      if (from.getCol() != 7) {
        if (board.get(from.plus(-1, 1)) != null) {
          if (board.get(from.plus(-1, 1)).getColour() != PlayerColour.WHITE) {
            allowedMoves.add(new Move(from, from.plus(-1, 1)));
          }
        }
      }
      if (from.getCol() != 0) {
        if (board.get(from.plus(-1, -1)) != null) {
          if (board.get(from.plus(-1, -1)).getColour() != PlayerColour.WHITE) {
            allowedMoves.add(new Move(from, from.plus(-1, -1)));
          }
        }
      }
    } else {
      if (from.getRow() == 7) {
        return allowedMoves;
      }
      if (board.get(from.plus(1, 0)) == null && from.getRow() != 7) {
        allowedMoves.add(new Move(from, from.plus(1, 0)));
      }
      if (from.getRow() == 1) {
        if (board.get(from.plus(2, 0)) == null) {
          allowedMoves.add(new Move(from, from.plus(2, 0)));
        }
      }
      if (from.getCol() != 7) {
        if (board.get(from.plus(1, 1)) != null) {
          if (board.get(from.plus(1, 1)).getColour() != PlayerColour.BLACK) {
            allowedMoves.add(new Move(from, from.plus(1, 1)));
          }
        }
      }
      if (from.getCol() != 0) {
        if (board.get(from.plus(1, -1)) != null) {
          if (board.get(from.plus(1, -1)).getColour() != PlayerColour.BLACK) {
            allowedMoves.add(new Move(from, from.plus(1, -1)));
          }
        }
      }
    }

    return allowedMoves;
  }
}
