package com.abc.ihis.role.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Doctor")
public class Doctor extends MedicalStaff {

}
