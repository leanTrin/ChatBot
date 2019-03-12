import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
public class test {
	/* TODO: transfer this to the main program for the getResponse function
	*/
	public static void main(String[] args) {
			Map<List<String>, String> map = new HashMap<List<String>, String>();
			map.put(
			new ArrayList<String>(Arrays.asList("cat,dog"))
			, "type of animal");
			for (Map.Entry<List<String>, String> entry : map.entrySet()) {	
				for (String temp : entry.getKey()) {
					String[] Key = temp.split(",");
					for(String test: Key) {
						System.out.println(test);
					}
				}
			}
	}	

}
