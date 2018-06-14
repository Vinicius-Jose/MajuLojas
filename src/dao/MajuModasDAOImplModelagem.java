package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Modelagem;
import model.Modelo;


public class MajuModasDAOImplModelagem implements MajuModasDAOModelagem {
	
	private Connection con;
	private String tipoBanco;
	
	public MajuModasDAOImplModelagem() { 
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
	public void adicionar(Modelagem modelagem) {
		
		try {			
			String sql = "INSERT INTO Modelagem " +
					" VALUES ( ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, modelagem.getCodigo() );
			stmt.setDouble(2, modelagem.getValor() );
			stmt.setDate(3, modelagem.getDataModelagem() );
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}




	@Override
	public void remover(Modelagem modelagem) {
		
		try {			
			String sql = "DELETE FROM Modelagem WHERE VendaCodigo = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			// precisa pegar apenas um codigo de uma venda ja realizada
			stmt.setInt(1, modelagem.getCodigo());
			
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}




	@Override
	public void alterar(Modelagem modelagem) {
		
		try {			
			String sql = "UPDATE Modelagem SET"
					+ " valor_Unitario = ?,"
					+ " data = ? "
					+ "WHERE codigo = ?";
					
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setFloat(1, modelagem.getValor() );
			stmt.setDate(2, modelagem.getDataModelagem() );
			stmt.setInt(3, modelagem.getCodigo());
			
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	@Override
	public List<Modelagem> buscarModelagem() {

		List<Modelagem> modelagem = new ArrayList<>();
		try {
			String sql = 
				"select * from Modelagem";
			PreparedStatement stmt = con.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				
				Modelagem m = new Modelagem();
				m.setCodigo( rs.getInt("codigo")  );
				m.setValor( rs.getFloat("valor_Unitario")  );
				m.setDataModelagem( rs.getDate("data_Modelagem")  );
				
				modelagem.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelagem;
		
	}
	
	@Override
	public Modelagem buscarModelagemEspecifica(Modelagem modelagem) {
		try {
			String sql = 
				  "select mod.codigo, mod.valor_Unitario, mod.data_Modelagem, "
					+"from modelagem mod, modelo model"
			    + "where model.codigo = mod.Modelagemcodigo ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setFloat(1, modelagem.getValor());
			stmt.setDate(2, modelagem.getDataModelagem());
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Modelo modelo = new Modelo();
				modelagem.setCodigo( rs.getInt("codigo")  );
				modelagem.setValor(rs.getFloat("valor_Unitario"));
				modelagem.setDataModelagem(rs.getDate("data_Modelagem"));
				modelo.setCodigo(rs.getInt("codigo"));
				modelo.setModelo(rs.getString("modelo"));
				modelagem.setModelo(modelo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelagem;
	}



}
