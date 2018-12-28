package com.chess.Pieces;

import com.chess.Board;
import com.chess.Moves.Moves;
import com.chess.Player;

abstract public class Piece {

    //Fields
    protected char      name;
    protected int      row;
    protected int      column;
    protected boolean   captured;
    protected boolean   isUpper;

    //Abstract methods
    public abstract void checkMoves(Board board, Moves moves, Player opponent);

    //Implemented methods
    public Piece (char name, int row, int column) {
        this.name = name;
        this.row = row;
        this.column = column;
        captured = false;
    }
    public int getRow() {return row;}
    public int getColumn() {return column;}
    public void setCaptured(boolean captured){this.captured = captured;}

    public boolean checkMove(Board board, Moves moves, Player opponent, int row, int column) {

        //Add a non-attack move to the list of options
        if (board.board[row][column] == 'x') {
            moves.addMove(row, column, row, column,0, this, null);
            return false;
        }

        //Piece from same player, ignore and stop checking this direction
        if (isUpper == Character.isUpperCase(board.board[row][column])) {
            return true;
        }

        //Piece from opposite player, add attack move
        moves.addMove(row, column, row, column,0, this, opponent.findPiece(row, column));
        return true;
    }

    public void perpendicular(Board board, Moves moves, Player opponent) {

        //Checking south
        for (int x = (row + 1); x < 8; x++) {
            if (checkMove(board, moves, opponent, x, column)) {
                break;
            }
        }

        //Checking north
        for (int x = (row - 1); x >= 0; x--) {
            if (checkMove(board, moves, opponent, x, column)) {
                break;
            }
        }

        //Checking west
        for (int x = (column - 1); x >= 0; x--) {
            if (checkMove(board, moves, opponent, row, x)) {
                break;
            }
        }

        //Checking east
        for (int x = (column + 1); x < 8; x++) {
            if (checkMove(board, moves, opponent, row, x)) {
                break;
            }
        }

    }

    public void diagonal (Board board, Moves moves, Player opponent) {

        //Checking up-left
        for (int x = (row - 1), y = (column - 1); x >= 0 && y >= 0; x--, y--) {
            if (checkMove(board, moves, opponent, x, y)) {
                break;
            }
        }

        //Checking up-right
        for (int x = (row - 1), y = (column + 1); x >= 0 && y < 8; x--, y++) {
            if (checkMove(board, moves, opponent, x, y)) {
                break;
            }
        }

        //Checking down-right
        for (int x = (row + 1), y = (column + 1); x < 8 && y < 8; x++, y++) {
            if (checkMove(board, moves, opponent, x, y)) {
                break;
            }
        }

        //Checking down-left
        for (int x = (row + 1), y = (column - 1); x < 8 && y >= 0; x++, y--) {
            if (checkMove(board, moves, opponent, x, y)) {
                break;
            }
        }
    }

}
