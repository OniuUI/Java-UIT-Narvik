package Budjetting_Sys;

import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Budjetting_S {
	protected static final CreateUser[] CreateUser = null;
	private JFrame frame;
	private JPasswordField txtPassword;
	private JTextField txtUsername;
	private JTextField txtSignedIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Budjetting_S window = new Budjetting_S();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Budjetting_S() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblUsername.setBounds(90, 96, 66, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblPassword.setBounds(90, 137, 66, 14);
		frame.getContentPane().add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setEchoChar('*');
		txtPassword.setBounds(207, 134, 86, 20);
		frame.getContentPane().add(txtPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(207, 93, 86, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblLoginArea = new JLabel("Login Area");
		lblLoginArea.setFont(new Font("SimSun-ExtB", Font.PLAIN, 11));
		lblLoginArea.setBounds(186, 11, 94, 14);
		frame.getContentPane().add(lblLoginArea);
		
		JLabel lblCreatedByMarius = new JLabel("Created by Marius Magnussen");
		lblCreatedByMarius.setFont(new Font("SimSun-ExtB", Font.PLAIN, 11));
		lblCreatedByMarius.setBounds(10, 236, 165, 14);
		frame.getContentPane().add(lblCreatedByMarius);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				String password = txtPassword.getText();
				String username = txtUsername.getText();
				
				if(password.contains("king") && username.contains("one")){
					txtPassword.setText(null);
					txtUsername.setText(null);
					JOptionPane.showMessageDialog(null, "Login success!","Access granted",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid login details!","Access denied",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(90, 186, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnResetForm = new JButton("Reset Form");
		btnResetForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		btnResetForm.setBounds(191, 186, 89, 23);
		frame.getContentPane().add(btnResetForm);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmLoginSystem = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit","The login system", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}
				
			}
		});
		btnExit.setBounds(290, 186, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(72, 172, 318, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(72, 49, 318, 2);
		frame.getContentPane().add(separator_1);
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateProfile signup = new CreateProfile();
				CreateProfile.main(null);
			}
		});
		btnSignup.setBounds(335, 15, 89, 23);
		frame.getContentPane().add(btnSignup);
		
		JLabel lblUserLoggedIn = new JLabel("User logged in:");
		lblUserLoggedIn.setBounds(10, 11, 72, 14);
		frame.getContentPane().add(lblUserLoggedIn);
		
		txtSignedIn = new JTextField();
		String name = txtUsername.getText();
		txtSignedIn.setText(name);
		txtSignedIn.setBackground(SystemColor.activeCaption);
		txtSignedIn.setBounds(90, 8, 86, 20);
		frame.getContentPane().add(txtSignedIn);
		txtSignedIn.setColumns(10);
	}
}
