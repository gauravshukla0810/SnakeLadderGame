package com.game;

import java.util.HashMap;
import java.util.Random;

public class SnakeLadder {
	static HashMap<Integer, Integer> snakePosition = new HashMap<Integer, Integer>();
	static int addSnake = -1;
	static int index = 0;

	public static void main(String[] args) {
		// int board[][] = new int[10][10];
		System.out.println("Please choose type of Dice you would like to play with (Enter 1/2)");
		System.out.println("1. Crooked Dice(Only Even Numbers)");
		System.out.println("2. Normal Dice");
//		Scanner sc = new Scanner(System.in);
//		int diceType = sc.nextInt();
		int diceType = Integer.parseInt(args[index]);
		index++;
//		while (diceType != 1 && diceType != 2) {
//			System.out.println("Please choose type of Dice you would like to play with (Enter 1/2)");
//			System.out.println("1. Crooked Dice(Only Even Numbers)");
//			System.out.println("2. Normal Dice");
//			diceType = sc.nextInt();
//		}
		System.out.println("Choosen Dice Type : " + diceType);

		while (addSnake != 2) {
			System.out.println("Do you want to add a snake on bard (Enter1/2)?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			addSnake = Integer.parseInt(args[index]);
			index++;
			if (addSnake == 1) {
				addSnakeToBoard(args);
			}
		}
		System.out.println("Snakes added to your board : " + snakePosition);
		int presentIndex = 0;
		int gameExit = 2;
		while (presentIndex != 100 && gameExit == 2) {
			if (diceType == 1) {
				int diceReturnedValue = getRandomEvenInteger();
				System.out.println("Dice Rolled and returned : " + diceReturnedValue);
				if (presentIndex + diceReturnedValue > 100) {
					System.out.println("You cannot move ahead .. ");
				} else {
					presentIndex += diceReturnedValue;
				}
				System.out.println("You are now at : " + presentIndex);
				if (snakePosition.containsKey(presentIndex)) {
					presentIndex = snakePosition.get(presentIndex);
					System.out.println("You are at Snakes house throwing you out of the house to : " + presentIndex);
				}
			} else if (diceType == 2) {
				int diceReturnedValue = getRandomInteger();
				presentIndex += getRandomInteger();
				System.out.println("Dice Rolled and returned : " + diceReturnedValue);
				System.out.println("You are now at : " + presentIndex);
				if (snakePosition.containsKey(presentIndex)) {
					presentIndex = snakePosition.get(presentIndex);
					System.out.println("You are at Snakes house throwing you out of the house to : " + presentIndex);
				}
			}
			System.out.println("DO you want to continue to play (Enter 1/2)?");
			System.out.println("1. Exit");
			System.out.println("2. Continue");
			gameExit = Integer.parseInt(args[index]);
			index++;

		}
		// sc.close();
	}

	public static int getRandomInteger() {
		int maximum = 7, minimum = 1;
		return ((int) (Math.random() * (maximum - minimum))) + minimum;
	}

	public static int getRandomEvenInteger() {
		int startOfRange = 2;
		int endOfRange = 8;
		Random rand = new Random();
		return startOfRange + rand.nextInt((endOfRange - startOfRange) / 2) * 2;
	}

	public static void addSnakeToBoard(String args[]) {
		// Scanner sc = new Scanner(System.in);
		int snakeStartIndex = -1, snakeEndIndex = -1;
		if (addSnake == 1) {
			System.out.println("Starting Position of Snake : ");
			snakeStartIndex = Integer.parseInt(args[index]);
			index++;
			System.out.println("End Position of Snake : ");
			snakeEndIndex = Integer.parseInt(args[index]);
			if (snakeStartIndex < snakeEndIndex || !(snakeStartIndex > 0 && snakeStartIndex < 100)
					|| !(snakeEndIndex > 0 && snakeEndIndex < 100)) {
				System.out.println("Invalid Placement of snake StartIndex should be greater than endindex.");
				System.out.println("Do you want to add a snake on bard (Enter1/2)?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				addSnake = Integer.parseInt(args[index]);
				if (addSnake == 1 || addSnake == 2) {
					// addSnake = 2;
					index++;
				} else {
					addSnake = 2;
				}
//				if (addSnake == 1) {
//					System.out.println("Starting Position of Snake : ");
//					snakeStartIndex = sc.nextInt();
//					System.out.println("End Position of Snake : ");
//					snakeEndIndex = sc.nextInt();
//				} else {
//					break;
//				}
			}
			if (!(snakeStartIndex < snakeEndIndex || !(snakeStartIndex > 0 && snakeStartIndex < 100)
					|| !(snakeEndIndex > 0 && snakeEndIndex < 100)))
				snakePosition.put(snakeStartIndex, snakeEndIndex);
			index++;
			System.out.println("Do you want to add a snake on bard (Enter1/2)?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			addSnake = Integer.parseInt(args[index]);
			if (addSnake == 1 || addSnake == 2) {
				// addSnake = 2;
				index++;
			} else {
				addSnake = 2;
			}
		}
	}
}
