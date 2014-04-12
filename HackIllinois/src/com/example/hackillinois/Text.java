package com.example.hackillinois;

import java.io.*;
import java.util.Scanner;

public class Text {

	private String input;
	private String fileName;
	private PrintWriter outputFile;
	private Scanner scan;
	
	
	public Text(String input, String fileName){
		super();
		this.input=input;
		this.fileName=fileName;
		try{
			this.outputFile=new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			outputFile.print(input);
			this.scan=new Scanner(new BufferedReader(new FileReader(fileName)));
		}
		catch (IOException e) {
			System.out.println(e.getMessage() + ", so nothing was done.");
			e.printStackTrace();
		}
		finally{
			outputFile.close();
		}
	}
	
	public String getInput(){
		return input;
	}
	public String getFileName(){
		return fileName;
	}
	public String checkOutputFile(){
		String result="";
		while (scan.hasNext())
			result+=scan.nextLine();
		scan.close();
		return result;
	}
	
	
	
}
