package com.capgemini.doctors.dao;

import java.util.HashMap;
import java.util.Random;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.invalidinputexception.InvalidInputExcetion;

public class ImptDoctorAppointmentDao implements IDoctorAppointmentDao {
	
	static HashMap<Integer,DoctorAppointment> appointments = new HashMap<Integer,DoctorAppointment>();
	static HashMap<String,String> doctors = new HashMap<String,String>();
	
	{
		doctors.put("heart", "Joel");
		doctors.put("ent", "Max");
		doctors.put("digestive", "Kent");
		doctors.put("brain", "Tom");
		doctors.put("bone", "Dave");
	}

	
	public int generateId()
	{
		return new Random().nextInt(9000);
	}

	@Override
	public int addDoctorAppointmentDetails(DoctorAppointment doctorAppointment) {
		if(doctors.containsKey(doctorAppointment.getProblemName()))
		{
			int id = generateId();
			doctorAppointment.setAppointmentId(id);
			doctorAppointment.setDoctorName(doctors.get(doctorAppointment.getProblemName().toLowerCase()));
			appointments.put(id,doctorAppointment);
			doctorAppointment.setAppointmentStatus("APPROVED");
			return id;
		}
		else
		{
			doctorAppointment.setDoctorName(null);
			throw new InvalidInputExcetion("Invalid Problem Name");
		}
		
	}

	@Override
	public DoctorAppointment getAppointmentDetails(int appointmentId) {
		if(appointments.containsKey(appointmentId))
		{
			return appointments.get(appointmentId);
		}
		else
		{
			throw new InvalidInputExcetion("Could not find Appointment ID:");
		}
	       
}
}

