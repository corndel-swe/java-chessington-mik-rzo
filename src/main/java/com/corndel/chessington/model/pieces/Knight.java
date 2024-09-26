package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import java.util.ArrayList;
import java.util.List;

public class Knight implements Piece {

  private final Piece.PieceType type;
  protected final PlayerColour colour;

  public Knight(PlayerColour colour) {
    this.type = PieceType.KNIGHT;
    this.colour = colour;
  }

  @Override
  public Piece.PieceType getType() {
    return type;
  }

  @Override
  public PlayerColour getColour() {
    return colour;
  }

  @Override
  public String toString() {
    return colour.toString() + " " + type.toString();
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();

    for (int i = -2; i < 3; i++) {
      if (i == 0) {
        continue;
      } else if (from.getRow() + i < 0 || from.getRow() + i > 7) {
        continue;
      }
      for (int j = -2; j < 3; j++) {
        if (j == 0) {
          continue;
        } else if (from.getCol() + j < 0 || from.getCol() + j > 7) {
          continue;
        } else if (Math.abs(i) + Math.abs(j) != 3) {
          continue;
        }
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
