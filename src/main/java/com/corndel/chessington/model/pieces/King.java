package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import java.util.ArrayList;
import java.util.List;

public class King extends AbstractPiece {

  protected boolean moved = false;

  public King(PlayerColour colour) {
    super(PieceType.KING, colour);
  }

  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();

    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        // king can't move to own square
        if (i == 0 && j == 0) {
          continue;
        }
        // check if king goes out of bounds
        if (from.getRow() + i < 0 || from.getRow() + i > 7) {
          continue;
        }
        if (from.getCol() + j <  0 || from.getCol() + j > 7) {
          continue;
        }
        // king can't take friendly piece
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
