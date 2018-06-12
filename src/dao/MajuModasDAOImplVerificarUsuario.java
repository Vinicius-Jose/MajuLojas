package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MajuModasDAOImplVerificarUsuario implements MajuModasDAOVerificarUsuario{
	
	private Connection con;
	private String tipoBanco;
	
	public MajuModasDAOImplVerificarUsuario() { 
		try {
			tipoBanco = "mariadb";
			String drivers = "org.mariadb.jdbc.Driver";
			String porta = "3306";
			String nomeBanco = "MajuModas";
			String usuario = "root";
			String senha = "";
			
			Class.forName(drivers);
			String urlDb = "jdbc:"+ tipoBanco +"//localhost:"+ porta +"/"+ nomeBanco +"?allowMultiQueries=true";
			con = DriverManager.getConnection(urlDb, usuario , senha);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public boolean verificarUsuario(String usuario, String senha) {
		boolean existe = false;
		String sql;
		
		try {
			
			if( tipoBanco == "mariadb"){
				sql =  "select * from usuario "
							+ "WHERE nome = ? AND "
							+ "senha = MD5(?)";
			}else{
				sql =  "select * from usuario "
						+ "WHERE nome = ? AND "
						+ "senha = PWDCOMPARE(?)";	
			}
			PreparedStatement stmt = con.prepareStatement( sql );
			stmt.setString(1, usuario);
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.isFirst()){
				existe = true;
			}else{
				existe = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return existe;
	}
	

}
