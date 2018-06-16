/**
 * @autor Rodrigo Santos Santiago
 * Classe que implementa a Interface DAO VerificarUsuario
 */
package dao;

import java.sql.Connection;
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

			if (tipoBanco == "mariadb") {
				sql = "select * from usuarios " + "WHERE nome = ? AND "
						+ "senha = MD5(?)";
			} else {
				sql = "select PWDCOMPARE(?, senha) as valido from usuarios "
						+ "WHERE nome = ?";
			}
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, senha);
			stmt.setString(2, usuario);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				existe = true;
			} else {
				existe = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return existe;
	}
	
}
