package com.sh44794.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(path={"/","/home" })
	public String home() {
		return "index";
	}

}
