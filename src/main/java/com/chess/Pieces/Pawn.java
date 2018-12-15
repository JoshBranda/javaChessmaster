package com.chess.Pieces;

import com.chess.Board;
import com.chess.Moves.Moves;
import com.chess.Player;

public class Pawn extends Piece {

    public Pawn(char name, byte row, byte column) {
        super(name, row, column);
        if (name == 'P') {
            isUpper = true;
        }
        else {
            isUpper = false;
        }
    }

    public void checkMoves(Board board, Moves moves, Player opponent) {
        if (captured) {
            return;
        }

        byte attackVector = row;

        if (isUpper) {
            attackVector--;
        }
        else {
            attackVector++;
        }

        //Check if you can attack
        if (isUpper != Character.isUpperCase(board.board[attackVector][column - 1]) && board.board[attackVector][column - 1] != 'x') {
            moves.addMove(row, column, row, column,0, this, opponent.findPiece(row, column));
        }

        if (isUpper != Character.isUpperCase(board.board[attackVector][column + 1]) && board.board[attackVector][column + 1] != 'x') {
            moves.addMove(row, column, row, column,0, this, opponent.findPiece(row, column));
        }

        //Check if you can move
        if (board.board[attackVector][column] == 'x') {
            moves.addMove(row, column, row, column,0, this, null);
        }
    }


}
