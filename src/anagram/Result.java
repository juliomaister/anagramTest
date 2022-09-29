package anagram;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Result {

	/*
	 * Complete the 'getAnagrams' function below.
	 *
	 * The function is expected to return a STRING_ARRAY. The function accepts
	 * STRING text as parameter.
	 */

	public static List<String> getAnagrams(String text) {
		text = normalize(text);
		List<String> anagramList = new ArrayList<>();
		List<String> textList = Arrays.asList(text.split(" "));

		for (int i = 0; i < textList.size(); i++) {
			for (int j = 0; j < textList.size(); j++) {
				if (i == j)
					continue;
				if (isAnagram(textList.get(i), textList.get(j))) {
					if (!anagramList.contains(textList.get(i)))
						anagramList.add(textList.get(i));
					if (!anagramList.contains(textList.get(j)))
						anagramList.add(textList.get(j));
				}
			}
		}
		anagramList.stream().sorted().collect(Collectors.toList());
		return anagramList;

	}

	private static boolean isAnagram(String s1, String s2) {
		if ((s1.length() != s2.length()) || (s1.length() == 1 || s2.length() == 1)) {
			return false;
		}

		char[] c1 = s1.toLowerCase().toCharArray();
		char[] c2 = s2.toLowerCase().toCharArray();

		Arrays.sort(c1);
		Arrays.sort(c2);

		String sc1 = new String(c1);
		String sc2 = new String(c2);
		return sc1.equals(sc2);
	}

	public static String normalize(String str) {
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{Punct}");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
}
