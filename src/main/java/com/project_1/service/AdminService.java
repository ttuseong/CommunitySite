package com.project_1.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project_1.dao.AdminDao;
import com.project_1.vo.AdVo;
import com.project_1.vo.BoardVo;
import com.project_1.vo.EventVo;

@Service
public class AdminService {
	@Autowired
	AdminDao adminDao;
	
	public Map<String, Object> SelectBoardContent(int boardPage){
		Map<String, Object> map = new HashMap<String, Object>();
		
		int page = (int)Math.ceil(SelectTotalBoard()/10.0);
		
		map.put("page", page);
		map.put("boardList", SelectBoard(boardPage));
		map.put("cntPage", boardPage);
		
		return map;
	}
	
	public List<BoardVo> SelectBoard(int boardPage) {
		int startPage = (boardPage - 1) * 10 + 1;
		int endPage = startPage + 9;
		
		Map<String , Object> selectMap = new HashMap<String, Object>();
		
		selectMap.put("startPage", startPage);
		selectMap.put("endPage", endPage);
		
		return adminDao.SelectBoard(selectMap);
	}
	
	public int SelectTotalBoard() {
		return adminDao.SelectTotalBoard();
	}
	
	public int InsertBoard(Map<String, Object> formData) {
		return adminDao.InsertBoard(formData);
	}
	
	public void UpdateBoard(Map<String, Object> formData) {
		adminDao.UpdateBoard(formData);
	}
	
	public int DeleteBoard(Map<String, Object> formData) {
		return adminDao.DeleteBoard(formData);
	}
	
	public Map<String, Object> SelectEventContent(int eventPage){
		Map<String, Object> map = new HashMap<String, Object>();
		
		int page = (int)Math.ceil(SelectTotalEvent()/3.0);
		
		map.put("page", page);
		map.put("eventList", SelectEvent(eventPage));
		map.put("cntPage", eventPage);
		
		return map;
	}
	
	public int SelectTotalEvent() {
		return adminDao.SelectTotalEvent();
	}
	
	public List<EventVo> SelectEvent(int eventPage) {
		int startPage = (eventPage - 1) * 3 + 1;
		int endPage = startPage + 2;
		
		Map<String , Object> selectMap = new HashMap<String, Object>();
		
		selectMap.put("startPage", startPage);
		selectMap.put("endPage", endPage);
		
		return adminDao.SelectEvent(selectMap);
	}
	
	public Map<String, Object> InsertEvent(String eventName, String eventLink, MultipartFile file) {
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		Map<String, Object> eventMap = null;
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream("D:\\upload\\"+saveName);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			bout.write(fileData);
			bout.close();
			
			eventMap = new HashMap<String, Object>();
			
			eventMap.put("eventName", eventName);
			eventMap.put("eventLink", eventLink);
			eventMap.put("saveName", saveName);
			
			adminDao.InsertEvent(eventMap);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eventMap;
	}
	
	public Map<String, Object> UpdateEvent(int eventNo, String eventName, String eventLink, MultipartFile file){
		Map<String, Object> eventMap = new HashMap<String, Object>();
		System.out.println(eventName);
		System.out.println(eventLink);
		
		eventMap.put("eventNo", eventNo);
		eventMap.put("eventName", eventName);
		eventMap.put("eventLink", eventLink);
		
		if(file.getSize() != 0) {
			String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;

			try {
				byte[] fileData = file.getBytes();
				OutputStream out = new FileOutputStream("D:\\upload\\"+saveName);
				BufferedOutputStream bout = new BufferedOutputStream(out);
				
				bout.write(fileData);
				bout.close();

				eventMap.put("saveName", saveName);
				
				adminDao.UpdateEvent(eventMap);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} else {
			adminDao.UpdateEvent(eventMap);
		}
		
		return eventMap;
	}
	
	public int EventDelete(Map<String, Object> map) {
		return adminDao.DeleteEvent(map);
	}
	
	public Map<String, Object>SelectAdContent(int adPage){
		Map<String, Object> map = new HashMap<String, Object>();
		
		int page = (int)Math.ceil(SelectTotalAd()/3.0);
		
		map.put("page", page);
		map.put("adList", SelectAd(adPage));
		map.put("cntPage", adPage);
		
		return map;
	}
	
	public List<AdVo> SelectAd(int adPage){
		int startPage = (adPage - 1) * 3 + 1;
		int endPage = startPage + 2;
		
		Map<String , Object> map = new HashMap<String, Object>();
		
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		return adminDao.SelectAd(map);
	}
	
	public int SelectTotalAd() {
		return adminDao.SelectTotalAd();
	}
	
	public Map<String, Object> adInsert(String adTitle, String adDesc, int adEffect, MultipartFile file) {
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		Map<String, Object> adMap = null;
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream("D:\\upload\\"+saveName);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			bout.write(fileData);
			bout.close();
			
			adMap = new HashMap<String, Object>();
			
			adMap.put("adTitle", adTitle);
			adMap.put("adDesc", adDesc);
			adMap.put("adEffect", adEffect);
			adMap.put("saveName", saveName);
						
			adminDao.InsertAd(adMap);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return adMap;
	}
	
	public Map<String, Object> adUpdate(int adNo,String adTitle, String adDesc, int adEffect, MultipartFile file){
		Map<String, Object> admap = new HashMap<String, Object>();
		
		admap.put("adNo", adNo);
		admap.put("adTitle", adTitle);
		admap.put("adDesc", adDesc);
		admap.put("adEffect", adEffect);
		
		if(file.getSize() != 0) {
			String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;

			try {
				byte[] fileData = file.getBytes();
				OutputStream out = new FileOutputStream("D:\\upload\\"+saveName);
				BufferedOutputStream bout = new BufferedOutputStream(out);
				
				bout.write(fileData);
				bout.close();

				admap.put("saveName", saveName);
				
				adminDao.UpdateAd(admap);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} else {
			adminDao.UpdateAd(admap);
		}
		
		return admap;
	}
	
	public int adDelete(Map<String, Object> map) {
		return adminDao.DeleteAd(map);
	}
}
