package com.situ.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.situ.mybatis.dao.IStudentDao;
import com.situ.mybatis.dao.impl.StudentDaoImpl;
import com.situ.mybatis.entity.Student;
import com.situ.mybatis.utils.MyBatisUtil;
import com.situ.mybatis.vo.SearchVO;

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
	
	@Test
	public void test1() {
		IStudentDao studentDao = new StudentDaoImpl();
		Student student = studentDao.findById(11);
		System.out.println(student);
	}
	
	@Test
	public void test2() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		//IStudentDao studentDao = new StudentDaoImpl();
		IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
		Student student = studentDao.findById(11);
		System.out.println(student);
	}
	
	@Test
	public void testFindBySearchVO() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
		SearchVO searchVO = new SearchVO();
		Student student = new Student();
		student.setName("李");
		searchVO.setStudent(student);
		List<Student> list = studentDao.findBySearchVO(searchVO);
		for (Student stu : list) {
			System.out.println(stu);
		}
	}
	
	@Test
	public void testFindByPage() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		//IStudentDao studentDao = new StudentDaoImpl();
		IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("offset", 3);
		map.put("pageSize", 3);
		List<Student> list = studentDao.findByPage1(map);
		for (Student stu : list) {
			System.out.println(stu);
		}
	}
	
	@Test
	public void testFindByPage1() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
		List<Student> list = studentDao.findByPage(3, 3);
		for (Student stu : list) {
			System.out.println(stu);
		}
	}
	
	@Test
	public void testCount() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
		Integer count = studentDao.count();
		System.out.println(count);
	}
	
	@Test
	public void testFindAll2() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
		List<Student> list = studentDao.findAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testFindByCondition() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
		SearchVO searchVO = new SearchVO();
		searchVO.setName("张");
		searchVO.setGender("男");
		List<Student> list = studentDao.findByCondition(searchVO);
		for (Student student : list) {
			System.out.println(student);
		}
	}
}
