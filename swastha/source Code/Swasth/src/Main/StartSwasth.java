package Main;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.net.ssl.HostnameVerifier;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StartSwasth implements ActionListener 
{
	JFrame f;
	JButton b1,b2,b3,b4;
	JLabel label1,label2,label3;
	public StartSwasth() 
	{
		// TODO Auto-generated constructor stub
		
		f=new JFrame();
		b1=new JButton("Check Disease",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//diseases.png"));
		b1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		b1.setBounds(280,40,180,35);
		f.add(b1);
		b2=new JButton("Nearby Hospitals",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//hospital.png"));
		b2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		b2.setBounds(280,180,180,35);
		f.add(b2);
		b3=new JButton("Way to Good Health",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//good health.png"));
		b3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		b3.setBounds(270,340,200,35);
		f.add(b3);
		
		label1=new JLabel();
		label2=new JLabel();
		label3=new JLabel();
		label1.setBounds(10, 140, 240, 130);
		f.add(label1);
		ImageIcon img=new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images//hospital1.jpg");
		Image im=img.getImage();
		Image myImg=im.getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image=new ImageIcon(myImg);
		label1.setIcon(image);
		
		label2.setBounds(10, 280, 240, 130);
		f.add(label2);
		ImageIcon img1=new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images//health.png");
		Image im1=img1.getImage();
		Image myImg1=im1.getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image1=new ImageIcon(myImg1);
		label2.setIcon(image1);
		
		label3.setBounds(10, 5, 240, 130);
		f.add(label3);
		ImageIcon img2=new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images//immune.jpg");
		Image im2=img2.getImage();
		Image myImg2=im2.getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image2=new ImageIcon(myImg2);
		label3.setIcon(image2);
		
//		f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\AMIT-PC\\Desktop\\hospital.jpg")));
		b4=new JButton("Logout",new ImageIcon("F:\\Eclipse\\WorkSpace\\Swasth\\images\\icons//login now.png"));
		b4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		b4.setBounds(170, 420, 150, 35);
		f.add(b4);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		f.setSize(500,500);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			new CheckDisease();
			f.dispose();
		}
		if(e.getSource()==b2)
		{
			new NearbyHospitals();
			f.dispose();
		}
		if(e.getSource()==b3)
		{
			new WayToGoodHealth();
			f.dispose();
		}
		if(e.getSource()==b4)
		{
			new LoginSwasth();
			f.dispose();
		}
	}
	public static void main(String[] args) {
		new StartSwasth();
	}
}
