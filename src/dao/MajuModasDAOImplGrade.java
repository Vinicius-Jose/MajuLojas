package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Grade;


public class MajuModasDAOImplGrade implements MajuModasDAOGrade {
	
	private Connection con;
	private String tipoBanco;
	
	public MajuModasDAOImplGrade() { 
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
	public void adicionar(Grade grade) {
		
		try {			
			String sql = "INSERT INTO Grade " +
					" VALUES ( ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, grade.getCodigo() );
			stmt.setInt(2, grade.getNumTamanhoMaximo() );
			stmt.setInt(3, grade.getNumTamanhoMinimo() );
			stmt.setString(4, grade.getLetra() );
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void remover(Grade grade) {
		
		try {			
			String sql = "DELETE FROM Grade WHERE codigo = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, grade.getCodigo() );
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void alterar(Grade grade) {
		
		try {			
			String sql = "UPDATE Grade SET"
					+ " num_Tamanho_Minimo = ?,"
					+ " num_Tamanho_Maximo = ?, "
					+ "letra = ? "
					+ "WHERE codigo = ? ";
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, grade.getNumTamanhoMinimo() );
			stmt.setInt(2, grade.getNumTamanhoMaximo() );
			stmt.setString(3, grade.getLetra());
			stmt.setInt(4, grade.getCodigo());
			
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	@Override
	public List<Grade> buscarGrade() {
		
		List<Grade> grade = new ArrayList<>();
		try {
			String sql = 
				"select * from Grade";
			PreparedStatement stmt = con.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Grade a = new Grade();
				a.setCodigo( rs.getInt("codigo")  );
				a.setNumTamanhoMinimo( rs.getInt("num_Tamanho_Minimo")  );
				a.setNumTamanhoMaximo( rs.getInt("num_Tamanho_Maximo")  );
				a.setLetra( rs.getString("letra"));
				
				grade.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grade;
		
	}



}
