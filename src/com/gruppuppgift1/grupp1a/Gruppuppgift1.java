package com.gruppuppgift1.grupp1a;

import java.util.Random;
import java.util.Scanner;

public class Gruppuppgift1  {

	public static void main(String[] args) {

		// Gruppuppgift1, Grupp 1a.		

		int[][] gameDataTable = new int[3][3];		

		while (testGameConditions(gameDataTable)) {

			printGame(gameDataTable);

			addUserPlay(gameDataTable);

			if (!testGameConditions(gameDataTable))
				break;			
			
			addComputerPlay(gameDataTable);
		}
		
		printGame(gameDataTable);

	}

	static void printGame(int[][] gameDataTable) {

		System.out.println("  Game  | Numbers");
		for (int i = 0; i < gameDataTable.length; i++) {

			for (int j = 0; j < gameDataTable[i].length; j++) {

				if (gameDataTable[i][j] == 1)
					System.out.print("X |");
				else if (gameDataTable[i][j] == 2)
					System.out.print("O |");
				else
					System.out.print("- |");
			}

			if (i == 0)
				System.out.print(" 1, 2, 3");
			else if (i == 1)
				System.out.print(" 4, 5, 6");
			else
				System.out.print(" 7, 8, 9");

			System.out.println();

		}
	}

	static void addUserPlay(int[][] gameDataTable) {
		
		Scanner input = new Scanner(System.in);
		
		int rowNumber;
		
		do {
			System.out.println("Please enter your move (1-9): ");
			
			rowNumber = input.nextInt()-1;

			//minus one to get the correct array position
			
		} while (testIfOccupied(rowNumber, gameDataTable, true));		
		
		rowNumberToTablePosition(rowNumber, gameDataTable, 1);			
		
	}
	
	static boolean testIfOccupied(int rowNumber, int[][] gameDataTable, boolean player) {
		
		//takes 0-8
		
		int x, y;

		x = rowNumber / 3;
		y = rowNumber - (x * 3);

		if (gameDataTable[x][y] == 0) {
			//Not Occupied.
			return false;
		}
		else {
			if (player)
				System.out.println("Already played. Try Again.");
			return true;
		}		
	}
	

	static void addComputerPlay(int [][] gameDataTable) {

		Random rnd = new Random();
		
		int cpuNumber;
		
		do {
			
			cpuNumber = rnd.nextInt(9);
			
		} while (testIfOccupied(cpuNumber, gameDataTable, false));		
		
		rowNumberToTablePosition(cpuNumber, gameDataTable, 2);		
		
	}
	
	static void rowNumberToTablePosition(int rowNumber, int[][] gameDataTable, int playerType) {

		//takes input number and translates it into array position for the chosen player

		//takes 0-8
		
		int x, y;

		x = rowNumber / 3;
		y = rowNumber - (x * 3);

		gameDataTable[x][y] = playerType;
	}

	
	static boolean testGameConditions(int[][] gameDataTable) {
		
		//player
		if (gameDataTable[0][0] ==1 && gameDataTable[0][1] ==1 && gameDataTable[0][2] == 1) {
			System.out.println("You Win!!");
			return false;
		} else if (gameDataTable[1][0]==1 && gameDataTable[1][1]==1 && gameDataTable[1][2] == 1) {
			System.out.println("You Win!!");
			return false;
		} else if (gameDataTable[2][0]==1 && gameDataTable[2][1] ==1 && gameDataTable[2][2] == 1) {
			System.out.println("You Win!!");
			return false;
		} else if (gameDataTable[0][0] ==1 && gameDataTable[1][0] ==1 && gameDataTable[2][0] == 1) {
			System.out.println("You Win!!");
			return false;
		} else if (gameDataTable[0][1] ==1 && gameDataTable[1][1] ==1 && gameDataTable[2][1] == 1) {
			System.out.println("You Win!!");
			return false;
		} else if (gameDataTable[0][2] ==1 && gameDataTable[1][2] ==1 && gameDataTable[2][2] == 1) {
			System.out.println("You Win!!");
			return false;
		} else if (gameDataTable[0][0] ==1 && gameDataTable[1][1] ==1 && gameDataTable[2][2] == 1) {
			System.out.println("You Win!!");
			return false;
		} else if (gameDataTable[0][2] ==1 && gameDataTable[1][1] ==1 && gameDataTable[2][0] == 1) {
			System.out.println("You Win!!");
			return false;
		}

		//computer
		if (gameDataTable[0][0] ==2 && gameDataTable[0][1] ==2 && gameDataTable[0][2] == 2) {
			System.out.println("You Lose!!");
			return false;
		} else if (gameDataTable[1][0] ==2 && gameDataTable[1][1] ==2 && gameDataTable[1][2] == 2) {
			System.out.println("You Lose!!");
			return false;
		} else if (gameDataTable[2][0] ==2 && gameDataTable[2][1] ==2 && gameDataTable[2][2] == 2) {
			System.out.println("You Lose!!");
			return false;
		} else if (gameDataTable[0][0] ==2 && gameDataTable[1][0] ==2 && gameDataTable[2][0] == 2) {
			System.out.println("You Lose!!");
			return false;
		} else if (gameDataTable[0][1] ==2 && gameDataTable[1][1] ==2 && gameDataTable[2][1] == 2) {
			System.out.println("You Lose!!");
			return false;
		} else if (gameDataTable[0][2] ==2 && gameDataTable[1][2] ==2 && gameDataTable[2][2] == 2) {
			System.out.println("You Lose!!");
			return false;
		} else if (gameDataTable[0][0] ==2 && gameDataTable[1][1] ==2 && gameDataTable[2][2] == 2) {
			System.out.println("You Lose!!");
			return false;
		} else if (gameDataTable[0][2] ==2 && gameDataTable[1][1] ==2 && gameDataTable[2][0] == 2) {
			System.out.println("You Lose!!");
			return false;
		}
		//draw
		else if ((gameDataTable[0][0] == 1 || gameDataTable[0][0] == 2)
				&& (gameDataTable[0][1] == 1 || gameDataTable[0][1] == 2)
				&& (gameDataTable[0][2] == 1 || gameDataTable[0][2] == 2)
				&& (gameDataTable[1][0] == 1 || gameDataTable[1][0] == 2)
				&& (gameDataTable[1][1] == 1 || gameDataTable[1][1] == 2)
				&& (gameDataTable[1][2] == 1 || gameDataTable[1][2] == 2)
				&& (gameDataTable[2][0] == 1 || gameDataTable[2][0] == 2)
				&& (gameDataTable[2][1] == 1 || gameDataTable[2][1] == 2)
				&& (gameDataTable[2][2] == 1 || gameDataTable[2][2] == 2)) {
			System.out.println("Draw!!");
			return false;
		}

		return true;
	}
	

}