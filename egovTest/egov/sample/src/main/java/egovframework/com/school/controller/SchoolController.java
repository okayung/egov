package egovframework.com.school.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.school.service.SchoolService;

@Controller
public class SchoolController {

	@Resource(name="SchoolService")
	private SchoolService schoolService;
	
	@RequestMapping("school/getSchoolList.do")
	public String getSchoolList(Model model) {
		
		List<HashMap<String, Object>> list = schoolService.selectSchoolList();
		model.addAttribute("schoolList", list);
		
		return "school/schoolList";
	}
//	@RequestMapping("school/getSchoolInfo.do")
//	public ModelAndView getSchoolInfo(@RequestParam(name="schoolIdx") int schoolIdx) {
//		ModelAndView mv = new ModelAndView("school/schoolInfo"); //jsp 경로 또는
//		mv.setViewName("school/schoolInfo); //->이런 형태가 능
//		HashMap<String, Object> schoolInfo = schoolService.selectSchoolInfo(schoolIdx);
//		mv.addObject("schoolInfo", schoolInfo);
//		
//		return mv;
//		
//	}
	
	//json 데이터로 바꾸기
	@RequestMapping("school/getSchoolInfo.do")
	public ModelAndView getSchoolInfo(@RequestParam HashMap<String, Object> paramMap) {
		ModelAndView mv = new ModelAndView();
		
		int schoolIdx = Integer.parseInt(paramMap.get("schoolId").toString());
		HashMap<String, Object> schoolInfo = schoolService.selectSchoolInfo(schoolIdx);
		mv.addObject("schoolInfo", schoolInfo);
		
		mv.setViewName("jsonView"); //json 형태로 addObject 넘겨주기
		return mv;
		
	}
	
	@RequestMapping("school/insertSchoolInfo.do")
	public ModelAndView insertSchoolInfo(@RequestParam HashMap<String, Object> paramMap) {
		ModelAndView mv = new ModelAndView();
		
		int resultChk = 0;
		resultChk = schoolService.insertSchoolInfo(paramMap);

		mv.addObject("resultChk", resultChk);		
		mv.setViewName("jsonView");
		return mv;
		
	}
	@RequestMapping("school/deleteSchoolInfo.do")
	public ModelAndView deleteSchoolInfo(@RequestParam HashMap<String, Object> paramMap) {
		ModelAndView mv = new ModelAndView();
		
		int schoolIdx = Integer.parseInt(paramMap.get("schoolId").toString());
		int schoolInfo = schoolService.deleteSchoolInfo(schoolIdx);

		mv.addObject("schoolInfo", schoolInfo);		
		mv.setViewName("jsonView");
		return mv;
		
	}

}
