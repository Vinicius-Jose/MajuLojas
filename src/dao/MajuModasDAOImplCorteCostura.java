package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CorteCostura;


public class MajuModasDAOImplCorteCostura implements MajuModasDAOCorteCostura {
	
	private Connection con;
	private String tipoBanco;
	
	public MajuModasDAOImplCorteCostura() { 
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
	public void adicionar(CorteCostura corteCostura) {
		
		try {			
			String sql = "INSERT INTO Corte_Costura " +
					" VALUES ( ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, corteCostura.getCodigo());
			stmt.setDouble(2, corteCostura.getValorCorte() );
			stmt.setDouble(3, corteCostura.getValorCostura() );
			stmt.setInt(4, corteCostura.getQuantidadePecasCortadas() );
			stmt.setDate(5, corteCostura.getDataCorte() );
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void remover(CorteCostura corteCostura) {
		try {			
			String sql = "DELETE FROM Corte_Costura WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, corteCostura.getCodigo() );
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}






	@Override
	public void alterar(CorteCostura corteCostura) {
		
		try {			
			String sql = "UPDATE Corte_Costura SET"
					+ " valor_Corte = ?, "
					+ " valor_Costura = ?, "
					+ "qtd_Peca_Cortada = ?, "
					+ "data = ?"
					+ "WHERE id = ? ";
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setFloat(1, corteCostura.getValorCorte() );
			stmt.setFloat(2, corteCostura.getValorCostura() );
			stmt.setInt(3, corteCostura.getQuantidadePecasCortadas());
			stmt.setDate(4, corteCostura.getDataCorte());
			stmt.setInt(5, corteCostura.getCodigo());
			
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public List<CorteCostura> buscarCorteCostura() {
		
		List<CorteCostura> corteCostura = new ArrayList<>();
		try {
			String sql = 
				"select * from Corte_Costura";
			PreparedStatement stmt = con.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				CorteCostura cc = new CorteCostura();
				cc.setCodigo( rs.getInt("codigo")  );
				cc.setValorCorte( rs.getFloat("valor_Corte")  );
				cc.setValorCostura( rs.getFloat("valor_Corte")  );
				
				/*
				 * verificar depois o nome da coluna certo
				 */
				cc.setQuantidadePecasCortadas(rs.getInt("qtd_Peca_Cortada"));
				cc.setDataCorte(rs.getDate("data"));
				
				corteCostura.add(cc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return corteCostura;
		
	}


}
