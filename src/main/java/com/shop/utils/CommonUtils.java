/**
 * 
 */
package com.shop.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.common.ResponseObject;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kartik.raina
 *
 */
public class CommonUtils {

	private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);

	private static ObjectMapper mapper = new ObjectMapper();

	public static String convertToJson(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			logger.error(e.getLocalizedMessage(), e);
		}
		return null;
	}

	public static Object convertToObject(String jsonString, Class<Object> cl) {
		try {
			return mapper.readValue(jsonString, cl);
		} catch (JsonParseException e) {
			logger.error(e.getLocalizedMessage(), e);
		} catch (JsonMappingException e) {
			logger.error(e.getLocalizedMessage(), e);
		} catch (IOException e) {
			logger.error(e.getLocalizedMessage(), e);
		}
		return null;
	}

	public static ResponseObject populateResponseObject(String status, String error, String message, String path) {
		ResponseObject responseObject = new ResponseObject();
		responseObject.setTimestamp(System.currentTimeMillis());
		responseObject.setStatus(status);
		responseObject.setError(error);
		responseObject.setMessage(message);
		responseObject.setPath(path);
		logger.info(responseObject.toString());
		return responseObject;
	}
}
