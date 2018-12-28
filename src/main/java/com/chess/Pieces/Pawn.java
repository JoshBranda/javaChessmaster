package com.chess.Pieces;

import com.chess.Board;
import com.chess.Moves.Moves;
import com.chess.Player;

public class Pawn extends Piece {
    private boolean firstMove;

    public Pawn(char name, int row, int column) {
        super(name, row, column);
        if (name == 'P') {
            isUpper = true;
        }
        else {
            isUpper = false;
        }
        firstMove = true;
    }

    public void checkMoves(Board board, Moves moves, Player opponent) {
        if (captured) {
            return;
        }

        int attackVector = row;

        //If white, check for up attack
        if (isUpper) {
            attackVector--;
        }
        else {
            attackVector++;
        }

        //Check if you can attack left
        if (column != 0 && isUpper != Character.isUpperCase(board.board[attackVector][column - 1]) && board.board[attackVector][column - 1] != 'x') {
            moves.addMove(row, column, attackVector, column - 1,0, this, opponent.findPiece(attackVector, column - 1));
        }

        //Check if you can attack right
        if (column != 7 && isUpper != Character.isUpperCase(board.board[attackVector][column + 1]) && board.board[attackVector][column + 1] != 'x') {
            moves.addMove(row, column, attackVector, column + 1,0, this, opponent.findPiece(attackVector, column + 1));
        }

        //Check if you can move
        if (board.board[attackVector][column] == 'x') {
            moves.addMove(row, column, attackVector, column,0, this, null);
        }

        //Paws are allowed to move 2 spaces on the first move.
        if (firstMove) {
            firstMove = false;
            if (attackVector < row) {
                moves.addMove(row, column, attackVector - 1, column, 0, this, null);
            }
            else {
                moves.addMove(row, column, attackVector - 1, column, 0, this, null);
            }
        }
    }


}
