package egovframework.com.schoolMng.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.schoolMng.service.SchoolMngService;

@Controller
public class SchoolMngController {

	@Resource(name="SchoolMngService")
	private SchoolMngService schoolMngService;
	
	@RequestMapping("/schoolMng/getSchoolList.do")
	public String getSchoolList(Model model) {
		
		List<HashMap<String, Object>> schoolList = schoolMngService.selectSchoolList();
		model.addAttribute("schoolList", schoolList);
		
		return "schoolMng/schoolList";
	}
	
	@RequestMapping("/schoolMng/getSchoolInfo.do")
	public ModelAndView getSchoolInfo(@RequestParam(name="schoolId") int schoolId) {
		ModelAndView mv = new ModelAndView();
		
		HashMap<String, Object> schoolInfo = schoolMngService.selectSchoolInfo(schoolId);
		
		mv.addObject("schoolInfo", schoolInfo);
		mv.setViewName("schoolMng/schoolInfo");
		return mv;
	}
	
	@RequestMapping("/schoolMng/registerSchool.do")
	public String registerSchool(@RequestParam HashMap<String, Object> paramMap, Model model ) {
		if(!paramMap.isEmpty()) { //수정
			int schoolId = Integer.parseInt(paramMap.get("schoolId").toString());
			HashMap<String, Object> schoolInfo = schoolMngService.selectSchoolInfo(schoolId);
			
			model.addAttribute("schoolInfo", schoolInfo);
			model.addAttribute("flag","U");
		}else { //등록
			model.addAttribute("flag", "I");
		}
		
		
		return "schoolMng/schoolRegister";
	}
	
	@RequestMapping("/schoolMng/insertSchoolInfo.do")
	public ModelAndView insertSchoolInfo(@RequestParam HashMap<String, Object> paramMap) {
		ModelAndView mv = new ModelAndView();
		
		int resultChk = 0;
		resultChk = schoolMngService.insertSchoolMngInfo(paramMap);
		mv.addObject("resultChk", resultChk);
		mv.setViewName("jsonView");
		return mv;
	}
	
	@RequestMapping("/schoolMng/deleteSchoolInfo.do")
	public ModelAndView deleteSchoolInfo(@RequestParam HashMap<String, Object> paramMap) {
		ModelAndView mv = new ModelAndView();
		
		int resultChk = 0;
		resultChk = schoolMngService.deleteSchoolMngInfo(paramMap);
		mv.addObject("resultChk", resultChk);
		mv.setViewName("jsonView");
		return mv;
	}
	@RequestMapping("/schoolMng/updateSchoolInfo.do")
	public ModelAndView updateSchoolInfo(@RequestParam HashMap<String, Object> paramMap) { //결과값만 보여줄거라 modelAndview
		ModelAndView mv = new ModelAndView();
		
		int resultChk = 0;
		resultChk = schoolMngService.updateSchoolMngInfo(paramMap);
		mv.addObject("resultChk", resultChk);
		mv.setViewName("jsonView"); //데이터만 받을거라 jsonview
		return mv;
	}
	
	
}