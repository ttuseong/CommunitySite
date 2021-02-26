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
	
	public List<BoardVo> SelectBoard(Map<String, Object> map) {
		return session.selectList("admin.boardSelect", map);
	}
	
	public int SelectTotalBoard() {
		return session.selectOne("admin.selectTotalBoard");
	}
	
	public int InsertBoard(Map<String, Object> formData) {
		return session.insert("admin.boardInsert", formData);
	}
	
	public int UpdateBoard(Map<String, Object>formData) {
		return session.update("admin.boardUpdate", formData);
	}
	
	public int DeleteBoard(Map<String, Object> formData) {
		return session.delete("admin.boardDelete", formData);
	}
	
	public List<EventVo> SelectEvent(Map<String, Object> map) {
		return session.selectList("admin.eventSelect", map);
	}
	
	public int SelectTotalEvent() {
		return session.selectOne("admin.selectTotalEvent");
	}
	
	public void InsertEvent(Map<String, Object> map) {
		session.insert("admin.eventInsert", map);
	}
	
	public void UpdateEvent(Map<String, Object> map) {
		session.update("admin.eventUpdate", map);
	}
	
	public int DeleteEvent(Map<String, Object> map) {
		return session.delete("admin.eventDelete", map);
	}
	
	public List<AdVo> SelectAd(Map<String, Object>map){
		return session.selectList("admin.adSelect", map);
	}
	
	public int SelectTotalAd() {
		return session.selectOne("admin.selectTotalAd");
	}
	
	public void InsertAd(Map<String, Object> map) {
		session.insert("admin.adInsert", map);
	}
	
	public void UpdateAd(Map<String, Object> map) {
		session.update("admin.adUpdate", map);
	}
	
	public int DeleteAd(Map<String, Object> map) {
		return session.delete("adDelete", map);
	}
}
