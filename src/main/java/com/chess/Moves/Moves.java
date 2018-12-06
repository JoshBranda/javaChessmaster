package com.chess.Moves;

import com.chess.Pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Moves {

    private List<Move> moves;

    public Moves() {moves = new ArrayList<>(); }

    public void addMove (byte oldRow, byte oldColumn, byte newRow, byte newColumn, int value, Piece fromPiece, Piece toPiece) {
        moves.add(new Move (oldRow, oldColumn, newRow, newColumn, value, fromPiece, toPiece));
    }
}
