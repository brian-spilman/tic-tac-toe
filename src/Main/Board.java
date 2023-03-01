package Main;

public class Board {
    // a 2D array to represent the pieces on the board:
    char [][] board;

    // should instantiate the board to be a 3x3 array:
    public Board() {
        this.board = new char[3][3];
    }

    // this method should take in a row, column, and a newChar and update the board accordingly:
    public void updateBoard(int row, int column, char newChar) {
        this.board[row][column] = newChar;
    }

    // this method should return a string representation of the board:
    public String toString() {
        String boardRepresentation = "";
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {
                boardRepresentation = boardRepresentation + this.board[i][j] + " ";
            }
            boardRepresentation += "\n";
        }
        return boardRepresentation;
    }
}
