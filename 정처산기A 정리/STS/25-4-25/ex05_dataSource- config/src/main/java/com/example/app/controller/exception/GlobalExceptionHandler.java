package com.example.app.controller.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String AllExceptionExceptionHandler(Exception e, Model model) {
		log.info("GlobalExceptionHandler's error : " + e);
		model.addAttribute("ex",e);
		return "global_error";
	}

}
