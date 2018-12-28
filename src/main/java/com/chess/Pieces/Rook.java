package com.chess.Pieces;

import com.chess.Board;
import com.chess.Moves.Moves;
import com.chess.Player;

public class Rook extends Piece{

    public Rook(char name, int row, int column) {
        super(name, row, column);
        if (name == 'R') {
            isUpper = true;
        }
        else {
            isUpper = false;
        }
    }

    public void checkMoves(Board board, Moves moves, Player opponent) {
        perpendicular(board, moves, opponent);
    }
}
