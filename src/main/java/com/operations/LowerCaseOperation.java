package com.operations;

import com.writers.Writer;

public class LowerCaseOperation implements Operation{

	@Override
	public boolean apply(Writer writer) {
		// TODO Auto-generated method stub
		return writer.write(writer.read().toLowerCase());
	}

}
