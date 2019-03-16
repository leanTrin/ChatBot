import java.io.*;
import java.util.*;

public class main {
	public static void main(String[] args) {
	}

	/* Creates a print statement simmilar to pythons*/
	private static void print(Object statement) {
		System.out.println(statement);
	}

	/* Creates an input grabber simmilar to pythons raw_input and input*/
	private static String input(Object label) {
		System.out.printf(String.format("%s: ",label));
		Scanner raw_input = new Scanner(System.in);
		return raw_input.nextLine();
	}

	
	/* Finds if a word is in a string*/
	private static boolean findKey(String statement, String key, boolean keyMultiple) {
		String[] words = statement.split(" ");
		for(String word : words) {
			if(word.toLowerCase().equals(key.toLowerCase())) {
				return true;
			}
		}	
		return false;
	}	

}
