public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (line == toLine) {

                return moveRightLeft(chessBoard, line, column, toLine, toColumn);
            }
            if (column == toColumn) {
                return moveUpDown(chessBoard, line, column, toLine, toColumn);
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    public boolean moveUpDown(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int d = 8;
        int a = toLine < line ? -1 : 1;
        int b = line + a;
        int y = toLine < line ? line - toLine : toLine - line;
        for (int c = 0; c < y; c++){
            if (chessBoard.board[b][column] == null){
                if(b == toLine){
                    return true;
                }
                b += a;
            } else {
                return rookWins(chessBoard, toLine, toColumn, b, d);
            }
        }
        return false;
    }

    public boolean moveRightLeft(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int b = 8;
        int a = toColumn < column ? -1 : 1;
        int d = line + a;
        int y = toColumn < column ? column - toColumn : toColumn - column;
        for (int c = 0; c < y; c++){
            if (chessBoard.board[line][d] == null){
                if(d == toColumn){
                    return true;
                }
                d += a;
            } else {
                return rookWins(chessBoard, toLine, toColumn, b, d);
            }
        }
        return false;
    }
    public boolean rookWins(ChessBoard chessBoard, int toLine, int toColumn, int b, int d){
        if (b == toLine || d == toColumn) {
            String color1 = chessBoard.board[toLine][toColumn].getColor();
            if (!color.equals(color1)) {
                return true;
            }
        }
        return false;
    }
}
