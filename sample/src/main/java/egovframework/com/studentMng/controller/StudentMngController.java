package egovframework.com.studentMng.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.support.ModelAndViewContainer;
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

}

