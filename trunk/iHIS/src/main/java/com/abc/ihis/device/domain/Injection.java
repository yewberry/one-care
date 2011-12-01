package com.abc.ihis.device.domain;

import java.util.Date;

import com.abc.ihis.medical.domain.Medicine;
import com.abc.ihis.role.domain.Nurse;
import com.abc.ihis.role.domain.Patient;

/**
 * 一次注射
 * 
 * @author chenkaihao
 * 
 */
public class Injection {
	private Medicine medicine;// 注射的药
	private Date begin;// 开始注射时间
	private Date end;// 结束注射时间
	private String type;// 注射类型,人工、自动
	private Device device;// 控制注射的设备
	private Patient patient; // 患者
	private Nurse nurse;// 负责注射护士

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

}
