package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {

		return "helloworld-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {

		return "helloworld";
	}

	@RequestMapping("/processFormTwo")
	public String processFormTwo(HttpServletRequest request, Model model) {

		String name = request.getParameter("studentName");
		name = name.toUpperCase();
		String result = "YO " + name;

		model.addAttribute("message", result);

		return "helloworld";
	}

	@RequestMapping("/processFormThree")
	public String processFormThree(@RequestParam("studentName") String theName, Model model) {

		theName = theName.toUpperCase();
		String result = "YO " + theName;

		model.addAttribute("message", result);

		return "helloworld";

	}

}
