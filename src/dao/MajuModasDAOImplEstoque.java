package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Estoque;
import model.Grade;


public class MajuModasDAOImplEstoque implements MajuModasDAOEstoque {
	
	private Connection con;
	private String tipoBanco;
	
	public MajuModasDAOImplEstoque() { 
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
	public void adicionar(Estoque estoque) {
		
		try {			
			String sql = "INSERT INTO Estoque " +
					" VALUES ( ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, estoque.getQuantidade() );
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void remover(Estoque estoque) {
		try {			
			String sql = "DELETE FROM Estoque WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, estoque.getId() );
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}






	@Override
	public void alterar(Estoque estoque) {
		
		try {			
			String sql = "UPDATE Estoque SET"
					+ " qtd_Grade = ? "
					+ "WHERE id = ? ";
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, estoque.getQuantidade() );
			stmt.setInt(2, estoque.getId() );
			
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

	@Override
	public List<Estoque> buscarEstoque() {

		List<Estoque> estoque = new ArrayList<>();
		try {
			String sql = 
				"select * from estoque";
			PreparedStatement stmt = con.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Estoque es = new Estoque();
				Grade gra = new Grade();
				es.setId( rs.getInt("id")  );
				gra.setCodigo(rs.getInt("codigo"));
				es.setGrade( gra );
				es.setQuantidade( rs.getInt("qtd_Grade")  );
				
				
				estoque.add(es);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estoque;
		
	}



}
