import java.util.*;
import java.io.*;
public class nlp {
	public static void main(String[] arguments) {
	}



	/* Tokenize a string */
	private static String[] tokenize(String text) {
		return text.split(" ");
	}


	
	/* group inflected forms of a word to a single item */
	private static String lemmatize(String word) {
		List<String> lema = FileManager.openFile("data/lemmatization-en.txt");	

		for(String line: lema) {
			String[] items = line.split("\t");

			String root = items[0];
			String branch = items[1];


			// if word is a branch return root, if word is root return root
			if(branch.toLowerCase().equals(word.toLowerCase())) {
				return root;	
			}	
			else if(root.toLowerCase().equals(word.toLowerCase())) {
				return root;	
			}
		}
		
		return null;
	}





}
