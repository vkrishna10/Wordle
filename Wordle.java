import java.util.Scanner;
public class Wordle{

	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args){

		boolean exit = false;

		System.out.println("Welcome to Wordle!!!!! You have 6 tries to get the word. Enter your guess after the colon.");
		int i = 0;
		for (i = 0; i < 6; i++){
			System.out.print("Guess " + (i+1) + ": ");

			String guess = reader.nextLine();
			exit = setDisplay(guess, "icing");

			if(exit){
				i = 20;
			}
		}

		if (exit){
			System.out.println("CONGRATULATIONS YOU WON!!!!");
		} else{
			System.out.println("Tough loss. Better luck next time");
		}
	}

	static boolean setDisplay(String guess, String answer){
		String display = "";
		guess = guess.toLowerCase();
		answer = answer.toLowerCase();

		for(int i = 0; i < answer.length(); i++){

			String gLetter = guess.substring(i, i + 1);
			String aLetter = answer.substring(i, i +1);

			if(gLetter.equals(aLetter) && counts(display, gLetter) < counts(answer, aLetter)){
				display += (" " + gLetter.toUpperCase() + " ");
			}
			else if(answer.indexOf(gLetter) >= 0 && counts(display, gLetter) < counts(answer, aLetter)) {
				display += (" " + gLetter.toLowerCase() + " ");
			}
			else {
				display += " _ ";
			}
		}

		System.out.println(display);
		if(guess.equals(answer)){
			return true;
		}
		return false;
	}

	public static int counts (String big, String letter){
		int counter = 0;
		for (int i = 0; i < big.length(); i++){
			if(big.substring(i,i+1).toLowerCase().equals(letter.toLowerCase())){
				counter++;
			}
		}

		return counter;
	}

}