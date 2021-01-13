package com.project_1.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project_1.vo.BoardVo;

@Repository
public class TestDao {
	@Autowired
	private SqlSession sqlSession;
	
	public BoardVo test() {
		return sqlSession.selectOne("test.dbtest");
	}
}
