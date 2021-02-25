package com.project_1.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project_1.vo.AdVo;
import com.project_1.vo.BoardVo;
import com.project_1.vo.ContentVo;
import com.project_1.vo.EventVo;
import com.project_1.vo.UserVo;

@Repository
public class MainDao {
	@Autowired
	SqlSession sqlSession;
	
	public List<EventVo> getEventList(){
		return sqlSession.selectList("main.eventSelect");
	}
	
	public List<Map<String, Object>> getImgList(){
		return sqlSession.selectList("main.imgSelect");
	}
	
	public List<BoardVo> getMenuList(){
		return sqlSession.selectList("main.menuList");
	}
	
	public List<Integer> getCommunityBoardList(){
		return sqlSession.selectList("main.communityBoardList");
	}
	
	public List<AdVo> getAdList(){
		return sqlSession.selectList("main.adList");
	}
	
	public List<ContentVo> getCommunityContentList(int n){
		return sqlSession.selectList("main.communityContentList", n);
	}
	
	public int countContent(int boardNo) {
		return sqlSession.selectOne("main.countContent", boardNo);
	}
	
	public List<ContentVo> getContentList(Map<String, Object> map) {
		return sqlSession.selectList("main.contentList", map);
	}
	
	public ContentVo getContent(int contentNo) {
		return sqlSession.selectOne("main.content", contentNo);
	}
	
	public int writeContent(ContentVo contentVo) {
		return sqlSession.insert("main.writecontent", contentVo);
	}
	
	public int insertImg(Map<String, Object> imgMap) {
		return sqlSession.insert("main.insertImg", imgMap);
	}
	
	public int delete(Map<String, Object> formData) {
		return sqlSession.delete("main.delete", formData);
	}
	
	public int login(UserVo userVo) {
		return sqlSession.selectOne("main.login", userVo);
	}
}
