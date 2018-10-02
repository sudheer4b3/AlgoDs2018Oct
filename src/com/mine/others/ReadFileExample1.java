package com.mine.others;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample1 {
	private static final String FILENAME = "/Users/mpatilr/Rules.java";
	public static void main(String[] args) {
		BufferedReader br = null;
		FileReader fr = null;
		try {
			//fr = new FileReader(FILENAME);
			//br = new BufferedReader(fr);
			String sCurrentLine = null;
			br = new BufferedReader(new FileReader(FILENAME));
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}