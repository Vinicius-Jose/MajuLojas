package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Capital;
import model.Piloto;


public class MajuModasDAOImplPiloto implements MajuModasDAOPiloto {
	
	private Connection con;
	private String tipoBanco;
	
	public MajuModasDAOImplPiloto() { 
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
	public void adicionar(Piloto piloto) {
		
		try {			
			String sql = "INSERT INTO Piloto " +
					" VALUES ( ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, piloto.getCodigo() );
			stmt.setDouble(2, piloto.getValorPiloto() );
			stmt.setDate(3, piloto.getDataPiloto() );
			stmt.setInt(4, 0);
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void remover(Piloto piloto) {
		
		try {			
			String sql = "DELETE FROM Piloto WHERE Codigo = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			
			stmt.setInt(1, piloto.getCodigo());
			
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void alterar(Piloto piloto) {
		
		try {			
			String sql = "UPDATE Modelagem SET"
					+ " valor_Unitrio = ?,"
					+ " data = ? "
					+ "WHERE codigo = ?";
					
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setFloat(1, piloto.getValorPiloto() );
			stmt.setDate(2, piloto.getDataPiloto() );
			stmt.setInt(3, piloto.getCodigo());
			
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public List<Piloto> buscarPiloto() {

		List<Piloto> piloto = new ArrayList<>();
		try {
			String sql = 
				"select * from piloto";
			PreparedStatement stmt = con.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Piloto p = new Piloto();
				Capital c = new Capital();
				
				p.setCodigo( rs.getInt("codigo")  );
				p.setValorPiloto( rs.getFloat("valor_Unitario")  );
				p.setDataPiloto( rs.getDate("data")  );
				c.setCodigo(rs.getInt("capitalCodigo"));
				p.setCapital(c);
				piloto.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return piloto;
		
	}



}