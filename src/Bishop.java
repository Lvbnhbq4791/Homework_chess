

public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line != toLine && column != toColumn) {
            if (Math.abs(line - toLine) == Math.abs(column - toColumn)) {
                if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
                    int x = 1;
                    int y = 1;
                    if (line < toLine && column > toColumn) {
                        x = -1;
                    }
                    if (line > toLine && column > toColumn) {
                        x = -1;
                        y = -1;
                    }
                    if (line > toLine && column < toColumn) {
                        y = -1;
                    }
                    return bishopMove(chessBoard, line, column, toLine, toColumn, x, y);
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    public boolean bishopMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn, int x, int y) {
        int d = y < 0 ? line : 7 - line;
        int a = line + y;
        int b = column + x;
        for (int c = 0; c < d; c++) {
            if (chessBoard.board[a][b] == null) {
                if (a == toLine && b == toColumn) {
                    return true;
                }
                a += y;
                b += x;
            } else {
                return bishopWins(chessBoard, toLine, toColumn, a, b);
            }
        }
        return false;
    }

    public boolean bishopWins(ChessBoard chessBoard, int toLine, int toColumn, int a, int b) {
        if (a == toLine && b == toColumn) {
            String color1 = chessBoard.board[toLine][toColumn].getColor();
            if (!color.equals(color1)) {
                return true;
            }
        }
        return false;
    }
}
