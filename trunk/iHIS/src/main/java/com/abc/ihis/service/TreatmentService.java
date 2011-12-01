package com.abc.ihis.service;

import com.abc.ihis.medical.domain.Treatment;

public interface TreatmentService {

	void saveTreatment(Treatment treatment);

	void deleteTreatment(Treatment treatment);
	
}
