package Action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.AddHospitalsBeans;
import Beans.RegisterBeans;
import Connection.MyCon;

public class MethodImplement 
{
	PreparedStatement ps;
	ResultSet rs;
	String query;
	int i;
	Connection con=new MyCon().config();
	public int registeruser(RegisterBeans rb,Connection con)
	{
		query="insert into user values(?,?,?,?)";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, rb.getName());
			ps.setString(2, rb.getMobileno());
			ps.setString(3, rb.getUsername());
			ps.setString(4, rb.getPassword());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public ResultSet loginuser(Connection con)
	{
		query="select email ,password from user";
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet selectAllUser(Connection con)
	{
		query="select * from user";
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public int addHospitals(AddHospitalsBeans ah,Connection con)
	{
		query="insert into hospitals values(?,?,?,?,?)";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, ah.getCity());
			ps.setString(2, ah.getDoctorname());
			ps.setString(3, ah.getDoctortype());
			ps.setString(4, ah.getHospitalname());
			ps.setString(5, ah.getContact());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public ResultSet returnCity(Connection con)
	{
		query="select DISTINCT city from hospitals ";
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet returnHospitals(String city,Connection con)
	{
		query="select * from hospitals where city=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, city);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	public ResultSet returnHos(Connection con)
	{
		query="select * from hospitals ";
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	public int deleteUser(String user,Connection con)
	{
		query="delete from user where email=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, user);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	public int deleteHospital(String hospitalname,String hospitalcity,Connection con)
	{
		query="delete from hospitals where city=? and hospitalname=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, hospitalcity);
			ps.setString(2, hospitalname);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	public int updatePassword(String id,String newpass, Connection con)
	{
		query="update user set password=? where email=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(2, id);
			ps.setString(1, newpass);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public int deleteYoga(String name,Connection con)
	{
		query="delete from yoga where name=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, name);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	public int deleteExercise(String name,Connection con)
	{
		query="delete from exercise where name=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, name);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
}
