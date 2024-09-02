package egovframework.com.studentMng.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.studentMng.service.StudentMngService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("StudentMngService")
public class StudentMngServiceImpl extends EgovAbstractServiceImpl implements StudentMngService{

	@Resource(name="StudentMngDAO")
	private StudentMngDAO studentMngDAO;

	@Override
	public List<HashMap<String, Object>> selectStudentMngList() {
		// TODO Auto-generated method stub
		return studentMngDAO.selectStudentMngList();
	}

	@Override
	public HashMap<String, Object> selectStudentMngInfo(int studentId) {
		// TODO Auto-generated method stub
		return studentMngDAO.selectStudentMngInfo(studentId);
	}

	@Override
	public HashMap<String, Object> selectStudentMngInfo(HashMap<String, Object> studentId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}