package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Capital;


public class MajuModasDAOImplCapital implements MajuModasDAOCapital {
	
	private Connection con;
	private String tipoBanco;
	
	public MajuModasDAOImplCapital() { 
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
	public void adicionar(Capital capital) {

		
		try {			
			String sql = "INSERT INTO Capital " +
					" VALUES ( ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, capital.getCodigo());
			stmt.setDate(2, capital.getMesAno() );
			stmt.setDouble(3, capital.getValorCapital() );
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	@Override
	public void remover(Capital capital) {
		try {			
			String sql = "DELETE FROM Capital WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, capital.getCodigo() );
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	@Override
	public void alterar(Capital capital) {
		
		try {			
			String sql = "UPDATE Capital SET"
					+ " data = ?, "
					+ " valor_Capital = ?"
					+ "WHERE codigo = ? ";
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setDate(1, capital.getMesAno() );
			stmt.setDouble(2, capital.getValorCapital() );
			stmt.setInt(3, capital.getCodigo() );
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public List<Capital> buscarCapital() {

		List<Capital> capital = new ArrayList<>();
		try {
			String sql = 
				"select * from capital";
			PreparedStatement stmt = con.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Capital a = new Capital();
				a.setCodigo( rs.getInt("codigo")  );
				a.setMesAno( rs.getDate("data")  );
				a.setValorCapital( rs.getFloat("valor_Capital")  );
				
				capital.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return capital;
		
	}


}
