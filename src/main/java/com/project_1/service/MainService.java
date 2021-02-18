package com.project_1.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project_1.dao.MainDao;
import com.project_1.vo.BoardVo;
import com.project_1.vo.ContentVo;

@Service
public class MainService {
	@Autowired
	MainDao mainDao;
	
	//모든 게시판을 가져오기 
	public Map<String, Object> getBoard(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("menuList", getMenuList());
		map.put("contentMap", getCommunityContentList(getCommunityBoardList()));
			
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
	
	public ContentVo getContent(int contentNo) {

		return mainDao.getContent(contentNo);
	}
}
