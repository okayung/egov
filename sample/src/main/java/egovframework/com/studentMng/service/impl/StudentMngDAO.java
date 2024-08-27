package egovframework.com.studentMng.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

	@Repository("StudentMngDAO")
	public class StudentMngDAO extends EgovAbstractMapper{
		
		public List<HashMap<String, Object>> selectStudentMngList(){
			return selectList("selectStudentMngList"); // 여러건 조회(목록)
		}

		public HashMap<String, Object> selectStudentMngInfo(int studentId) {
			// TODO Auto-generated method stub
			return selectOne("selectStudentMngInfo", studentId); // 단건 조회(1건 상제조회)
		}




}
