package com.chess.Moves;

import com.chess.Board;
import com.chess.Pieces.Piece;

public class Move {
    private byte oldRow, oldColumn, newRow, newColumn;
    private int value;
    private Piece fromPiece, toPiece;

    public Move (byte oldRow, byte oldColumn, byte newRow, byte newColumn, int value, Piece fromPiece, Piece toPiece) {

        this.oldRow         = oldRow;
        this.oldColumn      = oldColumn;
        this.newRow         = newRow;
        this.newColumn      = newColumn;
        this.value          = value;
        this.fromPiece      = fromPiece;
        this.toPiece        = toPiece;
    }

    public void makeMove(Board board) {
        char moving = board.board[oldRow][oldColumn];
        board.board[oldRow][oldColumn] = 'x';

        if (toPiece != null) {
            toPiece.setCaptured(true);
        }
    }
}
