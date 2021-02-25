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
	
	public List<BoardVo> SelectBoard() {
		return adminDao.SelectBoard();
	}
	
	public int InsertBoard(Map<String, Object> formData) {
		return adminDao.InsertBoard(formData);
	}
	
	public int DeleteBoard(Map<String, Object> formData) {
		return adminDao.DeleteBoard(formData);
	}
	
	public List<EventVo> SelectEvent() {
		return adminDao.SelectEvent();
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
	
	public int EventDelete(Map<String, Object> map) {
		return adminDao.DeleteEvent(map);
	}
	
	public List<AdVo> AdSelect(){
		return adminDao.SelectAd();
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
	
	public int adDelete(Map<String, Object> map) {
		return adminDao.DeleteAd(map);
	}
}
