package egovframework.com.main.web;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.main.service.MainService;
import egovframework.com.util.SHA256;

@Controller
public class MainController {

	@Resource(name="MainService")
	private MainService mainService;
	SHA256 sha256 = new SHA256();
	
	@RequestMapping("/main.do")
	public String main() {
		return "main/main";
	}
	
	@RequestMapping("/login.do")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/join.do")
	public String join() {
		return "join";
	}
	@RequestMapping("/member/idChk.do")
	public ModelAndView idChk(@RequestParam HashMap<String, Object> paramMap){
//  public ModelAndView idChk(@RequestParam(name="accountId") String accountId){	->2번째 방법
		ModelAndView mv = new ModelAndView();
		
		int idChk = 0;
		idChk = mainService.selectIdChk(paramMap);
		mv.addObject("idChk", idChk);
		mv.setViewName("jsonView"); //결과값을 보여주는 많이사용하는 방법
		return mv;
		
	}
	@RequestMapping("/member/insertMember.do")
	public  ModelAndView insertMember(@RequestParam HashMap<String, Object> paramMap) throws Exception {
		ModelAndView mv = new ModelAndView();

		String pwd = paramMap.get("accountPwd").toString();
//		try {
//			System.out.println(sha256.encrypt(pwd).toString()); ->암호와 학인
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace(); ->try catch 예외처리 방법 ->throws Exception
//		}
		paramMap.replace("accountPwd", sha256.encrypt(pwd)); // 암호화하기-> sha256을 많이 사용,사용하기 위해서는 util폴더 만들어서 sha256 java파일만들어줘야함
		String accountEmail = paramMap.get("email").toString()+"@"+paramMap.get("emailAddr").toString();
		paramMap.put("accountEmail", accountEmail); //impl에서 작업가능
		
		int reseulChk =0;
		reseulChk= mainService.insertMember(paramMap);
		mv.addObject("reseulChk", reseulChk);
		mv.setViewName("jsonView");
		return mv;
		
	}
}

