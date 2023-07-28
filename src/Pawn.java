public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (color.equals("White")) {
                return whitePawnMove(chessBoard, line, column, toLine, toColumn);
            } else {
                return blackPawnMove(chessBoard, line, column, toLine, toColumn);
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    private boolean whitePawnMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (column == toColumn) {
            if (chessBoard.board[line + 1][column] == null && line + 1 == toLine) {//chessBoard.board[line + 2][column] == null) {
                return true;
            }
            else if (line == 1) {
                if (chessBoard.board[line + 1][column] == null && chessBoard.board[line + 2][column] == null) {
                    return line + 2 == toLine;
                }
            }
        } else if (line + 1 == toLine) {
            return pawnWins(chessBoard, line, column, toLine, toColumn);
        }
        return false;
    }

    public boolean pawnWins(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (column - 1 >= 0 && column + 1 <= 7) {
            if (column + 1 == toColumn || column - 1 == toColumn) {
                if (chessBoard.board[toLine][toColumn] != null) {
                    if (!chessBoard.board[line][column].getColor().equals(chessBoard.board[toLine][toColumn].getColor())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean blackPawnMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (column == toColumn) {
            if (chessBoard.board[line - 1][column] == null && line - 1 == toLine) {
                return true;
            } else if (line == 6) {
                if (chessBoard.board[line - 1][column] == null && chessBoard.board[line - 2][column] == null) {
                    return line - 2 == toLine;
                }
            }
        } else if (line - 1 == toLine) {
            return pawnWins(chessBoard, line, column, toLine, toColumn);
        }
        return false;
    }
}