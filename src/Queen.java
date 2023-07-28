public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        Bishop bishop = new Bishop(this.getColor());
        if (Math.abs(line - toLine) == Math.abs(column - toColumn)) {
            return bishop.canMoveToPosition(chessBoard, line, column, toLine, toColumn);
        }
        Rook rook = new Rook(this.getColor());
        return rook.canMoveToPosition(chessBoard, line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
