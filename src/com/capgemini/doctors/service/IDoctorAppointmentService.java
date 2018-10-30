package com.capgemini.doctors.service;

import com.capgemini.doctors.bean.DoctorAppointment;

public interface IDoctorAppointmentService {
	int addDoctorAppointmentDetails(DoctorAppointment doctorAppointment);
	DoctorAppointment getDoctoreAppointmentDetails(int appointmentId);
}
