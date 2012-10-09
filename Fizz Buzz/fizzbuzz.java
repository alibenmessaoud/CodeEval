/*
//  fizzbuzz.java
//  Created by Ryan Barril on 10/9/12.
*/

import java.io.*;

public class fizzbuzz {
	static String process(int a, int b, int n) {
		String output = "";
		for (int i = 1; i <= n; i++) {
			if (i % a == 0 && i % b == 0)
				output += "FB ";
			else if (i % a == 0)
				output += "F ";
			else if (i % b == 0)
				output += "B ";
			else
				output += i + " ";
		}
		return output.trim();
	}
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Please provide a file path.");
			System.exit(0);
		}
				
		try {
			BufferedReader buf = new BufferedReader(new FileReader(args[0]));
			String line = null;
			while ((line = buf.readLine()) != null) {
				String[] words = line.split(" ");
				int a = Integer.parseInt(words[0]);
				int b = Integer.parseInt(words[1]);
				int n = Integer.parseInt(words[2]);
				System.out.println(process(a, b, n));
			}
		} catch (IOException x) {
			System.out.println("Invalid pathname.");
		}
	}
}