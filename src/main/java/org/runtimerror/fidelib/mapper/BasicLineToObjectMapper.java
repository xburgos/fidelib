/**
 * 
 */
package org.runtimerror.fidelib.mapper;

import java.util.Map;


/**
 * @author Ess Laptop
 *
 */
public class BasicLineToObjectMapper extends AbstractLineToObjectMapper 
{
	public BasicLineToObjectMapper(Class<?> mappedType, Map<Integer,String> propertiesMap) {
		this.mappedType = mappedType;
		this.propertiesMap = propertiesMap;
	}
}
