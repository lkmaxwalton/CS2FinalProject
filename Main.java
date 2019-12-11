import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		int round = 1;
		boolean win = false;
		while (choice != 2) {
			System.out.println("Do you want to play a game? 1 for yes, 2 for no, and 3 for debug");
			choice = input.nextInt();
			if (choice == 2)
				break;
			MasterMind game = new MasterMind();
			if (choice == 3) {
				game.gereratePattern();
				System.out.println("enter in the secret code");
				System.out.println("enter the first color");
				String color1 = input.next();
				System.out.println("enter the second color");
				String color2 = input.next();
				System.out.println("enter the third color");
				String color3 = input.next();
				System.out.println("enter the fourth color");
				String color4 = input.next();
				String[] newAnswer = new String[] { color1, color2, color3, color4 };
				game.setAnswer(newAnswer);
			} else {
				game.gereratePattern();
			}
			game.printStringArray(game.getAnswer());
			while (round <= 10) {
				System.out.println("Round " + round);
				System.out.println("enter the first color");
				String color1 = input.next();
				System.out.println("enter the second color");
				String color2 = input.next();
				System.out.println("enter the third color");
				String color3 = input.next();
				System.out.println("enter the fourth color");
				String color4 = input.next();
				String[] colorsGuessed = new String[] { color1, color2, color3, color4 };
				try {
					game.checkPattern(colorsGuessed);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				game.addToBoard();
				if (game.winOrLose() == true) {
					System.out.println("YOU WIN");
					int points = 11 - round;
					System.out.println("Points: " + points);
					win = true;
					break;
				} else {
					System.out.println("Output");
					game.printArrayList();
				}
				round++;

			}
			if (win = false)
				System.out.println("you lose");
			round = 1;
		}
	}
}
