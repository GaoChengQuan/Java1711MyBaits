package com.situ.mybatis.vo;

import java.util.List;

import com.situ.mybatis.entity.Student;

public class SearchVO {
	private int[] idArray;
	private List<Integer> idList;

	private String name;
	private String gender;

	public int[] getIdArray() {
		return idArray;
	}

	public void setIdArray(int[] idArray) {
		this.idArray = idArray;
	}

	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}

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
