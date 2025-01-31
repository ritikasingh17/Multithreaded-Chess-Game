package edu.utdallas.cs4348;

public final class ChessMove {
    private final String piece;
    private final int xStart;

    private final int yStart;
    private final int xEnd;
    private final int yEnd;

    public ChessMove(final String piece, final int xStart, final int yStart, final int xEnd, final int yEnd) {
        this.piece = piece;
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    @Override
    public String toString() {
        return "Move: " + piece + " from " + xStart + ", " + yStart + " to " + xEnd + ", " + yEnd;
    }

    @Override
    public boolean equals(Object obj) {
        if ( !(obj instanceof ChessMove)) {
            return false;
        }
        ChessMove other = (ChessMove) obj;
        return ( (this.piece.equals(other.piece)) &&
                (this.xStart == other.xStart) &&
                (this.yStart == other.yStart) &&
                (this.xEnd == other.xEnd) &&
                (this.yEnd == other.yEnd) );
    }

    public String getPiece() {
        return piece;
    }


    public int getxStart() {
        return xStart;
    }

    public int getyStart() {
        return yStart;
    }

    public int getxEnd() {
        return xEnd;
    }

    public int getyEnd() {
        return yEnd;
    }

}
