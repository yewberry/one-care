package com.abc.ihis.medical.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 病房对象
 * 
 * @author chenkaihao
 */
@Entity
@Table(name = "t_ward")
public class Ward {

	private String id; // 标识
	private String wardNo; // 病床号
	private String name;// 病房名称
	private String category; // 病房类别
	private String description; // 病房描述
	private List<WardBed> beds = new ArrayList<WardBed>();//病床列表

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWardNo() {
		return wardNo;
	}

	public void setWardNo(String number) {
		this.wardNo = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, mappedBy = "ward")
	public List<WardBed> getBeds() {
		return beds;
	}

	public void setBeds(List<WardBed> beds) {
		this.beds = beds;
	}

	public void addBed(WardBed bed) {
		this.getBeds().add(bed);
	}
}
