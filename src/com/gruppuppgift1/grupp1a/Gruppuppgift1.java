package com.gruppuppgift1.grupp1a;

import java.util.Scanner;

public class Gruppuppgift1 {

	public static void main(String[] args) {		
		
		//Gruppuppgift1, Grupp 1a.
		
		int[][] gameDataTable = new int[3][3];
		
			
		while (testGameConditions()) {
			
			printGame(gameDataTable);
				
			addUserPlay(gameDataTable);
			
			if (testGameConditions())	//kolla efter varje speldrag
					break;
			
			//addComputerPlay etc
			
		
		}
		
		
		/*
		 * Mer metoder som behövs:
		 * 
		 * addComputerPlay, för datorns speldrag
		 * 
		 * testGameConditions, för att testa ställningen vid varje nytt speldrag
		 * och när bryta loopen, return: true/false
		 * 
		 * endOfGame, skriva ut vem som vann, kan metoden testGameConditions anropa den
		 * innan ger sin boolean retur?
		 * 
		 * 
		 */

	}
	
	static void printGame(int[][] gameDataTable) {

		System.out.println("Spelplan| Radnummer");
		for (int i=0; i<gameDataTable.length;i++) {	
			
			for (int j=0; j<gameDataTable[i].length; j++) {
				
				if(gameDataTable[i][j] == 1)
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
		//minus ett eftersom visar radNr som börjar på 1 ist för 0		
		
		
		rowNumberToTablePosition(rowNumber, gameDataTable);
		
		//input.close();
		
	}
	
	static void rowNumberToTablePosition(int rowNumber, int[][] gameDataTable) {
		
		//tar emot radnummer och omvandlar till tabellkoordinat
	
		//X är radnummer/3  (heltalsdiv)
		//Y är radnummer - (X*3)
		
		int x, y;
		
		x = rowNumber/3;
		y = rowNumber - (x*3);
		
		gameDataTable[x][y] = 1;		
	}

	static boolean testGameConditions() {
		
		//ska anropa endOfGame metoden, när detekterar vem som vann eller oavgjort
		
		return true;
	}

}
