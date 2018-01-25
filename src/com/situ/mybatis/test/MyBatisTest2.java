package com.situ.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.net.SyslogAppender;
import org.junit.Test;

import com.situ.mybatis.entity.Banji;
import com.situ.mybatis.entity.Course;
import com.situ.mybatis.entity.Student;
import com.situ.mybatis.mapper.StudentMapper;
import com.situ.mybatis.utils.MyBatisUtil;

public class MyBatisTest2 {
	@Test
	public void testFindStudentInfoById1() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		Student student = studentDao.findStudentInfoById(18);
		//System.out.println(student);
		System.out.println("学生名字：" + student.getName());
		Banji banji = student.getBanji();
		System.out.println("所在班级：" + banji.getName());
		List<Course> courseList = banji.getCourseList();
		System.out.println("所学所有课程：");
		for (Course course : courseList) {
			System.out.println(course);
		}
	}
}
