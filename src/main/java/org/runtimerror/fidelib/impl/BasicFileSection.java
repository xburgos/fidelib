package org.runtimerror.fidelib.impl;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.runtimerror.fidelib.AbstractFileSection;
import org.runtimerror.fidelib.FileSection;
import org.runtimerror.fidelib.LineReader;
import org.runtimerror.fidelib.ParseReport;
import org.runtimerror.fidelib.ParserEventListener;
import org.runtimerror.fidelib.ParserEventSource;
import org.runtimerror.fidelib.SectionDelimiter;



public class BasicFileSection extends AbstractFileSection implements ParserEventSource {
	
	private Map<String, String> dataMap;
	private List<ParserEventListener> listeners = new ArrayList<ParserEventListener>();
	
	public BasicFileSection() {
		this.lineReader = new BasicLineReader();
		this.sectionDelimiter = new BasicSectionDelimiter();
	}
	
	public BasicFileSection(SectionDelimiter sectionDelimiter) {
		this.lineReader = new BasicLineReader();
		this.sectionDelimiter = sectionDelimiter;
	}
	
	public BasicFileSection(LineReader lineReader) {
		this.lineReader = lineReader;
		this.sectionDelimiter = new BasicSectionDelimiter();
	}
	
	public BasicFileSection(LineReader lineReader, SectionDelimiter sectionDelimiter){
		this.lineReader = lineReader;
		this.sectionDelimiter = sectionDelimiter;
	}	

	/**
	 * @return the lineReader
	 */
	public LineReader getLineReader() {
		return lineReader;
	}

	/**
	 * @param lineReader the lineReader to set
	 */
	public void setLineReader(LineReader lineReader) {
		this.lineReader = lineReader;
	}

	/**
	 * @return the sectionDelimiter
	 */
	public SectionDelimiter getSectionDelimiter() {
		return sectionDelimiter;
	}

	/**
	 * @param sectionDelimiter the sectionDelimiter to set
	 */
	public void setSectionDelimiter(SectionDelimiter sectionDelimiter) {
		this.sectionDelimiter = sectionDelimiter;
	}

	/**
	 * @return the sectionData
	 */
	public List<String> getSectionData() {
		return sectionData;
	}

	/**
	 * @param sectionData the sectionData to set
	 */
	public void setSectionData(List<String> sectionData) {
		this.sectionData = sectionData;
	}

	/**
	 * @return the subSections
	 */
	public List<FileSection> getSubSections() {
		return subSections;
	}

	/**
	 * @param subSections the subSections to set
	 */
	public void setSubSections(List<FileSection> subSections) {
		this.subSections = subSections;
	}

	/**
	 * @return the sectionName
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * @param sectionName the sectionName to set
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}	 
	
	@Override
	public List<Object> parseSection(Integer lineNumber, ParseReport report, BufferedReader reader) throws Exception {
		List<Object> result = super.parseSection(lineNumber, report, reader);
		
		notifyListeners();
		return result;
	}

	@Override
	public void addListener(ParserEventListener listener) {
		this.listeners.add(listener);		
	}

	@Override
	public void notifyListeners() {
		for(ParserEventListener listener : listeners) {
			listener.update(parsedLines);
		}
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
}
