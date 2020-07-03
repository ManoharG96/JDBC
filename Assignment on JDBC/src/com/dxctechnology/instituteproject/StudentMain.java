package com.dxctechnology.instituteproject;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		StudentUtil util = new StudentUtil();
		System.out.println("enter the no of students to be inserted");
		int noOfStudent = scn.nextInt();

		for (int i = 0; i < noOfStudent; i++) {

			StudentInfo info = new StudentInfo();

			System.out.println("enter the Student id");
			info.setStudId(scn.nextInt());
			scn.nextLine();

			System.out.println("enter the student name");
			info.setStudName(scn.nextLine());

			System.out.println("enter the student full address");
			String fullAddress = scn.nextLine();
			info.setStudAddress(fullAddress);

			System.out.println("enter the student city");
			String city = scn.nextLine();
			info.setStudCity(city);

			System.out.println("enter the student country");
			info.setStudCountry(scn.nextLine());

			System.out.println("enter the student mobile no");
			info.setStudMobNo(scn.nextLong());


			int count = util.insertStudent(info);
			if (count>0)
				System.out.println("inserted successfully");

		}
		scn.nextLine();
		System.out.println("enter the city you want to get student list");
		ArrayList<StudentInfo> infoList = util.getStudentInfo(scn.nextLine());
		for (StudentInfo info : infoList) {
			System.out.println(info);
		}

		System.out.println("Enter the student id where you want to change name");
		int studentID = scn.nextInt();
		scn.nextLine();
		System.out.println("enter the name you want to change");
		String studentName = scn.nextLine();
		int nameCount = util.updateStudentName(studentName, studentID);
		if (nameCount > 0) {
			System.out.println("Updated successfully");
		}

		System.out.println("Enter the student id where you want to get Mobile number");
		int id = scn.nextInt();
		scn.nextLine();
		StudentInfo info = util.updateStudentMobileNo(id, "no", 0);
		System.out.println(info);

		System.out.println("do you want to change the mobile number (yes or no)?");
		String option = scn.nextLine();

		if (option.equalsIgnoreCase("yes")) {
			System.out.println("enter the mobile number you want to change");
			long mobile = scn.nextLong();
			StudentInfo info1 = util.updateStudentMobileNo(id, option, mobile);
			if (info1 != null)
				System.out.println("mobile number is successfully updated");
		} else {
			System.out.println("you choose No, so didn't updated the mobile number");
		}
		scn.close();
	}


}


