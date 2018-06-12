package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Fornecedor;


public class MajuModasDAOImplFornecedor implements MajuModasDAOFornecedor {
	
	private Connection con;
	private String tipoBanco;
	
	public MajuModasDAOImplFornecedor() { 
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
	public void adicionar(Fornecedor fornecedor) {
		
		try {			
			String sql = "INSERT INTO Fornecedor " +
					" VALUES ( ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, fornecedor.getId() );
			stmt.setString(2, fornecedor.getNome() );
			stmt.setString(3, fornecedor.getTelefoneFornecedor() );
			
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void remover(Fornecedor fornecedor) {
		
		try {			
			String sql = "DELETE FROM Fornecedor WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, fornecedor.getId() );
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void alterar(Fornecedor fornecedor) {
		
		try {			
			String sql = "UPDATE Fornecedor SET"
					+ " nome = ?,"
					+ "telefone = ? "
					+ "WHERE id = ? ";
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setString(1, fornecedor.getNome() );
			stmt.setString(2, fornecedor.getTelefoneFornecedor() );
			stmt.setInt(3, fornecedor.getId());
			
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public List<Fornecedor> buscarFornecedor() {

		List<Fornecedor> fornecedor = new ArrayList<>();
		try {
			String sql = 
				"select * from fornecedor";
			PreparedStatement stmt = con.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Fornecedor a = new Fornecedor();
				a.setId( rs.getInt("id")  );
				a.setNome( rs.getString("nome")  );
				a.setTelefoneFornecedor( rs.getString("telefone")  );
				
				fornecedor.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fornecedor;
		
	}



}
