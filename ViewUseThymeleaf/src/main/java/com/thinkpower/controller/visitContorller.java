package com.thinkpower.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/visit")
public class visitContorller {

	@RequestMapping(value={"","/"} , method= {RequestMethod.POST ,RequestMethod.GET})
	public String toVisitPage(Model model , @RequestParam String username 
				,@RequestParam String visitip , @RequestParam String visittime,HttpServletRequest request) {			
			
		model.addAttribute("username", username);
		model.addAttribute("visitip", visitip);
		model.addAttribute("visittime", visittime);
		model.addAttribute("lang",request.getParameter("lang"));
		return "visitpage";
	}
	@RequestMapping(value={"","/"} , method= RequestMethod.GET , params="returnmode")
	public @ResponseBody String getVisitPage( @RequestParam String username 
				,@RequestParam String visitip , @RequestParam String visittime , @RequestParam String returnmode) {		
		String returnMsg = "";
		if(returnmode.equals("2")) {			
			returnMsg = username;
			returnMsg = returnMsg + " , " + visitip;
			returnMsg = returnMsg + " , " + visittime;			
		}else {
			returnMsg = "returnmode Error";
		}
		return returnMsg;
	} 

}
