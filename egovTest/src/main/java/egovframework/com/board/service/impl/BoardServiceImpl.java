package egovframework.com.board.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import egovframework.com.board.service.BoardService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("BoardService")
public class BoardServiceImpl extends EgovAbstractServiceImpl implements BoardService{

	@Resource(name="BoardDAO")
	private BoardDAO boardDAO;

	@Override
	public List<HashMap<String, Object>> selectBoardList(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return boardDAO.selectBoardList(paramMap);
	}

	@Override
	public int selectBoardListCnt(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return boardDAO.selectBoardListCnt(paramMap);
	}

	@Override
	public int saveBoard(HashMap<String, Object> paramMap, List<MultipartFile> multipartFile) {
		// TODO Auto-generated method stub
		int resultChk = 0;
		
		String flag = paramMap.get("statusFlag").toString();
		
		if("I".equals(flag)) {
			resultChk = boardDAO.insertBoard(paramMap);
		}else if("U".equals(flag)) {
			resultChk = boardDAO.updateBoard(paramMap);
		}
		String filePath = "/ictsaeil/egovTest";
		System.out.println(multipartFile.size());
		System.out.println(multipartFile.get(0).getOriginalFilename());
		if(multipartFile.size()> 0 && !multipartFile.get(0).getOriginalFilename().equals("")) {
			for(MultipartFile file : multipartFile) {
				SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHms"); // 데이터가 들어오면 날짜형태의 파일명으로변경하는 
				Calendar cal = Calendar.getInstance();//현재시점날짜 시간
				String today = date.format(cal.getTime()); // 원하는 형태의 값으로 이름 변경하기
				
				try {
					File fileFolder = new File(filePath); // 경로에 있는 파일(폴더) 가져오기, 경로만 준거
					System.out.println(1);
					if(!fileFolder.exists()) { //exists -> filePath 경로에 있는 파일 있는지 없는지 확인
						System.out.println(2);
						if(fileFolder.mkdirs()) { // mkdir -> 폴더만를 만들어주는 메소드(상위폴더가없으면 안만듬)
							System.out.println("[file.mkdirs] : Success"); //mkdirs -> 파일 폴더를 만듬(상위폴더가 없어도 같이 만들어줌) 
						}
					}
					System.out.println(3);
					String fileExt = FilenameUtils.getExtension(file.getOriginalFilename());// 파일네임에 확장자만 따서 saveFile에 적용
					File saveFile = new File(filePath, "file_"+today+"."+fileExt); // 여기서 File은  경로에 "file_"+today+"."+fileExt의 파일 생성해줌(파일만생성)
					System.out.println(4);
					file.transferTo(saveFile); //생성된file(아무것도없는)을  saveFile(업로드한) 로 바꿔주기
					System.out.println(5);
				}catch(Exception e) {
					e.printStackTrace();//에러
				}
			} 
			
		}		
		
		return resultChk;
	}

	@Override
	public HashMap<String, Object> selectBoardDetail(int boardIdx) {
		// TODO Auto-generated method stub
		return boardDAO.selectBoardDetail(boardIdx);
	}

	@Override
	public int deleteBoard(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return boardDAO.deleteBoard(paramMap);
	}

	@Override
	public int insertReply(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return boardDAO.insertReply(paramMap);
	}

	@Override
	public List<HashMap<String, Object>> selectBoardReply(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return boardDAO.selectBoardReply(paramMap);
	}
	
}