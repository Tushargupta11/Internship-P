package Admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Action.MethodImplement;
import Connection.MyCon;
import Main.ShowYoga;

public class AddYogaMoves {
	JFrame f;
	JButton btndashboard,btnyoga,btnexercise,btndeleteyoga,btndeleteexercise,btnshowyoga,btnshowexercise;

	public AddYogaMoves() {
		// TODO Auto-generated constructor stub
		f=new JFrame("Add Yoga Moves");
		btndashboard=new JButton("Go To DashBoard",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//go to dashboard.png"));
		btndashboard.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		btnyoga=new JButton("Add Yoga",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//add hospital admin.png"));
		btnyoga.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnyoga.setBounds(20, 200, 145, 30);
		
		btndeleteyoga=new JButton("Delete Yoga",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//choose image.png"));
		btndeleteyoga.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btndeleteyoga.setBounds(170,200,150,30);
		
		btnexercise=new JButton("Add Exercise",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//fitness.png"));
		btnexercise.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnexercise.setBounds(20, 300, 145, 30);
		
		btndeleteexercise=new JButton("Delete Exercise",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//good health.png"));
		btndeleteexercise.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btndeleteexercise.setBounds(170, 300, 150, 30);
		
		btnshowyoga=new JButton("Show Yoga",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//yoga.png"));
		btnshowyoga.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnshowyoga.setBounds(330,200,150,30);
		
		btnshowexercise=new JButton("Show Exercise",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//show hospitals admin.png"));
		btnshowexercise.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnshowexercise.setBounds(330,300,150,30);
		
		btndashboard.setBounds(280, 400, 200, 30);
		f.add(btndashboard);
		f.add(btnexercise);
		f.add(btnyoga);
		f.add(btndeleteyoga);
		f.add(btndeleteexercise);
		f.add(btnshowexercise);
		f.add(btnshowyoga);
		btndashboard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new AdminDashBoard();
				f.dispose();
				
			}
		});
		btnyoga.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddYoga();
				f.dispose();
			}
		});
		btnexercise.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new AddExercise();
				f.dispose();
				
			}
		});
		btndeleteyoga.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String name=JOptionPane.showInputDialog("Enter the name of Yoga");
				if(name!=null)
				{
					Connection con=new MyCon().config();
					MethodImplement mi=new MethodImplement();
					int i=mi.deleteYoga(name,con);
					if(i>0)
						{
						JOptionPane.showMessageDialog(f, "Deleted", "Alert", JOptionPane.INFORMATION_MESSAGE);
						}
					else
					{
						JOptionPane.showMessageDialog(f, "Error Occurred", "Alert", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btndeleteexercise.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=JOptionPane.showInputDialog("Enter the name of Exercise");
				if(name!=null)
				{
					Connection con=new MyCon().config();
					MethodImplement mi=new MethodImplement();
					int i=mi.deleteExercise(name,con);
					if(i>0)
						{
						JOptionPane.showMessageDialog(f, "Deleted", "Alert", JOptionPane.INFORMATION_MESSAGE);
						}
					else
					{
						JOptionPane.showMessageDialog(f, "Error Occurred", "Alert", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnshowyoga.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminShowYoga();
				f.dispose();
			}
		});
		btnshowexercise.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminShowExercise();
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
		new AddYogaMoves();
	}

}
