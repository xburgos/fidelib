package org.runtimerror.fidelib;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BasicParseReport implements ParseReport {
	
	private Date date;
	private String summary;
	private Severity severity;
	private Integer linesParsed;
	private Map<String, List<ReportLineMessage>> eventsPerLine = new TreeMap<String, List<ReportLineMessage>>();
	
	public BasicParseReport() {
		this.summary = "";
		this.severity = Severity.NORMAL;
		this.linesParsed = 0;
		this.date = new Date();
	}
	
	/* (non-Javadoc)
	 * @see uk.co.ecube.parser.ParseReport#getLinesParsed()
	 */
	public Integer getLinesParsed() {
		return linesParsed;
	}
	/* (non-Javadoc)
	 * @see uk.co.ecube.parser.ParseReport#setLinesParsed(java.lang.Integer)
	 */
	public void setLinesParsed(Integer linesParsed) {
		this.linesParsed = linesParsed;
	}
	
	/* (non-Javadoc)
	 * @see uk.co.ecube.parser.ParseReport#getEventsPerLine()
	 */
	public Map<String, List<ReportLineMessage>> getEventsPerLine() {
		return eventsPerLine;
	}
	/* (non-Javadoc)
	 * @see uk.co.ecube.parser.ParseReport#setEventsPerLine(java.util.Map)
	 */
	public void setEventsPerLine(Map<String, List<ReportLineMessage>> eventsPerLine) {
		this.eventsPerLine = eventsPerLine;
	}
	/* (non-Javadoc)
	 * @see uk.co.ecube.parser.ParseReport#getSummary()
	 */
	public String getSummary() {
		return summary;
	}
	/* (non-Javadoc)
	 * @see uk.co.ecube.parser.ParseReport#setSummary(java.lang.String)
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/* (non-Javadoc)
	 * @see uk.co.ecube.parser.ParseReport#getDate()
	 */
	public Date getDate() {
		return date;
	}
	/* (non-Javadoc)
	 * @see uk.co.ecube.parser.ParseReport#setDate(java.util.Date)
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/* (non-Javadoc)
	 * @see uk.co.ecube.parser.ParseReport#getSeverity()
	 */
	public Severity getSeverity() {
		return severity;
	}
	/* (non-Javadoc)
	 * @see uk.co.ecube.parser.ParseReport#setSeverity(uk.co.ecube.parser.Severity)
	 */
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}
	/* (non-Javadoc)
	 * @see uk.co.ecube.parser.ParseReport#dismiss()
	 */
	public void dismiss() {
		this.linesParsed = 0;
		this.eventsPerLine.clear();
	}

	
	

}
