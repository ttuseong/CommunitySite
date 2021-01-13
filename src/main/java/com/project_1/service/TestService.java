package com.project_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project_1.dao.TestDao;
import com.project_1.vo.BoardVo;

@Service
public class TestService {
	@Autowired
	TestDao testDao;
	
	public void test() {
		System.out.println(testDao.test());
	}
}
