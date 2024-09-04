package egovframework.com.main.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("MainDAO")
public class MainDAO extends EgovAbstractMapper{

	public int selectIdChk(HashMap<String, Object> paramMap) {
		return selectOne("selectIdChk", paramMap);
	}
	
	public int insertMember(HashMap<String, Object> paramMap) {
		return insert("insertMember",paramMap);
	}
	public HashMap<String, Object> selectLoginInfo(HashMap<String, Object> paramMap) {
		return selectOne("selectLoginInfo", paramMap);
	}
	public int updateMember(HashMap<String, Object> paramMap) {
		return update("updateMember", paramMap);
	}
	
	public HashMap<String, Object> selectMemberInfo(HashMap<String, Object> paramMap){
		return selectOne("selectMemberInfo",paramMap);
	}
	public int deleteMemberInfo(int memberIdx) {
		return update("deleteMemberInfo", memberIdx);
	}
	public List<String> selectFindId(HashMap<String, Object> prarmMap){
		return selectList("selectFindId", prarmMap);
	}
	public int selectMemberCertification(HashMap<String, Object> prarmMap) {
		return selectOne("selectMemberCertification", prarmMap);
	}
	public int selectMemberCertificationChk(HashMap<String, Object> prarmMap) {
		return selectOne("selectMemberCertification", prarmMap);
	}
	public int updatePwd(HashMap<String, Object> prarmMap) {
		return update("updatePwd", prarmMap);
	}
}
