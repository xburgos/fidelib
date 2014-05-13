package org.runtimerror.fidelib.line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.runtimerror.fidelib.mapper.LineToObjectMapper;
import org.runtimerror.fidelib.report.ParseReport;
import org.runtimerror.fidelib.event.ParserEventListener;
import org.runtimerror.fidelib.event.ParserEventSource;


public class BasicLineReader extends AbstractLineReader implements ParserEventSource{
	
	private List<ParserEventListener> listeners = new ArrayList<ParserEventListener>();
	
	public BasicLineReader() {
		this.fieldSeparator = DEFAULT_FIELD_SEPARATOR;
		this.objectMapper = null;
	}
	
	public BasicLineReader(String fieldSeparator) {
		this.fieldSeparator = fieldSeparator;
		this.objectMapper = null;
	}
	
	public BasicLineReader(LineToObjectMapper objectMapper) {
		this.fieldSeparator = DEFAULT_FIELD_SEPARATOR;
		this.objectMapper = objectMapper;
	}
	
	public BasicLineReader(String fieldSeparator, LineToObjectMapper objectMapper) {
		this.fieldSeparator = fieldSeparator;
		this.objectMapper = objectMapper;
	}

	protected LineToObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public void setObjectMapper(LineToObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public String getFieldSeparator() {
		return fieldSeparator;
	}

	public void setFieldSeparator(String fieldSeparator) {
		this.fieldSeparator = fieldSeparator;
	}

	public String getCurrentLine() {
		return currentLine;
	}

	public void setCurrentLine(String currentLine) {
		this.currentLine = currentLine;
	}

	public Object getCurrentParsedLine() {
		return currentParsedLine;
	}

	public void setCurrentParsedLine(Object currentParsedLine) {
		this.currentParsedLine = currentParsedLine;
	}
	
	@Override
	public void addListener(ParserEventListener listener) {
		this.listeners.add(listener);
	}
	
	@Override
	public void removeListener(ParserEventListener listener) {
		this.listeners.remove(listener);
	}
	
	public List<ParserEventListener> getListeners() {
		return listeners;
	}

	public void setListeners(List<ParserEventListener> listeners) {
		this.listeners = listeners;
	}

	@Override
	public void notifyListeners() {
		for(ParserEventListener listener : this.listeners) {
			Map<String, Object> data = new HashMap<String,Object>();
			data.put("lineNumber", currentLineNumber);
			data.put("parsedLine", currentParsedLine);
			data.put("parsedLines", parsedLines);
			data.put("report", report);
			listener.update(data);
		}
	}
	
	@Override
	public Object parseLine(Integer lineNumber,String line, ParseReport report) throws Exception {
		this.currentLine = line;
		this.currentParsedLine =  super.parseLine(lineNumber,line, report);
		notifyListeners();
		return currentParsedLine;
	}
	
}