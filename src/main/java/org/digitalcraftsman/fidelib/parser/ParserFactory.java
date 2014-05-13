package org.digitalcraftsman.fidelib.parser;

import org.digitalcraftsman.fidelib.report.Report;

import java.io.File;
import java.io.FileNotFoundException;

public class ParserFactory {

    private ParserFactory(){}

    public static Parser configure() {
        return new StreamBasedParser();
    }

    private static class StreamBasedParser implements Parser {

        @Override
        public Report run(String fileName) throws FileNotFoundException{
            File file = new File(fileName);
            if(!file.exists()) throw new FileNotFoundException();
            return new Report(fileName);
        }
    }
}
