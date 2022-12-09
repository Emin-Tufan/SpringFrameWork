package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	
	@InitBinder
	private void initBinder(WebDataBinder theData) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		theData.registerCustomEditor(String.class, editor);

	}

	@RequestMapping("/showForm")
	private String showForm(Model model) {

		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		return "customer-Form";
	}

	@RequestMapping("/processForm")
	private String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult theBindingResult) {

		if (theBindingResult == null || theBindingResult.hasErrors()) {
			return "customer-Form";

		} else {
			return "customerForm";
		}

	}
}
