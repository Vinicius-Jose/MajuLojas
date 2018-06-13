package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public Connection getConnection(){
		
		
		String drivers = "org.mariadb.jdbc.Driver";
		drivers = "net.sourceforge.jtds.jdbc.Driver";
		String nomeBanco = "MajuLoja";
		String usuario = "root";
		String senha = "root";
		
		Connection result = null;
		
		try {
			
			Class.forName(drivers);
			result  = DriverManager.getConnection(String.format("jdbc:jtds:sqlserver://localhost:1433;database=%s;user=%s;password=%s;", nomeBanco, usuario, senha));
			
			return result;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	
}