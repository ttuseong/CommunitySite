package com.project_1.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project_1.dao.AdminDao;
import com.project_1.vo.BoardVo;

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
}
