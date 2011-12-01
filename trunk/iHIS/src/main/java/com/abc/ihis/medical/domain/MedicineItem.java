package com.abc.ihis.medical.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 药品，只是用于描述一种具体的药品
 * 
 * @author chenkaihao
 */
@Entity
@Table(name = "t_medicine")
public class MedicineItem {

	/**
	 * 药品计算单位
	 * 
	 * @author chenkaihao
	 * 
	 */
	public static abstract class Unit {

		String MG = "MG";// 毫克

		String G = "G";// 克

		String L = "L";// 升

		String ML = "ML";// 毫升

		String U = "U";// 最小效价单位

		String IU = "IU";// 国际最小效价单位
	}

	private long id;// 标识
	private String medicineNo; // 药品编号
	private String name;// 药品名称
	private String functional;// 功用
	private String type; // 药品类别
	private String manufacturer; // 生产厂商
	private float price;// 价格
	private String unit; // 计量单位

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMedicineNo() {
		return medicineNo;
	}

	public void setMedicineNo(String medicineNo) {
		this.medicineNo = medicineNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFunctional() {
		return functional;
	}

	public void setFunctional(String functional) {
		this.functional = functional;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
