package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstractPiece {

  public Knight(PlayerColour colour) {
    super(PieceType.KNIGHT, colour);
  }

  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();

    for (int i = -2; i < 3; i++) {
      // skip current knight coordinate
      if (i == 0) {
        continue;
      // check if going out of bounds
      } else if (from.getRow() + i < 0 || from.getRow() + i > 7) {
        continue;
      }
      for (int j = -2; j < 3; j++) {
        // skip current knight coordinate
        if (j == 0) {
          continue;
        // check if going out of bounds
        } else if (from.getCol() + j < 0 || from.getCol() + j > 7) {
          continue;
        // does knight move in L shape (two squares then one square)
        } else if (Math.abs(i) + Math.abs(j) != 3) {
          continue;
        }
        // ensures knight doesn't land on friendly piece
        if (board.get(from.plus(i, j)) != null) {
          if (getColour() == board.get(from.plus(i, j)).getColour()) {
            continue;
          }
        }
        allowedMoves.add(new Move(from, from.plus(i, j)));
      }
    }
    return allowedMoves;
  }
}
