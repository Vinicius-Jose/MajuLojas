package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ItemPeca;
import model.Modelo;


public class MajuModasDAOImplModelo implements MajuModasDAOModelo {
	
	private Connection con;
	private String tipoBanco;
	
	public MajuModasDAOImplModelo() { 
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
	public void adicionar(Modelo modelo) {
		
		try {			
			String sql = "INSERT INTO Modelo " +
					" VALUES ( ?, ?, ?, ?, ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, modelo.getCodigo() );
			stmt.setString(2, modelo.getModelo() );
			stmt.setDouble(3, modelo.getMargemCusto() );
			stmt.setDouble(4, modelo.getCustoConfeccao() );
			stmt.setInt(5, modelo.getPiloto().getCodigo() );
			stmt.setInt(6, modelo.getModelagem().getCodigo());
			stmt.setInt(7, modelo.getCorteCostura().getCodigo());
			stmt.setInt(8, modelo.getTecido().getCodigo());
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {			
			String sql = "INSERT INTO Capital_Modelo " +
					" VALUES ( ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			stmt.setInt(1, modelo.getCodigo());
			stmt.setInt(2, 0);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {			
			String sql = "INSERT INTO Item_Peca " +
					" VALUES ( ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			for (ItemPeca ip : modelo.getItemPeca()) {
				
			
			stmt.setInt(1, ip.getAviamento().getCodigo());
			//teria que pegar o codigo do modelo, ver onde pegar esse codigo depois
			stmt.setInt(2, modelo.getCodigo());
			stmt.setDouble(3, ip.getQuantidadeAviamento() );
			stmt.setDouble(4, ip.getValorAviamento() );
			
			stmt.executeUpdate();
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void remover(Modelo modelo, Integer codigoAviamento) {
		
		try {			
			String sql = "DELETE FROM Modelo WHERE Codigo = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			
			stmt.setInt(1, modelo.getCodigo());
			
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {			
			String sql = "DELETE FROM Capital_Modelo WHERE ModeloCodigo = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			
			stmt.setInt(1, modelo.getCodigo());
			
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {			
			String sql = "DELETE FROM Item_Peca WHERE AviamentoCodigo = ? AND"
					+ "ModeloCodigo = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, codigoAviamento);
			stmt.setInt(2, modelo.getCodigo());
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void alterar(Modelo modelo) {
		
		try {			
			String sql = "UPDATE Modelo SET"
					+ " modelo = ?,"
					+ " margem_Custo = ?,"
					+ "preco_Custo = ?,"
					+ "PilotoCodigo = ?,"
					+ "ModelagemCodigo = ?,"
					+ "Corte_CosturaCodigo = ?,"
					+ "TecidoCodigo = ? "
					+ "WHERE codigo = ?";
					
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setString(1, modelo.getModelo() );
			stmt.setFloat(2, modelo.getMargemCusto() );
			stmt.setFloat(3, modelo.getCustoConfeccao());
			stmt.setInt(4, modelo.getPiloto().getCodigo());
			stmt.setInt(5, modelo.getModelagem().getCodigo());
			stmt.setInt(6, modelo.getCorteCostura().getCodigo());
			stmt.setInt(7, modelo.getTecido().getCodigo());
			stmt.setInt(8, modelo.getCodigo());
			
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		try {			
			String sql = "UPDATE Item_Peca SET"
					+ " qtd_Aviamento = ?,"
					+ " valor_Item_Peca = ? "
					+ "WHERE AviamentoCodigo = ? AND "
					+ "ModeloCodigo = ?";
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			for (ItemPeca ip : modelo.getItemPeca()) {
				
				
				stmt.setDouble(1, ip.getQuantidadeAviamento() );
				stmt.setDouble(2, ip.getValorAviamento() );
				stmt.setInt(3, ip.getAviamento().getCodigo());
				stmt.setInt(4, modelo.getCodigo());
				
				stmt.executeUpdate();
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public List<Modelo> buscarModeloInfoBasica() {
		List<Modelo> modelos = new ArrayList();
		String sql = "Select *   from Modelo ";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rt = stmt.executeQuery();
			while (rt.next()) {
				Modelo mod = new Modelo();
				mod.setCodigo(rt.getInt("codigo"));
				mod.setCustoConfeccao(rt.getFloat("preco_Custo"));
				mod.setMargemCusto(rt.getFloat("margem_Custo"));
				mod.setModelo(rt.getString("modelo"));
				modelos.add(mod);
			}
			rt.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return modelos;
	}



	@Override
	public List<Modelo> buscarModelo() {
		// TODO Auto-generated method stub
		return null;
	}



	



}
