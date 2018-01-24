package com.situ.mybatis.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.situ.mybatis.dao.IStudentDao;
import com.situ.mybatis.entity.Student;
import com.situ.mybatis.service.IStudentService;
import com.situ.mybatis.utils.MyBatisUtil;
import com.situ.mybatis.vo.PageBean;
import com.situ.mybatis.vo.StudentSearchCondition;

public class StudentServiceImpl implements IStudentService{
	

	@Override
	public PageBean<Student> getPageBean(StudentSearchCondition condition) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
		
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setPageNo(condition.getPageNo());
		pageBean.setPageSize(condition.getPageSize());
		
		// 总记录数
		int totalCount = studentDao.getTotalCountByCondition(condition);
		pageBean.setTotalCount(totalCount);
		// 一共有多少页
		int totalPage = (int) Math.ceil((double)totalCount / condition.getPageSize());
		pageBean.setTotalPage(totalPage);
		// 当前页的数据
		int offset = (condition.getPageNo() - 1) * condition.getPageSize();
		//List<Student> list = studentDao.findPageBeanListByCondition(condition, offset);
		//pageBean.setList(list);
		
		return pageBean;
	}

}
