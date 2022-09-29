package anagram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collector;

public class Solution {
	 public static void main(String[] args) throws IOException {
	     
		 	String text= "Code? aaagmnrs, doce and anagrams";
	        List<String> result = Result.getAnagrams(text);
	        
	        for (String string : result) {
	        	System.out.println(result);
			}
	        
	    }

}
