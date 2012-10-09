//
//  LCS.java
//  Finds the longest common subsequence of two strings.
//
//  Created by Ryan Barril on 10/6/12.
//  Copyright 2012 __MyCompanyName__. All rights reserved.
//

import java.io.*;

public class LCS {
	
	public String findLCS(String s, String t) {
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
		if (args.length != 1) {
			System.out.println("Please provide a file path.");
			System.exit(0);
		}
		
		String path = args[0];
		LCS lcs = new LCS();
		
		try {
			BufferedReader buf = new BufferedReader(new FileReader(path));
			String line = null;
			int iteration = 0;
			while ((line = buf.readLine()) != null) {
				if (line.equals("")) continue;
				String[] words = line.split(";");
				String s = words[0]; String t = words[1];
				System.out.println(lcs.findLCS(s, t));
			}
		} catch (IOException x) {
			System.out.println("Invalid pathname.");
		}
	}
}