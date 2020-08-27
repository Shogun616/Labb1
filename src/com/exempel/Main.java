package com.exempel;

import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);

	//static int[] highScore;

	static String choice;

	public static void main(String[] args) {

	/*	System.out.println("Hur många varv vill du köra?");
		int numberOfLaps = scan.nextInt();

		highScore = new int [numberOfLaps]; */

		boolean exit = false;
		System.out.println("Välkommen till Dicegame, starta?");

		while (!exit){
			choice = scan.nextLine().toLowerCase();

			if(choice.equals("nej")){
				exit = true;
				System.out.println("Avslutar spelet nu...");
			}else {
				diceGames();
			}
		}
	}

	static void diceGames(){

		System.out.print("Hur många kast vill du ange? ");
		int numberOfThrow = scan.nextInt();
		choice = scan.nextLine().toLowerCase();

		int sumComputer = 0;
		int sumPlayer = 0;

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
		}else {
			System.out.println("Datorn vann");
		}

		System.out.println();
		System.out.println("Fortsätta?");
	}
}
