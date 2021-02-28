package com.project_1.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project_1.dao.MainDao;
import com.project_1.vo.AdVo;
import com.project_1.vo.BoardVo;
import com.project_1.vo.ContentVo;
import com.project_1.vo.EventVo;
import com.project_1.vo.UserVo;

@Service
public class MainService {
	@Autowired
	MainDao mainDao;
	
	public Map<String, Object> getMainContent(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("eventList", eventContent());
		map.put("imgList", imgContent());
		return map;
	}
	
	public List<EventVo> eventContent() {
		return mainDao.getEventList();
	}
	
	public List<Map<String, Object>> imgContent(){
		return mainDao.getImgList();
	}
	
	//모든 게시판을 가져오기 
	public Map<String, Object> getBoard(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("menuList", getMenuList());
		map.put("contentMap", getCommunityContentList(getCommunityBoardList()));
		map.put("adContent", adContent());
		
		return map;
	}
	
	//직업 게시판에 있는 게시판 목록을 가져옵니다.
	public List<BoardVo> getMenuList() {
		List<BoardVo> list = mainDao.getMenuList();

		return list;
	}
	
	//커뮤니티 게시판에 있는 게시판 목록을 가져옴
	public List<Integer> getCommunityBoardList(){
		return mainDao.getCommunityBoardList();
	}
	
	public List<AdVo> adContent(){
		return mainDao.getAdList();
	}
	
	//커뮤니티 게시판에 있는 최신 게시글을 가져오기 위함
	public Map<Integer, List<ContentVo>> getCommunityContentList(List<Integer> list){
		Map<Integer, List<ContentVo>> contentMap = new HashMap<Integer, List<ContentVo>>();

		for(int i = 0; i < list.size(); i++) {
			List<ContentVo> list1 = mainDao.getCommunityContentList(list.get(i));
			
			contentMap.put(list.get(i), list1);
		}
		
		return contentMap;
	}
	
	//게시판에서 필요한 정보를 가져오기 위해 다른 메소드를 호출하고 정리하여 컨트롤러로 보내주는 역할
	public Map<String, Object> getContents(int boardNo, int cntPage){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("page", Math.ceil(countContent(boardNo)/10.0));
		map.put("list", getContentList(boardNo, cntPage));
		map.put("cntPage", cntPage);
		map.put("boardNo", boardNo);
		
		return map;
	}
	
	//클릭한 게시판의 게시글 수를 가져오는 역할
	public int countContent(int boardNo) {
		return mainDao.countContent(boardNo);
	}
	
	//클릭한 게시판의 게시글을 가져오는 역할
	public List<ContentVo> getContentList(int boardNo, int cntPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardNo", boardNo);
		map.put("startPage", (cntPage - 1) * 10 + 1);
		map.put("endPage", cntPage * 10);
		
		return mainDao.getContentList(map);
	}
	
	//게시물에 보여줄 정보를 가져오는 역할
	public ContentVo getContent(int contentNo) {
		System.out.println(mainDao.getContent(contentNo));
		return mainDao.getContent(contentNo);
	}
	
	//게시글 저장 및 이미지 저장
	public void writeContent(ContentVo contentVo, MultipartFile file) {
		if(mainDao.writeContent(contentVo) == 1) {
			if(!file.isEmpty()) {
				String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
				String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;

				try {
					byte[] fileData = file.getBytes();
					OutputStream out = new FileOutputStream("D:\\upload\\"+saveName);
					BufferedOutputStream bout = new BufferedOutputStream(out);
					
					bout.write(fileData);
					bout.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Map<String, Object> imgMap = new HashMap<String, Object>();
				
				System.out.println(contentVo.getContentNo());
				
				imgMap.put("contentNo", contentVo.getContentNo());
				imgMap.put("imgName", saveName);
				
				mainDao.insertImg(imgMap);
			}
			
		} else {
			System.out.println("실패");
		}
		
	}
	
	public int delete(Map<String, Object> formData) {
		return mainDao.delete(formData);
	}
	
	public int login(UserVo userVo) {
		userVo.setSalt(mainDao.getSalt(userVo));
		changePW(userVo);
		
		return mainDao.login(userVo);
	}
	
	public void logreg(UserVo userVo) {
		userVo.setSalt(generateSalt());
		
		changePW(userVo);
		
		mainDao.logreg(userVo);
	}
	
	public void changePW(UserVo userVo) {
		try {
			byte[] bytes1 = (userVo.getManagerPW()).getBytes();
			byte[] bytes2 = new byte[bytes1.length + userVo.getSalt().getBytes().length];
			
			System.arraycopy(bytes1, 0, bytes2, 0, bytes1.length);
			System.arraycopy(userVo.getSalt().getBytes(), 0, bytes2, bytes1.length, userVo.getSalt().getBytes().length);
			
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(bytes2);
			
			byte[] byteData = md.digest();
			
			StringBuilder builder = new StringBuilder();
			for(int i = 0; i < byteData.length; i++) {
				builder.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			
			userVo.setManagerPW(builder.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String generateSalt() {
        Random random = new Random();
        
        byte[] salt = new byte[8];
        random.nextBytes(salt);
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < salt.length; i++) {
            // byte 값을 Hex 값으로 바꾸기.
            sb.append(String.format("%02x",salt[i]));
        }
        
        return sb.toString();
    }
}
