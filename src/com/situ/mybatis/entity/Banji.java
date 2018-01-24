package com.situ.mybatis.entity;

import java.util.ArrayList;
import java.util.List;

public class Banji {
	private Integer id;
	private String name;
	private List<Student> list = new ArrayList<Student>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Banji [id=" + id + ", name=" + name + "]";
	}

}
