package com.sensemaya.medical.doctor.model;

import org.springframework.data.repository.CrudRepository;

public interface DoctorEntityRepository extends CrudRepository<DoctorEntity, Long>{

	DoctorEntity findByCurp(String curp);
	
}
