package com.situ.mybatis.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	static SqlSessionFactory sqlSessionFactory  = null;
	static {
		//加载核心的配置文件
		String resource = "mybatis.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			//创建SqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private MyBatisUtil() {
	}

	public static SqlSession getSqlSession() {
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
