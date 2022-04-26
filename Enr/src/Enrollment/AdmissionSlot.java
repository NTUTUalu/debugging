package Enrollment;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class AdmissionSlot {
	JFrame admissionPage;
	JLabel remark;
	JTextArea studentDetails;
	
	public AdmissionSlot() { 
		admissionPage = new JFrame("Admission portal");
		studentDetails = new JTextArea(); 
		studentDetails.setBounds(50,50, 1200, 470); 
		admissionPage.add(studentDetails);
		admissionPage.setSize(460,600);  
		admissionPage.setLayout(null);   		
		admissionPage.setVisible(true);
		
		try { 
			//1. Create database connection
			Connection myConn = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/alu_registration_database","root", "");
			
			//2. Create a statement
			Statement mySt = myConn.createStatement();
			
			ResultSet myRe = mySt.executeQuery("select * from applicants_table");
			
			
//			int record = 0;
			//4. Process the result
			String Allrecords = "";

			
			while(myRe.next()) {
				String Record="STUDENT NUMBER: " +   myRe.getString("studentRegistrationNumber") + 
						 "STUDENT NAME: "  + myRe.getString("fullName") +   " STUDENT EMAIL: " + myRe.getString("email") + 
						  "COUNTRY OF RESIDENCE: " + myRe.getString("countryOfResidence") +    "CAMPUS: " + myRe.getString("campus") + "INTAKE:"   +
						myRe.getString("intake") + "ADMISSION STATUS: "   + myRe.getString("major");
				

				//System.out.println(Record);
				Allrecords += "\r\n" + Record;
				//(Record);
				
				//System.out.println(myRe.getString("studentRegistrationNumber"));
				// displaying the rows in the database
				
				
			}
			System.out.println(Allrecords);
			studentDetails.setText(Allrecords);
			 
			//
			//
			// PARTICULAR STUDENT !!!!!!!! REMOVE WHILENEXT...
			//
			//
			//
			
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		

	}
	
	public static void main(String[] args) {
		AdmissionSlot adm = new AdmissionSlot();
	}
}
