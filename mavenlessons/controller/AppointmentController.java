package com.chainsys.mavenlessons.controller;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.chainsys.mavenlessons.entity.Appointment;
import com.chainsys.mavenlessons.entity.Doctor;
import com.chainsys.mavenlessons.repository.AppointmentRepository;

@RestController
public class AppointmentController {
	@Autowired
	private AppointmentRepository arepo;

	@GetMapping(value = "/fetchdoctorbyappointmentid")
	public String getDoctorByAppointmentId(int id) {
	Appointment app = arepo.findById(id);
	Doctor doc = app.getDoctor();
	return doc.toString(); 
	}
//	@GetMapping("/getapp")
//	public Appointment getAppointment(int id) {
//		return arepo.findById(id);
//	}
	
	@GetMapping("/getallappointments")
	public List<Appointment> getAppointments() {
		return arepo.findAll();
	}

	@PostMapping(value = "/newapp", consumes = "application/json")
	// we need to give from where to read data from the http request and also the
	// content type
	public RedirectView addNewAppointment(@RequestBody Appointment app) {
		arepo.save(app);
		return new RedirectView("/getallappointments");
	}

	@PutMapping(value = "/modifyapp", consumes = "application/json")
	public RedirectView modifyAppointment(@RequestBody Appointment app) {
		arepo.save(app);
		return new RedirectView("/getallappointments");
	}

	@DeleteMapping("/deleteapp")
	public RedirectView deleteAppointment(int id) {
		arepo.deleteById(id);
		return new RedirectView("/getallappointments");
	}

	@GetMapping("/getallbydocid")
	public List<Appointment> getAllbydocid(int dr_Id) {
		return arepo.findAllByDoctorId(dr_Id);
	}

}