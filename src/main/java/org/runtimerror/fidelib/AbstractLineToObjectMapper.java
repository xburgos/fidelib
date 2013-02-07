package org.runtimerror.fidelib;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public abstract class AbstractLineToObjectMapper implements LineToObjectMapper{

	protected Class<?> mappedType;
	protected Map<Integer,String> propertiesMap;

	/**
	 * @return the mappedObject
	 */
	public Class<?> getMappedType() {
		return mappedType;
	}

	/**
	 * @param mappedObject the mappedObject to set
	 */
	public void setMappedType(Class<?> mappedType) {
		this.mappedType = mappedType;
	}

	/**
	 * @return the propertiesMap
	 */
	public Map<Integer, String> getPropertiesMap() {
		return propertiesMap;
	}

	/**
	 * @param propertiesMap the propertiesMap to set
	 */
	public void setPropertiesMap(Map<Integer, String> propertiesMap) {
		this.propertiesMap = propertiesMap;
	}

	@Override
	public Object map(List<?> columns) throws Exception {
		Object mappedObject = getMappedType().newInstance();
		
		for(int i = 0; i < columns.size(); i++) {
			Object column = columns.get(i);
			
			String propertyName = getPropertiesMap().get(Integer.valueOf(i+1));
			BeanUtils.setProperty(mappedObject, propertyName, column);
		}
		
		return mappedObject;
	}

}