package com.exempel;

import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		String[] choices = {"sten", "sax", "påse"};

		String playersChoice;
		boolean exit = false;

		System.out.println("Välkommen till dice of Doom (Skriv e för att avsluta)");

		while (!exit){
			int computerRand = (int) (Math.random() * 3);
			String computerChoice = choices[computerRand];

			System.out.println("Datorn " + computerChoice);

			System.out.print("Sten, sax eller påse? ");
			playersChoice = scan.nextLine().toLowerCase();

			switch (playersChoice) {
				case "e":
					exit = true;
					System.out.println("Stänger ner spelet nu");
					break;
				case "sten":
					if (computerChoice.equals("sax")) {
						System.out.println("Du vann");
					} else {
						System.out.println("Datorn vann");
					}

					break;
				case "påse":
					if (computerChoice.equals("sten")) {
						System.out.println("Du vann");
					} else {
						System.out.println("Datorn vann");
					}

					break;
				case "sax":
					if (computerChoice.equals("påse")) {
						System.out.println("Du vann");
					} else {
						System.out.println("Datorn vann");
					}
					break;
				default:
					System.out.println("Det blev något fel...");
					break;
			}
		}

	}

	static void dice(){

		int antalKast = 5;
		int antalSidor = 6;
		int summaSpelare1 = 0;
		int summaSpelare2 = 0;

		int[] kastArray;
		kastArray = new int[2];

		for(int i=1; i <= antalKast; i++){
			kastArray[0] = (int) (1+antalSidor*Math.random());
			kastArray[1] = (int) (1+antalSidor*Math.random());

			System.out.println("Spelare 1: Kast: " + i + " är " + kastArray[0]);
			System.out.println("Spelare 2: Kast: " + i + " är " + kastArray[1]);

			summaSpelare1 += kastArray[0];
			summaSpelare2 += kastArray[1];
		}
		System.out.println("Summa för spelare 1 är: " + summaSpelare1);
		System.out.println("Summa för spelare 2 är: " + summaSpelare2);
	}

}
