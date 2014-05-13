package org.digitalcraftsman.fidelib.report;

public class Report {

    private String fileName;
    private int linesParsed;

    public Report(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public int getLinesParsed() {
        return linesParsed;
    }

}
