package com.capgemini.doctors.service;

import com.capgemini.doctors.bean.DoctorAppointment;

public interface IDoctorAppointmentService {
	int addDoctorAppointmentDetails(int appointmentId,DoctorAppointment doctorAppointment);
	DoctorAppointment getDoctoreAppointmentDetails(int appointmentId);
	boolean isValidName(String name);

}
