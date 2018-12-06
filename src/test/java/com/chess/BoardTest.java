package com.chess;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void printBoard() {
        Board board = new Board();
        board.printBoard();
    }
}