package com.operations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.writers.Writer;

public class RemoveDublicationOperation implements Operation {

	@Override
	public boolean apply(Writer writer) {
		String regex= "\\b(\\w+)(?:\\W+\\1\\b)+";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		String input = writer.read();
		Matcher m = p.matcher(input);
		while (m.find()) {
			input = input.replaceAll(m.group(), m.group(1));
		}

		return writer.write(input);
	}

}
