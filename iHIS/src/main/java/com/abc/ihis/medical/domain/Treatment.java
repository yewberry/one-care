package com.abc.ihis.medical.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.abc.ihis.role.domain.Doctor;
import com.abc.ihis.role.domain.Patient;

/**
 * 就诊记录，与领域对象患者Patient为n:1关系，与使用的药关系是1:n
 * 
 * @author chenkaihao
 */
@Entity
@Table(name = "t_treament")
public class Treatment {
	private long id;
	private String hospital;// 就诊医院
	private String contact;// 联系人
	private String telephone;// 电话
	private String address;// 联系地址
	private String serialno;// 就诊号
	private Date time;// 就诊时间
	private String department;// 科室
	private String category;// 就诊类别,普通、专家
	private Doctor doctor;// 就诊医生
	private String patientCondition;// 病情描述
	private Patient patient; // 患者
	private WardBed wardBed; // 病床号
	private boolean stayHospital;// 是否住院
	private List<Medicine> medicines = new ArrayList<Medicine>();// 治疗药品

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(length = 200)
	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	@Column(length = 50)
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(length = 30)
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(length = 300)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSerialno() {
		return serialno;
	}

	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(length = 30)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(length = 20)
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPatientCondition() {
		return patientCondition;
	}

	public void setPatientCondition(String patientCondition) {
		this.patientCondition = patientCondition;
	}

	public boolean isStayHospital() {
		return stayHospital;
	}

	public void setStayHospital(boolean stayHospital) {
		this.stayHospital = stayHospital;
	}

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "patient_id")
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "wardbed_id")
	public WardBed getWardBed() {
		return wardBed;
	}

	public void setWardBed(WardBed wardBed) {
		this.wardBed = wardBed;
	}

	@OneToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name = "t_treatment_medicine", joinColumns = @JoinColumn(name = "treatment_id"), inverseJoinColumns = @JoinColumn(name = "medicine_id"))
	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}

	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "doctor_id")
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}
