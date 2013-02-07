package org.runtimerror.fidelib.impl;

import java.util.Map;

import org.runtimerror.fidelib.ParseEvent;

public class BasicParseEvent implements ParseEvent {
	
	private Integer currentLineNumber;
	private String currentLine;
	private String[] currentParsedLine;
	private Object currentMappedLine;
	
	private Map<Integer, String> linesReadSoFar;
	private Map<Integer, String[]> linesParsedSoFar;
	private Map<Integer, Object[]> linesMappedSoFar;
	/**
	 * @return the currentLineNumber
	 */
	@Override
	public Integer getCurrentLineNumber() {
		return currentLineNumber;
	}
	/**
	 * @param currentLineNumber the currentLineNumber to set
	 */
	public void setCurrentLineNumber(Integer currentLineNumber) {
		this.currentLineNumber = currentLineNumber;
	}
	/**
	 * @return the currentLine
	 */
	@Override
	public String getCurrentLine() {
		return currentLine;
	}
	/**
	 * @param currentLine the currentLine to set
	 */
	public void setCurrentLine(String currentLine) {
		this.currentLine = currentLine;
	}
	/**
	 * @return the currentParsedLine
	 */
	@Override
	public String[] getCurrentParsedLine() {
		return currentParsedLine;
	}
	/**
	 * @param currentParsedLine the currentParsedLine to set
	 */
	public void setCurrentParsedLine(String[] currentParsedLine) {
		this.currentParsedLine = currentParsedLine;
	}
	/**
	 * @return the currentMappedLine
	 */
	@Override
	public Object getCurrentMappedLine() {
		return currentMappedLine;
	}
	/**
	 * @param currentMappedLine the currentMappedLine to set
	 */
	public void setCurrentMappedLine(Object currentMappedLine) {
		this.currentMappedLine = currentMappedLine;
	}
	/**
	 * @return the linesReadSoFar
	 */
	@Override
	public Map<Integer, String> getLinesReadSoFar() {
		return linesReadSoFar;
	}
	/**
	 * @param linesReadSoFar the linesReadSoFar to set
	 */
	public void setLinesReadSoFar(Map<Integer, String> linesReadSoFar) {
		this.linesReadSoFar = linesReadSoFar;
	}
	/**
	 * @return the linesParsedSoFar
	 */
	@Override
	public Map<Integer, String[]> getLinesParsedSoFar() {
		return linesParsedSoFar;
	}
	/**
	 * @param linesParsedSoFar the linesParsedSoFar to set
	 */
	public void setLinesParsedSoFar(Map<Integer, String[]> linesParsedSoFar) {
		this.linesParsedSoFar = linesParsedSoFar;
	}
	/**
	 * @return the linesMappedSoFar
	 */
	@Override
	public Map<Integer, Object[]> getLinesMappedSoFar() {
		return linesMappedSoFar;
	}
	/**
	 * @param linesMappedSoFar the linesMappedSoFar to set
	 */
	public void setLinesMappedSoFar(Map<Integer, Object[]> linesMappedSoFar) {
		this.linesMappedSoFar = linesMappedSoFar;
	}

	

}
