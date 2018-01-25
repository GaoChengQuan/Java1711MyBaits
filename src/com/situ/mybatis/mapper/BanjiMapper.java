package com.situ.mybatis.mapper;

import java.util.List;

import com.situ.mybatis.entity.Banji;
import com.situ.mybatis.entity.Student;

public interface BanjiMapper {
	public Banji findBanjiInfoById(Integer id);
	
	public List<Student> findStudentsByName(String banjiName);
	
	public Banji findClassCourseInfoByName(String banjiName);
}
