package edu.utdallas.cs4348;

import java.util.ArrayList;
import java.util.List;

public final class MoveRecord {

    private final List<ChessMove> moves = new ArrayList<>();

    public void addMove(ChessMove moveRecord) {
        moves.add(moveRecord);
    }

    public boolean verifyMoveOrder(List<ChessMove> firstPlayer, List<ChessMove> secondPlayer) {
        if ( moves.size() != (firstPlayer.size()) + secondPlayer.size()) {
            System.err.println("Wrong number of moves played!");
            return false;
        }
        final int movesForBoth = Math.min(firstPlayer.size(), secondPlayer.size());
        int allMovesCounter = 0;
        for ( int i=0; i<movesForBoth; i++) {
            if ( !firstPlayer.get(i).equals(moves.get(allMovesCounter))) {
                System.err.println("First player move " + firstPlayer.get(i) + " doesn't match " + moves.get(allMovesCounter));
                return false;
            }
            allMovesCounter++;
            if ( !secondPlayer.get(i).equals(moves.get(allMovesCounter))) {
                System.err.println("Second player move " + secondPlayer.get(i) + " doesn't match " + moves.get(allMovesCounter));
                return false;
            }
            allMovesCounter++;
        }
        if ( firstPlayer.size() > secondPlayer.size()) {
            for ( int i=secondPlayer.size(); i<firstPlayer.size(); i++) {
                if ( !firstPlayer.get(i).equals(moves.get(allMovesCounter))) {
                    System.err.println("First player move " + firstPlayer.get(i) + " doesn't match " + moves.get(allMovesCounter));
                    return false;
                }
                allMovesCounter++;
            }
        }
        return true;
    }
}
