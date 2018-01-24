package com.situ.mybatis.vo;

import com.situ.mybatis.entity.Student;

public class SearchVO {
	private String name;
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "SearchVO [name=" + name + ", gender=" + gender + "]";
	}

}
