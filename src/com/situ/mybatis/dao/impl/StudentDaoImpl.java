package com.situ.mybatis.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.situ.mybatis.entity.Student;
import com.situ.mybatis.mapper.StudentMapper;
import com.situ.mybatis.utils.MyBatisUtil;
import com.situ.mybatis.vo.SearchVO;

public class StudentDaoImpl implements StudentMapper{

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

	@Override
	public List<Student> findByName(Integer age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findBySearchVO(SearchVO searchVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByPage(Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByPage1(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByCondition(SearchVO searchVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByConditionTrim(SearchVO searchVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer dynamicUpdate(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer dynamicUpdateTrim(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByIdArray(int[] idArray) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByIdList(List<Integer> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findBySearchVIO(SearchVO searchVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findBySearchVIOIf(SearchVO searchVO) {
		// TODO Auto-generated method stub
		return null;
	}
}
