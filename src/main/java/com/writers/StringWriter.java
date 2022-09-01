package com.writers;

import java.util.function.Function;

public class StringWriter implements Writer {
	
	private StringBuffer data = new StringBuffer();
	private boolean closed = false;
	
	public String read() {
		return data.toString();
	}
	

	@Override
	public void close() {
		this.closed = true;
	}
	
	public String apply(Function<String, String> f) {
		return f.apply(this.read());
	}


	@Override
	// it will delete what was writen before, and write a new data
	public boolean write(String s) {
		if (this.closed) {
			return false;			
		}
		this.data = new  StringBuffer();
		this.data.append(s);
		return true;
	}

}
