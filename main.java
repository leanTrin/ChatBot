import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;


public class main {

  private static String codeName = "A.P.R.I.L.";

  public static void main(String[] args) {
    //
    // print("Hello, I'm " + codeName + ", how can I help you?");
    //
    // while(true) {
    //   print("<" + codeName + "> "+ getResponse(removeSymbols(input("<YOU>"))));
    // }
		try {
			getResponse();
		} catch(IOException e) {
			print("error");
		}
  }


  private static void print(String statement) {
    System.out.println(statement);
  }


  private static boolean findKey(String statement, String key) {
    String[] words = statement.split(" ");
    for (String word : words) {
      if(word.toLowerCase().equals(key.toLowerCase())) {
        return true;
      }
    }
    return false;
  }


  private static String input(String label) {
    System.out.printf(label + ": ");
    Scanner s = new Scanner(System.in);
    return s.nextLine();
  }

  private static String removeSymbols(String statement) {
    String[] sym = {"!","@","#","$","%","^","&","*","(",")","?",".",","}; // TODO: add the rest
    //TODO: remove words with [`] like john's
    for (String Symbol  : sym ) {
        statement = statement.replace(Symbol,"");
    }
    return statement;
  }


  private static String getResponse(String statement) {

    // TODO: make it work for plural words
    String[][] response = {
      {"cat","Tell me more about your cat"},
      {"dog","Tell me more about your dog"},
      {"weather","The weather is nice"},
      {"school","School is cool"},
      {"test","test away"}
    };

    for(String[] options: response) {
      String keyword = options[0].toLowerCase();
      String res = options[1];

      if(findKey(statement.toLowerCase(),keyword)) {
        return res;
      }
    }
    return null;
    // return (findKey(statement,"cat") || findKey(statement,"dog")) ? "Tell me more about your pets." :
    //   (findKey(statement,"weather")) ? "I think the weather is nice." :
    //   (findKey(statement,"school")) ? "School is cool." :
    //   (findKey(statement,"test")) ? "Test away." :
    //   "what";
  }

	private static int fileLineLength(File file) throws IOException {
		int count = 0;
 
		BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream(file)));
		String line = null;
		while ((line = br.readLine()) != null) {
			count++;
		}
	 
		br.close();
		return count;
	}

	private static String getRandomResponse() throws IOException{

		Random random = new Random();

		int randInt = 0;
		try { randInt = random.nextInt(fileLineLength(new File("test.txt")) + 1);}
		catch (IOException e) {print("IOException");}

		int count = 0;	
		BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream("test.txt")));
		String line = null;
		while ((line = br.readLine()) != null) {
			if(count == randInt) {
				return line;	
			}
			count++;
		}
	 
		br.close();
		return line;
	}





}
