package org.runtimerror.fidelib.section;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import org.runtimerror.fidelib.line.LineReader;
import org.runtimerror.fidelib.report.ParseReport;
import org.runtimerror.fidelib.section.delimiter.SectionDelimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractFileSection implements FileSection {

	private static final Logger log = LoggerFactory.getLogger(AbstractFileSection.class);
	
	protected Integer linesRead = 1;
	protected List<String> sectionData = new ArrayList<String>();
	protected List<Object> parsedLines;
	protected List<FileSection> subSections = new ArrayList<FileSection>();
	
	protected String sectionName;
	protected LineReader lineReader;
	protected SectionDelimiter sectionDelimiter;


	@Override
	public List<Object> parseSection(Integer lineNumber, ParseReport report, BufferedReader reader) throws Exception {
		this.linesRead = lineNumber;
		String line = null;
		
		if(subSections.isEmpty()) {
			log.debug(sectionName+" has no sub-sections");
			while( (line = reader.readLine()) != null && sectionDelimiter.isWithinLimits(line)) {
				log.debug("Read line: "+line);
				this.sectionData.add(line);
				this.lineReader.setParsedLines(parsedLines);
				this.parsedLines.add(lineReader.parseLine(linesRead, line, report));
				this.linesRead++;
			}
			log.debug("Finished reading "+sectionName+", no more sub-sections");
		} else {
			log.debug(sectionName+" has "+subSections.size()+" sub-sections");
			for(FileSection section: subSections) {
				log.debug("About to start "+sectionName);
				section.setParsedLines(parsedLines);
				
				while( (line = reader.readLine()) != null && sectionDelimiter.isWithinLimits(line)) {
					log.debug("Readed line: "+line);
					
					if(section.isSectionWithinLimits(line)) {
						
						section.parseSection(linesRead, report, reader);
					} else if (section.isSectionOver()) {
						
						break;
					} else {
						this.sectionData.add(line);
						this.lineReader.setParsedLines(parsedLines);
						this.parsedLines.add(lineReader.parseLine(linesRead, line, report));
						this.linesRead++;
					}
				}				
			}
		}
		log.debug("Finished reading lines for "+sectionName);
		
		return parsedLines;
	}
	
	@Override
	public Boolean isSectionWithinLimits(String line) {
		return sectionDelimiter.isWithinLimits(line);
	}
	@Override
	public Boolean isSectionOver() {
		return sectionDelimiter.isOver();
	}
	@Override
	public List<Object> getParsedLines() {
		return parsedLines;
	}
	@Override
	public void setParsedLines(List<Object> dataMap) {
		this.parsedLines = dataMap;		
	}
	
}