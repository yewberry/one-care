package com.abc.ihis.medical.domain;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

/**
 * 使用的药，包含药品和药品数量
 * 
 * @author chenkaihao
 * 
 */
public class Medicine {

	private MedicineItem medicine; // 药品

	private float count;// 数量

	private Treatment treatment;// 就诊

	public MedicineItem getMedicine() {
		return medicine;
	}

	public void setMedicine(MedicineItem medicine) {
		this.medicine = medicine;
	}

	public float getCount() {
		return count;
	}

	public void setCount(float count) {
		this.count = count;
	}

	@ManyToOne(cascade = CascadeType.REFRESH)
	public Treatment getTreatment() {
		return treatment;
	}

	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;

	}

}
