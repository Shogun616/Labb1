package com.exempel;

import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		String[] choices = {"sten", "sax", "påse"};

		String playerChoice;
		boolean exit = false;

		System.out.println("Välkommen till dice of Doom (Skriv e för att avsluta)");

		while (!exit){
			int computerRand = (int) (Math.random() * 3);
			String computerChoice = choices[computerRand];

			System.out.print("Sten, sax eller påse? ");
			playerChoice = scan.nextLine().toLowerCase();

			System.out.println("Datorn " + computerChoice);


			if(playerChoice.equals("q")){
				exit = true;
				System.out.println("Nu stänger vi ner spelet...");
			}
			else if (playerChoice.equals(computerChoice)) {
				System.out.println("Det blev samma");
			}
			else if (playerChoice.equals("sten")) {
				if(computerChoice.equals("sax")) {
					System.out.println("Du vann!");
				}else{
					System.out.println("Datorn vann!");
				}
			}
			else if (playerChoice.equals("påse")) {
				if(computerChoice.equals("sten")) {
					System.out.println("Du vann!");
				}else{
					System.out.println("Datorn vann!");
				}
			}
			else if (playerChoice.equals("sax")) {
				if(computerChoice.equals("påse")) {
					System.out.println("Du vann!");
				}else{
					System.out.println("Datorn vann!");
				}
			}
			else {
				System.out.println("Det blev något fel...");
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
