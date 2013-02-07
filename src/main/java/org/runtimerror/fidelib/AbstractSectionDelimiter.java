package org.runtimerror.fidelib;


import org.runtimerror.fidelib.impl.BasicSectionDelimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSectionDelimiter implements SectionDelimiter{

	private static final Logger log = LoggerFactory.getLogger(BasicSectionDelimiter.class);
	protected String startString;
	protected String endString;
	protected Boolean isStartPositionReached = Boolean.FALSE;
	protected Boolean isEndPositionReached = Boolean.FALSE;

	/**
	 * @return the startString
	 */
	public String getStartString() {
		return startString;
	}

	/**
	 * @param startString the startString to set
	 */
	public void setStartString(String startString) {
		this.startString = startString;
	}

	/**
	 * @return the endString
	 */
	public String getEndString() {
		return endString;
	}

	/**
	 * @param endString the endString to set
	 */
	public void setEndString(String endString) {
		this.endString = endString;
	}

	@Override
	public Boolean isWithinLimits(String line) {
		log.debug("About to check wether '"+line+"' is within limits.");
		
		if(this.isStartPositionReached && this.isEndPositionReached) {
			log.debug("Both the start position and the end position have been reached, section is over.");
			return Boolean.FALSE;
		}
		
		if(this.isStartPositionReached && !this.isEndPositionReached) {
			if(getEndString().equals("") || getEndString().equals(line)) {
				log.debug("End position '"+getEndString()+"' has been reached");
				this.isEndPositionReached = Boolean.TRUE;
				return Boolean.FALSE;
			} else {
				log.debug("End position not yet reached, still within limits.");
			}
			return Boolean.TRUE;
		}
		
		if(!this.isStartPositionReached) {
			if(getStartString().equals("") || getStartString().equals(line)) {
				log.debug("Start position '"+getStartString()+"' has been reached");
				this.isStartPositionReached = Boolean.TRUE;
				return Boolean.TRUE;
			}
		}
		log.debug("Section is not within limits");
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean isOver() {
		return (this.isStartPositionReached && this.isEndPositionReached);
	}
}