package Budjetting_Sys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

public class CreateProfile {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JTextField txtRepeatPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateProfile window = new CreateProfile();
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
	public CreateProfile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSignup = new JLabel("Signup");
		lblSignup.setFont(new Font("SimSun-ExtB", Font.PLAIN, 11));
		lblSignup.setBounds(200, 11, 46, 14);
		frame.getContentPane().add(lblSignup);
		
		JLabel lblNewLabel = new JLabel("Created By Marius Magnussen");
		lblNewLabel.setFont(new Font("SimSun-ExtB", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 236, 180, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(42, 105, 67, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(42, 130, 69, 14);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(160, 102, 86, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(160, 128, 86, 20);
		frame.getContentPane().add(txtPassword);
		
		txtRepeatPass = new JTextField();
		txtRepeatPass.setBounds(160, 156, 86, 20);
		frame.getContentPane().add(txtRepeatPass);
		txtRepeatPass.setColumns(10);
		
		JLabel lblRepeatPass = new JLabel("Repeat Password:");
		lblRepeatPass.setBounds(42, 159, 88, 14);
		frame.getContentPane().add(lblRepeatPass);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(42, 92, 203, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(42, 184, 203, 2);
		frame.getContentPane().add(separator_1);
	}

}
