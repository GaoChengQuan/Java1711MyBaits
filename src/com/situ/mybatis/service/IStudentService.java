package com.situ.mybatis.service;

import org.junit.validator.PublicClassValidator;

import com.situ.mybatis.entity.Student;
import com.situ.mybatis.vo.PageBean;
import com.situ.mybatis.vo.StudentSearchCondition;

public interface IStudentService {
	public PageBean<Student> getPageBean(StudentSearchCondition condition);
}
