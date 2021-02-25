package com.project_1.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project_1.vo.AdVo;
import com.project_1.vo.BoardVo;
import com.project_1.vo.EventVo;

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
	
	public List<EventVo> SelectEvent() {
		return session.selectList("admin.eventSelect");
	}
	
	public void InsertEvent(Map<String, Object> map) {
		session.insert("admin.eventInsert", map);
	}
	
	public int DeleteEvent(Map<String, Object> map) {
		return session.delete("admin.eventDelete", map);
	}
	
	public List<AdVo> SelectAd(){
		return session.selectList("admin.adSelect");
	}
	
	public void InsertAd(Map<String, Object> map) {
		session.insert("admin.adInsert", map);
	}
	
	public int DeleteAd(Map<String, Object> map) {
		return session.delete("adDelete", map);
	}
}
