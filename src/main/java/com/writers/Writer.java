package com.writers;

public interface Writer {
	String read();
	boolean write(String s);
	void close();
}
