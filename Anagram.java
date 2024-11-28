/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcessSpaces(str1);
		str2 = preProcessSpaces(str2);

		if (str1.length() != str2.length()) {
			return false;
		}

		int c = 0;

		char char1;
		for (int i = 0; i < str1.length(); i++) {
			char1 = str1.charAt(i);
			for (int j = 0; j < str1.length(); j++) {
				if(char1 == str2.charAt(j)){
					str2 = str2.substring(0, j) + " " + str2.substring(j+1);
					c++;
				}
			}
		}

		if (c == str1.length()) return true;

		return false;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newStr = "";
		char char1;

		for (int i = 0; i < str.length(); i++) {
			char1 = str.charAt(i);
			if ((char1 - 0) > 64 || (char1- 0) == 32) {
				if ((char1 - 0) > 90 || (char1 - 0) == 32) newStr = newStr + char1;
				else newStr = newStr + (char) (char1 + 32);
			}	
		}

		return newStr;
	} 

	public static String preProcessSpaces(String str) {
		String newStr = "";
        char char1;
		for (int i = 0; i < str.length(); i++) {
			char1 = str.charAt(i);
			if ((char1 - 0) != 32){
				if ((char1 - 0) > 90) newStr = newStr + char1;
				else newStr = newStr + (char) (char1 + 32);
			}
		}

		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newString = "";
		int rand;
		int i = 0;
		int length = str.length();

		while (i < length) {
			rand = (int) (Math.random() * str.length());
			newString += str.charAt(rand);

			str = str.substring(0, rand) + str.substring(rand+1);
			i++;
		}

		return newString;
	}
}