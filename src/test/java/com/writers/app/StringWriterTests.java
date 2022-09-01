package com.writers.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import com.operations.LowerCaseOperation;
import com.operations.Operation;
import com.operations.RemoveDublicationOperation;
import com.operations.RemoveStupidOperation;
import com.operations.UpperCaseOperation;
import com.writers.StringWriter;
import com.writers.Writer;

@Testable
class StringWriterTests {
	
	private Writer writer = new StringWriter();
	

	@Test
	void testWriteAndRead() {
		String msg = "first test";
		
		assertTrue(writer.write(msg));
		assertEquals(msg, writer.read());
		
		writer.close();
		
		assertFalse(writer.write("New message"));
		
		// let us make sure, the new message is ignored, and we still have the previous message before close
		assertEquals(msg, writer.read());

	}
	
	@Test
	void testLowerCaseOperation() {
		String msg = "capital letters to small letters";
		assertTrue(writer.write(msg));
		
		Operation op = new LowerCaseOperation();
		op.apply(writer);
		
		System.out.println(writer.read());
		
		assertEquals(msg.toLowerCase(), writer.read());	
	}
	@Test
	void testUpperCaseOperation() {
		String msg = "small letters to capital letters";
		assertTrue(writer.write(msg));
		
		Operation op = new UpperCaseOperation();
		op.apply(writer);
		
		assertEquals(msg.toUpperCase(), writer.read());	
		System.out.println(writer.read());
	}
	
	@Test
	void testRemoveStupidOperation() {
		String msg = "I see something stupid there, let us remove all of the stupid words";
		assertTrue(writer.write(msg));
		
		Operation op = new RemoveStupidOperation();
		op.apply(writer);
		assertFalse(writer.read().contains("stupid"));
		System.out.println(writer.read());
		
	}
	

	@Test
	void testRemoveDuplicationOperation() {
		String msg = "Let us remove remove remove some repeated repeated words";
		assertTrue(writer.write(msg));
		
		Operation op = new RemoveDublicationOperation();
		op.apply(writer);
		assertEquals("Let us remove some repeated words",writer.read());
		System.out.println(writer.read());
		
	}
	
	@Test
	void testOperations() {
	
		String msg = "Let us remove remove remove some repeated repeated words, and then the stupid word";
		assertTrue(writer.write(msg));
		
		Operation op = new RemoveDublicationOperation();
		op.apply(writer);
		assertEquals("Let us remove some repeated words, and then the stupid word",writer.read());
		
		op = new RemoveStupidOperation();
		op.apply(writer);
		assertEquals("Let us remove some repeated words, and then the s**** word",writer.read());
		System.out.println(writer.read());
		
		
	}
	
}
