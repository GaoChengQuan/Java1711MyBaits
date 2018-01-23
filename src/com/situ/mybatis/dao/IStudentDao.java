package com.situ.mybatis.dao;

import java.util.List;

import com.situ.mybatis.entity.Student;

public interface IStudentDao {
	//接口中的方法名与StudentMapper.xml定义的方法名一致。
	//参数必须与StudentMapper.xml定义的方法参数一致。
	//返回值必须与StudentMapper.xml定义方法的返回值一致。
	//StudentMapper.xml的命名空间绑定这个接口
	public Student findById(Integer id);
	public List<Student> findAll();
	public List<Student> findByName(String name);
}
