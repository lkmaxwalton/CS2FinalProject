import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MasterMind {

	private String[] Answer;

	private int[] hint;
	
	private String[] guess;
	
	private ArrayList<eachRound> Gueses;

	public String[] gereratePattern() {
		Gueses = new ArrayList<eachRound>();
		String[] colors = new String[] { "Red", "Blue", "Yellow", "Green", "Orange", "Purple" };
		Answer = new String[4];
		for (int i = 0; i < Answer.length; i++) {
			Random randomNumber = new Random();
			int index = randomNumber.nextInt(6);
			Answer[i] = colors[index];
		}

		return Answer;
	}

	public void printStringArray(String[] newArray) {
		for (int i = 0; i < newArray.length - 1; i++) {
			System.out.print(newArray[i] + ", ");
		}
		System.out.print("and " + newArray[newArray.length - 1]);
		System.out.println("");
	}

	public void printIntArray(int[] newArray) {
		System.out.println("black: " + newArray[0] + " white: " + newArray[1]);
	}

	public void checkPattern(String[] newArray) throws Exception {
		guess = newArray;
		int black = 0;
		int white = 0;
		int[] Akey = { 0, 0, 0, 0 };
		int[] Gkey = { 0, 0, 0, 0 };
		for (int i = 0; i < Answer.length; i++) {
			if (!newArray[i].contentEquals("Red") && !newArray[i].contentEquals("Blue")
					&& !newArray[i].contentEquals("Green") && !newArray[i].contentEquals("Yellow")
					&& !newArray[i].contentEquals("Orange") && !newArray[i].contentEquals("Purple"))
				throw new Exception("Please enter a vaid color");
			if (Answer[i].contentEquals(newArray[i])) {
				black++;
				Akey[i] = 1;
				Gkey[i] = 1;
			}
		}
		for (int i = 0; i < Answer.length; i++) {
			for (int j = 0; j < newArray.length; j++) {
				if (Akey[i] == 0 && Gkey[j] == 0 && Answer[j].contentEquals(newArray[i])) {
					white++;
					Akey[i] = 1;
					Gkey[j] = 1;
					break;
				}
			}

		}

		hint = new int[] { black, white };
	}
	
	public void addToBoard() {
	eachRound e1 = new eachRound(guess, hint);
	Gueses.add(e1);
	}
	public void printArrayList() {
		for(int i = 0; i < Gueses.size(); i++) {
	System.out.println("your gueses are ");
	printStringArray(Gueses.get(i).getGuess());
	System.out.println("the hint is ");
	printIntArray(Gueses.get(i).getHint());
		}
	}
	public boolean winOrLose() {
		if (hint[0] == 4)
			return true;
		else
			return false;
	}

	public String[] getAnswer() {
		return Answer;
	}

	public void setAnswer(String[] answer) {
		Answer = answer;
	}
}
