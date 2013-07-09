package com.entity;

public class Film {

	private int id;
	private String name;
	private int year;
	private String y_name;
	private String k_name;

	public Film() {
		// TODO Auto-generated constructor stub
	}

	public Film(int id, String name, int year) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
	}
	


	public Film(int id, String name, int year, String y_name, String k_name) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.y_name = y_name;
		this.k_name = k_name;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getY_name() {
		return y_name;
	}
	public String getK_name() {
		return k_name;
	}
	public void setY_name(String y_name) {
		this.y_name = y_name;
	}
	public void setK_name(String k_name) {
		this.k_name = k_name;
	}
	
	
	@Override
	public String toString() {
		
		return this.id + " - " +this.name+ " - " + this.year + " - " + this.y_name + " - " + this.k_name;
	}
	public String toString1(){
		return this.id + " - "+this.name + " - " + this.year;
	}

}
