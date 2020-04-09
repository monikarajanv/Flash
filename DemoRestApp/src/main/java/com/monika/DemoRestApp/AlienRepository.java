package com.monika.DemoRestApp;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository
{
	Connection con = null;
	public AlienRepository() throws SQLException, ClassNotFoundException
	{
		String url = "jdbc:mysql://localhost:3306/anika";
		String username = "root";
		String password= "starplus";
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection(url, username, password);
		
	}

public List<ALien> getAliens() throws Exception
{
	List<ALien> aliens = new ArrayList<>();
	String sql = "select * from alien";
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(sql);
	while(rs.next())
	{
		ALien a = new ALien();
		a.setId(rs.getInt(1));
		a.setName(rs.getString(2));
		a.setPoints(rs.getInt(3));
		aliens.add(a); //we add the values into a list
	}
	return null;
}

public void create(ALien a1) throws Exception
{   String sql="insert into alien values(?,?,?)";
	PreparedStatement st = con.prepareStatement(sql);
	st.setInt(1, a1.getId());
	st.setString(2, a1.getName());
	st.setInt(3, a1.getPoints());
	 st.executeUpdate();
	
}
}