package com.situ.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.situ.mybatis.dao.IStudentDao;
import com.situ.mybatis.entity.Student;
import com.situ.mybatis.utils.MyBatisUtil;

public class StudentDaoImpl implements IStudentDao{

	@Override
	public Student findById(Integer id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		Student student = sqlSession.selectOne("student.findById", id);
		sqlSession.close();
		return student;
	}

	@Override
	public List<Student> findAll() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<Student> list = sqlSession.selectList("student.findAll");
		sqlSession.close();
		return list;
	}

	@Override
	public List<Student> findByName(String name) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<Student> list = sqlSession.selectList("student.findByName");
		sqlSession.close();
		return list;
	}
}
