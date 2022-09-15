package com.example.demo.form.annotation.Imple;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;

import com.example.demo.form.annotation.PatternCheckAnnotation;



public class PatternCheckAnnotationImple implements ConstraintValidator<PatternCheckAnnotation, String> {

	private static Pattern pattern = Pattern.compile("^[a-zA-Z0-9 -/:-@\\[-\\`\\{-\\~]+$");
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (StringUtils.isEmpty(value)) {
			return true;
		}

		return pattern.matcher(value).matches();
	}
}
