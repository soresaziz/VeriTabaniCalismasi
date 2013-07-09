package com.entity;

public class Kategori {

	private int id;
	private String name;

	public Kategori() {
		// TODO Auto-generated constructor stub
	}

	public Kategori(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

		return name;
	}
}
