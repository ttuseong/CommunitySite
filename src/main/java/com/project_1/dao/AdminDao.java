package com.project_1.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project_1.vo.BoardVo;

@Repository
public class AdminDao {
	@Autowired
	SqlSession session;
	
	public List<BoardVo> SelectBoard() {
		return session.selectList("admin.boardSelect");
	}
	
	public int InsertBoard(Map<String, Object> formData) {
		return session.insert("admin.boardInsert", formData);
	}
	
	public int DeleteBoard(Map<String, Object> formData) {
		return session.delete("admin.boardDelete", formData);
	}
}
