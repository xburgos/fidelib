/**
 * 
 */
package org.runtimerror.fidelib.mapper;

import java.util.List;

/**
 * @author Ess Laptop
 *
 */
public interface LineToObjectMapper {
	/**
	 * Maps the columns of a parsed line into the properties of an object.
	 * @param columns The columns of the parsed line.
	 * @return An <code>Object</code> intance of the type specified in the mapper.
	 */
	Object map(List<?> columns) throws Exception;
}
