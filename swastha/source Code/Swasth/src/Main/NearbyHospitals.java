package Main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Action.MethodImplement;
import Connection.MyCon;

public class NearbyHospitals 
{
	JFrame f,frame1;
	JButton btndashboard,btnshowhospitals;
	JComboBox combo;
	ResultSet rs,rs1;
	JTable table;
	int i=0;
	String city;
	
	
	
	public NearbyHospitals() {
		// TODO Auto-generated constructor stub
		f=new JFrame("Nearby Hospitals");
		f.setContentPane(new JLabel(new ImageIcon("F:\\Eclipse\\projectdata//clinica.jpg")));
		btndashboard=new JButton("Go To DashBoard",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//go to dashboard.png"));
		btndashboard.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btndashboard.setBounds(280, 400, 200, 30);
		f.add(btndashboard);
		btnshowhospitals=new JButton("Show Hospitals",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//show hospital.png"));
		btnshowhospitals.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnshowhospitals.setBounds(210, 50, 180, 30);
		f.add(btnshowhospitals);
		MethodImplement mi=new MethodImplement();
		Connection con=new MyCon().config();
		int count=0;
		rs=mi.returnCity(con);
		try {
			
			while(rs.next())
			{
				count++;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String cityname[]=new String[count];
		rs=mi.returnCity(con);
		try {
			
			while(rs.next())
			{
				cityname[i]=rs.getString(1);
				i=i+1;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		combo=new JComboBox<>(cityname);
		combo.setBounds(50, 50,100,30);
		f.add(combo);
		btnshowhospitals.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
				city=(String) combo.getSelectedItem();
				rs1=mi.returnHospitals(city, con);
				try {
					while(rs1.next())
					{
						datacity=rs1.getString(1);
						docname=rs1.getString(2);
						doccategory=rs1.getString(3);
						hosname=rs1.getString(4);
						contact=rs1.getString(5);
						model.addRow(new Object[] {datacity,docname,doccategory,hosname,contact});
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame1.add(scroll);
				frame1.setVisible(true);
				frame1.setLocationRelativeTo(null);
				frame1.setSize(500,300);
				

			}
		});
		
		
			btndashboard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new StartSwasth();
				f.dispose();
			}
		});
		f.setSize(500,500);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new NearbyHospitals();
	}
	
}
