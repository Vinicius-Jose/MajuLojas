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
		con = new Conexao().getConnection();
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
