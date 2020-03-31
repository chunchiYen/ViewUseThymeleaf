package com.thinkpower.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thinkpower.model.Person;
import com.thinkpower.model.VisitInfo;

@Controller
public class homeController {
	@Value("WellCome to my Thymeleaf Example !")
	private String welcomeMessage;
	@Value("<b>WellCome to my Thymeleaf Example !<b>")
	private String welcomeMessageWithHtml;
	private List<String> appliancesIndex = Arrays.asList("C","B","A","E","D");

	private Integer[] intArr= {20,21,12,81,11,92};
		
	@GetMapping("/")
	public String toIndex(Model model) {
		System.out.println("to home ");
		model.addAttribute("welcomeMessage", welcomeMessage);
		return "home";
	}
	@GetMapping("/home")
	public String toHome(Model model) {
		System.out.println("to home ");
		model.addAttribute("welcomeMessage", welcomeMessage);
		return "home";
	}
}