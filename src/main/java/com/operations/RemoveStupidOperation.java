package com.operations;

import com.writers.Writer;

public class RemoveStupidOperation implements Operation{

	@Override
	public boolean apply(Writer writer) {
		String str = writer.read();		
		return writer.write(writer.read().replaceAll("stupid|STUPID|Stupid","s****"));
	}

}
