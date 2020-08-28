package com.exempel;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);

	static String choice;

	static int[] highScore = new int[5];

	static void diceGames(){

		System.out.print("Hur många kast vill du ange? ");
		int numberOfThrow = scan.nextInt();
		choice = scan.nextLine().toLowerCase();

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
		System.out.println("Fortsätta? (ja/nej)");
	}

	static void scoreBoard(){

		//int min = 0;
		Arrays.sort(highScore);

		System.out.println();
		System.out.println("High Score");


		for (int i = highScore.length-1; i >=0; i--) {
			System.out.println(highScore[i]);
		}

	/*	for(int j = 1; j < highScore.length; j++){
			if(highScore[j] < highScore[min]){
				min = j;
			}
		}*/
	}

	public static void main(String[] args) {

		boolean exit = false;
		System.out.println("Välkommen till Dicegame, starta? (ja/nej)");

		while (!exit){
			choice = scan.nextLine().toLowerCase();

			if(choice.equals("nej")){
				exit = true;
				System.out.println("Avslutar spelet nu...");
			}
			else if (choice.equals("ja")){
				diceGames();
			}else {
				exit = true;
				System.out.println("Ett problem har uppståt...");
			}
		}
	}
}
