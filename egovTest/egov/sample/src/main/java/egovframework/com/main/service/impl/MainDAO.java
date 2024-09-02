package egovframework.com.main.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("MainDAO")
public class MainDAO extends EgovAbstractMapper{
	
	public List<HashMap<String, Object>> selectStudentInfo(){
		return selectList("selectStudentInfo");
	}

}
