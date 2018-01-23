package com.situ.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.situ.mybatis.entity.Student;
import com.situ.mybatis.utils.MyBatisUtil;

public class MyBatisTest {
	@Test
	public void testFindById() throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		//执行sql语句
		Student student = sqlSession.selectOne("student.findById", 11);
		System.out.println(student);
		sqlSession.close();
	}
	
	@Test
	public void testFindAll() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<Student> list = sqlSession.selectList("student.findAll");
		for (Student student : list) {
			System.out.println(student);
		}
		sqlSession.close();
	}
	
	@Test
	public void testFindByName() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<Student> list = sqlSession.selectList("student.findByName", "李");
		for (Student student : list) {
			System.out.println(student);
		}
		sqlSession.close();
	}
	
	@Test
	public void testSave() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		Student student = new Student("wangwu", 20, "男", "上海", new Date());
		int update = sqlSession.update("student.save", student);
		System.out.println(update);
		//手动提交
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testDeleteById() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int update = sqlSession.update("student.deleteById", 17);
		System.out.println(update);
		//手动提交
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testDelete() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		Student student = new Student();
		student.setId(21);
		int update = sqlSession.update("student.delete", student);
		System.out.println(update);
		//手动提交
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testUpdate() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		Student student = new Student();
		student.setId(20);
		student.setName("王五");
		student.setAddress("青岛");
		int update = sqlSession.update("student.update", student);
		System.out.println(update);
		//手动提交
		sqlSession.commit();
		sqlSession.close();
	}
	
}
