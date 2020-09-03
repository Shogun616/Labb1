package com.exempel;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    static int[] highScore = new int[5];

    static boolean repeat = true;

    static boolean exit = false;

    static String decision;

    static int singleOrMulti;

    static void diceGames() {

        System.out.print("Hur många kast vill du ange? ");
        int numberOfThrow = scan.nextInt();
        scan.nextLine();

        int sumComputer = 0;
        int sumPlayer = 0;
        int position = 0;

        for (int i = 0; i < numberOfThrow; i++) {
            int computersThrow = (int) (Math.random() * 6 + 1);
            int playersThrow = (int) (Math.random() * 6 + 1);

            sumPlayer = sumPlayer + playersThrow;
            sumComputer = sumComputer + computersThrow;

            System.out.println("Spelar");
            System.out.println("Tärningskast: " + playersThrow);
            System.out.println("Dator");
            System.out.println("Tärningskast: " + computersThrow);
            System.out.println();
        }

        System.out.println("Summa för spelare är: " + sumPlayer);
        System.out.println("Summa för datorn är: " + sumComputer);

        if (sumPlayer > sumComputer) {
            System.out.println("Spelare vann");
            highScore[position] = sumPlayer;
            position++;
            scoreBoard();
        } else if (sumPlayer < sumComputer) {
            System.out.println("Datorn vann");
            highScore[position] = sumComputer;
            position++;
            scoreBoard();
        } else {
            System.out.println("Ovagjort");
        }

        System.out.println();
        System.out.println("Fortsätta (ja/nej)");
        choice();
    }

    static void diceGames2() {
        System.out.println("Ange antal spelare: ");
        int numberOfPlayer = scan.nextInt();
        scan.nextLine();

        System.out.print("Hur många kast vill du ange? ");
        int numberOfThrow = scan.nextInt();
        scan.nextLine();

        int position = 0;

        int[] sumPlayer = new int[6];

        for (int i = 1; i <= numberOfPlayer; i++) {
            System.out.println("Spelare " + i + ".");

            for (int j = 1; j < numberOfThrow; j++) {
                System.out.println("Tärningskast " + j + " (spelare: " + i + ").");
                int playersThrow = (int) (1 + Math.random() * 6);

                System.out.println("Spelare: " + i + " kast: " + playersThrow);

                sumPlayer[i] = sumPlayer[i] + playersThrow;
            }
            System.out.println("Summa spelare " + i + ": " + sumPlayer[i]);
            System.out.println();
            highScore[position] = sumPlayer[i];
            position++;
            scoreBoard();
            System.out.println();
        }

        System.out.println();
        System.out.println("Fortsätta (ja/nej)");
        choice();
    }

    static void scoreBoard() {

        Arrays.sort(highScore);

        System.out.println();
        System.out.println("High Score");
        System.out.println("==========");


        for (int i = highScore.length - 1; i >= 0; i--) {
            System.out.println(highScore[i]);
        }
    }

    static void menu() {
        System.out.println("\n======================================");
        System.out.println("              Main Menu             ");
        System.out.println("======================================");
        System.out.println("1. Player VS Computer");
        System.out.println("2. Player Vs Player");
        System.out.println("3. HighScore");
        System.out.println("0. Exit");

        System.out.println("\nMake your choice");
        singleOrMulti = scan.nextInt();
        scan.nextLine();

        switch (singleOrMulti) {

            case 0:
                System.out.println("Avsluta? (ja/nej)");
                options();
                repeat = false;
                System.out.println("Avslutar spelet nu...");
                break;

            case 1:
                System.out.println("Välkommen till Dicegame PvE");
                diceGames();
                break;

            case 2:
                System.out.println("Välkommen till DiceGame PvP");
                diceGames2();
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

    static void options() {

        while (!exit) {
            decision = scan.nextLine();

            if (decision.equalsIgnoreCase("nej")) {
                exit = true;
                menu();
            } else if (decision.equalsIgnoreCase("ja")) {
                exit = true;
            }
        }
    }

    static void choice() {

        boolean choice = true;

        while (choice) {
            decision = scan.nextLine().toLowerCase();

            switch (decision) {
                case "nej":
                    choice = false;
                    menu();
                    break;
                case "ja":
                    if (singleOrMulti == 1)
                        diceGames();
                    else if (singleOrMulti == 2)
                        diceGames2();
                    break;
                default:
                    choice = false;
                    System.out.println("Ett problem har uppståt...");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        while (repeat) {
            menu();
        }
    }
}