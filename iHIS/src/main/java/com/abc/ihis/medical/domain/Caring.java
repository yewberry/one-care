package com.abc.ihis.medical.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.abc.ihis.device.domain.Injection;

/**
 * 护理
 * 
 * @author chenkaihao
 */
public class Caring {
	private Long id;// 标识
	private Date time;// 护理时间
	private String breathing;// 呼吸
	private float pulse;// 脉搏
	private float systoliPressure;// 收缩压
	private float diastolicPressure;// 舒张压
	private float bodyTemperature;// 体温
	private String condition;// 病情描述
	private String description;// 护理描述
	private List<Medicine> medicines = new ArrayList<Medicine>();// 使用药品
	private Injection injection; // 注射

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getBreathing() {
		return breathing;
	}

	public void setBreathing(String breathing) {
		this.breathing = breathing;
	}

	public float getPulse() {
		return pulse;
	}

	public void setPulse(float pulse) {
		this.pulse = pulse;
	}

	public float getSystoliPressure() {
		return systoliPressure;
	}

	public void setSystoliPressure(float systoliPressure) {
		this.systoliPressure = systoliPressure;
	}

	public float getDiastolicPressure() {
		return diastolicPressure;
	}

	public void setDiastolicPressure(float diastolicPressure) {
		this.diastolicPressure = diastolicPressure;
	}

	public float getBodyTemperature() {
		return bodyTemperature;
	}

	public void setBodyTemperature(float bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}

	public Injection getInjection() {
		return injection;
	}

	public void setInjection(Injection injection) {
		this.injection = injection;
	}

}
