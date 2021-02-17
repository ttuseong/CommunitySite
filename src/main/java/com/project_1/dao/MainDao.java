package com.project_1.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project_1.vo.BoardVo;
import com.project_1.vo.ContentVo;

@Repository
public class MainDao {
	@Autowired
	SqlSession sqlSession;
	
	public List<BoardVo> getMenuList(){
		return sqlSession.selectList("main.menuList");
	}
	
	public List<Integer> getCommunityBoardList(){
		return sqlSession.selectList("main.communityBoardList");
	}
	
	public List<ContentVo> getCommunityContentList(int n){
		return sqlSession.selectList("main.communityContentList", n);
	}
	
	public List<ContentVo> getContentList(int boardNo) {
		return sqlSession.selectList("main.contentList", boardNo);
	}
}
