package com.chess.Pieces;

import com.chess.Board;
import com.chess.Moves.Moves;
import com.chess.Player;

public class Pawn extends Piece {

    public Pawn(char name, byte row, byte column) {
        this.name = name;
        this.row = row;
        this.column = column;
        captured = false;
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
            checkMove(board, moves, opponent, attackVector, (byte)(column - 1));
        }

        if (isUpper != Character.isUpperCase(board.board[attackVector][column + 1]) && board.board[attackVector][column + 1] != 'x') {
            checkMove(board, moves, opponent, attackVector, (byte)(column + 1));
        }

        //Check if you can move
        if (board.board[attackVector][column] == 'x') {
            moves.addMove(row, column, row, column,0, this, null);
        }
    }


}
