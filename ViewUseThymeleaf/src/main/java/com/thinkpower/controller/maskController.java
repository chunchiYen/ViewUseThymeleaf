package com.thinkpower.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.thinkpower.model.MaskOfPerson;
import com.thinkpower.model.Pharmacy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;
@Api(tags = "Mask x.x")
@Controller
@RequestMapping("/mask")
public class maskController {
	
	//private static List<String> CVSINFO = Arrays.asList("全家台北店","全家板橋店","全家大安店","全家北投店","全家淡水店","全家汐止店"
	//			,"全家桃園店","全家內湖店","全家西湖店","全家台中店","全家台南店","全家彰化店","全家雲林店","全家新竹店");
	private List<MaskOfPerson>  maskPersonListsOri = Arrays.asList(
		new MaskOfPerson("A123456789" , "a1234" , "喬伊" , "0986123001" , "2020/02/27" ,"全家台北店" , "",""),
		new MaskOfPerson("B223456789" , "b1234" , "提娜" , "0986123002" , "2020/02/27" ,"全家台南店" , "2020/03/05","全家台中店"),
		new MaskOfPerson("C123456789" , "c1234" , "歐陽丹尼" , "0986123003" , "2020/02/27" ,"全家西門店" , "","") ,
		new MaskOfPerson("D123456789" , "d1234" , "王小明" , "0986123004" , "" ,"" , "",""),
		new MaskOfPerson("E123456789" ,"ed1234" , "李李仁" , "0986123005" , "" ,"" , "",""),
		new MaskOfPerson("F223456789" , "f1234" , "陳珊珊" , "0986123006" , "2020/01/29" ,"全家關島店" , "","")
	);
	List<MaskOfPerson>  maskPersonLists = null;
	
	String[] kindOfCVS = {"7-11","全家","OK","Hi-Life"};
	
	String[] sevenBranch = {"內湖","大安","興隆","寶山","香山","九如","九份","西湖","竹北","經國","武廟","三峽","淡水","大里","新社","斗六","鹽水","田中","鶯歌","石門","美麗華","北門"};
	String[] familyBranch = {"衡陽","北車一","動物園","林森","西門","重慶北","重慶南","北車二","龍江","泰山","八里","七堵","八堵","宜蘭","頭城","鹽水","竹南","竹北","陽明","士林","台中","西屯"};
	String[] okBranch = {"新豐","新竹","大安","西湖","三峽","七堵","八德","十全","五湖","四海","三才","二儀","六合","南雅","苗栗","通宵","花蓮","台東","屏東","墾丁","佳里","大園"};
	String[] hilifeBranch = {"西門","北門","東門","南門","動物園內","莊泰","鑫寶華","林園","中原","青大","台大","北大","中正","成功","瑞光","基湖","龜山","大林","斗南","雲林","六福村","劍湖山"};
	
	String[] stroeName = {"內湖","大安","興隆","寶山","香山","九如","九份","西湖","竹北","經國","武廟","三峽","淡水","大里","新社","斗六","鹽水","田中","鶯歌","石門","美麗華","北門"};
	
	static List<Pharmacy> pharmacyList = Arrays.asList(
			new Pharmacy("5901012507","康麗藥局","02-27234117","台北市松山區南京東路3段303巷20號","432","422","2020/04","臺北市","松山區","中正里"),
			new Pharmacy("6901012508","美康藥局","02-27234115","台中市北屯區南京東路3段313巷210號","432","22","2020/04","台中市","北屯區","中山里"),
			new Pharmacy("7901012509","一安藥局","02-27174117","臺北市北投區南京東路3段33巷120號","32","89","2020/04","臺北市","北投區","文衡里"),
			new Pharmacy("8901012500","大樹藥局","02-24374147","台南市安平區南京東路3段33巷250號","0","32","2020/04","台南市","安平區","安平里"),
			new Pharmacy("9901012501","祐全藥局","02-27174117","新北市淡水區南京東路3段93巷21號","3","56","2020/04","新北市","淡水區","中正里"),
			new Pharmacy("1901012502","和欣藥局","02-27174117","南投縣手掌鎮南京東路3段93巷22號","143","222","2020/04","南投縣","手掌鎮","合掌村"),
			new Pharmacy("2901012503","快樂藥局","02-27333413","台東縣外島區南京東路3段93巷23號","333","333","2020/04","台東縣","外島區","綠島里")

		);
	
	@RequestMapping(value={"","/","/login"} , method= {RequestMethod.POST,RequestMethod.GET })
	@ApiIgnore	// 使用此註解，於swagger忽略顯示
	public String toLogin(Model model) {
		maskPersonLists = maskPersonListsOri ;	
		model.addAttribute("accountList", maskPersonLists);
		return "login";
	}

	
	@PostMapping(value="/maskquery")
	@ApiIgnore		
	public String toQuery(@RequestParam String idno , @RequestParam String password 
						, @RequestParam String cellphone , Model model) {
		boolean idnoFlag = false;		
		MaskOfPerson maskOfPerson = null;		
		for(MaskOfPerson maskper:maskPersonLists) {
			if( maskper.idno.equals(idno) ) {
				idnoFlag = true;
				maskOfPerson= maskper;					
				break;			
			}
		}
	
		if(idnoFlag ) {		
			if(maskOfPerson.password.equals(password) && maskOfPerson.cellPhone.equals(cellphone)) {
				model.addAttribute("personinfo", maskOfPerson);			
				model.addAttribute("accountList", maskPersonLists);			
				model.addAttribute("kindOfCVS", kindOfCVS);	
				model.addAttribute("sevenBranch", sevenBranch);	
				model.addAttribute("familyBranch", familyBranch);	
				model.addAttribute("okBranch", okBranch);	
				model.addAttribute("hilifeBranch", hilifeBranch);	
				
				return "maskquery";
			}else {
				if(!maskOfPerson.password.equals(password)) {
					model.addAttribute("errinfo", "身分認證密碼有誤!");
				}else if(! maskOfPerson.cellPhone.equals(cellphone)) {
					model.addAttribute("errinfo", "身分認證電話有誤!");
				}
				model.addAttribute("accountList", maskPersonLists);
				return "login";
			}
		}else {
			model.addAttribute("errinfo", "身分認證有誤[無此身分證]!");
			model.addAttribute("accountList", maskPersonLists);
			return "login";			
		}	
	}
	
	@PostMapping(value="/maskquery" , params="verified")
	@ApiIgnore
	public String toPrePurchare(HttpServletRequest request , @RequestParam String idno , @RequestParam String verified 
							, Model model) {
			
		MaskOfPerson maskOfPerson = null;
		if(verified.equals("true") ) {
			for(MaskOfPerson maskper:maskPersonLists) {
				if( maskper.idno.equals(idno) ) {					
					maskOfPerson= maskper;							
					break;			
				}
			}
			String cvskind = request.getParameter("cvskind");
			String cvsinfo ="";
			if(cvskind.equals(kindOfCVS[0].toString())) {
				cvsinfo = request.getParameter("branch_seven");
			}else if(cvskind.equals(kindOfCVS[1].toString())) {
				cvsinfo = request.getParameter("branch_family");
			}else if(cvskind.equals(kindOfCVS[2].toString())) {
				cvsinfo = request.getParameter("branch_ok");
			}else if(cvskind.equals(kindOfCVS[3].toString())) {
				cvsinfo = request.getParameter("branch_hilife");
			}
				
			String cvsstore = cvskind +cvsinfo+"店";
			model.addAttribute("cvsstore", cvsstore);
				
			LocalDate ldt = LocalDate.now().plusDays(7);			
			maskOfPerson.setPrePurchaseInfo( ldt.toString(), cvsstore);
			model.addAttribute("personinfo", maskOfPerson);			
			model.addAttribute("isprepurchase", "true");	
						
			return "maskquery";
		}else {
			model.addAttribute("errinfo", "身分認證有誤，請重新登入!");
			model.addAttribute("accountList", maskPersonLists);
			return "login";
		}
	}
	
	@PostMapping(value={"/","/login"} ,params="dataAction=reset")	
	@ApiIgnore
	public String toDataRest(Model model) {		
		maskPersonLists = null;
		
		List<MaskOfPerson> masks  = new ArrayList<MaskOfPerson>();
		masks.add(new MaskOfPerson("A123456789" , "a1234" , "喬伊" , "0986123001" , "2020/02/27" ,"全家台北店" , "",""));
		masks.add(new MaskOfPerson("B223456789" , "b1234" , "提娜" , "0986123002" , "2020/02/27" ,"全家台南店" , "2020/03/05","全家台中店"));
		masks.add(new MaskOfPerson("C123456789" , "c1234" , "歐陽丹尼" , "0986123003" , "2020/02/27" ,"全家西門店" , "",""));
		masks.add(new MaskOfPerson("D123456789" , "d1234" , "王小明" , "0986123004" , "" ,"" , "",""));
		masks.add(new MaskOfPerson("E123456789" ,"ed1234" , "李李仁" , "0986123005" , "" ,"" , "",""));
		masks.add(new MaskOfPerson("F223456789" , "f1234" , "陳珊珊" , "0986123006" , "2020/01/29" ,"全家關島店" , "",""));
	
		maskPersonListsOri = masks;
		maskPersonLists = maskPersonListsOri;

		model.addAttribute("datareset", "true");
		model.addAttribute("accountList", maskPersonLists);
		return "login";
	}
	@PostMapping("/mask")
	public @ResponseBody Map<String,Integer> getMaskInfo(@RequestParam String  city) {		
		
		Map<String , Integer> returnMap = new HashMap<String,Integer>();
		returnMap.put("大樹藥局",99);
		returnMap.put("快樂藥局",199);
		returnMap.put("杏一藥局",67);
		returnMap.put("一安藥局",0);
		returnMap.put("康全藥局",62);
		returnMap.put("博詮藥局",12);
		
		return returnMap;
	}
	
	@GetMapping(value="/maskquery" ,params="returnmode")	
	public @ResponseBody Map<String,String> queryResult(@RequestParam String idno , @RequestParam String password 
						, @RequestParam String cellphone ,@RequestParam String returnmode, Model model) {
		boolean idnoFlag = false;		  
		MaskOfPerson maskOfPerson = null;	
		Map<String,String> returnMap = new HashMap<String,String>();
			 
		if(!returnmode.equals("2")) {
			returnMap.put("retunrMessage", "returnmode Error! ");			
			return returnMap;
		}
		if(maskPersonLists == null)
			maskPersonLists = maskPersonListsOri;
		for(MaskOfPerson maskper:maskPersonLists) {
			if( maskper.idno.equals(idno) ) {
				idnoFlag = true;
				maskOfPerson= maskper;					
				break;			
			}
		}
	
		if(idnoFlag ) {		
			if(maskOfPerson.password.equals(password) && maskOfPerson.cellPhone.equals(cellphone)) {
				returnMap.put("retunrMessage", "200 ok");
				returnMap.put("idno", maskOfPerson.idno);
				returnMap.put("name", maskOfPerson.name);
				returnMap.put("cellPhone", maskOfPerson.cellPhone);
				returnMap.put("lastPurchaseCVS", maskOfPerson.lastPurchaseCVS);
				returnMap.put("lastPurchaseTime", maskOfPerson.lastPurchaseTime);
				returnMap.put("prePurchaseCVS", maskOfPerson.prePurchaseCVS);
				returnMap.put("prePurchaseTime", maskOfPerson.prePurchaseTime);				
			}else {
				if(!maskOfPerson.password.equals(password)) {					
					returnMap.put("retunrMessage", "身分認證密碼有誤!");
				}else if(! maskOfPerson.cellPhone.equals(cellphone)) {					
					returnMap.put("retunrMessage", "身分認證電話有誤");
				}							
			}
		}else {					
			returnMap.put("retunrMessage", "身分認證有誤[無此身分證]!");
		}	
		
		return returnMap;
	}
 
	
	@PostMapping("/pharmacy")		
	public @ResponseBody List<String> PharmacyInfo(@RequestParam String  city) {
		
		List<String> returnList = Arrays.asList("大樹","一安","新杏","祐全");		
		return returnList;
	}
	@ApiOperation("查詢藥局口罩餘額")
	@GetMapping(value="/pharmacy" , params="returnmode=all")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success")})
	public @ResponseBody List<Pharmacy> PharmacyAll() {			
		 return pharmacyList;
	}
	

}
