package com.chess;

public class Board {

    public char [][] board;

    public Board() {
        board = new char[8][8];

        //Create empty spaces
        for (int x = 2; x < 6; x++) {
            for (int y = 0; y < 8; y++) {
                board[x][y] = 'x';
            }
        }

        //Create black pawns
        for (int x = 0; x < 8; x++) {
            board[1][x] = 'p';
        }

        //Create white pawns
        for (int x = 0; x < 8; x++) {
            board[6][x] = 'P';
        }

        //Create rooks
        board[0][0] = 'r';
        board[0][7] = 'r';
        board[7][0] = 'R';
        board[7][7] = 'R';

        //Create bishops
        board[0][1] = 'b';
        board[0][6] = 'b';
        board[7][1] = 'B';
        board[7][6] = 'B';

        //Create knights
        board[0][2] = 'n';
        board[0][5] = 'n';
        board[7][2] = 'N';
        board[7][5] = 'N';

        //Create kings
        board[0][3] = 'k';
        board[7][3] = 'K';

        //Create queens
        board[0][4] = 'q';
        board[7][4] = 'Q';
    }

    public void printBoard() {
        for (char[] array : board) {
            System.out.println(array);
        }
    }
}
