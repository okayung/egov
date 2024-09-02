package egovframework.com.main.web;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String main(HttpSession session, Model model) {
		HashMap<String, Object> loginInfo = null;
		loginInfo = (HashMap<String, Object>) session.getAttribute("loginInfo");
		if(loginInfo != null) {
			model.addAttribute("loginInfo", loginInfo);
			return "main/main";
		}else {
			return "redirect:/login.do"; // redirect-> login.do로 다시 요청하기
		}
		
	}
	
	@RequestMapping("/login.do")
	public String login() {
		return "login";
	}
	@RequestMapping("/logout.do") //logout
	public String logout(HttpSession session) { 
		session.setAttribute("loginInfo", null);
		return "redirect:/";
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
	@RequestMapping("/member/loginAction.do")
	public  ModelAndView loginAction(HttpSession session, @RequestParam HashMap<String, Object> paramMap) {
		ModelAndView mv =  new ModelAndView();
		// 입력받은 패스워드
		String pwd = paramMap.get("pwd").toString();
		// 암호화된 패스워드
		String encryptPwd = null;
		try {
			encryptPwd = sha256.encrypt(pwd).toString();
			paramMap.replace("pwd", encryptPwd);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String, Object> loginInfo = null;
		loginInfo = mainService.selectLoginInfo(paramMap);
		if(loginInfo != null) {
			session.setAttribute("loginInfo", loginInfo); // 로그인 정보를 session에 넣어주기
			mv.addObject("resultChk", true);
		}else {
			mv.addObject("resultChk", false);
		}

		mv.setViewName("jsonView");
		return mv;
		
	}
}

