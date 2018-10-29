package com.capgemini.doctors.ui;

import java.util.Scanner;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.invalidinputexception.InvalidInputExcetion;
import com.capgemini.doctors.service.IDoctorAppointmentService;
import com.capgemini.doctors.service.ImpDoctorAppointmentService;

public class Client {
	Scanner sc = new Scanner(System.in);
	IDoctorAppointmentService ids = new ImpDoctorAppointmentService();
	int appointmentid =(int) Math.random()*90000+1001;
	
	//Displays the menu 
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
				System.out.println("---!Choosed Wrong Option!---");
				break;
		}
	}
	
	//Get details from user and book doctor appointment
	void bookdoctorappointment(){
		DoctorAppointment da = new DoctorAppointment();
		da.setAppointmentId(appointmentid);
		try {
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
		int appointmentId=ids.addDoctorAppointmentDetails(da.getAppointmentId(),da);
		System.out.println("\nYour Doctor Appointment has been successfully registered,your appointment ID is: "+appointmentId);
		}
		catch(InvalidInputExcetion e) {
			System.out.println(e.getMessage());
		}
		
		}
	
	//Get appointment id from user and show the status of appointment
	void viewdoctorappointment() {
		DoctorAppointment da = new DoctorAppointment();
		System.out.println("Enter your Appointment ID: ");
		int appointmentId = sc.nextInt();
		try {
			ids.getDoctoreAppointmentDetails(appointmentId);
			//System.out.println(da);
			System.out.println("Patient Name: "+da.getPatientName());
			System.out.println("Appointment Status: APPROVED");
		}
		catch(InvalidInputExcetion e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//Exit the user from program
	void exit() {
		System.out.println("!----------Thank You-------------!");
		System.exit(0);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			Client c = new Client();
			c.displayMenu();
		}

	}

}
