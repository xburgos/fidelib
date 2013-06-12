package org.runtimerror.fidelib.parser;

import org.runtimerror.fidelib.description.FileDescription;
import org.runtimerror.fidelib.exception.ParserException;
import org.runtimerror.fidelib.report.ParseReport;

public interface Parser {

	public abstract ParseReport parse(FileDescription descriptor, String filePath)
			throws ParserException;

	public abstract ParseReport parse(String path) throws ParserException;

	public abstract ParseReport parse() throws ParserException;

}