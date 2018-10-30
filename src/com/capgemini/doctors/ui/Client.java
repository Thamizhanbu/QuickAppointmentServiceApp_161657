package com.capgemini.doctors.ui;

import java.util.Scanner;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.invalidinputexception.InvalidInputExcetion;
import com.capgemini.doctors.service.IDoctorAppointmentService;
import com.capgemini.doctors.service.ImpDoctorAppointmentService;

public class Client {
	
	IDoctorAppointmentService ids;
	public Client() {
		ids = new ImpDoctorAppointmentService();
	}
	
	Scanner sc = new Scanner(System.in);
 
	public void displayMenu() {
		System.out.println("\n\n----Select an Option------");
		System.out.println("\n1) Book Doctor Appointment");
		System.out.println("\n2) View Doctor Appointment");
		System.out.println("\n3) Exit");
		int ch = sc.nextInt();
		
		switch (ch){
			case 1: bookdoctorappointment();
					break;
			case 2: viewdoctorappointment();
					break;
			case 3: exit();
					break;
			default:
				System.out.println("---!Invalid Option!---");
				break;
		}
	}
	
	void bookdoctorappointment(){
		DoctorAppointment da = new DoctorAppointment();
		
		System.out.println("Enter Patient Name: ");
		da.setPatientName(sc.next());		
		System.out.println("Enter Phone Number: ");
		da.setPhoneNumber(sc.next());
		System.out.println("Enter EmailID: ");
		da.setEmail(sc.next());
		System.out.println("Enter Age: ");
		da.setAge(sc.nextInt());
		System.out.println("Enter Gender: ");
		da.setGender(sc.next());
		System.out.println("Enter Problem Name: ");
		da.setProblemName(sc.next());
		try {
		System.out.println("\nYour Doctor Appointment has been successfully registered,your appointment ID is: "+ ids.addDoctorAppointmentDetails(da));
		}
		catch(InvalidInputExcetion e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			//e.printStackTrace();
		}
		}
	
	
		void viewdoctorappointment() {
		System.out.println("Enter your Appointment ID: ");
		int appointmentId = sc.nextInt();
		try {
		DoctorAppointment doc = ids.getDoctoreAppointmentDetails(appointmentId);
		System.out.println("Patient Name: "+ doc.getPatientName());
		System.out.println("Appointment Status: " + doc.getAppointmentStatus() );
		System.out.println("Doctor Name: " + doc.getDoctorName());
		}
		catch(InvalidInputExcetion e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			//e.printStackTrace();
		}
		
	}
	
	//Exit the user from program
	void exit() {
		System.out.println("!----------Thank You-------------!");
		System.exit(0);
	}


	public static void main(String[] args) {

		Client c = new Client();
		while(true) {
		c.displayMenu();
		}

	}

}
