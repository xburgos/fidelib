package org.runtimerror.fidelib;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public abstract class AbstractLineToObjectMapper implements LineToObjectMapper{

	protected Class<?> mappedType;
	protected Map<Integer,String> propertiesMap;

	public Class<?> getMappedType() {
		return mappedType;
	}

	public void setMappedType(Class<?> mappedType) {
		this.mappedType = mappedType;
	}

	public Map<Integer, String> getPropertiesMap() {
		return propertiesMap;
	}

	public void setPropertiesMap(Map<Integer, String> propertiesMap) {
		this.propertiesMap = propertiesMap;
	}

	@Override
	public Object map(List<?> columns) throws Exception {
		Object mappedObject = getMappedType().newInstance();
		
		for(int i = 0; i < columns.size(); i++) {
			Object column = columns.get(i);
			
			String propertyName = getPropertiesMap().get(i+1);
			BeanUtils.setProperty(mappedObject, propertyName, column);
		}
		
		return mappedObject;
	}

}