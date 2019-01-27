package Admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.omg.CORBA.portable.InputStream;

import Connection.MyCon;

public class AddExercise {
	JFrame f;
	JButton cfile,btndashboard,btnupload;
	JLabel labelname,labeldescrip,labelbenefit;
	JTextField textname;
	JTextArea textdescrip,textbenefit;
	File selectedfile;
	String path;
	int i;
	
	public AddExercise() {
		// TODO Auto-generated constructor stub
		f=new JFrame("Add New Exercise ");
		cfile=new JButton("Choose Image",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//choose image.png"));
		cfile.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cfile.setBounds(80, 30, 180, 30);
		f.add(cfile);
		labelname=new JLabel("Name");
		labelname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelname.setBounds(70, 140, 150, 30);
		f.add(labelname);
		textname=new JTextField();
		textname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textname.setBounds(250, 140, 200, 25);
		f.add(textname);
		labeldescrip=new JLabel("Description");
		labeldescrip.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labeldescrip.setBounds(70, 190, 150, 30);
		f.add(labeldescrip);
		textdescrip=new JTextArea();
		textdescrip.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textdescrip.setBounds(250, 190, 200, 70);
		f.add(textdescrip);
		labelbenefit=new JLabel("Benefits");
		labelbenefit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelbenefit.setBounds(70, 280, 150, 30);
		f.add(labelbenefit);
		textbenefit=new JTextArea();
		textbenefit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textbenefit.setBounds(250, 280, 200, 70);
		f.add(textbenefit);
		
		btnupload=new JButton("Add",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//add hospital admin.png"));
		btnupload.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnupload.setBounds(140, 400, 100, 30);
		f.add(btnupload);
		
		btndashboard=new JButton("Go To DashBoard",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//go to dashboard.png"));
		btndashboard.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btndashboard.setBounds(280, 400, 200, 30);
		f.add(btndashboard);
		btndashboard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new AddYogaMoves();
				f.dispose();
				
			}
		});
		cfile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				   JFileChooser file = new JFileChooser();
				   file.setCurrentDirectory(new File(System.getProperty("user.home")));
			       FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
			          file.addChoosableFileFilter(filter);
			          int result = file.showSaveDialog(null);
			          if(result == JFileChooser.APPROVE_OPTION)
			          {
			              selectedfile = file.getSelectedFile();
			              path = selectedfile.getAbsolutePath();
			          }
			          
			}
		});
		btnupload.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=textname.getText();
				String description=textdescrip.getText();
				String benefits=textbenefit.getText();
				
				File imgfile= new File(path);
				try {
					FileInputStream fin=new FileInputStream(imgfile);
					Connection con=new MyCon().config();
					PreparedStatement ps;
					String query="insert into exercise values(?,?,?,?)";
					ps=con.prepareStatement(query);
					ps.setString(1, name);
					ps.setBinaryStream(2,fin,(int)imgfile.length());
					ps.setString(3, description);
					ps.setString(4, benefits);
					i=ps.executeUpdate();
					if(i>0)
					{
						JOptionPane.showMessageDialog(f,"Added Successfull","Alert", JOptionPane.INFORMATION_MESSAGE);
						textname.setText("");
						textdescrip.setText("");
						textbenefit.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(f,"Error Occurred","Alert", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		new AddExercise();
	}

}
