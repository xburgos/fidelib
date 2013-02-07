package org.runtimerror.fidelib;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ParseReport {

	/**
	 * @return the linesParsed
	 */
	public abstract Integer getLinesParsed();

	/**
	 * @param linesParsed the linesParsed to set
	 */
	public abstract void setLinesParsed(Integer linesParsed);

	/**
	 * @return the eventsPerLine
	 */
	public abstract Map<String, List<ReportLineMessage>> getEventsPerLine();

	/**
	 * @param eventsPerLine the eventsPerLine to set
	 */
	public abstract void setEventsPerLine(
			Map<String, List<ReportLineMessage>> eventsPerLine);

	/**
	 * @return the summary
	 */
	public abstract String getSummary();

	/**
	 * @param summary the summary to set
	 */
	public abstract void setSummary(String summary);

	/**
	 * @return the date
	 */
	public abstract Date getDate();

	/**
	 * @param date the date to set
	 */
	public abstract void setDate(Date date);

	/**
	 * @return the severity
	 */
	public abstract Severity getSeverity();

	/**
	 * @param severity the severity to set
	 */
	public abstract void setSeverity(Severity severity);

	public abstract void dismiss();

}