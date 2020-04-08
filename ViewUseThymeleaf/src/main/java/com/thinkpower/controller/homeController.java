package com.thinkpower.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
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
	
	private static HashMap<String , String> map ;
	static{
		map = new HashMap<String,String>();
		map.put("zh_TW", "台灣");
		map.put("FR", "法國");		
		map.put("zh_CN", "中國大陸");
		map.put("en_US", "美國");
		map.put("JP", "日本");
		map.put("ru", "俄羅斯");
	}
	
	private Map<String, String> localMaps = Stream.of(new String[][] {
		  { "zh_TW", "台灣" }, 
		  { "FR", "法國"}, 
		  { "zh_CN", "中國大陸"}, 
		  { "en_US", "美國"}, 
		  { "JP", "日本" }, 
		  { "ru", "俄羅斯" }, 
		}).collect(Collectors.toMap(data -> data[0], data -> data[1]));
		
	@GetMapping("/")
	public String toIndex(Model model) {	

		model.addAttribute("welcomeMessage", welcomeMessage);
		model.addAttribute("localMaps", localMaps);
		
		return "home";
	}
	@GetMapping("/home")
	public String toHome(Model model) {
		System.out.println("to home ");
		model.addAttribute("welcomeMessage", welcomeMessage);
		model.addAttribute("localMaps", localMaps);
		return "home";
	}
}