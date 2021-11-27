package com.yttranscriptformatter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ReadFileToString {
	
	public void readFile(String pathToFile){
		
		try{
				BufferedReader in = new BufferedReader(new FileReader(pathToFile));
				String str;
				File newFile = new File("newFile.txt");
				newFile.setWritable(true);
				newFile.setReadable(true);
				BufferedWriter out = new BufferedWriter(new FileWriter(newFile, true));				
				
				while( (str = in.readLine()) != null) {					
					
					String temp = new String(str + " ");
					out.append(temp);

				}
				
				in.close();
				out.close();
				chopLineLength();
								
		} catch(Exception e){
			e.printStackTrace();
			}
	}
	
	public void chopLineLength(){
				
		try{
		BufferedReader in = new BufferedReader(new FileReader("newFile.txt"));
		String str;
		File newFile = new File("formattedFile.txt");
		newFile.setWritable(true);
		newFile.setReadable(true);
		
		BufferedWriter out = new BufferedWriter(new FileWriter(newFile, true));
		String[] newArr = null;
		
		while( (str = in.readLine()) != null) {
					
			newArr = str.split(" ");
			
			for(int i = 0 ; i < newArr.length; i++){
				
				if(newArr[i].contains("[Music]")){
					newArr[i] = newArr[i].replace("[Music]", "");
				}
				
				out.append(newArr[i] + " ");				
				
				if( (i % 15) == 0){
					out.append("\n");
				}				
			}					
		}

		in.close();
		out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
