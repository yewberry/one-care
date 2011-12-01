package com.abc.ihis.role.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Nurse")
public class Nurse extends MedicalStaff {

}
