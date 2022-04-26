package Enrollment;


import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Globalchallenges { 
	JFrame frame;
	JTextArea studentDetails;
	
	public Globalchallenges() { 
		
		frame = new JFrame("Admission portal");
		studentDetails = new JTextArea(); 
		studentDetails.setBounds(50,50, 1200, 470);
		frame.add(studentDetails);
		frame.setSize(460,600);  
		
		try { 
			//1. Create database connection
			Connection myConn = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/alu_registration_database","root", "");
			
			//2. Create a statement
			Statement mySt = myConn.createStatement();
			
			ResultSet myRe = mySt.executeQuery("select * from applicants_table where major = 'Global challenges'");
			
			
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

	public void show() {
		// TODO Auto-generated method stub
		frame.setLayout(null);   		
		frame.setVisible(true);
		
		
	}

	    
}

