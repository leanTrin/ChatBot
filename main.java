import java.util.Scanner;

public class main {
  public static void main(String[] args) {
    print(getResponse(removeSymbols(input("statement"))));
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
}
