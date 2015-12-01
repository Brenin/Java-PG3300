package db;

import java.sql.*;

public class ConnectToDB implements AutoCloseable {

	private Connection con;
	private String serverName;
	private String databaseName;
	
	public ConnectToDB (String user, String password) throws SQLException {
		
		String sn = getServerName();
		String dbn = getDatabaseName();
		
		try{
			con = DriverManager.getConnection
				("jdbc:mysql://" + sn + "/" + dbn, user, password);
		} catch(SQLException sqlex){
			sqlex.printStackTrace();
		}
	}
	
	public void close() throws SQLException {
		con.close();
	}
	
	public Connection getConnection(){
		return con;
	}
	
	public void setServerName(String serverName){
		this.serverName = serverName;
	}
	
	public String getServerName(){
		return serverName;
	}
	
	public void setDatabaseName(String databaseName){
		this.databaseName = databaseName;
	}
	
	public String getDatabaseName(){
		return databaseName;
	}
	
}
