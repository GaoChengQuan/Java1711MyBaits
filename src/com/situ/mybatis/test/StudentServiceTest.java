package com.situ.mybatis.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.situ.mybatis.entity.Student;
import com.situ.mybatis.service.IStudentService;
import com.situ.mybatis.service.impl.StudentServiceImpl;
import com.situ.mybatis.vo.PageBean;
import com.situ.mybatis.vo.StudentSearchCondition;

public class StudentServiceTest {

	@Test
	public void testGetPageBean() {
		IStudentService service = new StudentServiceImpl();
		
		StudentSearchCondition condition = new StudentSearchCondition();
		condition.setName("张");
		condition.setPageNo(1);
		condition.setPageSize(3);
		PageBean<Student> pageBean = service.getPageBean(condition);
		System.out.println(pageBean);
	}

}
