package egovframework.com.schoolMng.service;

import java.util.HashMap;
import java.util.List;

public interface SchoolMngService {
	public List<HashMap<String, Object>> selectSchoolList();
	
	public HashMap<String, Object> selectSchoolInfo(int schoolIdx);
	
	public int insertSchoolMngInfo(HashMap<String, Object> paramMap);
	
	public int deleteSchoolMngInfo(HashMap<String, Object> paramMap);

	public int updateSchoolMngInfo(HashMap<String, Object> paramMap);
}