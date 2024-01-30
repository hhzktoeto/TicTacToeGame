import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};

        printBoard(board);

        while (true) {
            playerTurn(board);
            if (isGameFinished(board)) {
                break;
            }
            printBoard(board);
            computerTurn(board);
            if (isGameFinished(board)) {
                break;
            }
            printBoard(board);
        }
        scanner.close();
    }

    private static boolean isGameFinished(char[][] board) {

        if (hasContestantWon(board, 'X')) {
            printBoard(board);
            System.out.println(Utils.YOU_WON);
            return true;
        }

        if (hasContestantWon(board, 'O')) {
            printBoard(board);
            System.out.println(Utils.YOU_LOST);
            return true;
        }



        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == Utils.BLANK) {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println(Utils.DRAW);
        return true;
    }

    private static boolean isValidMove(char[][] board, int position) {

        switch (position) {
            case 7:
                return board[0][0] == Utils.BLANK;
            case 8:
                return board[0][1] == Utils.BLANK;
            case 9:
                return board[0][2] == Utils.BLANK;
            case 4:
                return board[1][0] == Utils.BLANK;
            case 5:
                return board[1][1] == Utils.BLANK;
            case 6:
                return board[1][2] == Utils.BLANK;
            case 1:
                return board[2][0] == Utils.BLANK;
            case 2:
                return board[2][1] == Utils.BLANK;
            case 3:
                return board[2][2] == Utils.BLANK;
            default:
                return false;

        }
    }

    private static void playerTurn(char[][] board) {
        int userInput;
        while (true) {
            System.out.println("Куда поставить \"X\" (1-9)");
            userInput = scanner.nextInt();
            if (isValidMove(board, userInput)) {
                break;
            } else {
                System.out.printf("Ячейка %d занята", userInput);
                System.out.println();
            }
        }
        placeMove(board, userInput, 'X');
    }

    private static void computerTurn(char[][] board) {
        Random random = new Random();
        int computerMove;
        while (true) {
            computerMove = random.nextInt(9) + 1;
            if (isValidMove(board, computerMove)) {
                break;
            }
        }
        System.out.println("Компьютер поставил \"О\" на позицию " + computerMove);
        placeMove(board, computerMove, 'O');
    }

    private static void placeMove(char[][] board, int position, char symbol) {
        switch (position) {
            case 7:
                board[0][0] = symbol;
                break;
            case 8:
                board[0][1] = symbol;
                break;
            case 9:
                board[0][2] = symbol;
                break;
            case 4:
                board[1][0] = symbol;
                break;
            case 5:
                board[1][1] = symbol;
                break;
            case 6:
                board[1][2] = symbol;
                break;
            case 1:
                board[2][0] = symbol;
                break;
            case 2:
                board[2][1] = symbol;
                break;
            case 3:
                board[2][2] = symbol;
                break;
            default:
                System.out.println("Выбери позицию от 1 до 9");
        }
    }

    private static boolean hasContestantWon(char[][] board, char symbol) {

        if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }

    private static void printBoard(char[][] board){
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("-+-+-");
    }
}


