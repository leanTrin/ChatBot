import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

public class main {

  private static String codeName = "A.P.R.I.L.";

  public static void main(String[] args) {
    //
    // print("Hello, I'm " + codeName + ", how can I help you?");
    //
    // while(true) {
    //   print("<" + codeName + "> "+ getResponse(removeSymbols(input("<YOU>"))));
    // }
    int test = fileLineLength(new File("test.txt"));
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

  private static int fileLineLength(File file) throws FileNotFoundException {
    int count = 0;
    try {
      for(Scanner sc = new Scanner(file); sc.hasNext(); ) {
        String line = sc.nextLine();
        print(line);
      }
    } catch(FileNotFoundException e) {
      print("test");
    }

    return 0;
  }



  // private static String randomResponse() {
  //   String result = null;
  //   try {
  // 			Scanner scanner = new Scanner(new File("test.txt"));
  //       int n = 0;
  //       Random rand = new Random();
  // 			while (scanner.hasNextLine()) {
  //         ++n;
  //
  //         if(rand.nextInt(n) == 0) {
  //           result = scanner.nextLine();
  //         }
  // 			}
  // 			scanner.close();
  // 		} catch (FileNotFoundException e) {
  // 			e.printStackTrace();
  // 		}
  //     return result;
  // 	}
}
