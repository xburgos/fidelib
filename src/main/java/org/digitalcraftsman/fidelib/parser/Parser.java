package org.digitalcraftsman.fidelib.parser;

import org.digitalcraftsman.fidelib.report.Report;

import java.io.FileNotFoundException;

public interface Parser {

    public Report run(String fileName) throws FileNotFoundException;

}
