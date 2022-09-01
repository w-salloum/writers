package com.writers.app;

import com.operations.Operation;
import com.operations.UpperCaseOperation;
import com.writers.StringWriter;
import com.writers.Writer;

public class MainApplication {

	public static void main(String[] args) {
		
		// let us create a new StringWriter 
		Writer writer = new StringWriter();
		writer.write("first test");
		Operation op = new UpperCaseOperation();
		op.apply(writer);
		System.out.println(writer.read());
		
		
	}

}
