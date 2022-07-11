package com.chainsys.mavenlessons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Appointments")
public class Appointment {
	@Id
	@Column(name = "APPOIMENT_ID")
	private int app_Id;
	@Column(name = "APPOIMENT_DATE")
	private Date app_Date;
//	@Column(name = "DOC_ID")
//	private int doc_Id;
	@Column(name = " PATIENT_NAME")
	private String p_Name;
	@Column(name = "FEES_COLLECTED")
	private float fees;
	// private int docId;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "DOC_ID" ,nullable = false, insertable = false, updatable = false) 
	@JsonIgnore
	private Doctor doctor;
	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public int getApp_Id() {
		return app_Id;
	}

	public void setApp_Id(int app_Id) {
		this.app_Id = app_Id;
	}

	public Date getApp_Date() {
		return app_Date;
	}

	public void setApp_Date(Date app_Date) {
		this.app_Date = app_Date;
	}

//	public int getDoc_Id() {
//		return doc_Id;
//	}
//
//	public void setDoc_Id(int doc_Id) {
//		this.doc_Id = doc_Id;
//	}

	public String getP_Name() {
		return p_Name;
	}

	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}

	public float getFees() {
		return fees;
	}

	public void setFees(float fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return String.format("%d,%s,%s,%f", app_Id, app_Date, p_Name, fees);
	}

}
