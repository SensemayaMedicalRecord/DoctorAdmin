package com.sensemaya.medical.doctor.contoller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensemaya.medical.doctor.model.DoctorEntity;
import com.sensemaya.medical.doctor.model.DoctorEntityRepository;

@RestController
@RequestMapping("doctor")
public class DoctorController {

	@Autowired
	DoctorEntityRepository repository;
	
	@RequestMapping(path={"{idDoctor}","/{idDoctor}"}, method=RequestMethod.POST)
	public CommonResponse getDoctorInfo(@PathParam("idDoctor") String curp){
		CommonResponse res = new CommonResponse();
		
		DoctorEntity rs = repository.findByCurp(curp);
		
		res.setSuccess(null!=rs);
		res.setDoctor(rs);
		
		return res;
	}
	
	@RequestMapping(path={"","/"}, method=RequestMethod.GET)
	public CommonResponse getDoctors(){
		CommonResponse res = new CommonResponse();
		
		res.setResponse((List<DoctorEntity>) repository.findAll());
		
		return res;
	}
	
	@RequestMapping(path={"","/"}, method=RequestMethod.POST)
	public CommonResponse createDoctor(@RequestBody DoctorEntity doctor){
		CommonResponse res = new CommonResponse();
		
		repository.save(doctor);
		
		return res;
	}
	
}

class CommonResponse{
	
	private boolean success;
	private DoctorEntity doctor;
	private List<DoctorEntity> response;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public DoctorEntity getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}
	public List<DoctorEntity> getResponse() {
		return response;
	}
	public void setResponse(List<DoctorEntity> response) {
		this.response = response;
	}
	
}
