package com.exempel;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);

	static int[] highScore = new int[5];

	static boolean repeat = true;

	static boolean exit = false;

	static String decision;

	static void diceGames(){

		System.out.print("Hur många kast vill du ange? ");
		int numberOfThrow = scan.nextInt();
		decision = scan.nextLine();

		int sumComputer = 0;
		int sumPlayer = 0;
		int position = 0;

		for (int i = 0; i < numberOfThrow; i++){
			int computersThrow = (int) (Math.random()*6+1);
			int playersThrow = (int) (Math.random()*6+1);


			sumPlayer += sumPlayer + playersThrow;
			sumComputer += sumComputer + computersThrow;

			System.out.println("Spelar: " + playersThrow);
			System.out.println("Dator: " + computersThrow);
			System.out.println();

		}

		System.out.println("Summa för spelare är: " + sumPlayer);
		System.out.println("Summa för datorn är: " + sumComputer);

		if(sumPlayer > sumComputer){
			System.out.println("Spelare vann");
			highScore[position] = sumPlayer;
			position++;
			scoreBoard();
		}else if(sumPlayer < sumComputer){
			System.out.println("Datorn vann");
			highScore[position] = sumComputer;
			position++;
			scoreBoard();
		} else {
			System.out.println("Ovagjort");
		}

		System.out.println();
		System.out.println("Fortsätta (ja/nej)");
	}

	static void scoreBoard(){

		Arrays.sort(highScore);

		System.out.println();
		System.out.println("High Score");
		System.out.println("==========");

		for (int i = highScore.length-1; i >=0; i--) {
			System.out.println(highScore[i]);
		}

		int min = 0;
		for(int j = 1; j < highScore.length; j++){
			if(highScore[j] < highScore[min]){
				min = j;
			}
		}
	}

	static void menu(){
		System.out.println("\n======================================");
		System.out.println("              Main Menu             ");
		System.out.println("======================================");
		System.out.println("1. Player VS Computer");
		System.out.println("2. Player Vs Player");
		System.out.println("3. HighScore");
		System.out.println("0. Exit");

		System.out.println("\nMake your choice");
		int choice = scan.nextInt();
		scan.nextLine();

		switch (choice){

			case 0:
				repeat = false;
				exit = true;
				System.out.println("Avslutar spelet nu...");
				break;

			case 1:
				System.out.println("Välkommen till Dicegame PvE, starta? (ja/nej)");
				options();
				break;

			case 2:
				System.out.println("Välkommen till DiceGame PvP, starta? (ja/nej)");
				options();
				break;

			case 3:
				scoreBoard();
				System.out.println();
				System.out.println("Press Enter to show menu");
				scan.nextLine();
				menu();
				break;

			default:
				System.out.println("Ogiltig val!");
		}
	}

	static void options(){

		while (!exit) {
			decision = scan.nextLine().toLowerCase();

			if (decision.equals("nej")) {
				repeat = true;
				menu();
			} else if (decision.equals("ja")) {
				diceGames();
			}
		}
	}

	public static void main(String[] args) {
		while (repeat){
			menu();
		}
	}
}