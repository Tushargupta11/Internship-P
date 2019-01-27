package Main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WayToGoodHealth 
{
	JFrame f;
	JButton btndashboard,btnexercise,btnyoga;
	public WayToGoodHealth() {
		// TODO Auto-generated constructor stub
		f=new JFrame("Way to Good Health");
		f.setContentPane(new JLabel(new ImageIcon("F:\\Eclipse\\projectdata//yoga.jpg")));
		
		btnexercise=new JButton("Exercise",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//fitness.png"));
		btnexercise.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnexercise.setBounds(170, 100, 150, 35);
		
		btnyoga=new JButton("Yoga",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//yoga.png"));
		btnyoga.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnyoga.setBounds(170, 240, 150, 35);
		
		btndashboard=new JButton("Go To DashBoard",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//go to dashboard.png"));
		btndashboard.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btndashboard.setBounds(280, 400, 200, 30);
		f.add(btndashboard);
		f.add(btnexercise);
		f.add(btnyoga);
		btndashboard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new StartSwasth();
				f.dispose();
			}
		});
		btnexercise.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ShowExercise();
				f.dispose();
			}
		});
		btnyoga.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ShowYoga();
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
		new WayToGoodHealth();
	}

}
