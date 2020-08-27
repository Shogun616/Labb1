package com.exempel;

import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);

	static int[] highScore;

	public static void main(String[] args) {

		System.out.println("Hur många varv får det vara?");
		int numberOfLaps = scan.nextInt();
		highScore = new int [numberOfLaps];

		diceGames();

	}

	static void diceGames(){

		System.out.print("Hur många kast vill du ange? ");
		int numberOfThrow = scan.nextInt();

		int sumComputer = 0;
		int sumPlayer = 0;

		for (int i = 0; i < numberOfThrow; i++){
			int computersThrow = (int) (Math.random()*6+1);
			int playersThrow = (int) (Math.random()*6+1);


			sumPlayer += sumPlayer+playersThrow;
			sumComputer += sumComputer+computersThrow;

			System.out.println("Spelar: " + playersThrow);
			System.out.println("Dator: " + computersThrow);
			System.out.println();

		}
		System.out.println("Summa för spelare  är: " + sumPlayer);
		System.out.println("Summa för datorn är: " + sumComputer);
	}
}
