package com.situ.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.situ.mybatis.entity.Student;

public class MyBatisTest {
	@Test
	public void testFindById() throws Exception {
		//加载核心的配置文件
		String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		Student student = sqlSession.selectOne("student.findById", 11);
		System.out.println(student);
	}
}
