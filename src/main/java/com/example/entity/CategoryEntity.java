package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name="category")
public class CategoryEntity extends AbstractEntity {
	 
	@Column(name="name")
	private String name ;
	
	@Column(name="code")
    private String code ;
	

	@OneToMany(mappedBy="category")
	private List<NewEntity> news = new ArrayList<>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<NewEntity> getListNew() {
		return news;
	}

	public void setListNew(List<NewEntity> listNew) {
		this.news = listNew;
	}
	
	
	
}
