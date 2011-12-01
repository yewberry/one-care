package com.abc.ihis.device.domain;

import javax.persistence.Entity;

import com.abc.ihis.medical.domain.Ward;

/**
 * 设备地点
 * 
 * @author chenkaihao
 * 
 */
@Entity
public class Position {
	private long id; // 标志
	private String name;// 地点名称
	private String description;// 地点描述
	private int distance; // 与后台服务器距离
	private Ward ward;// 设备所在病房。 可选，有些设备可能放在其他地方

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Ward getWard() {
		return ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
	}

}
