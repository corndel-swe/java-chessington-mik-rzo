package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {

  public Rook(PlayerColour colour) {
    super(PieceType.ROOK, colour);
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();
    // rook going left
    for (int i = 1; from.getCol() - i >= 0; i++) {
      if (board.get(from.plus(0, -i)) == null) {
        allowedMoves.add(new Move(from, from.plus(0, -i)));
      } else if (board.get(from.plus(0, -i)).getColour() != this.getColour()) {
        allowedMoves.add(new Move(from, from.plus(0, -i)));
        break;
      } else {
        break;
      }
    }
    // rook going right
    for (int i = 1; from.getCol() + i <= 7; i++) {
      if (board.get(from.plus(0, i)) == null) {
        allowedMoves.add(new Move(from, from.plus(0, i)));
      } else if (board.get(from.plus(0, i)).getColour() != this.getColour()) {
        allowedMoves.add(new Move(from, from.plus(0, i)));
        break;
      } else {
        break;
      }
    }
    // rook going up
    for (int i = 1; from.getRow() - i >= 0; i++) {
      if (board.get(from.plus(-i, 0)) == null) {
        allowedMoves.add(new Move(from, from.plus(-i, 0)));
      } else if (board.get(from.plus(-i, 0)).getColour() != this.getColour()) {
        allowedMoves.add(new Move(from, from.plus(-i, 0)));
        break;
      } else {
        break;
      }
    }
    // rook going down
    for (int i = 1; from.getRow() + i <= 7; i++) {
      if (board.get(from.plus(i, 0)) == null) {
        allowedMoves.add(new Move(from, from.plus(i, 0)));
      } else if (board.get(from.plus(i, 0)).getColour() != this.getColour()) {
        allowedMoves.add(new Move(from, from.plus(i, 0)));
        break;
      } else {
        break;
      }
    }

    return allowedMoves;
  }
}
