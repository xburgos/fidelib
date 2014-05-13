package org.runtimerror.fidelib.line

import spock.lang.Specification
import spock.lang.Unroll

import static org.runtimerror.fidelib.line.AbstractLineReader.DEFAULT_FIELD_SEPARATOR


@Unroll
class BasicLineReaderSpec extends Specification {

       def 'when I create a basic reader without a field separator the default is used'() {

           expect:
                new BasicLineReader().getFieldSeparator() == DEFAULT_FIELD_SEPARATOR
       }

       def 'when I create a basic reader with a field separator the supplied separator is used'() {

           given:
                String fieldSeparator = "[0-9][A-Z]"

           expect:
                new BasicLineReader(fieldSeparator).getFieldSeparator() == fieldSeparator

       }

}
