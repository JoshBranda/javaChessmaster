package com.chess.Pieces;

import com.chess.Board;
import com.chess.Moves.Move;
import com.chess.Moves.Moves;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RookTest {


    @Test
    public void noMoveOptionsAtStart() {
        Board board = new Board();
        Rook rook = new Rook('r', 0,0);
        Moves moves = new Moves();

        rook.checkMoves(board, moves, null);

        List<Move> move = moves.getMoves();

        assertTrue(move.isEmpty());
    }
}