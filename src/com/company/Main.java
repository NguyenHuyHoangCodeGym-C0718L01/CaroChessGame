package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner =  new Scanner(System.in);
        String[][] board = new String[10][10];
        drawChessBoard(board);
        System.out.println("Game start");

        int playTime = board.length*board[0].length;
        int i = 0;

        while(i<playTime) {
            System.out.print("Inout the row: ");
            int a = scanner.nextInt();
            System.out.println();
            System.out.print("Input the column: ");
            int b = scanner.nextInt();
            askDirection(a, b, board);
            i++;
        }
    }

    public static void askDirection(int a, int b, String[][] board){
        if(a < board.length && b < board[a].length) {
            System.out.println("Next move: ");
            if (board[a][b] == "X" || board[a][b] == "O") {
                System.out.println("Wrong Move");
            } else {
                Scanner scanner = new Scanner(System.in);
                String c = scanner.nextLine();
                board = addCaro(a,b,c,board);
                drawChessBoard(board);
            }
        }else{
            System.out.println("Wrong direction");
        }
    }

    public static String[][] addCaro(int a, int b, String c, String[][] board){
        if(a<board.length && b<board[a].length){
            board[a][b] = c;
            System.out.println("Player just input: "+c);
        }else{
            System.out.println("Input again!");
        }
        return board;
    }

    public static void playRule(String[][] board) {
        playInHorizontal(board);
        playInVertical(board);
    }

    public static void playInHorizontal(String[][] board) {
        String[] temp = new String[board[0].length];
        for (int row = 0; row < board.length; row++) {
            int i = 0;
            for (int column = 0; column < board[row].length; column++) {
                if(board[row][column]=="X"||board[row][column]=="O"){
                    temp[i] = board[row][column];
                    i++;
                }
            }
        }
        result(temp);
    }

    public static void playInVertical(String[][] board){
        String[] temp = new String[board.length];
        for (int column = 0; column < board[0].length; column++) {
            int i = 0;
            for (int row = 0; row < board.length; row++) {
                if(board[row][column]=="X"||board[column][row]=="O"){
                    temp[i] = board[column][row];
                    i++;
                }
            }
        }
        result(temp);
    }

    public static void result(String[] temp){
        if(temp.length == 3){
            for(int i = 0; i < temp.length; i++){
                if(temp[i]=="X"||temp[i]=="O"){
                    System.out.println("You won");
                    break;
                }
            }
        }else if(temp.length > 4){
            for(int i = 0; i < temp.length; i++){
                if(temp[i]=="X" && temp[i+1]=="X" && temp[i+2]=="X" && temp[i+4]=="X" && temp[i+5]=="O"){
                    System.out.println("You won");
                    break;
                }else if(temp[i]=="O" && temp[i+1]=="O" && temp[i+2]=="O" && temp[i+4]=="O" && temp[i+5]=="X"){
                    System.out.println("You won");
                    break;
                }else if(temp[i]=="X" && temp[i+1]=="O" && temp[i+2]=="O" && temp[i+4]=="O" && temp[i+5]=="O"){
                    System.out.println("You won");
                    break;
                }else if(temp[i]=="O" && temp[i+1]=="X" && temp[i+2]=="X" && temp[i+4]=="X" && temp[i+5]=="X"){
                    System.out.println("You won");
                    break;
                }
            }
        }
    }

    public static void drawChessBoard(String[][] board){
        for(int row = 0; row < board.length; row++){
            for(int column = 0; column < board[row].length; column++){
                if(board[row][column] == null) {
                    board[row][column] = " ";
                }
                System.out.print(" | ");
                System.out.print(board[row][column]);
            }
            System.out.println();
            for(int column = 0; column < board[row].length; column++){
                System.out.print("----");
            }
            System.out.println();
        }
    }
}
