package com.writers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileWriter implements Writer {
    
	private boolean closed = false;
	private static String FILE_PATH ="data";
	private String fileName;

	public FileWriter(String fileName) {
		
		this.fileName = fileName;
		
	}


	@Override
	public void close() {
		if (this.closed) {
			return;
		}
		
			
			this.closed = true;
		
	}

	@Override
	public String read() {
		StringBuilder str = new StringBuilder();
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH+"/"+this.fileName));
	    	 String currentLine;
			while ( (currentLine = reader.readLine()) !=null){
				str.append(currentLine);
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
		return str.toString();
	}

	@Override
	// it will delete what was written before, and write a new data
	public boolean write(String s) {
		if (this.closed) {
			return false;			
		}
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new java.io.FileWriter(FILE_PATH+"/"+fileName));
			writer.write(s);
		    writer.close();
		    return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	    
	}

}
	
	

