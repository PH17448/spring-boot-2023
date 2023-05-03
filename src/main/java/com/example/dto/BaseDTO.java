package com.example.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseDTO<DTO> {
	
	private Long id ;
	private String createdBy ;
	private Date createdDate ;
	private String modifiedBy ;
	private Date modifiedDate ;
	private List<DTO> list = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public List<DTO> getList() {
		return list;
	}
	public void setList(List<DTO> list) {
		this.list = list;
	}
	
	
	
	
}
