package Main;

import java.util.Scanner;

enum Status {
    // there is a row, column or diagonal consisting of only player1's game pieces:
    PLAYER1_WON,
    // there is a row, column or diagonal consisting of only player2's game pieces:
    PLAYER2_WON,
    // there is no row, column, or diagonal consisting of a single player's pieces:
    TIE,
    // there are spots on the board which are uninitialized;
    UNFINISHED
}

public class Game {
    Player player1;
    Player player2;
    Board board;

    // this function should prompt the players for names and gamePiece and assign it
    // to the player objects:
    private void initPlayers() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Player 1 enter name: ");
        String p1Name = scan.nextLine();
        System.out.print("Player 1 enter game piece: ");
        char p1GamePiece = scan.nextLine().charAt(0);
        System.out.print("Player 2 enter name: ");
        String p2Name = scan.nextLine();
        System.out.print("Player 2 enter game piece: ");
        char p2GamePiece = scan.nextLine().charAt(0);

        this.player1 = new Player(p1Name, p1GamePiece);
        this.player2 = new Player(p2Name, p2GamePiece);
    }

    // this method should let each player pick a spot and also print the board between selections:
    private void round(boolean turn) {
        Scanner scan = new Scanner(System.in);
        if(!turn) {
            System.out.print("Player 1 select row: ");
            int p1Row = scan.nextInt();
            System.out.print("Player 1 select column: ");
            int p1Column = scan.nextInt();
            this.board.updateBoard(p1Row, p1Column, this.player1.getGamePiece());
            System.out.println(this.board.toString());
        }
        else {
            System.out.print("Player 2 select row: ");
            int p2Row = scan.nextInt();
            System.out.print("Player 2 select column: ");
            int p2Column = scan.nextInt();
            this.board.updateBoard(p2Row, p2Column, this.player2.getGamePiece());
            System.out.println(this.board.toString());
        }

    }

    // This should return a status of the board, using the enum Status:
    private Status getStatus() {
        char p1 = player1.getGamePiece();

        if((this.board.board[0][0] == this.board.board[0][1]) && (this.board.board[0][0] == this.board.board[0][2]) && (this.board.board[0][0] != 0)){
            if(p1 == this.board.board[0][0]) return Status.PLAYER1_WON;
            else return Status.PLAYER2_WON;
        }
        if((this.board.board[1][0] == this.board.board[1][1]) && (this.board.board[1][0] == this.board.board[1][2]) && (this.board.board[1][0] != 0)){
            if(p1 == this.board.board[1][0]) return Status.PLAYER1_WON;
            else return Status.PLAYER2_WON;
        }
        if((this.board.board[2][0] == this.board.board[2][1]) && (this.board.board[2][0] == this.board.board[2][2]) && (this.board.board[2][0] != 0)){
            if(p1 == this.board.board[2][0]) return Status.PLAYER1_WON;
            else return Status.PLAYER2_WON;
        }
        if((this.board.board[0][0] == this.board.board[1][0]) && (this.board.board[0][0] == this.board.board[2][0]) && (this.board.board[0][0] != 0)){
            if(p1 == this.board.board[0][0]) return Status.PLAYER1_WON;
            else return Status.PLAYER2_WON;
        }
        if((this.board.board[0][1] == this.board.board[1][1]) && (this.board.board[0][1] == this.board.board[2][1]) && (this.board.board[0][1] != 0)){
            if(p1 == this.board.board[0][1]) return Status.PLAYER1_WON;
            else return Status.PLAYER2_WON;
        }
        if((this.board.board[0][2] == this.board.board[1][2]) && (this.board.board[0][2] == this.board.board[2][2]) && (this.board.board[0][2] != 0)){
            if(p1 == this.board.board[0][2]) return Status.PLAYER1_WON;
            else return Status.PLAYER2_WON;
        }
        if((this.board.board[0][0] == this.board.board[1][1]) && (this.board.board[0][0] == this.board.board[2][2]) && (this.board.board[0][0] != 0)){
            if(p1 == this.board.board[0][0]) return Status.PLAYER1_WON;
            else return Status.PLAYER2_WON;
        }
        if((this.board.board[2][0] == this.board.board[1][1]) && (this.board.board[2][0] == this.board.board[0][2]) && (this.board.board[2][0] != 0)){
            if(p1 == this.board.board[2][0]) return Status.PLAYER1_WON;
            else return Status.PLAYER2_WON;
        }

        boolean tie = true;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {
                if(this.board.board[i][j] == 0) {
                    tie = false;
                    break;
                }
            }
        }

        if(tie) return Status.TIE;
        else return Status.UNFINISHED;

    }

    // 1. Set up, ask players for names and game piece
    // 2. For each round, let each player pick a spot
    // 3. Print the board after each move:
    // 4. When the game is over, announce the winner or that it is a tie
    public static void main(String[] args) {

        Game game = new Game();
        game.initPlayers();
        game.board = new Board();
        System.out.println(game.board.toString());
        boolean turn = false;

        while(game.getStatus() == Status.UNFINISHED){
            game.round(turn);
            if(turn) turn = false;
            else turn = true;
        }

        if(game.getStatus() == Status.PLAYER1_WON){
            System.out.println("Congrats " + game.player1.getName() + " on winning!!");
        }
        else if(game.getStatus() == Status.PLAYER2_WON){
            System.out.println("Congrats " + game.player2.getName() + " on winning!!");
        }
        else System.out.println("Tie game! Better luck next time!");
    }
}