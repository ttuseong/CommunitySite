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
	
	public Map<String, Object> getContent(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("menuList", getMenuList());
		map.put("contentMap", getCommunityContentList(getCommunityBoardList()));
		
		System.out.println((map.get("contentMap")));
			
		return map;
	}
	
	public List<BoardVo> getMenuList() {
		List<BoardVo> list = mainDao.getMenuList();
		System.out.println(list);
		return list;
	}
	
	public List<Integer> getCommunityBoardList(){
		
		
		return mainDao.getCommunityBoardList();
	}
	
	public Map<Integer, List<ContentVo>> getCommunityContentList(List<Integer> list){
		Map<Integer, List<ContentVo>> contentMap = new HashMap<Integer, List<ContentVo>>();
		System.out.println("test");
		for(int i = 0; i < list.size(); i++) {
			List<ContentVo> list1 = mainDao.getCommunityContentList(list.get(i));
			
			System.out.println(list1);
			
			contentMap.put(list.get(i), list1);
		}
		
		System.out.println(contentMap.get(2));
		
		return contentMap;
	}
}
