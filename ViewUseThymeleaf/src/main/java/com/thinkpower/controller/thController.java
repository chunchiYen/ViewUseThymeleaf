package com.thinkpower.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.thinkpower.model.Person;
import com.thinkpower.model.VisitInfo;

@Controller
@RequestMapping("/thymeleaf")
public class thController {
	@Value("WellCome to my Thymeleaf Example !")
	private String welcomeMessage;
	@Value("<b>WellCome to my Thymeleaf Example !<b>")
	private String welcomeMessageWithHtml;
	private List<String> appliancesIndex = Arrays.asList("C","B","A","E","D");
	private List<String> appliancesArr = Arrays.asList("冷氣","冰箱","電風扇","氣炸鍋","吸塵器");		
	private List<String> serarchArr = Arrays.asList("A","E");
	private List<Integer> numList = Arrays.asList(238,900,602,242,101);
	private List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	private Integer[] intArr= {20,21,12,81,11,92};
	private Map<String, String> localMaps = Stream.of(new String[][] {
		  { "zh_TW", "台灣" }, 
		  { "FR", "法國"}, 
		  { "zh_CN", "中國大陸"}, 
		  { "en_US", "美國"}, 
		  { "JP", "日本" }, 
		  { "ru", "俄羅斯" }, 
		}).collect(Collectors.toMap(data -> data[0], data -> data[1]));
	
	
	@Autowired
	private LocaleResolver localeResolver;

	
	@RequestMapping({"/",""})	
	public String toExample(Model model , HttpServletRequest request , HttpServletResponse response) {			
		int numA = 12;
		int numB = 4;
		String[] stringArr = {"B","C","D","F","E","A"};
		String[] stringArr2 = {"A","F"};		
		model.addAttribute("welcomeMessageWithHtml", welcomeMessageWithHtml);
		model.addAttribute("welcomeMessage", welcomeMessage);
		model.addAttribute("numA", numA);
		model.addAttribute("numB", numB);
		model.addAttribute("stringArr", stringArr);
		model.addAttribute("stringArr2", stringArr2);	
		model.addAttribute("numList", numList);
		model.addAttribute("intArr", intArr);
		model.addAttribute("intList", intList);		
		model.addAttribute("appliancesIndex", appliancesIndex);
		model.addAttribute("appliancesArr", appliancesArr);
		model.addAttribute("serarchArr", serarchArr);		
		model.addAttribute("localMaps", localMaps);		
		model.addAttribute("lang", request.getParameter("lang"));
		
		VisitInfo visitor = new VisitInfo("Tony Stark","159.11.133.25","2021/02/28");
		model.addAttribute("visitor", visitor);		
		
		List<VisitInfo>  visitorList= new ArrayList<VisitInfo>();
		visitorList.add(new VisitInfo("Ken","172.18.12.250","2019/08/15"));
		visitorList.add(new VisitInfo("Joe","192.168.12.20","2019/12/22"));
		visitorList.add(new VisitInfo("Tin","201.108.11.143","2019/10/11"));
		visitorList.add(new VisitInfo("Jessica","211.10.111.14","2020/03/01"));
		model.addAttribute("visitorList", visitorList);		
		
		List<Person> personList =new  ArrayList<Person>();		
		personList.add(new Person("A123456789","Jimmy",30));
		personList.add(new Person("B123456789","Jerry",31));
		personList.add(new Person("C123456789","Denny",20));
		personList.add(new Person("D223456789","Dora",21));
		personList.add(new Person("E223456789","Emily",55));
		personList.add(new Person("F123456789","Ken",78));
		personList.add(new Person("G223456789","Tina",22));
		personList.add(new Person("H223456789","Lucy",25));
		model.addAttribute("personifno", personList);
		
		HashMap<String , String> appliancesMap = new HashMap<String,String>();
		appliancesMap.put("C", "冷氣");
		appliancesMap.put("B", "冰箱");
		appliancesMap.put("A", "電風扇");
		appliancesMap.put("E", "氣炸鍋");
		appliancesMap.put("D", "吸塵器");
		model.addAttribute("appliancesMap", appliancesMap);
		model.addAttribute("appliancesSelected", "E");		
		
		Set<String> nameSet = new HashSet<String>();
		nameSet.add("Tina");
	    nameSet.add("Jimmy");
	    nameSet.add("Hank");
	    nameSet.add(null);
	    nameSet.add("Denny");
	    model.addAttribute("nameSet", nameSet);
	    
	    String[] searchNames = {"Tina","Denny"};	 
	    model.addAttribute("searchNames", searchNames);
	    
		model.addAttribute("company", "thinkpower");
		model.addAttribute("isHidden" ,true);
		model.addAttribute("today" ,new Date());
		
		model.addAttribute("flagTrue", "TRUE");
		model.addAttribute("flagFalse", false);		
		
		
		model.addAttribute("oddeven", "odd");
		model.addAttribute("cssbgpink", "cssbgpink");
		return "thymeleafExample";
	}
	@PostMapping("/visit")
	public String toVisitPage(Model model , @RequestParam String username 
			,@RequestParam String visitip , @RequestParam String visittime) {
		
		System.out.println("to visit page ");
		model.addAttribute("username", username);
		model.addAttribute("visitip", visitip);
		model.addAttribute("visittime", visittime);
		return "visitpage";
	}
  

}
class User{
	public String name1;
	public String name2;
	public String name3;
	public String name4;
	public User(String name1 , String name2 , String name3 , String name4) {
		this.name1 = name1;
		this.name2 = name2;
		this.name3 = name3;
		this.name4 = name4;
	}
}