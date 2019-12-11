
public class eachRound {
	private String[] guess;
	
	private int[] hint;
	
	public eachRound(String[] newguess, int[] newhint) {
		setGuess(newguess);
		setHint(newhint);
	}

	public String[] getGuess() {
		return guess;
	}

	public void setGuess(String[] guess) {
		this.guess = guess;
	}

	public int[] getHint() {
		return hint;
	}

	public void setHint(int[] hint) {
		this.hint = hint;
	}
}