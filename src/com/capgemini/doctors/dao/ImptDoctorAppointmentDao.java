package com.capgemini.doctors.dao;

import java.util.HashMap;
import java.util.Map;
import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.invalidinputexception.InvalidInputExcetion;

public class ImptDoctorAppointmentDao implements IDoctorAppointmentDao {
	
	
	Map<Integer,DoctorAppointment> appointments = new HashMap<Integer,DoctorAppointment>();

	//Stores the values in hashmap
	@Override
	public int addDoctorAppointmentDetails(int appointmentId,DoctorAppointment doctorAppointment) {
		// TODO Auto-generated method stub
		appointments.put(doctorAppointment.getAppointmentId(),doctorAppointment);
		System.out.println(appointments.get(appointmentId));
		return doctorAppointment.getAppointmentId();
	}

	//Return the status of appointment
	@Override
	public DoctorAppointment getAppointmentDetails(int appointmentId) {
		// TODO Auto-generated method stub
		DoctorAppointment result =null;
		/*if(appointments.containsKey(appointmentId)) {
			for(DoctorAppointment da:appointments.values()) {
				if(da.getAppointmentId()==appointmentId) {
				result = da;
				}
			}
			return result;
		}
			else {
					throw new InvalidInputExcetion("DISAPPROVED");
				}
	}*/
		 for (DoctorAppointment da : appointments.values()) {
	            
	            result =da;
	            System.out.println(da);
		}
		 
		 return result;
		 //System.out.println(result);
	       
}
}

