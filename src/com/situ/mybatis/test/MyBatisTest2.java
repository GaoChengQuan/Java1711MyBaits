package com.situ.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.situ.mybatis.entity.Student;
import com.situ.mybatis.mapper.StudentMapper;
import com.situ.mybatis.utils.MyBatisUtil;

public class MyBatisTest2 {
	@Test
	public void testFindStudentInfoById1() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		Student student = studentDao.findStudentInfoById(18);
		System.out.println(student);
	}
}
