package org.digitalcraftsman.fidelib;


import org.digitalcraftsman.fidelib.parser.ParserFactory;
import org.digitalcraftsman.fidelib.parser.Parser;
import org.digitalcraftsman.fidelib.report.Report;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParserUnitTest {

    private static final String RESOURCES_BASE = "src/test/resources/";

    private Parser parser;

    @Before
    public void setUp() {
        this.parser = ParserFactory.configure();
    }

    @Test(expected = FileNotFoundException.class)
    public void GivenNonExistentFile_WhenRun_ExceptionIsThrown() throws FileNotFoundException {
        parser.run("i_do_not_exist.txt");
    }

    @Test
    public void GivenEmptyFileWithNoConfiguration_WhenParserRun_WeGetABasicReport() throws FileNotFoundException {
        String testFile = "empty_test_file.txt";
        Report report = parser.run(resource(testFile));
        assertThat(report, is(notNullValue()));
        assertThat(report.getFileName(), is(testFile));
        assertThat(report.getLinesParsed(), is(0));
    }

    private String resource(String name) {
        return RESOURCES_BASE + name;
    }
}
