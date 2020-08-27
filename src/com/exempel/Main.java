package com.exempel;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);

	static int[] highScores= new int[10];


	public static void main(String[] args) {
		diceGames();
	}

	static void diceGames(){

		System.out.print("Hur många kast vill du göra? ");
		int antalKast = scan.nextInt();

		int sumDator = 0;
		int sumspelare = 0;

		for (int i = 0; i < antalKast; i++){
			int datorskast = (int) (Math.random()*6+1);
			int spelarenskast = (int) (Math.random()*6+1);


			sumspelare += sumspelare+spelarenskast;
			sumDator += sumDator+datorskast;

			System.out.println("Spelar: " + spelarenskast);
			System.out.println("Dator: " + datorskast);
			System.out.println();

		}
		System.out.println("Summa för spelare  är: " + sumspelare);
		System.out.println("Summa för datorn är: " + sumDator);
	}
}
