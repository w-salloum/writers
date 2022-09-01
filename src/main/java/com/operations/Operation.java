package com.operations;

import com.writers.Writer;

public interface Operation {
	boolean apply(Writer writer);
}
