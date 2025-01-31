package edu.utdallas.cs4348;

import java.util.List;

public class ChessMatch {
    // Do not modify these, and do not add any other member variables to this class
    private ChessMove playerOneMove;
    private ChessMove playerTwoMove;

    // Your private Runnable implementations here
    private class Ritika implements Runnable {
        private List<ChessMove> chessMoves;
        private MoveRecord moveRecord;

        public Ritika(List<ChessMove> chessMoves, MoveRecord moveRecord) {
            this.chessMoves = chessMoves;
            this.moveRecord = moveRecord;
        }

        public void run() {
            synchronized (ChessMatch.this) {
                for (ChessMove move : chessMoves) {
                    playerOneMove = move;
                    ChessMatch.this.notify();
                    while (playerTwoMove == null) {
                        try {
                            ChessMatch.this.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    moveRecord.addMove(playerTwoMove);
                    playerTwoMove = null;
                }
            }
        }
    }

    private class Singh implements Runnable {
        private List<ChessMove> chessMoves;
        private MoveRecord moveRecord;

        public Singh(List<ChessMove> chessMoves, MoveRecord moveRecord) {
            this.chessMoves = chessMoves;
            this.moveRecord = moveRecord;
        }

        public void run() {
            synchronized (ChessMatch.this) {
                for (ChessMove move : chessMoves) {
                    while (playerOneMove == null) {
                        try {
                            ChessMatch.this.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    moveRecord.addMove(playerOneMove);
                    playerOneMove = null;
                    playerTwoMove = move;
                    ChessMatch.this.notify();
                }
            }
        }
    }

    public MoveRecord playMoves(List<ChessMove> playerOneMoves, List<ChessMove> playerTwoMoves) {
        MoveRecord moveRecord = new MoveRecord();

        Thread playerOneThread = new Thread(new Ritika(playerOneMoves, moveRecord));
        Thread playerTwoThread = new Thread(new Singh(playerTwoMoves, moveRecord));

        playerOneThread.start();
        playerTwoThread.start();

        try {
            playerOneThread.join(2000);
            playerTwoThread.join(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (playerOneThread.isAlive() || playerTwoThread.isAlive()) {
            throw new RuntimeException("Threads did not complete in time.");
        }

        return moveRecord;
    }
}
