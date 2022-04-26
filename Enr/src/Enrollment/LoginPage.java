package Enrollment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class LoginPage {
   JFrame loginFrame;
   JLabel emailLabel;
   JTextField email;
   JLabel passwordLabel;
   JTextField password;
   JLabel confirmEmailLabel;
   JTextField confirmPassword;
   JLabel result;
   JButton loginBtn;
   JButton signupBtn;
   
   
   public LoginPage() {
      loginFrame = new JFrame("Login in");
      loginFrame.setResizable(false);
      loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      emailLabel = new JLabel("Enter your email: ");  
      emailLabel.setBounds(50, 50, 350, 20); 
      email = new JTextField();
      email.setBounds(50, 80, 350, 30); 
      
      passwordLabel = new JLabel("Password: ");  
       passwordLabel.setBounds(50, 120, 300,30); 
      password = new JTextField();
      password.setBounds(50,160, 350, 30);  
       
//    confirmEmailLabel = new JLabel("Confirm Password: ");  
//    confirmEmailLabel.setBounds(50,200, 300,30); 
//    confirmPassword = new JTextField();
//    confirmPassword.setBounds(50,240, 350,30); 
      
      result = new JLabel("");  
      result.setBounds(50,20, 300,30); 
      
      loginFrame.add(result);
       loginFrame.add(email);
       loginFrame.add(password);
//     loginFrame.add(confirmPassword);
       loginFrame.add(emailLabel);
       loginFrame.add(passwordLabel);
//     loginFrame.add(confirmEmailLabel);
       
       
      loginBtn =  new JButton("Login");
      loginBtn.setBounds(50,220,100,30);  
      loginBtn.setEnabled(true); 
      loginFrame.add(loginBtn); 
      
      signupBtn =  new JButton("Signup");
      signupBtn.setBounds(150,220,100,30);  
      signupBtn.setEnabled(true);
      loginFrame.add(signupBtn); 
      
      
      signupBtn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			loginFrame.setVisible(false);
			SignUpPage p = new SignUpPage();
			
		} 
    	   
      });
      loginBtn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            String studentEmail = email.getText();
            String studentPassword = password.getText();
            String atEmail = "@";
            String dot = ".";
            
            if (studentEmail.indexOf(atEmail) > -1 & studentEmail.indexOf(dot) > -1 &
                  studentPassword.length() >= 4) {            
               try {
                  
                  //1. Create database connection
                  Connection myConn = DriverManager.getConnection(
                           "jdbc:mysql://localhost:3306/alu_registration_database","root", "");
                  
                  //2. Create a statement
                  Statement mySt = myConn.createStatement();
                           
                  //3. Execute sql query
                  String selectQuery = "select * from login_credentials_table where 'email' = "
                        + "(\"" + studentEmail + "\" and 'password = ' \"" + studentPassword + "\");";
                  
                  ResultSet matchingData = mySt.executeQuery(selectQuery);
                  int count = 0;
                  
                  if (matchingData.next()) {
//                   System.out.println("successful");
                     System.out.println(matchingData);
                     count ++;
                     
//                         UserHome ah = new UserHome(userName);
//                         ah.setTitle("Welcome");
//                         ah.setVisible(true);
//                         JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                       } else {
//                        System.out.println("Not successful");
                           //JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                       }
                  
                  if (count == 0) {
                     //System.out.println("Not successful");
                     result.setText("Not successful!...Please sign up to create account");
                     loginFrame.setVisible(true);
                     
                     
                     
                  }
                  else { 
                     System.out.println("successful");
                     System.out.println("Logged in successfully");  // green color
                     result.setText("Logged in successfully");
                     loginFrame.setVisible(false);
                     //RegistrationPage p = new RegistrationPage();
                     WelcomePage WelcomePage = new WelcomePage();
                     // show home page
                     WelcomePage.show();
                  } 
                  
                  
                                  
               }  
               
               catch(Exception exception) {
                  exception.printStackTrace();
               }
            } 
            else { 
               if (studentPassword.length() < 4) {       // red color
                  result.setText("Password must be at least 4 characters");
               } else {
                  result.setText("Invalid email.");
               }
            }
            
         }
         
      });
      
      loginFrame.setSize(460,320);  
      loginFrame.setLayout(null);       
      loginFrame.setVisible(true); 
   }
   // show frame 
    public void show() {
        loginFrame.setVisible(true);
    }
   
   public static void main(String[] args) {
      LoginPage login = new LoginPage();  

   }
   
}