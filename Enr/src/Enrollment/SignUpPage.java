package Enrollment;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SignUpPage {
	JFrame signInFrame;
	JLabel nameLabel;
	JTextField name;
	JLabel emailLabel;
	JTextField email;
	JLabel passwordLabel;
	JTextField password;
	JLabel confirmPasswordLabel;
	JTextField confirmPassword;
	JLabel result;
	JButton signupBtn;
	
	public SignUpPage() { 
		signInFrame = new JFrame("Sign Up");
		signInFrame.setResizable(false);
		signInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		nameLabel = new JLabel("Enter your full name: ");  
		nameLabel.setBounds(50, 50, 350, 20); 
		name = new JTextField();
		name.setBounds(50, 80, 350, 30); 
		
		emailLabel = new JLabel("Enter your email: ");  
		emailLabel.setBounds(50, 120, 300,30); 
		email = new JTextField();
		email.setBounds(50,160, 350, 30); 
		
		passwordLabel = new JLabel("Password: ");  
	    passwordLabel.setBounds(50,200, 300,30); 
		password = new JTextField();
		password.setBounds(50,240, 350,30);   
	    
		confirmPasswordLabel = new JLabel("Confirm Password: ");  
		confirmPasswordLabel.setBounds(50,280, 300,30); 
		confirmPassword = new JTextField();
		confirmPassword.setBounds(50,320, 350,30); 
		
		result = new JLabel("");  
		result.setBounds(50,20, 300,30); 
	   
		
		signInFrame.add(result);
		signInFrame.add(name);
	    signInFrame.add(email);
	    signInFrame.add(password);
	    signInFrame.add(confirmPassword);
	    signInFrame.add(nameLabel);
	    signInFrame.add(emailLabel);
	    signInFrame.add(passwordLabel);
	    signInFrame.add(confirmPasswordLabel);
	    
	    			    
		//signupBtn =  new JButton("Sign Up");
		signupBtn =  new JButton("submit");
		signupBtn.setBounds(50,380,100,30);  
		signupBtn.setEnabled(true);
		signInFrame.add(signupBtn); 
		 
		
		signupBtn.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				String studentName = name.getText();
				String studentEmail = email.getText();
				String studentPassword = password.getText();
				String confPassword = confirmPassword.getText();
				String atEmail = "@";
				String dot = ".";
				
				if (studentEmail.indexOf(atEmail) > -1 & studentEmail.indexOf(dot) > -1 &
						studentPassword.length() >= 4 & studentPassword.equals(confPassword)) {				
					try { 
						
						//1. Create database connection
						Connection myConn = DriverManager.getConnection(
					            "jdbc:mysql://localhost:3306/alu_registration_database","root", "");
						
						//2. Create a statement
						Statement mySt = myConn.createStatement();
									
						//3. Execute sql query
						String insertQuery = "insert into login_credentials_table (studentName, email, password) values"
								+ "(\"" + studentName + "\",\"" + studentEmail + "\",\"" + studentPassword + "\");";
						
						mySt.executeUpdate(insertQuery);
						
						System.out.println("Inserted successfully");	// green color
						result.setText("Signed Up successfully");
						signInFrame.setVisible(false); 
						LoginPage l = new LoginPage();
						
											
					}
					
					catch(Exception exception) { 
						exception.printStackTrace();
					}
				} 
				else { 
					if (studentEmail.indexOf(atEmail) <= 0 & studentEmail.indexOf(dot) <= 0) {
						result.setText("Invalid email.");
					}
					else if (studentPassword.length() < 4) {       // red color
						result.setText("Password must be at least 4 characters");
					}
					else if (studentPassword != confPassword) {
						result.setText("Passwords don't match");
					}
					else {
						result.setText("verify your entries");
					} 
				}
				
			}
			
		});
		
		signInFrame.setSize(460,500);  
		signInFrame.setLayout(null);  		
		signInFrame.setVisible(true);  
	}
	
	public static void main(String[] args) {
		SignUpPage c = new SignUpPage();
		//have an event listener
		//signupBtn.addActionListener(e -> LoginPage());
		
		//LoginPage l = new LoginPage();
		

	}
}
