package com.capgemini.doctors.service;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.dao.IDoctorAppointmentDao;
import com.capgemini.doctors.dao.ImptDoctorAppointmentDao;
import com.capgemini.doctors.invalidinputexception.InvalidInputExcetion;

public class ImpDoctorAppointmentService implements IDoctorAppointmentService {

	IDoctorAppointmentDao idd = new ImptDoctorAppointmentDao();
	DoctorAppointment da = new DoctorAppointment();
	
	//pass the values to dao
	@Override
	public int addDoctorAppointmentDetails(int appointmentId,DoctorAppointment doctorAppointment) {
		// TODO Auto-generated method stub
			return idd.addDoctorAppointmentDetails(appointmentId,doctorAppointment);
	}
	

	//pass the values to dao
	@Override
	public DoctorAppointment getDoctoreAppointmentDetails(int appointmentId) {
		// TODO Auto-generated method stub
		if(isValidId(appointmentId)) {
			return idd.getAppointmentDetails(appointmentId);
		}
		
		else
			throw new InvalidInputExcetion(" : AppointmentId is Wrong!");
	}
	
	//validate the appointmentID
	public boolean isValidId(int appointmentId) {
		
		if(appointmentId>1000) {
			return true;
		}
		else
			return false;
	}
	
	//validate the name
	public boolean isValidName(String name) {
		if(name.matches("^[A-Z][A-Za-z]+")) {
			return true;
		}
		else
			throw new InvalidInputExcetion(" : Invalid Name");
	}

}
