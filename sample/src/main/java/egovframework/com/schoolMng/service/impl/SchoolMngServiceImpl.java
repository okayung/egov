package egovframework.com.schoolMng.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.schoolMng.service.SchoolMngService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("SchoolMngService")
public class SchoolMngServiceImpl extends EgovAbstractServiceImpl implements SchoolMngService{

	@Resource(name="SchoolMngDAO")
	private SchoolMngDAO schoolMngDAO;
	
	@Override
	public List<HashMap<String, Object>> selectSchoolList() {
		// TODO Auto-generated method stub
		
		List<HashMap<String, Object>> list = schoolMngDAO.selectSchoolList();		
		return list;
	}

	@Override
	public HashMap<String, Object> selectSchoolInfo(int schoolIdx) {
		// TODO Auto-generated method stub
		HashMap<String, Object> schoolInfo = schoolMngDAO.selectSchoolInfo(schoolIdx);	
		return schoolInfo;
	}

	@Override
	public int insertSchoolMngInfo(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		int resultChk = 0;
		resultChk = schoolMngDAO.insertSchoolMngInfo(paramMap);
		return resultChk;
	}

	@Override
	public int deleteSchoolMngInfo(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		int resultChk = 0;
		resultChk = schoolMngDAO.deleteSchoolMngInfo(paramMap);
		return resultChk;
	}

	@Override
	public int updateSchoolMngInfo(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		int resultChk = 0;
		resultChk = schoolMngDAO.updateSchoolMngInfo(paramMap);
		return resultChk;
		
	}
	
}