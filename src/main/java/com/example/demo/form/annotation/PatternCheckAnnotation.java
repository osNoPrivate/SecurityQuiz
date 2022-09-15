package com.example.demo.form.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.demo.form.annotation.Imple.PatternCheckAnnotationImple;

@Target({ElementType.FIELD})
@Constraint(validatedBy={PatternCheckAnnotationImple.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface PatternCheckAnnotation {
	
	String message() default "{validation.PatternCheckAnnotationMessage}";
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}