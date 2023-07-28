public class King extends ChessPiece {
    public King(String color) {
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
            if (Math.abs(line - toLine) == 1) {
                return bishop.canMoveToPosition(chessBoard, line, column, toLine, toColumn);
            }
        }
        if (Math.abs(line - toLine) == 1 || Math.abs(column - toColumn) == 1) {
            Rook rook = new Rook(this.getColor());
            return rook.canMoveToPosition(chessBoard, line, column, toLine, toColumn);
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
                ChessPiece figure = board.board[a][b];
                if(figure != null && !color.equals(figure.getColor())){
                    return figure.canMoveToPosition(board,a,b,line,column);
                }
            }
        }
        return false;
    }
}
