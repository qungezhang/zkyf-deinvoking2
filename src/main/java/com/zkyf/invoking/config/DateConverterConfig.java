package com.zkyf.invoking.config;

import com.zkyf.invoking.common.DateUtils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateConverterConfig implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		return new DateFormat().parse(source);
	}

	@Bean(name = "mapperObject")
	public ObjectMapper getObjectMapper() {
	    ObjectMapper om = new ObjectMapper();
	    om.setDateFormat(new DateFormat());
	    om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//	    om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	    return om;
	}

	public class DateFormat extends SimpleDateFormat{

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		private String [] formarts = {"yyyy-MM","yyyy-MM-dd","yyyy-MM-dd HH:mm","yyyy-MM-dd HH:mm:ss"};

		@Override
		public Date parse(String source){
			String value = source.trim();
	        if ("".equals(value)) {
	            return null;
	        }
	        if(source.matches("^\\d{4}-\\d{1,2}$")){
	        	return DateUtils.stringToDate(source, formarts[0]);
	        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
	        	return DateUtils.stringToDate(source, formarts[1]);
	        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){
	        	return DateUtils.stringToDate(source, formarts[2]);
	        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
	        	return DateUtils.stringToDate(source, formarts[3]);
	        }else {
	            throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
	        }
		}

		@Override
		public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition pos) {
			return new StringBuffer(DateUtils.format(date,formarts[3]));
		}

	}
}
