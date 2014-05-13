package org.digitalcraftsman.fidelib;

import org.digitalcraftsman.fidelib.parser.Parser;
import org.digitalcraftsman.fidelib.parser.ParserFactory;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParserFactoryUnitTest {

    @Test
    public void WhenConfiguredWithoutParameters_ThenDefaultParserIsBuilt() {

        Parser parser = ParserFactory.configure();
        assertThat(parser, is(notNullValue()));
    }

}
