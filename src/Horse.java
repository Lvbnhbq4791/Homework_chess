public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (chessBoard.board[toLine][toColumn] == null) {
                return moveUp(line, column, toLine, toColumn);
            } else {
                String b = chessBoard.board[toLine][toColumn].getColor();
                if (!color.equals(b)) {
                    return moveUp(line, column, toLine, toColumn);
                }
            }

        }
        return false;
    }


    @Override
    public String getSymbol() {
        return "H";
    }

    public boolean moveUp(int line, int column, int toLine, int toColumn) {
        if (line + 2 == toLine && column + 1 == toColumn) {
            return true;
        }
        if (line + 2 == toLine && column - 1 == toColumn) {
            return true;
        }
        return moveDown(line, column, toLine, toColumn);
    }

    public boolean moveDown(int line, int column, int toLine, int toColumn) {
        if (line - 2 == toLine && column + 1 == toColumn) {
            return true;
        }
        if (line - 2 == toLine && column - 1 == toColumn) {
            return true;
        }
        return moveRight(line, column, toLine, toColumn);
    }

    public boolean moveRight(int line, int column, int toLine, int toColumn) {
        if (line + 1 == toLine && column + 2 == toColumn) {
            return true;
        }
        if (line - 1 == toLine && column + 2 == toColumn) {
            return true;
        }
        return moveLeft(line, column, toLine, toColumn);
    }

    public boolean moveLeft(int line, int column, int toLine, int toColumn) {
        if (line + 1 == toLine && column - 2 == toColumn) {
            return true;
        }
        if (line - 1 == toLine && column - 2 == toColumn) {
            return true;
        }
        return false;
    }
}
