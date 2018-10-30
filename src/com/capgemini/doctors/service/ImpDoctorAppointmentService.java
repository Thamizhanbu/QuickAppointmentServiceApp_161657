package com.capgemini.doctors.service;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.dao.IDoctorAppointmentDao;
import com.capgemini.doctors.dao.ImptDoctorAppointmentDao;
import com.capgemini.doctors.invalidinputexception.InvalidInputExcetion;

public class ImpDoctorAppointmentService implements IDoctorAppointmentService {

	IDoctorAppointmentDao idd;
	
	public ImpDoctorAppointmentService() {
		idd = new ImptDoctorAppointmentDao();
	}


	@Override
	public int addDoctorAppointmentDetails(DoctorAppointment doctorAppointment) {
		if(isValidName(doctorAppointment.getPatientName()))
			return idd.addDoctorAppointmentDetails(doctorAppointment);
		else
			throw new InvalidInputExcetion("Something went wrong : ");
		}
	
	@Override
	public DoctorAppointment getDoctoreAppointmentDetails(int appointmentId) {
		return idd.getAppointmentDetails(appointmentId);
	}
	
	
	public boolean isValidName(String name) {
		if(name.matches("[A-Z][A-Za-z]+")) {
			return true;
		}
		else
			throw new InvalidInputExcetion("Invalid Name");
	}

}
