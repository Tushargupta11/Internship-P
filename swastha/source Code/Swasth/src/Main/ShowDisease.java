package Main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Connection.MyCon;

public class ShowDisease {
	JFrame f;
	JButton btndashboard,btncheckhospital;
	String name,prevention,causes;
	JLabel lname,lprevention,lcauses;
	JTextArea labelprevention,labelcauses,labelname;
	ResultSet rs=null;
	JScrollPane js1,js2;

	public ShowDisease(String disease) {
		// TODO Auto-generated constructor stub
		f=new JFrame("Diseases");
		
		labelname=new JTextArea();
		labelname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		labelprevention=new JTextArea(40,40);
		labelprevention.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		labelprevention.setEditable(false);
		
		labelcauses=new JTextArea();
		labelcauses.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		labelcauses.setEditable(false);
		
		lname=new JLabel(disease);
		lprevention=new JLabel("Prevention");
		lcauses=new JLabel("Causes");
		
		
		lname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lprevention.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lcauses.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		lname.setBounds(20, 15, 200, 20);
		lprevention.setBounds(20,30,100,20);
		lcauses.setBounds(20, 230, 100, 20);
		
		js1=new JScrollPane(labelcauses);
		js2=new JScrollPane(labelprevention);
		
		js1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		js1.setBounds(30, 250, 450, 180);
		
		
		js2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		js2.setBounds(30, 50, 450, 180);
		
		
		
		
		btndashboard=new JButton("Go To DashBoard",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//go to dashboard.png"));
		btndashboard.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btndashboard.setBounds(280, 430, 200, 30);
		
		btncheckhospital=new JButton("Check Hospital",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//show hospital.png"));
		btncheckhospital.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btncheckhospital.setBounds(50, 430, 200, 30);
		f.add(btncheckhospital);
		f.add(btndashboard);
		
		Connection con=new MyCon().config();
		PreparedStatement ps;
		ResultSet rs=null;
		String query="select * from disease where name=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, disease);
			rs=ps.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while(rs.next())
			{
				String preven,cause;
				preven=rs.getString(2);
				cause=rs.getString(3);
				labelprevention.setText(preven);
				labelcauses.setText(cause);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		btndashboard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new StartSwasth();
				f.dispose();
				
			}
		});
		
		btncheckhospital.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NearbyHospitals();
				
				
			}
		});
		
		
		f.add(js2);
		f.add(js1);
		f.add(lprevention);
		f.add(lcauses);
		f.add(lname);
		
		f.setSize(500,500);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
	

}
