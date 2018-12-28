package com.chess;

import com.chess.Pieces.Pawn;
import com.chess.Pieces.Piece;

import java.util.List;

public class Player {

    Piece []    pieces;
    char        color;

    public Player(char color) {
        this.color = color;
        int row1 = 0;
        int row2 = 1;

        if (color == 'w') {
            row1 = (int) 7;
            row2 = (int) 6;
        }

        pieces = new Piece[16];

        //Initiate Pawn objects for player
        for (int x = 0; x < 8; x++) {
            pieces[x] = new Pawn(makeUpper('p'), row2, x);
        }

        //Initiate Rooks
    }

    public char makeUpper(char name) {
        if (color == 'w') {
            return Character.toUpperCase(name);
        }
        return name;
    }

    public Piece findPiece(int row, int column) {
        for (Piece piece : pieces) {
            if (piece.getRow() == row && piece.getColumn() == column) {
                return piece;
            }
        }
        return null;
    }

}
