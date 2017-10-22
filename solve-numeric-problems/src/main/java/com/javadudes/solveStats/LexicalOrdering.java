package com.javadudes.solveStats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LexicalOrdering {
	public void calculateLexicalWeight(List<String> strList) {

		Map<Integer, String> strWeightage = new HashMap<Integer, String>();
		List<String> sortedString = new ArrayList<String>();

		System.out.println("Before Sorting");
		for (int m = 0; m < strList.size(); m++) {
			System.out.println("Element @ " + (m + 1) + " : " + strList.get(m));
		}

		for (int i = 0; i < strList.size(); i++) {
			for (int j = i + 1; j < strList.size(); j++) {
				String str1 = strList.get(i);
				String str2 = strList.get(j);
				int length = (str1.length() > str2.length()) ? str2.length() : str1.length();
				for (int k = 0; k < length; k++) {
					System.out.println("Character for str1 : " + str1.charAt(k) + " | Weightage : "
							+ LexicalOrdering.getCharWeightage().get(str1.charAt(k)));
					System.out.println("Character for str2 : " + str2.charAt(k) + " | Weightage : "
							+ LexicalOrdering.getCharWeightage().get(str2.charAt(k)));
					if (LexicalOrdering.getCharWeightage().get(str1.charAt(k)) > LexicalOrdering.getCharWeightage()
							.get(str2.charAt(k)))
						break;
					else if (LexicalOrdering.getCharWeightage().get(str1.charAt(k)) == LexicalOrdering.getCharWeightage()
							.get(str2.charAt(k)) && k != length - 1)
						continue;
					else if (k == length - 1 && str1.length() > str2.length())
						continue;
					else {
						strList.set(i, str2);
						strList.set(j, str1);
						break;
					}
				}
			}
		}

		System.out.println("After Sorting");
		for (int l = 0; l < strList.size(); l++) {
			System.out.println("Element @ " + (l + 1) + " : " + strList.get(l));
		}

	}

	public static Map<Character, Integer> getCharWeightage() {

		Map<Character, Integer> charWeightage = new HashMap<Character, Integer>();
		charWeightage.put('a', 26);
		charWeightage.put('b', 25);
		charWeightage.put('c', 24);
		charWeightage.put('d', 23);
		charWeightage.put('e', 22);
		charWeightage.put('f', 21);
		charWeightage.put('g', 20);
		charWeightage.put('h', 19);
		charWeightage.put('i', 18);
		charWeightage.put('j', 17);
		charWeightage.put('k', 16);
		charWeightage.put('l', 15);
		charWeightage.put('m', 14);
		charWeightage.put('n', 13);
		charWeightage.put('o', 12);
		charWeightage.put('p', 11);
		charWeightage.put('q', 10);
		charWeightage.put('r', 9);
		charWeightage.put('s', 8);
		charWeightage.put('t', 7);
		charWeightage.put('u', 6);
		charWeightage.put('v', 5);
		charWeightage.put('w', 4);
		charWeightage.put('x', 3);
		charWeightage.put('y', 2);
		charWeightage.put('z', 1);

		return charWeightage;
	}

	public static void main(String args[]) {
		String[] strArray = new String[] { "abc", "dab", "dabc", "fhi" };
		LexicalOrdering rextester = new LexicalOrdering();
		rextester.calculateLexicalWeight(Arrays.asList(strArray));
	}
}