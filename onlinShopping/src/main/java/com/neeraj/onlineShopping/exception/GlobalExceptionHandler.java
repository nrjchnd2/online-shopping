package com.neeraj.onlineShopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="no data found")
	public ModelAndView handlerProductNotFound(Exception ex){
		
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","Product not available");
		mv.addObject("errorDescription","This product is not currently available");
		mv.addObject("title","error page");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerAllException(Exception ex){
		
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","Something went wrong");
		mv.addObject("errorDescription","Please contact admin..");
		mv.addObject("title","error page");
		return mv;
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException(Exception ex){
		
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","This page hasn't been designed yet");
		mv.addObject("errorDescription","Please contact admin..");
		mv.addObject("title","error page");
		return mv;
	}
}
