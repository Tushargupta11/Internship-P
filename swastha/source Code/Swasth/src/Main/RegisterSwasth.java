package Main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Action.MethodImplement;
import Beans.RegisterBeans;
import Connection.MyCon;

public class RegisterSwasth 
{
	JFrame f;
	JTextField textemail,textname,textmobile;
	JPasswordField textpassword,textcnfpassword;
	JLabel labelemail,labelpassword,labelregister,labelname,labelmobile,labelcnfpassword;
	JButton btnregister,btnlogin;
	String username,password,name,mobileno,cnfpassword;
	int flagemail=0,flagmobile=0,flag=0,i;
	Connection con;
	MethodImplement mi=new MethodImplement();
	public RegisterSwasth() 
	{
		f=new JFrame("Register");
		f.setContentPane(new JLabel(new ImageIcon("F:\\Eclipse\\projectdata//clinica.jpg")));
		labelregister=new JLabel("Create New User");
		labelregister.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		labelregister.setBounds(155, 50, 200, 30);
		f.add(labelregister);
		labelname=new JLabel("Name                     :-");
		labelname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelname.setBounds(70, 110, 250, 25);
		f.add(labelname);
		textname=new JTextField();
		textname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textname.setBounds(270, 110, 150, 25);
		f.add(textname);
		labelemail=new JLabel("E-Mail                   :-");
		labelemail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelemail.setBounds(70, 150, 250, 25);
		f.add(labelemail);
		textemail=new JTextField();
		textemail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textemail.setBounds(270, 150, 150, 25);
		f.add(textemail);
		labelmobile=new JLabel("Mobile No.            :-");
		labelmobile.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelmobile.setBounds(70, 190, 250, 25);
		f.add(labelmobile);
		textmobile=new JTextField();
		textmobile.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textmobile.setBounds(270, 190, 150, 25);
		f.add(textmobile);
		labelpassword=new JLabel("Password               :-");
		labelpassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelpassword.setBounds(70, 230, 250, 25);
		f.add(labelpassword);
		textpassword=new JPasswordField();
		textpassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textpassword.setBounds(270, 230, 150, 25);
		f.add(textpassword);
		labelcnfpassword=new JLabel("Confirm Password :-");
		labelcnfpassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelcnfpassword.setBounds(70, 270, 250, 25);
		f.add(labelcnfpassword);
		textcnfpassword=new JPasswordField();
		textcnfpassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textcnfpassword.setBounds(270, 270, 150, 25);
		f.add(textcnfpassword);
		btnregister=new JButton("Register Now",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//user.png"));
		btnregister.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnregister.setBounds(70, 350, 180, 30);
		f.add(btnregister);
		btnregister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				name=textname.getText();
				username=textemail.getText();
				password=textpassword.getText();
				cnfpassword=textcnfpassword.getText();
				mobileno=textmobile.getText();
				Pattern p=Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				Matcher m=p.matcher(username);
				while(m.find())
				{
					flagemail=1;
					break;
				}
				if(name.equals(null))
				{
					JOptionPane.showMessageDialog(f,"Name cannot be null");
				}
				else
				{
					if(flagemail==0)
					{
						JOptionPane.showMessageDialog(f,"Enter a valid Email");
					}
					else
					{
						 Pattern p1 = Pattern.compile("(0/91)?[6-9][0-9]{9}");
						 Matcher m1=p1.matcher(mobileno);
						 while(m1.find())
						 {
							 flagmobile=1;
						 }
						 if(flagmobile==0)
						 {
							 JOptionPane.showMessageDialog(f,"Enter a valid Mobile Number");
						 }
						 else
						 {
							 if(password.length()<8)
							 {
								 JOptionPane.showMessageDialog(f,"Minimum 8 Characters Required");
							 }
							 else
							 {
								 if(password.equals(cnfpassword))
								 {
									 flag=1;
								 }
								 else
								 {
									 JOptionPane.showMessageDialog(f,"Password didn't Match");
								 } 
							 }
							
						 }
					}
				}
				if(flag==1)
				{
					con=new MyCon().config();
					RegisterBeans rb=new RegisterBeans();
					rb.setName(name);
					rb.setMobileno(mobileno);
					rb.setUsername(username);
					rb.setPassword(password);
					i=mi.registeruser(rb, con);
					if(i>0)
					{
						JOptionPane.showMessageDialog(f,"Registration Successfull");
						new LoginSwasth();
						f.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(f,"Error Occurred");
					}
					
				}
			}
		});
		btnlogin=new JButton("Login Page",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//login now.png"));
		btnlogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnlogin.setBounds(260, 350, 180, 30);
		f.add(btnlogin);
		btnlogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new LoginSwasth();
				f.dispose();
			}
		});
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setLayout(null);
		f.setVisible(true);
		// TODO Auto-generated constructor stub
	}
	
	

}
