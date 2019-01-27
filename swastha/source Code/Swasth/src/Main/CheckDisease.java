 package Main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Action.MethodImplement;
import Connection.MyCon;

public class CheckDisease 
{
	JFrame f;
	JButton btndashboard,btncheckdisease;
	JCheckBox check1,check2,check3,check4,check5,check6,check7,check8,check9,check10,check11;
	String disease;
	
	public CheckDisease() 
	{
		// TODO Auto-generated constructor stub
		f=new JFrame("Check Disease");
		f.setContentPane(new JLabel(new ImageIcon("F:\\Eclipse\\projectdata//diseases.jpg")));
		btndashboard=new JButton("Go To DashBoard",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//go to dashboard.png"));
		btndashboard.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btndashboard.setBounds(280, 430, 200, 30);
		f.add(btndashboard);
		btndashboard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new StartSwasth();
				f.dispose();
			}
		});
		check1=new JCheckBox();
		check2=new JCheckBox();
		check3=new JCheckBox();
		check4=new JCheckBox();
		check5=new JCheckBox();
		check6=new JCheckBox();
		check7=new JCheckBox();
		check8=new JCheckBox();
		check9=new JCheckBox();
		check10=new JCheckBox();
		check11=new JCheckBox();
		
		check1.setText("Shortness in Breath");
		check2.setText("Fast HeartBeat");
		check3.setText("High Fever");
		check4.setText("Headache");
		check5.setText("Vomitting");
		check6.setText("Coughing and Sneezing");
		check7.setText("Constipation");
		check8.setText("Acidity");
		check9.setText("Body Ache");
		check10.setText("Eye Pain");
		check11.setText("Abdominal Pain");
		
		check1.setBounds(80, 20, 180, 20);
		check2.setBounds(80, 60, 180, 20);
		check3.setBounds(80, 100, 180, 20);
		check4.setBounds(80, 140, 180, 20);
		check5.setBounds(80, 180, 180, 20);
		check6.setBounds(80, 220, 180, 20);
		check7.setBounds(280, 20, 180, 20);
		check8.setBounds(280, 60, 180, 20);
		check9.setBounds(280, 100, 180, 20);
		check10.setBounds(280, 140, 180, 20);
		check11.setBounds(280, 180, 180, 20);
		
		f.add(check1);
		f.add(check2);
		f.add(check3);
		f.add(check4);
		f.add(check5);
		f.add(check6);
		f.add(check7);
		f.add(check8);
		f.add(check9);
		f.add(check10);
		f.add(check11);
		
		btncheckdisease=new JButton("Check Disease");
		btncheckdisease.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btncheckdisease.setBounds(50, 430, 150, 30);
		f.add(btncheckdisease);
		btncheckdisease.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int count=0;
				if(check1.isSelected())
				{
					count++;
				}
				if(check2.isSelected())
				{
					count++;
				}
				if(check3.isSelected())
				{
					count++;
				}
				if(check4.isSelected())
				{
					count++;
				}
				if(check5.isSelected())
				{
					count++;
				}
				if(check6.isSelected())
				{
					count++;
				}
				if(check7.isSelected())
				{
					count++;
				}
				if(check8.isSelected())
				{
					count++;
				}
				if(check9.isSelected())
				{
					count++;
				}
				if(check10.isSelected())
				{
					count++;
				}
				if(count<3 || count>5)
				{
					JOptionPane.showMessageDialog(f, "Minimum 3 or Maximum 5 Symptoms Required", "Alert", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Connection con=new MyCon().config();
					MethodImplement mi=new MethodImplement();
					if(check1.isSelected() && check2.isSelected() && check8.isSelected())
					{
						JOptionPane.showMessageDialog(f,"Heart Diseaes");
						disease="HEART DISEASES";
					}
					else if(check4.isSelected() && check5.isSelected() && check1.isSelected())
					{
						JOptionPane.showMessageDialog(f,"BP");
						disease="BLOOD PRESSURE";
					}
					else if(check4.isSelected() && check6.isSelected() && check9.isSelected())
					{
						JOptionPane.showMessageDialog(f,"Common COld");
						disease="COMMON COLD";
					}
					else if(check4.isSelected() && check3.isSelected() && check11.isSelected() && check7.isSelected())
					{
						JOptionPane.showMessageDialog(f,"Typhoid");
						disease="Typhoid";
					}
					else if(check11.isSelected() && check8.isSelected() && check1.isSelected() && check5.isSelected())
					{
						JOptionPane.showMessageDialog(f,"Digestion Disorder");
						disease="DIGESTIVE DISORDERS";
					}
					else if(check3.isSelected() && check4.isSelected() && check5.isSelected() && check9.isSelected() && check10.isSelected())
					{
						JOptionPane.showMessageDialog(f,"Dengue malaria chickengunia ");
						disease="DENGUE/MALARIA/CHIKUNGUNYA";
					}
					else if(check5.isSelected() && check4.isSelected() && check10.isSelected())
					{
						JOptionPane.showMessageDialog(f,"Malaria");
						disease="MALARIA";
					}
					else
					{
						JOptionPane.showMessageDialog(f,"Common Disorder");
						disease="Common Disorder";
					}
					new ShowDisease(disease);
					f.dispose();
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
		new CheckDisease();
	}
}
