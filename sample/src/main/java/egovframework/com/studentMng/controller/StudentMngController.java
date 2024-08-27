package egovframework.com.studentMng.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.studentMng.service.StudentMngService;


@Controller
public class StudentMngController {

	@Resource(name="StudentMngService")
	private StudentMngService studentMngService;

	@RequestMapping("/studentMng/getStudentList.do")
	public String getStudentList() {

		return "studentMng/studentList";
	}
	@RequestMapping("/studentMng/selectStudentMngList.do")
	public ModelAndView selectStudentList() {
		ModelAndView mv = new ModelAndView();

		List<HashMap<String, Object>> list = studentMngService.selectStudentMngList();

		mv.addObject("list", list);
		mv.setViewName("jsonView");
		return mv;
	}
	
//	@RequestMapping("/studentMng/getStudentInfo.do")
//	public ModelAndView getSchoolInfo(@RequestParam(name="studentId") int studentId) {
//		ModelAndView mv = new ModelAndView();
//	//System.out.println(1);
//		HashMap<String, Object> studentInfo = studentMngService.selectStudentMngInfo(studentId);
//		
//		mv.addObject("studentInfo", studentId);
//		mv.setViewName("studentMng/studentInfo");
//		return mv;
//}

@RequestMapping("/studentMng/getStudentMngInfo.do")
public String getStudentMngInfo(
		@RequestParam HashMap<String, Object> paramMap,
		Model model) {
	
	if(!paramMap.isEmpty()) {
		int studentId = Integer.parseInt(paramMap.get("studentId").toString());
		HashMap<String, Object> studentInfo = studentMngService.selectStudentMngInfo(studentId);
		model.addAttribute("studentInfo", studentInfo);
	}
	
	return "studentMng/studentInfo";
}

//public ModelAndView getStudentMngInfo(@RequestParam HashMap<String, Object> paramMap) {
//	ModelAndView mv = new ModelAndView();
//	
//	if(!paramMap.isEmpty()) {
//		int studentId = Integer.parseInt(paramMap.get("studentId").toString());
//		HashMap<String, Object> studentInfo = studentMngService.selectStudentMngInfo(studentId);
//		mv.addObject("studentInfo", studentInfo);
//	}
//	
//	mv.setViewName("studentMng/studentInfo");
//	return mv;
//}


}
