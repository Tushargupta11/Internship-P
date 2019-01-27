package Admin;

import java.awt.BorderLayout;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Action.MethodImplement;
import Beans.AddHospitalsBeans;
import Connection.MyCon;

public class AddHospitals {
	JFrame f,frame1;
	JButton btndashboard;
	JLabel labelcity,labeldoctorname,labelhospitalname,labeldoctortpye,labelcontact;
	JTextField textcity,textdoctorname,textdoctortype,texthospitalname,textcontact;
	JButton btnaddhospitals,btnshowhospitals,btndeletehospitals;
	JTable table;
	Connection con=new MyCon().config();
	MethodImplement mi=new MethodImplement();
	AddHospitalsBeans ah=new AddHospitalsBeans();
	ResultSet rs;
	int i;

	public AddHospitals() {
		// TODO Auto-generated constructor stub
		f=new JFrame("Add Hospitals");
		btndashboard=new JButton("Go To DashBoard",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//go to dashboard.png"));
		btndashboard.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btndashboard.setBounds(160, 435, 200, 30);
		f.add(btndashboard);
		btndashboard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new AdminDashBoard();
				f.dispose();
			}
		});
		labelcity=new JLabel("City");
		labeldoctorname=new JLabel("Doctor Name");
		labelhospitalname=new JLabel("Hospital Name");
		labeldoctortpye=new JLabel("Doctor Specilality");
		labelcontact=new JLabel("Contact");
		
		labelcity.setFont(new Font("TImes New Roman", Font.PLAIN, 20));
		labeldoctorname.setFont(new Font("TImes New Roman", Font.PLAIN, 20));
		labeldoctortpye.setFont(new Font("TImes New Roman", Font.PLAIN, 20));
		labelcontact.setFont(new Font("TImes New Roman", Font.PLAIN, 20));
		labelhospitalname.setFont(new Font("TImes New Roman", Font.PLAIN, 20));
		
		labelcity.setBounds(70, 90, 150, 30);
		labeldoctorname.setBounds(70, 130, 150, 30);
		labelhospitalname.setBounds(70, 170, 150, 30);
		labelcontact.setBounds(70, 210, 150, 30);
		labeldoctortpye.setBounds(70, 250, 150, 30);
		
		f.add(labelcity);
		f.add(labeldoctorname);
		f.add(labelhospitalname);
		f.add(labelcontact);
		f.add(labeldoctortpye);
		
		textcity=new JTextField();
		textdoctorname=new JTextField();
		textdoctortype=new JTextField();
		textcontact=new JTextField();
		texthospitalname=new JTextField();
		
		textcity.setFont(new Font("TImes New Roman", Font.PLAIN, 20));
		textdoctorname.setFont(new Font("TImes New Roman", Font.PLAIN, 20));
		textdoctortype.setFont(new Font("TImes New Roman", Font.PLAIN, 20));
		textcontact.setFont(new Font("TImes New Roman", Font.PLAIN, 20));
		texthospitalname.setFont(new Font("TImes New Roman", Font.PLAIN, 20));
		
		textcity.setBounds(250, 90, 150, 25);
		textdoctorname.setBounds(250, 130, 150, 25);
		texthospitalname.setBounds(250, 170, 150, 25);
		textcontact.setBounds(250, 210, 150, 25);
		textdoctortype.setBounds(250, 250, 150, 25);
		
		f.add(textcity);
		f.add(textdoctorname);
		f.add(textdoctortype);
		f.add(texthospitalname);
		f.add(textcontact);
		
		btnaddhospitals=new JButton("Add Hospital",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//add hospitals.png"));
		btnaddhospitals.setFont(new Font("TImes New Roman", Font.PLAIN, 18));
		btnaddhospitals.setBounds(170, 300, 170, 30);
		f.add(btnaddhospitals);
		
		btnaddhospitals.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ah.setCity(textcity.getText());
				ah.setDoctorname(textdoctorname.getText());
				ah.setDoctortype(textdoctortype.getText());
				ah.setHospitalname(texthospitalname.getText());
				ah.setContact(textcontact.getText());
				i=mi.addHospitals(ah, con);
				if(i>0)
				{
					JOptionPane.showMessageDialog(f,"Added Successfully");
					textcity.setText("");
					textdoctorname.setText("");
					textdoctortype.setText("");
					textcontact.setText("");
					texthospitalname.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Error Occurred");
				}
			}
		});
		
		btnshowhospitals=new JButton("Show Hospitals",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//show hospital.png"));
		btnshowhospitals.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnshowhospitals.setBounds(50, 400, 180, 30);
		f.add(btnshowhospitals);
		btnshowhospitals.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame1 = new JFrame("Database Search Result");
				frame1.setLayout(new BorderLayout());
				DefaultTableModel model = new DefaultTableModel();
				String column[]= {"City","Doctor Name","Category","Hospital Name","Contact"};
				model.setColumnIdentifiers(column);
				table = new JTable();
				table.setModel(model); 
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				table.setFillsViewportHeight(true);
				JScrollPane scroll = new JScrollPane(table);
				scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
				String datacity= "";
				String docname= "";
				String doccategory= "";
				String hosname= "";
				String contact="";
				rs=mi.returnHos(con);
				try {
					while(rs.next())
					{
						datacity=rs.getString(1);
						docname=rs.getString(2);
						doccategory=rs.getString(3);
						hosname=rs.getString(4);
						contact=rs.getString(5);
						model.addRow(new Object[] {datacity,docname,doccategory,hosname,contact});
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame1.add(scroll);
				frame1.setVisible(true);
				frame1.setLocationRelativeTo(f);
				frame1.setSize(500,300);
			}
		});
		btndeletehospitals=new JButton("Delete Hospitals",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//add hospital admin.png"));
		btndeletehospitals.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btndeletehospitals.setBounds(280, 400, 200, 30);
		f.add(btndeletehospitals);
		btndeletehospitals.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String hospitalname=JOptionPane.showInputDialog("Enter Hospital Name...");
				if(hospitalname!=null)
				{
					String hospitalcity=JOptionPane.showInputDialog("Enter Hospital City");
					i=mi.deleteHospital(hospitalname,hospitalcity,con);
					if(i>0)
					{
						JOptionPane.showMessageDialog(f, "Hospital Deleted", "Alert", JOptionPane.INFORMATION_MESSAGE);
						new AdminDashBoard();
						f.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(f, "Error Occurred", "Alert", JOptionPane.INFORMATION_MESSAGE);
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
		new AddHospitals();
	}

}
