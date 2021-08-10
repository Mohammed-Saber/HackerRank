import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class Result {

	/*
	 * Complete the 'makeAnagram' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. STRING a 2. STRING b
	 */

	public static int makeAnagram(String a, String b) {
		Map<Character, Integer> occurenceOfFirstStr = getOccurence(a);
		Map<Character, Integer> occurenceOfSecondStr = getOccurence(b);

		doAdjsutment(occurenceOfFirstStr, occurenceOfSecondStr);
		doAdjsutment(occurenceOfSecondStr, occurenceOfFirstStr);

		StringBuilder adjuestedStr = new StringBuilder();
		occurenceOfFirstStr.forEach((key, value) -> {
			for (int i = 0; i < value; i++) {
				adjuestedStr.append(key);
			}

		});

		int numOfDeletionFromFirstStr = a.length() - adjuestedStr.length();
		int numOfDeletionFromSecondStr = b.length() - adjuestedStr.length();

		return numOfDeletionFromFirstStr + numOfDeletionFromSecondStr;

	}

	private static void doAdjsutment(Map<Character, Integer> firstMap, Map<Character, Integer> secondMap) {
		firstMap.forEach((key, value) -> {
			if (!secondMap.containsKey(key)) {
				firstMap.put(key, 0);
			} else {
				while (firstMap.get(key) > secondMap.get(key)) {
					firstMap.put(key, firstMap.get(key) - 1);
				}
			}

		});
	}

	private static Map<Character, Integer> getOccurence(String str) {
		Map<Character, Integer> occurrenceMap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			Character charAt = str.charAt(i);
			occurrenceMap.computeIfAbsent(charAt, key -> 0);
			occurrenceMap.computeIfPresent(charAt, (key, value) -> value + 1);
		}
		return occurrenceMap;
	}

}

public class Solution {

	private static void showData(String a, String b) {

		System.out.println("String 1=[" + a + "] , String 2=[" + b + "] , Result=" + Result.makeAnagram(a, b));
	}

	public static void main(String[] args) throws IOException {
		/*
		 * BufferedReader bufferedReader = new BufferedReader(new
		 * InputStreamReader(System.in)); BufferedWriter bufferedWriter = new
		 * BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		 */
		/*
		 * String a = bufferedReader.readLine();
		 * 
		 * String b = bufferedReader.readLine();
		 */

		showData("cde", "abc");
		showData("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke");
		showData("showman", "woman");
		showData("bugexikjevtubidpulaelsbcqlupwetzyzdvjphn",
				"lajoipfecfinxjspxmevqxuqyalhrsxcvgsdxxkacspbchrbvvwnvsdtsrdk");

		/*
		 * bufferedWriter.write(String.valueOf(res)); bufferedWriter.newLine();
		 * 
		 * bufferedReader.close(); bufferedWriter.close();
		 */
	}
}
