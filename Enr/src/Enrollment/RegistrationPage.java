package Enrollment;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.util.Date;  

public class RegistrationPage {
//	JPanel registrationForm = new JPanel();
	JFrame registrationForm;
	
	JLabel result;
	JLabel nameLabel;
	JLabel emailLabel;
	JLabel phoneNumberLabel;
	JLabel countryOfResidenceLabel;
	JLabel nationalityLabel;
	JLabel campusLabel;
	JLabel IntakeLabel;
	JLabel gradesLabel;

	private JTextField name;
	JTextField email;
	JTextField phoneNumber;
	JTextField countryOfResidence;
	JTextField nationality;
	JTextField grades;
	
	JRadioButton rwandaRadioBtn;
	JRadioButton mauritiusRadioBtn;
	JRadioButton janIntakeRadioBtn;
	JRadioButton septIntakeRadioBtn;
	
	JButton registerBtn;
	
	String studentName;
	String studentEmail;
	String studentPhoneNumber;
	String countryofRes;
	String studentNationality;
	String selectedCampus;
	String selectedIntake;
	String studentGrades; 
	String major;
	
	String studentNumber;
	String lastNumber;
	int nextNumber;
	
	
	public RegistrationPage() { 
		registrationForm = new JFrame("Registration form");
		
		nameLabel = new JLabel("Full name: ");  
		nameLabel.setBounds(50, 50, 300, 20); 
		name = new JTextField();
		name.setBounds(50, 80, 350, 30); 
		
		emailLabel = new JLabel("Email address: ");  
		emailLabel.setBounds(50, 120, 300,30); 
		email = new JTextField();
		email.setBounds(50,160, 350, 30); 
		
		phoneNumberLabel = new JLabel("Phone number: ");  
		phoneNumberLabel.setBounds(50,200, 300,30); 
		phoneNumber = new JTextField();
		phoneNumber.setBounds(50,240, 350,30);  
	    
		countryOfResidenceLabel = new JLabel("Country of residence: ");  
		countryOfResidenceLabel.setBounds(50,280, 300,30); 
		countryOfResidence = new JTextField();
		countryOfResidence.setBounds(50,320, 350,30); 
		
		nationalityLabel = new JLabel("Nationality: ");  
		nationalityLabel.setBounds(50,360, 300,30); 
		nationality = new JTextField();
		nationality.setBounds(50,400, 350,30); 
		
		campusLabel = new JLabel("Campus: ");  
		campusLabel.setBounds(50,440, 100,30); 
		IntakeLabel = new JLabel("Intake: ");  
		IntakeLabel.setBounds(50,480, 100,30); 
		
		
		rwandaRadioBtn = new JRadioButton();
		rwandaRadioBtn.setText("Rwanda");
		rwandaRadioBtn.setBounds(120, 440, 100,30);
		
		mauritiusRadioBtn = new JRadioButton();
		mauritiusRadioBtn.setText("Mauritius");
		mauritiusRadioBtn.setBounds(250, 440, 100, 30);
		
		janIntakeRadioBtn = new JRadioButton();
		janIntakeRadioBtn.setText("January");
		janIntakeRadioBtn.setBounds(120, 480, 100,30);
		
		septIntakeRadioBtn = new JRadioButton();
		septIntakeRadioBtn.setText("September");
		septIntakeRadioBtn.setBounds(250, 480, 100,30);
		
		gradesLabel = new JLabel("Grade out of 20: ");  
		gradesLabel.setBounds(50,520, 300,30); 
		grades = new JTextField();
		grades.setBounds(50,560, 350,30); 
		
		result = new JLabel("");  
		result.setBounds(50,20, 350,30); 
		
		registerBtn = new JButton("Register");
		registerBtn.setBounds(250,620, 150,30);
		registerBtn.setEnabled(true);
		
		registrationForm.add(result);	
		registrationForm.add(nameLabel);
		registrationForm.add(name);
		registrationForm.add(emailLabel);
		registrationForm.add(email);
		registrationForm.add(phoneNumberLabel);		
		registrationForm.add(phoneNumber);
		registrationForm.add(countryOfResidenceLabel);
		registrationForm.add(countryOfResidence);
		registrationForm.add(nationalityLabel);
		registrationForm.add(nationality);
		registrationForm.add(campusLabel);
		registrationForm.add(rwandaRadioBtn);
		registrationForm.add(mauritiusRadioBtn);
		registrationForm.add(IntakeLabel);
		registrationForm.add(janIntakeRadioBtn);
		registrationForm.add(septIntakeRadioBtn);
		registrationForm.add(registerBtn);
		registrationForm.add(gradesLabel);
		registrationForm.add(grades);
		
		registrationForm.setSize(460,720);  
		registrationForm.setLayout(null);  		
		registrationForm.setVisible(true); 
		
		
		registerBtn.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				studentName = name.getText();
				studentEmail = email.getText();
				studentPhoneNumber = phoneNumber.getText();
				countryofRes = countryOfResidence.getText();
				studentNationality = nationality.getText();
				if (rwandaRadioBtn.isSelected()) {
					selectedCampus = "Rwanda";
				} else if (mauritiusRadioBtn.isSelected()){
					selectedCampus = "Mauritius";
				} 
				
				if (janIntakeRadioBtn.isSelected()) {
					selectedIntake = janIntakeRadioBtn.getText();
				} else if (septIntakeRadioBtn.isSelected()){
					selectedIntake = septIntakeRadioBtn.getText();
				}
				studentGrades = grades.getText();
					
				String atEmail = "@";
				String dot = ".";
								
				
//		        studentNumber = String.valueOf(year).concat(String.valueOf(nextNumber));
//		        studentNumber = String.valueOf(nextNumber);
//		        nextNumber ++;
		        
		        				
				if (studentName.length() > 0 & (studentEmail.indexOf(atEmail) > -1 & studentEmail.indexOf(dot) > -1 )&
						(String.valueOf(studentPhoneNumber).length() >= 10 |
								String.valueOf(studentPhoneNumber).length() <= 20)
						& countryofRes.length() > 0 & studentNationality.length() > 0 
						& (rwandaRadioBtn.isSelected() | mauritiusRadioBtn.isSelected() ) 
						&(janIntakeRadioBtn.isSelected() | septIntakeRadioBtn.isSelected())
						& studentGrades.length() > 0 ) {	
//					System.out.println("Hi");
					
					LocalDate currentdate = LocalDate.now();
			        int year= currentdate.getYear(); 
					try { 
						
						if (Integer.parseInt(studentGrades) >= 18 & Integer.parseInt(studentGrades) <= 20 ) {
							major = "Computer science";
						} else if (Integer.parseInt(studentGrades) >= 15 & Integer.parseInt(studentGrades) <= 17 ) {
							major = "Global challenges";
						} else if (Integer.parseInt(studentGrades) >= 12 & Integer.parseInt(studentGrades) <= 14 ) {
							major = "Business studies";
						} else {
//							result.setText("You don't have enough grades to be qualified for admission.");
							major = "Unqualified";
						}
						
						//1. Create database connection
						Connection myConn = DriverManager.getConnection(
					            "jdbc:mysql://localhost:3306/alu_registration_database","root", "");
						
						//2. Create a statement
						Statement mySt = myConn.createStatement();
						
						ResultSet myRe = mySt.executeQuery("select * from applicants_table");
						 
						//4. Process the result 
						while(myRe.next()) {
							int previousStNum = 0;
							// getting the rows in the database
							lastNumber = myRe.getString("Enrolnumber");
							System.out.println("last number is :" + lastNumber);
							String[] splitStudentNbr = lastNumber.split("/");
							int currentYear = Integer.parseInt(splitStudentNbr[0]);
							System.out.println(currentYear);
							int currentNum = Integer.parseInt(splitStudentNbr[1]);
							System.out.println("current: "+currentNum);
							if (currentYear == year) {
								if (currentNum >= previousStNum) {
									nextNumber = (currentNum + 1);
									System.out.println("must be: " + nextNumber);
								}
								else {
									continue;
								}
								previousStNum = currentNum; 
//								
							}
						}                //default year + / + autoincrement
						System.out.println("one taken: " + nextNumber);
						studentNumber = String.valueOf(year).concat("/" + String.valueOf(nextNumber));
						
//						String[] splitStudentNbr = lastNumber.split("/");
//						if splitStudentNbr 
						
						//3. Execute sql query
						String insertQuery = "insert into applicants_table( fullName,"
								+ " email, phoneNumber, countryOfResidence, nationality, campus, intake, grades, major, Enrolnumber) values"
								+ "(\"" + studentName + "\",\"" + studentEmail + "\",\"" 
								+ studentPhoneNumber + "\",\"" + countryofRes + "\",\""  + studentNationality +
								 "\",\"" + selectedCampus +  "\",\"" + selectedIntake +  "\",\"" + 
								Integer.parseInt(studentGrades) + "\",\"" + major +  "\", \"" + studentNumber +  "\" );";
						
						mySt.executeUpdate(insertQuery);
						
						System.out.println("Inserted successfully");	// green color
						
						//result.setText(LoginPage.page );
						result.setText("insert success!!!" );
						registrationForm.setVisible(false);
						AdmissionSlot s = new AdmissionSlot();
						
						
						if (major == "Unqualified"){
							JOptionPane.showMessageDialog(registrationForm,
									"You don't have enough grades to be qualified for admission.", "Message", 1);
						}
											
					}
					
					catch(Exception exception) {
						exception.printStackTrace();
					}
					
				} else { 
					if (studentName.length() == 0) {       // red color
						result.setText("Full name field is empty");
					}
					else if (studentEmail.indexOf(atEmail) <= 0 & studentEmail.indexOf(dot) <= 0) {
						result.setText("Invalid email.");
					} 
					else if (String.valueOf(studentPhoneNumber).length() < 10 ) {       
						result.setText("Verify the provided phone number");
					}
					else if (countryofRes.length() == 0) {       // red color
						result.setText("Please specify your country of residence");
					}
					else if (studentNationality.length() == 0) {       // red color
						result.setText("Please specify your nationality");
					}
					else if (!rwandaRadioBtn.isSelected() & !mauritiusRadioBtn.isSelected()) { // red color
						result.setText("Please select a campus");
					}
					else if (!janIntakeRadioBtn.isSelected() & !septIntakeRadioBtn.isSelected()) { // red color
						result.setText("Please select an intake");
					}
					else if (studentGrades.length() == 0 ) { // red color
						result.setText("Please provide your grade");
					}
//					else if (major == "Unqualified"){
//						result.setText("You don't have enough grades to be qualified for admission.");
//					}
					else {
						result.setText("verify your entries");
					}
				}
			 }
		  }
			
		);
		
	}
	
	public static void main(String[] args) {
		RegistrationPage r = new RegistrationPage(); 
		

	}
}
