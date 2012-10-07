//
//  LCS.java
//  Finds the longest common subsequence of two strings.
//
//  Created by Ryan Barril on 10/6/12.
//  Copyright 2012 __MyCompanyName__. All rights reserved.
//

public class LCS {
	
	static String findLCS(String s, String t) {
		String smax = "";
		int maxlen = 0;
		
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			temp = "";
			for (int j = 0; j < t.length(); j++) {
				if (s.charAt(i) == t.charAt(j)) {
					temp = temp + s.charAt(i) + findLCS(s.substring(i + 1), t.substring(j + 1));
					if (temp.length() > maxlen) {
						smax = temp;
						maxlen = temp.length();
					}
				}
			}
		}
		
		return smax;
	}
	
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Provide two strings");
			System.exit(0);
		}
		
		String s = args[0];
		String t = args[1];
		
		System.out.println(findLCS(s, t));
	}
}
