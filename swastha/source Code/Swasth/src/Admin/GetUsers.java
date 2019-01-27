package Admin;

import java.awt.Font;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Action.MethodImplement;
import Connection.MyCon;

public class GetUsers {
	JFrame f;
	JLabel labelname,labelusername,labelpassword,labelmobile;
	JTextField textname,textusername,textpassword,textmobile;
	JButton btndashboard,btndeleteuser;
	ResultSet rs;
	String name,password,email,mobile;
	int i=0;

	public GetUsers() {
		// TODO Auto-generated constructor stub
		f=new JFrame("Get Users");
		JScrollPane js=new JScrollPane(null);
		js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		labelname=new JLabel("Name");
		labelname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelname.setBounds(20, 30, 100, 30);
		f.add(labelname);
		labelmobile=new JLabel("Mobile No.");
		labelmobile.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelmobile.setBounds(120, 30, 100, 30);
		f.add(labelmobile);
		labelusername=new JLabel("E-Mail");
		labelusername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelusername.setBounds(250, 30, 100, 30);
		f.add(labelusername);
		labelpassword=new JLabel("Password");
		labelpassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelpassword.setBounds(350, 30, 100, 30);
		f.add(labelpassword);
		
		
		MethodImplement mi=new MethodImplement();
		Connection con=new MyCon().config();
		rs=mi.selectAllUser(con);
		try {
			while(rs.next())
			{
				name=rs.getString(1);
				mobile=rs.getString(2);
				email=rs.getString(3);
				password=rs.getString(4);
				
				textname=new JTextField();
				textusername=new JTextField();
				textmobile=new JTextField();
				textpassword=new JTextField();
				
				
				textname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				textmobile.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				textusername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				textpassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				
				
				textname.setBounds(20, 70+i, 100, 25);
				textmobile.setBounds(130, 70+i, 100, 25);
				textusername.setBounds(240, 70+i, 100, 25);
				textpassword.setBounds(350, 70+i, 100, 25);
				
				f.add(textname);
				f.add(textmobile);
				f.add(textusername);
				f.add(textpassword);
				
				
				textname.setText(name);
				textmobile.setText(mobile);
				textusername.setText(email);
				textpassword.setText(password);
				
				i=i+30;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btndashboard=new JButton("Go To DashBoard",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//go to dashboard.png"));
		btndashboard.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btndashboard.setBounds(280, 400, 200, 30);
		f.add(btndashboard);
		btndashboard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new AdminDashBoard();
				f.dispose();
			}
		});
		
		btndeleteuser=new JButton("Delete User",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//delete user.png"));
		btndeleteuser.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btndeleteuser.setBounds(35, 400, 200, 30);
		f.add(btndeleteuser);
		btndeleteuser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String user=JOptionPane.showInputDialog("Enter Email Id Of User");
				i=mi.deleteUser(user,con);
				if(user!=null)
				{
					if(i>0)
					{
						JOptionPane.showMessageDialog(f, "User Deleted", "Alert", JOptionPane.INFORMATION_MESSAGE);
						new AdminDashBoard();
						f.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(f,"Error Occurred","Alert",JOptionPane.INFORMATION_MESSAGE);
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
	public static void main(String[] args) {
		new GetUsers();
	}

}
