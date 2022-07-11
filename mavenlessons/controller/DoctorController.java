package com.chainsys.mavenlessons.controller;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.mavenlessons.entity.Appointment;
import com.chainsys.mavenlessons.entity.Doctor;
import com.chainsys.mavenlessons.repository.DoctorRepository;

@RestController
public class DoctorController {
	@Autowired
	private DoctorRepository repo;

//	@Bean
//	public void setRepo(DoctorRepository repo) {
//		this.repo = repo;
//	}

//	@GetMapping("/getdoctor")
//	public String getDoctor(int id) {
//		return repo.findById(id).toString();
//	}
	@GetMapping(value = "/getdoctorappointment")
    public String getAppointment(int id) {
        Doctor doc = repo.findById(id);
        List<Appointment> appointment = doc.getAppointment();
        return appointment.toString();
    }
	@PutMapping(value="/updateDoctor" , consumes="application/json")
	public  RedirectView updateDoctor(@RequestBody Doctor dr) {
	 repo.save(dr);
	 return new RedirectView("/getalldoctor");
	}
	@PostMapping(value="/addDoctor" , consumes="application/json")
	public RedirectView addNewDoctor(@RequestBody Doctor dr) {
	 repo.save(dr);
	 return new RedirectView("/getalldoctor");
	}
	@DeleteMapping("/removeDoctor")
	public  RedirectView deleteDoctor(int id) {
		repo.deleteById(id);
		return new RedirectView("/getalldoctor");
	}
	@GetMapping("/getalldoctor")
	public List<Doctor> getDoctors() {
		return repo.findAll();
	}
	
}
