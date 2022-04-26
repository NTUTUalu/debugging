package Enrollment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

// about this class
/*
This is the first screen to show users.
They are presented with 2 buttons, compsci or business.
When they click either buttons, they are directed to the next screen.
*/

public class WelcomePage {
	
//	private JFrame frame;
	static JFrame frame = new JFrame("business in");
	
	JLabel guideLabel;
	
	
    private JButton compsci; 
    private JButton business;
    private JButton global;
    private JButton register;


    public WelcomePage() {
        // create frame
        frame = new JFrame("Welcome to the general admissions portal");
        

        // create buttons
        compsci = new JButton("ComputerSci");
        // size
        compsci.setSize(100, 50);
        // position
        compsci.setBounds(10, 10, 100, 50);
        
        business = new JButton("BusinessStudies");
        // size
        business.setSize(100, 50);
        // position
        business.setBounds(10, 60, 100, 50);
        
        global = new JButton("Globalchallenges");
        // size
        global.setSize(100, 50);
        // position
        global.setBounds(20, 60, 100, 50);
        
        register = new JButton("register");
        // size
        register.setSize(100, 50);
        // position
        register.setBounds(10, 10, 100, 50);
        
  
		guideLabel = new JLabel("Click any option below to view preferred enrolled students or to REGISTER ! ");  
		
		 guideLabel.setBounds(10, 50, 500, 60); 


        
        // call method compsci when button is clicked
        compsci.addActionListener(e -> compsci());

        // call method business when button is clicked
        business.addActionListener(e -> business());
        global.addActionListener(e -> global());
        register.addActionListener(e -> register());

        // add components to frame
        frame.add(compsci);
        frame.add(business);
        frame.add(global);
        frame.add(guideLabel);
        frame.add(register);

        // positioning

        // compsci - top left
        compsci.setBounds(10, 170, 150, 35);

        // business - top left + 50
        business.setBounds(10, 140, 150, 35);
        global.setBounds(10, 105, 150, 35);
        register.setBounds(10, 205, 150, 35);

        // set frame properties
        frame.setSize(500, 300);
        frame.setLayout(null); 
    }

    
    // show the frameF
    public void show() {
        try {
			frame.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    } 
    
 // sign up - closes the current frame and opens the sign up page
    public void compsci() {
        frame.setVisible(false);
        Compsci compsci = new Compsci();
        compsci.show(); 
    }

    // login - closes the current frame and opens the login page
    public void business() {
        frame.setVisible(false);
        Business business = new Business();
        business.show();
    }
    
 // login - closes the current frame and opens the login page
    public void global() {
        frame.setVisible(false);
        Globalchallenges globalchallenges = new Globalchallenges();
        globalchallenges.show();  
    }  
    
    public void register() {
        frame.setVisible(false);
        RegistrationPage global = new RegistrationPage();
        //RegistrationPage.show();
    }
    
//    public static void main(String[] args) throws Exception {
//        
//    }
    


}


 