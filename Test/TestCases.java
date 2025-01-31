package edu.utdallas.cs4348;

import org.junit.jupiter.api.Test;

import java.util.List;

public class TestCases {

    @Test
    public void testOneMoveEach() {
        List<ChessMove> playerOneMoves =
                List.of(new ChessMove("King", 5, 1, 1, 2));
        List<ChessMove> playerTwoMoves =
                List.of(new ChessMove("Pawn", 0, 1, 1, 3));
        runTest(playerOneMoves, playerTwoMoves);

    }

    @Test
    public void testMultipleMoves() {
        List<ChessMove> playerOneMoves =
                List.of(
                        new ChessMove("King", 5, 0, 2, 2),
                        new ChessMove("Rook2", 7, 0, 7, 5),
                        new ChessMove("Knight1", 3, 0, 4, 2));
        List<ChessMove> playerTwoMoves =
                List.of(
                        new ChessMove("Pawn", 0, 1, 0, 2),
                        new ChessMove("Bishop1", 0, 2, 4, 6),
                        new ChessMove("Queen", 4, 0, 4, 7));
        runTest(playerOneMoves, playerTwoMoves);
    }

    @Test
    public void testLotsOfMoves() {
        List<ChessMove> playerOneMoves =
                List.of(
                        new ChessMove("King", 5, 0, 2, 2),
                        new ChessMove("Rook2", 7, 0, 7, 5),
                        new ChessMove("Knight1", 3, 0, 4, 2),
                        new ChessMove("King", 5, 0, 2, 2),
                        new ChessMove("Rook1", 7, 0, 7, 5),
                        new ChessMove("Knight2", 3, 0, 4, 2),
                        new ChessMove("Pawn3", 5, 0, 2, 2),
                        new ChessMove("Rook2", 7, 0, 7, 5),
                        new ChessMove("Knight2", 3, 0, 4, 2),
                        new ChessMove("Pawn7", 5, 0, 2, 2),
                        new ChessMove("Rook1", 7, 0, 7, 5),
                        new ChessMove("Queen", 3, 0, 4, 2),
                        new ChessMove("King", 5, 0, 2, 2),
                        new ChessMove("Rook2", 7, 0, 7, 5),
                        new ChessMove("Pawn3", 3, 0, 4, 2),
                        new ChessMove("King", 5, 0, 2, 2),
                        new ChessMove("Rook1", 7, 0, 7, 5),
                        new ChessMove("Knight2", 3, 0, 4, 2),
                        new ChessMove("King", 5, 0, 2, 2),
                        new ChessMove("Rook2", 7, 0, 7, 5),
                        new ChessMove("Knight1", 3, 0, 4, 2));
        List<ChessMove> playerTwoMoves =
                List.of(
                        new ChessMove("Pawn2", 0, 1, 0, 2),
                        new ChessMove("Bishop1", 0, 2, 4, 6),
                        new ChessMove("Queen", 4, 0, 4, 7),
                        new ChessMove("Pawn5", 0, 1, 0, 2),
                        new ChessMove("Bishop1", 0, 2, 4, 6),
                        new ChessMove("King", 4, 0, 4, 1),
                        new ChessMove("Pawn4", 0, 1, 0, 2),
                        new ChessMove("Bishop2", 0, 2, 4, 6),
                        new ChessMove("Queen", 4, 0, 4, 7),
                        new ChessMove("Pawn8", 0, 1, 0, 2),
                        new ChessMove("Bishop1", 0, 2, 4, 6),
                        new ChessMove("King", 4, 2, 4, 3),
                        new ChessMove("Pawn2", 0, 1, 0, 2),
                        new ChessMove("Bishop2", 0, 2, 4, 6),
                        new ChessMove("Queen", 4, 0, 4, 7),
                        new ChessMove("Pawn6", 0, 1, 0, 2),
                        new ChessMove("Bishop1", 0, 2, 4, 6),
                        new ChessMove("Queen", 4, 0, 4, 7),
                        new ChessMove("Pawn1", 0, 1, 0, 2),
                        new ChessMove("Bishop2", 0, 2, 4, 6),
                        new ChessMove("King", 4, 6, 4, 7));
        runTest(playerOneMoves, playerTwoMoves);

    }

    private void runTest(List<ChessMove> playerOneMoves, List<ChessMove> playerTwoMoves) {
        ChessMatch match = new ChessMatch();
        MoveRecord results = match.playMoves(playerOneMoves, playerTwoMoves);

        assert(results.verifyMoveOrder(playerOneMoves, playerTwoMoves));
    }
}
