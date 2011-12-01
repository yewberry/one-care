package com.abc.ihis.role.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.abc.ihis.medical.domain.Treatment;

/**
 * 患者。与领域对象就诊Treatment为1:n关系
 * 
 * @author chenkaihao
 */
@Entity
@DiscriminatorValue(value = "1")
public class Patient extends Citizen {

	private String diseaseDescrition;// 特别疾病

	private List<Treatment> treatments = new ArrayList<Treatment>();// 就诊记录

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, mappedBy = "patient")
	public List<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}

	public void addTreatment(Treatment treatment) {
		this.getTreatments().add(treatment);
	}

	@Column
	public String getDiseaseDescrition() {
		return diseaseDescrition;
	}

	public void setDiseaseDescrition(String diseaseDescrition) {
		this.diseaseDescrition = diseaseDescrition;
	}
}
