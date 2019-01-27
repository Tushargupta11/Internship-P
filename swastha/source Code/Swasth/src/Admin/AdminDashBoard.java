package Admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import Action.MethodImplement;
import Connection.MyCon;
import Main.LoginSwasth;

public class AdminDashBoard {
	JFrame f;
	JButton btnaddyogamoves,btnaddhospitals,btngetusers,btnlogout,btnadddisease;

	public AdminDashBoard() {
		// TODO Auto-generated constructor stub
		f=new JFrame("Admin DashBoard");
		btngetusers=new JButton("Get All Users",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//all user.png"));
		btnaddyogamoves=new JButton("Add Fitness Moves",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//fitness.png"));
		btnaddhospitals=new JButton("Add Hospitals",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//add hospital admin.png"));
		btnadddisease=new JButton("Add Disease",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//diseases.png"));
		
		btngetusers.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnaddyogamoves.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnaddhospitals.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnadddisease.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		btngetusers.setBounds(160,120,200,35);
		btnaddhospitals.setBounds(160,190,200,35);
		btnaddyogamoves.setBounds(160,260,200,35);
		btnadddisease.setBounds(160,330,200,35);
		
		btnlogout=new JButton("Logout",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//login now.png"));
		btnlogout.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnlogout.setBounds(330, 400, 150, 35);
		f.add(btnlogout);
		
		f.add(btngetusers);
		f.add(btnaddyogamoves);
		f.add(btnaddhospitals);
		f.add(btnadddisease);
		btnlogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new LoginSwasth();
				f.dispose();
				
			}
		});
		btngetusers.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GetUsers();
				f.dispose();	
			}
		});
		btnaddhospitals.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddHospitals();
				f.dispose();
			}
		});
		btnaddyogamoves.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddYogaMoves();
				f.dispose();
			}
		});
		btnadddisease.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new AddDisease();
				f.dispose();
				
			}
		});
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setLayout(null);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new AdminDashBoard();
	}
}
