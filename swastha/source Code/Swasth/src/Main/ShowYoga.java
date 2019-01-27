package Main;

import java.awt.Font;
import java.awt.Image;
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

public class ShowYoga {
	JFrame f;
	JButton btndashboard,btnnext;;
	String name,desc,benefits;
	byte[] img;
	JLabel labelimage,lname,ldesc,lbeneifts;
	JTextArea labeldesc,labelbenefits,labelname;
	ResultSet rs=null;
	JScrollPane js1,js2;

	public ShowYoga() {
		// TODO Auto-generated constructor stub
		f=new JFrame("Yoga");
		
		labelimage=new JLabel();
		labelimage.setBounds(250, 10, 150, 150);
		f.add(labelimage);
		
		labelname=new JTextArea();
		labelname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		labeldesc=new JTextArea(40,40);
		labeldesc.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		labeldesc.setEditable(false);
		
		labelbenefits=new JTextArea();
		labelbenefits.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		labelbenefits.setEditable(false);
		
		lname=new JLabel();
		ldesc=new JLabel("Description");
		lbeneifts=new JLabel("Benefits");
		
		
		lname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ldesc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbeneifts.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		lname.setBounds(20, 30, 200, 20);
		ldesc.setBounds(20,150,100,20);
		lbeneifts.setBounds(20, 283, 100, 20);
		
		js1=new JScrollPane(labelbenefits);
		js2=new JScrollPane(labeldesc);
		
		js1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		js1.setBounds(30, 300, 450, 120);
		
		
		js2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		js2.setBounds(30, 170, 450, 115);
		
		
		
		
		btndashboard=new JButton("Go To DashBoard",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//go to dashboard.png"));
		btndashboard.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btndashboard.setBounds(260, 420, 200, 30);
		f.add(btndashboard);
		
		btnnext=new JButton("Next",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//add icon.png"));
		btnnext.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnnext.setBounds(60, 420, 100, 30);
		f.add(btnnext);

		f.add(js2);
		f.add(js1);
		f.add(lbeneifts);
		f.add(ldesc);
		f.add(lname);
		
		Connection con=new MyCon().config();
		String query="select * from yoga";
		
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if(rs.next())
			{
				name=rs.getString(1);
				img=rs.getBytes(2);
				ImageIcon image=new ImageIcon(img);
				Image im=image.getImage();
				Image myImg=im.getScaledInstance(labelimage.getWidth(),labelimage.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newImg=new ImageIcon(myImg);
				labelimage.setIcon(newImg);
				benefits=rs.getString(4);
				desc=rs.getString(3);
				//System.out.println(desc);
				labelbenefits.setText(benefits);
				labeldesc.setText(desc);
				lname.setText(name);
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
		
		btnnext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					if(rs.next())
					{
						name=rs.getString(1);
						img=rs.getBytes(2);
						ImageIcon image=new ImageIcon(img);
						Image im=image.getImage();
						Image myImg=im.getScaledInstance(labelimage.getWidth(),labelimage.getWidth(), Image.SCALE_SMOOTH);
						ImageIcon newImg=new ImageIcon(myImg);
						benefits=rs.getString(4);
						desc=rs.getString(3);
						labelimage.setIcon(newImg);
						labelbenefits.setText(benefits);
						labeldesc.setText(desc);
						lname.setText(name);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		f.setSize(500,500);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
		new ShowYoga();
	}

}
