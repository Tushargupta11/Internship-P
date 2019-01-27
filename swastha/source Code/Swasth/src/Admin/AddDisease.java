package Admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Connection.MyCon;

public class AddDisease {
	JFrame f;
	JButton cfile,btndashboard,btnupload;
	JLabel labelname,labeldescrip,labelbenefit;
	JTextField textname;
	JTextArea textprevention,textcauses;
	int i;
	Connection con=new MyCon().config();

	public AddDisease() {
		// TODO Auto-generated constructor stub
		f=new JFrame("Add New Disease");
		labelname=new JLabel("Name");
		labelname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelname.setBounds(70, 140, 150, 30);
		f.add(labelname);
		textname=new JTextField();
		textname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textname.setBounds(250, 140, 200, 25);
		f.add(textname);
		labeldescrip=new JLabel("Prevention");
		labeldescrip.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labeldescrip.setBounds(70, 190, 150, 30);
		f.add(labeldescrip);
		textprevention=new JTextArea();
		textprevention.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textprevention.setBounds(250, 190, 200, 70);
		f.add(textprevention);
		labelbenefit=new JLabel("Causes");
		labelbenefit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelbenefit.setBounds(70, 280, 150, 30);
		f.add(labelbenefit);
		textcauses=new JTextArea();
		textcauses.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textcauses.setBounds(250, 280, 200, 70);
		f.add(textcauses);
		
		

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
		
		btnupload=new JButton("Add",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//add hospital admin.png"));
		btnupload.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnupload.setBounds(140, 400, 100, 30);
		f.add(btnupload);
		btnupload.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=textname.getText();
				String prevention=textprevention.getText();
				String causes=textcauses.getText();
				PreparedStatement ps;
				String query="insert into disease values(?,?,?)";
				try {
					ps=con.prepareStatement(query);
					ps.setString(1, name);
					ps.setString(2, prevention);
					ps.setString(3, causes);
					i=ps.executeUpdate();
					if(i>0)
					{
						JOptionPane.showMessageDialog(f,"Added Successfully","Alert",JOptionPane.INFORMATION_MESSAGE);
						textname.setText("");
						textprevention.setText("");
						textcauses.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(f,"Error Occurred","Alert",JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		new AddDisease();
	}

}
