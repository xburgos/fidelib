package org.runtimerror.fidelib.line;

import java.util.ArrayList;
import java.util.List;

import org.runtimerror.fidelib.mapper.LineToObjectMapper;
import org.runtimerror.fidelib.report.ParseReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractLineReader implements LineReader {
	
	private static final Logger log = LoggerFactory.getLogger(AbstractLineReader.class);

	public static final String DEFAULT_FIELD_SEPARATOR = ",";
	public static final String NO_FIELD_SEPARATOR = ".*";
	
	protected List<Object> parsedLines;
	protected String fieldSeparator;
	protected LineToObjectMapper objectMapper;
	protected Integer currentLineNumber;
	protected String currentLine;
	protected Object currentParsedLine;
	protected ParseReport report;

	@Override
	public Object parseLine(Integer lineNumber,String line, ParseReport report) throws Exception {
		if(line == null) {
			throw new IllegalArgumentException("line may not be null");
		}
		
		String[] columns = line.split(fieldSeparator);
		List<String> list = new ArrayList<String>(columns.length); 
		
		for(String column: columns) {
			log.debug("Adding column: "+column);
			list.add(column);
		}
		if(list.isEmpty()) {
			list.add(line);
		}
		
		this.currentParsedLine = list;
		
		if(objectMapper != null) {
			log.debug("About to map line to object.");
			this.currentParsedLine = objectMapper.map(list);
		}
		this.currentLineNumber = lineNumber;
		this.report = report;
		
		return currentParsedLine;
	}
	@Override
	public List<Object> getParsedLines() {
		return this.parsedLines;
	}
	@Override
	public void setParsedLines(List<Object> parsedLines) {
		this.parsedLines = parsedLines;
	}
}