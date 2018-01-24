package com.situ.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.situ.mybatis.dao.impl.StudentDaoImpl;
import com.situ.mybatis.entity.Student;
import com.situ.mybatis.mapper.StudentMapper;
import com.situ.mybatis.utils.MyBatisUtil;
import com.situ.mybatis.vo.PageBean;
import com.situ.mybatis.vo.SearchVO;
import com.situ.mybatis.vo.StudentSearchCondition;

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
		StudentMapper studentDao = new StudentDaoImpl();
		Student student = studentDao.findById(11);
		System.out.println(student);
	}
	
	@Test
	public void test2() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		//IStudentDao studentDao = new StudentDaoImpl();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		Student student = studentDao.findById(11);
		System.out.println(student);
	}
	
	@Test
	public void testFindBySearchVO() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
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
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
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
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		List<Student> list = studentDao.findByPage(3, 3);
		for (Student stu : list) {
			System.out.println(stu);
		}
	}
	
	@Test
	public void testCount() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		Integer count = studentDao.count();
		System.out.println(count);
	}
	
	@Test
	public void testFindAll2() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		List<Student> list = studentDao.findAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testFindByCondition() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		SearchVO searchVO = new SearchVO();
		searchVO.setName("张");
		searchVO.setGender("  男   ");
		List<Student> list = studentDao.findByCondition(searchVO);
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testFindByConditionTrim() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		SearchVO searchVO = new SearchVO();
		searchVO.setName("张");
		searchVO.setGender("   男   ");
		List<Student> list = studentDao.findByConditionTrim(searchVO);
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testDynamicUpdate() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		Student student = new Student();
		student.setId(11);
		student.setName("lisi");
		student.setAddress("北京");
		Integer count = studentDao.dynamicUpdate(student);
		System.out.println(count);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testDynamicUpdateTrim() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		Student student = new Student();
		student.setId(11);
		student.setName("lisi");
		student.setAddress("济南    ");
		Integer count = studentDao.dynamicUpdateTrim(student);
		System.out.println(count);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testFindByIdArray() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		int[] array = {11,16,18};
		List<Student> list = studentDao.findByIdArray(array);
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testFindByIdList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		//int[] array = {11,16,18};
		List<Integer> list = new ArrayList<Integer>();
		list.add(11);
		list.add(16);
		list.add(18);
		List<Student> listResult = studentDao.findByIdList(list);
		for (Student student : listResult) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testFindBySearchVIO() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		List<Integer> list = new ArrayList<Integer>();
		list.add(11);
		list.add(16);
		list.add(18);
		SearchVO searchVO = new SearchVO();
		searchVO.setIdList(list);
		List<Student> listResult = studentDao.findBySearchVIO(searchVO);
		for (Student student : listResult) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testFindBySearchVIOIf() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		SearchVO searchVO = new SearchVO();
		//searchVO.setName("张");;
		//searchVO.setGender("男");
		List<Student> listResult = studentDao.findBySearchVIOIf(searchVO);
		for (Student student : listResult) {
			System.out.println(student);
		}
	}
	
}
