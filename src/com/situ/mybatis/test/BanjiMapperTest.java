package com.situ.mybatis.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.situ.mybatis.entity.Banji;
import com.situ.mybatis.entity.Course;
import com.situ.mybatis.entity.Student;
import com.situ.mybatis.mapper.BanjiMapper;
import com.situ.mybatis.utils.MyBatisUtil;

public class BanjiMapperTest {

	@Test
	public void testFindBanjiInfoById() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BanjiMapper banjiMapper = sqlSession.getMapper(BanjiMapper.class);
		Banji banji = banjiMapper.findBanjiInfoById(2);
		//System.out.println(banji);
		System.out.println("班级名称：" + banji.getName());
		System.out.println("班级的学生信息列表：");
		List<Student> list = banji.getList();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testFindStudentsByName() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BanjiMapper banjiMapper = sqlSession.getMapper(BanjiMapper.class);
		List<Student> list = banjiMapper.findStudentsByName("java1711");
		System.out.println("班级的学生信息列表：");
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testFindClassCourseInfoByName() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BanjiMapper banjiMapper = sqlSession.getMapper(BanjiMapper.class);
		Banji banji = banjiMapper.findClassCourseInfoByName("java1711");
		System.out.println("班级id：" + banji.getId());
		System.out.println("班级名字：" + banji.getName());
		List<Course> courseList = banji.getCourseList();
		for (Course course : courseList) {
			System.out.println(course);
		}
	}

}
