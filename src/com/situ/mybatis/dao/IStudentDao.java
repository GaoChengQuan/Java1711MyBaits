package com.situ.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;
import org.junit.validator.PublicClassValidator;

import com.situ.mybatis.entity.Student;
import com.situ.mybatis.vo.SearchVO;

public interface IStudentDao {
	//接口中的方法名与StudentMapper.xml定义的方法名一致。
	//参数必须与StudentMapper.xml定义的方法参数一致。
	//返回值必须与StudentMapper.xml定义方法的返回值一致。
	//StudentMapper.xml的命名空间绑定这个接口
	public Student findById(Integer id);
	public List<Student> findAll();
	public List<Student> findByName(Integer age);
	//根据SearchVO条件查询
	public List<Student> findBySearchVO(SearchVO searchVO);
	//public List<Student> findByPage(Integer offset, Integer pageSize);
	public List<Student> findByPage(@Param(value="offset")Integer offset, 
			@Param(value="pageSize")Integer pageSize);
	//将多个参数放到map里面
	public List<Student> findByPage1(Map<String, Integer> map);
	//查询一共有多少学生
	public Integer count();
	
	public List<Student> findByCondition(SearchVO searchVO);
}
