package org.runtimerror.fidelib.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.runtimerror.fidelib.description.FileDescription;
import org.runtimerror.fidelib.exception.ParserException;
import org.runtimerror.fidelib.report.BasicParseReport;
import org.runtimerror.fidelib.report.ParseReport;
import org.runtimerror.fidelib.section.FileSection;

public abstract class AbstractParser implements Parser {
	
	private FileDescription descriptor;
	private String filePath;
	private Integer linesRead;
	private ParseReport report;
	private List<Object> dataMap;
	
	public AbstractParser() {
		this.linesRead = 1; 
		this.dataMap = new ArrayList<Object>();
	}
	public AbstractParser(FileDescription descriptor, ParseReport report) {
		this.dataMap = new ArrayList<Object>();
		this.report = report;
		this.linesRead = 1;
		this.descriptor = descriptor;
	}

	public AbstractParser(FileDescription descriptor, String filePath, ParseReport report) {
		this.dataMap = new ArrayList<Object>();
		this.linesRead = 1;
		this.descriptor = descriptor;
		this.filePath = filePath;
		this.report = report;
	}
	
	/* (non-Javadoc)
	 * @see uk.co.ecube.parser.Parser#parse(uk.co.ecube.parser.FileDescriptor, java.lang.String)
	 */
	public ParseReport parse(FileDescription descriptor, String filePath) throws ParserException{
		if(descriptor == null || filePath == null || filePath.trim().length() == 0) {
			throw new InvalidParameterException("Neither descriptor or filePath may be null or empty.");
		}
		BufferedReader reader = null;
		try {
			File file = new File(filePath);
			reader = new BufferedReader(new FileReader(file));
			if(report == null) report = new BasicParseReport();
			for (FileSection section : descriptor.getSections()) {
				section.setParsedLines(dataMap);
				section.parseSection(linesRead, report, reader);
			}
			return report;
		} catch (Exception e) {
			throw new ParserException(e);
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new ParserException(e);
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see uk.co.ecube.parser.Parser#parse(java.lang.String)
	 */
	public ParseReport parse(String path) throws ParserException{
		return parse(this.descriptor, path);
	}
	
	/* (non-Javadoc)
	 * @see uk.co.ecube.parser.Parser#parse()
	 */
	public ParseReport parse() throws ParserException{
		return parse(this.descriptor, this.filePath);
	}
	
}
