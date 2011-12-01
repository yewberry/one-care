package com.abc.ihis.device.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 控制节点
 * 
 * @author chenkaihao
 * 
 */
@Entity
@Table(name = "t_controller")
public class Controller {
	private long id;// 标识
	private String name;// 名称
	private String ip;// IP地址
	private String apName;// Wifi热点名称
	private String apPassword;// Wifi密码
	private String status;// 当前状态
	private Position position;// 控制设备所在地点
	private List<Device> devices = new ArrayList<Device>();// 控制的目标设备列表

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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getApName() {
		return apName;
	}

	public void setApName(String apName) {
		this.apName = apName;
	}

	public String getApPassword() {
		return apPassword;
	}

	public void setApPassword(String apPassword) {
		this.apPassword = apPassword;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, mappedBy = "controller")
	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

}
