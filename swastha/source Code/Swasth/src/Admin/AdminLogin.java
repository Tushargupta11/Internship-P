package Admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminLogin {
	JFrame f;
	JTextField textemail;
	JPasswordField textpassword;
	JLabel labelemail,labelpassword,labellogin;
	JButton btnlogin;
	String username,password;
	int i=0;
	
	public AdminLogin() {
		// TODO Auto-generated constructor stub
		f=new JFrame("Login");
		//f.setContentPane(new JLabel(new ImageIcon("D:\\projectdata\\images//admin.jpg")));
		labellogin=new JLabel("Admin Login");
		labellogin.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		labellogin.setBounds(180, 110, 200, 30);
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
		btnlogin=new JButton("Login Now",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//login now.png"));
		btnlogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnlogin.setBounds(160, 300, 150, 30);
		f.add(btnlogin);
		btnlogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				username=textemail.getText();
				password=textpassword.getText();
				if(username.equals("adminuser"))
				{
					if(password.equals("adminpassword"))
					{
						i=1;
					}
				}
				if(i==1)
				{
					JOptionPane.showMessageDialog(f,"Login Successfull");
					new AdminDashBoard();
					f.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Invalid Credentials");
				}
			}
		});
		
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setLayout(null);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new AdminLogin();
	}
}
