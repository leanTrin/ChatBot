import java.io.*;
import java.util.*;

public class main {

	private static String codename = "April";
    private static String version = "1.0";



	/* Main Program*/
	public static void main(String[] args) {
		FileManager FileManager = new FileManager();
		print(String.format("<%s>: Hello!", codename));
		while(true) {
		
			String user = input("<YOU>");	
			String response = getResponse(user);
			print(String.format("<%s>: %s",codename, response));
		}	
	}



	/* Creates a print statement simmilar to pythons*/
	private static void print(Object statement) {
		System.out.println(statement);
	}



	/* Creates an input grabber simmilar to pythons raw_input and input*/
	private static String input(Object label) {
		System.out.printf(String.format("%s: ",label));
    Scanner s = new Scanner(System.in);
    return s.nextLine();
	}


	
	/* Finds if a word is in a string*/
	private static boolean findKey(String statement, String keys) { // the key can be a word or multiple words
	}
	


	/* A simple get Response using a few keywords*/
	private static String getResponse(String statement) {
		return ( findKey(statement,"dog") || findKey(statement,"dogs") ) ? "Tell me more about the dog." :
			( findKey(statement,"cat") || findKey(statement,"cats") ) ? "Tell me more about the cat." :
			( findKey(statement,"weather") ) ? "The weather is nice.":
			( findKey(statement,"leandro") ) ? "I like Leandro, he created me.":
			( findKey(statement,"how are you") ) ? "I'm doing well.":
			( findKey(statement,"your name") || findKey(statement,"who are you") ) ? String.format("My name is %s",codename):
			( findKey(statement,"hello *") ) ? "asdfghjkl;":
			( findKey(statement,"your version") || (findKey(statement,"you") && findKey(statement,"version") ) ) ? String.format("I am version %s",version) :
			randomResponse();
	}



	/* Gets a random string from a list of responses*/
	private static String randomResponse() {
		String filename = "data/random.txt";
		return FileManager.randChoice(FileManager.openFile(filename));	
	}
}
