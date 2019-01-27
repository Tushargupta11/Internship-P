package Main;
import java.awt.Font;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Action.MethodImplement;
import Admin.AdminLogin;
import Connection.MyCon;

public class LoginSwasth 
{
	JFrame f;
	JTextField textemail;
	JPasswordField textpassword;
	JLabel labelemail,labelpassword,label,label2,labellogin,labelor;
	JButton btnlogin,btnregister,btnadmin,btnforgotpassword;
	String username,password,user,pass;
	Connection con;
	ResultSet rs;
	int flag=0;
	MethodImplement mi=new MethodImplement();
	public LoginSwasth() 
	{
		// TODO Auto-generated constructor stub
		f=new JFrame("Login");
		label=new JLabel("Welcome to Swasth");
		f.setContentPane(new JLabel(new ImageIcon("F:\\Eclipse\\projectdata//clinica.jpg")));
		label.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 30));
		label.setBounds(120, 30, 300, 50);
		f.add(label);
		label2=new JLabel("-way to good health");
		label2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label2.setBounds(300, 70, 200, 30);
		f.add(label2);
		labellogin=new JLabel("LOGIN");
		labellogin.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		labellogin.setBounds(200, 110, 200, 30);
		f.add(labellogin);
		labelemail=new JLabel("Username :-");
		labelemail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelemail.setBounds(70, 190, 150, 30);
		f.add(labelemail);
		textemail=new JTextField();
		textemail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textemail.setBounds(250, 190, 150, 25);
		f.add(textemail);
		labelpassword=new JLabel("Password :-");
		labelpassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelpassword.setBounds(70, 240, 150, 30);
		f.add(labelpassword);
		textpassword=new JPasswordField();
		textpassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textpassword.setBounds(250, 240, 150, 25);
		f.add(textpassword);
		btnlogin=new JButton("User Login",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//login now.png"));
		btnlogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnlogin.setBounds(50, 300, 170, 30);
		f.add(btnlogin);
		btnregister=new JButton("Register",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//user.png"));
		btnregister.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnregister.setBounds(260, 300, 170, 30);
		f.add(btnregister);
		btnadmin=new JButton("Admin Login",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//username admin.png"));
		btnadmin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnadmin.setBounds(50, 380, 170, 30);
		f.add(btnadmin);
		btnforgotpassword=new JButton("Forgot Pass",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//change password.png"));
		btnforgotpassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnforgotpassword.setBounds(260, 380, 170, 30);
		f.add(btnforgotpassword);
		btnadmin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminLogin();
				f.dispose();
			}
		});
		btnlogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				username=textemail.getText();
				password=textpassword.getText();
				con=new MyCon().config();
				rs=mi.loginuser(con);
				try {
					while(rs.next())
					{
						user=rs.getString(1);
						pass=rs.getString(2);
						if(user.equals(username))
						{
							if(pass.equals(password))
							{
								flag=1;
								break;
							}
						}
					}
					if(flag==1)
					{
						JOptionPane.showMessageDialog(f,"Login Successfull");
						new StartSwasth();
						f.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(f,"Invalid Credentials");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnregister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new RegisterSwasth();
				f.dispose();
			}
		});
		btnforgotpassword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Connection con=new MyCon().config();
				String id=JOptionPane.showInputDialog("Enter Email id of user");
				if(id!=null)
				{
					String newpass=JOptionPane.showInputDialog("Enter New Password");
					if(newpass.length()<8)
					{
						JOptionPane.showMessageDialog(f, "Minimum 8 Character Required", "Alert", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						int j=mi.updatePassword(id, newpass, con);
						if(j>0)
						{
							JOptionPane.showMessageDialog(f, "Updated", "Alert", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(f, "Error Occurred or Invalid Email", "Alert", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new LoginSwasth();
	}

}
