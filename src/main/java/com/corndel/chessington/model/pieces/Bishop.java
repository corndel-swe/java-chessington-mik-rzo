package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {

  public Bishop(PlayerColour colour) {
    super(PieceType.BISHOP, colour);
  }

  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();

    // bishop going up and left
    for (int i = 1; from.getRow() - i >= 0 && from.getCol() - i >= 0; i++) {
      if (board.get(from.plus(-i, -i)) == null) {
        allowedMoves.add(new Move(from, from.plus(-i, -i)));
      } else if (board.get(from.plus(-i, -i)).getColour() != this.getColour()) {
        allowedMoves.add(new Move(from, from.plus(-i, -i)));
        break;
      } else {
        break;
      }
    }
    // bishop going up and right
    for (int i = 1; from.getRow() - i >= 0 && from.getCol() + i <= 7; i++) {
      if (board.get(from.plus(-i, i)) == null) {
        allowedMoves.add(new Move(from, from.plus(-i, i)));
      } else if (board.get(from.plus(-i, i)).getColour() != this.getColour()) {
        allowedMoves.add(new Move(from, from.plus(-i, i)));
        break;
      } else {
        break;
      }
    }
    // bishop going down and left
    for (int i = 1; from.getRow() + i <= 7 && from.getCol() - i >= 0; i++) {
      if (board.get(from.plus(i, -i)) == null) {
        allowedMoves.add(new Move(from, from.plus(i, -i)));
      } else if (board.get(from.plus(i, -i)).getColour() != this.getColour()) {
        allowedMoves.add(new Move(from, from.plus(i, -i)));
        break;
      } else {
        break;
      }
    }
    // bishop going down and right
    for (int i = 1; from.getRow() + i <= 7 && from.getCol() + i <= 7; i++) {
      if (board.get(from.plus(i, i)) == null) {
        allowedMoves.add(new Move(from, from.plus(i, i)));
      } else if (board.get(from.plus(i, i)).getColour() != this.getColour()) {
        allowedMoves.add(new Move(from, from.plus(i, i)));
        break;
      } else {
        break;
      }
    }

    return allowedMoves;
  }
}
