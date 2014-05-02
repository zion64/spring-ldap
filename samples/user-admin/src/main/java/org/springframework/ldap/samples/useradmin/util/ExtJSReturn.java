package org.springframework.ldap.samples.useradmin.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component 
public class ExtJSReturn {  
	/**
	 * Generates modelMap to return in the modelAndView
	 * @param contacts
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> mapOK(List list){

		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", list.size());
		modelMap.put("data", list);
		modelMap.put("success", true);
 
		return modelMap;
	}
	
	
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> mapOK(List list, long startTime){

		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", list.size());
		modelMap.put("data", list);
		modelMap.put("success", true);
		modelMap.put("duration", System.currentTimeMillis()-startTime);

		return modelMap;
	}
 
	/**
	 * Generates modelMap to return in the modelAndView
	 * @param contacts
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String,Object> mapOK(List list, Number total){

		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", total);
		modelMap.put("data", list); 
		modelMap.put("success", true); 

		return modelMap;
	}
	
	@SuppressWarnings("rawtypes")
	public static Map<String,Object> mapOK(List list, Number total, long startTime){
		long endTime = System.currentTimeMillis();
		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", total);
		modelMap.put("data", list);
		modelMap.put("success", true); 
		modelMap.put("duration", endTime-startTime);

		return modelMap;
	}
	
	/**
	 * Generates modelMap to return in the modelAndView in case
	 * of exception
	 * @param msg message
	 * @return
	 */
	public static Map<String,Object> mapError(String msg){

		Map<String,Object> modelMap = new HashMap<String,Object>(2);
		modelMap.put("message", msg);
		modelMap.put("success", false);

		return modelMap;
	} 
}
