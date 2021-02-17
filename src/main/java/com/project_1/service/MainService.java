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
	public Map<String, Object> getContent(){
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
	
	//클릭한 게시판의 게시글을 가져오는 역할
	public List<ContentVo> getContentList(int boardNo) {
		return mainDao.getContentList(boardNo);
	}
}
