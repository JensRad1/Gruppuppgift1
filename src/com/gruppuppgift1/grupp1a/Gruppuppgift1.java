package com.gruppuppgift1.grupp1a;

import java.util.Scanner;

public class Gruppuppgift1 {

	public static void main(String[] args) {

		// Gruppuppgift1, Grupp 1a.

		int[][] gameDataTable = new int[3][3];

		while (testGameConditions(gameDataTable)) {

			printGame(gameDataTable);

			addUserPlay(gameDataTable);

			if (!testGameConditions(gameDataTable)) { // kolla efter varje speldrag
				printGame(gameDataTable);// s‰tt in en visar br‰dan sista gÂngen.
				break;
			}
			// addComputerPlay etc

		}

		/*
		 * Mer metoder som beh√∂vs:
		 * 
		 * addComputerPlay, f√∂r datorns speldrag
		 * 
		 * testGameConditions, f√∂r att testa st√§llningen vid varje nytt speldrag och
		 * n√§r bryta loopen, return: true/false
		 * 
		 * endOfGame, skriva ut vem som vann, kan metoden testGameConditions anropa den
		 * innan ger sin boolean retur?
		 * 
		 * 
		 */

	}

	static void printGame(int[][] gameDataTable) {

		System.out.println("Spelplan| Radnummer");
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

		System.out.println("Ange ett radnummer (1-9): ");

		Scanner input = new Scanner(System.in);

		int rowNumber;
		rowNumber = input.nextInt() - 1;
		// minus ett eftersom visar radNr som b√∂rjar p√• 1 ist f√∂r 0

		rowNumberToTablePosition(rowNumber, gameDataTable);

		// input.close();

	}

	static void rowNumberToTablePosition(int rowNumber, int[][] gameDataTable) {

		// tar emot radnummer och omvandlar till tabellkoordinat

		// X √§r radnummer/3 (heltalsdiv)
		// Y √§r radnummer - (X*3)

		int x, y;

		x = rowNumber / 3;
		y = rowNumber - (x * 3);

		gameDataTable[x][y] = 1;
	}

	static boolean testGameConditions(int[][] gameDataTable) {

		boolean n = true;
		// ska anropa endOfGame metoden, n√§r detekterar vem som vann eller oavgjort.

		// fˆr spelare
		if (gameDataTable[0][0] + gameDataTable[0][1] + gameDataTable[0][2] == 3) {
			System.out.println("You Win!!");
			n = false;
		} else if (gameDataTable[1][0] + gameDataTable[1][1] + gameDataTable[1][2] == 3) {
			System.out.println("You Win!!");
			n = false;
		} else if (gameDataTable[2][0] + gameDataTable[2][1] + gameDataTable[2][2] == 3) {
			System.out.println("You Win!!");
			n = false;
		} else if (gameDataTable[0][0] + gameDataTable[1][0] + gameDataTable[2][0] == 3) {
			System.out.println("You Win!!");
			n = false;
		} else if (gameDataTable[0][1] + gameDataTable[1][1] + gameDataTable[2][1] == 3) {
			System.out.println("You Win!!");
			n = false;
		} else if (gameDataTable[0][2] + gameDataTable[1][2] + gameDataTable[2][2] == 3) {
			System.out.println("You Win!!");
			n = false;
		} else if (gameDataTable[0][0] + gameDataTable[1][1] + gameDataTable[2][2] == 3) {
			System.out.println("You Win!!");
			n = false;
		} else if (gameDataTable[0][2] + gameDataTable[1][1] + gameDataTable[2][0] == 3) {
			System.out.println("You Win!!");
			n = false;
		}

		// fˆr Datorn
		if (gameDataTable[0][0] + gameDataTable[0][1] + gameDataTable[0][2] == 6) {
			System.out.println("You Lose!!");
			n = false;
		} else if (gameDataTable[1][0] + gameDataTable[1][1] + gameDataTable[1][2] == 6) {
			System.out.println("You Lose!!");
			n = false;
		} else if (gameDataTable[2][0] + gameDataTable[2][1] + gameDataTable[2][2] == 6) {
			System.out.println("You Lose!!");
			n = false;
		} else if (gameDataTable[0][0] + gameDataTable[1][0] + gameDataTable[2][0] == 6) {
			System.out.println("You Lose!!");
			n = false;
		} else if (gameDataTable[0][1] + gameDataTable[1][1] + gameDataTable[2][1] == 6) {
			System.out.println("You Lose!!");
			n = false;
		} else if (gameDataTable[0][2] + gameDataTable[1][2] + gameDataTable[2][2] == 6) {
			System.out.println("You Lose!!");
			n = false;
		} else if (gameDataTable[0][0] + gameDataTable[1][1] + gameDataTable[2][2] == 6) {
			System.out.println("You Lose!!");
			n = false;
		} else if (gameDataTable[0][2] + gameDataTable[1][1] + gameDataTable[2][0] == 6) {
			System.out.println("You Lose!!");
			n = false;
		}
		// kollar om det ‰r draw
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
			n = false;
		}

		return n;

	}

}
