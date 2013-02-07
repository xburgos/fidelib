package org.runtimerror.fidelib;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Xabier Burgos
 *
 */
public abstract class FileDescriptor {
	protected static final String DEFAULT_LINE_SEPARATOR = "\n";
	
	//private Map<String,String> additionalProperties;
	private List<FileSection> sections = new ArrayList<FileSection>();
	private String lineSeparator = DEFAULT_LINE_SEPARATOR;

	public void addSection(int position, FileSection section) {
		this.sections.add(position-1, section);
	}
	
	public void removeSection(int position) {
		this.sections.remove(position);
	}
	
	public List<FileSection> getSections() {
		return sections;
	}

	public String getLineSeparator() {
		return lineSeparator;
	}

	public void setLineSeparator(String lineSeparator) {
		this.lineSeparator = lineSeparator;
	}

	public void setSections(List<FileSection> sections) {
		this.sections = sections;
	}	
}
