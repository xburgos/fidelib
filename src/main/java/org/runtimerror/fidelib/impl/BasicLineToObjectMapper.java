/**
 * 
 */
package org.runtimerror.fidelib.impl;

import java.util.Map;

import org.runtimerror.fidelib.AbstractLineToObjectMapper;


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
