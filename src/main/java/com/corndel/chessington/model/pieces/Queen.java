package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import java.util.ArrayList;
import java.util.List;

public class Queen extends AbstractPiece {

  public Queen(PlayerColour colour) {
    super(PieceType.QUEEN, colour);
  }

  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();

    // copy Rook's behaviour
    Rook rook = new Rook(getColour());
    allowedMoves.addAll(rook.getAllowedMoves(from, board));

    // copy Bishop's behaviour
    Bishop bishop = new Bishop(getColour());
    allowedMoves.addAll(bishop.getAllowedMoves(from, board));

    return allowedMoves;
  }
}
