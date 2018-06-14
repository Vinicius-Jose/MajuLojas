package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RelatorioLucro;
import model.Venda;


public class MajuModasDAOImplRelatorioLucro implements MajuModasDAORelatorioLucro {
	
	private Connection con;
	private String tipoBanco;
	
	public MajuModasDAOImplRelatorioLucro() { 
		con = new Conexao().getConnection();
	}


	
	@Override
	public void adicionar(RelatorioLucro lucro) {
		
		try {			
			
			String sql = "INSERT INTO Lucro " +
					" VALUES ( ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
		
			for (Venda v : lucro.getVenda()) {
				
			
			stmt.setInt(1, v.getCodigo());
			stmt.setInt(2, 0);
			stmt.setDate(3, lucro.getMesAno() );
			stmt.setDouble(4, lucro.getLucroMes() );
			
			stmt.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public void remover(Integer codigoVenda) {
		
		try {			
			String sql = "DELETE FROM Lucro WHERE VendaCodigo = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			// precisa pegar apenas um codigo de uma venda ja realizada
			stmt.setInt(1, codigoVenda);
			
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void alterar(RelatorioLucro lucro) {
		
		try {			
			String sql = "UPDATE Item_Peca SET"
					+ " data = ?,"
					+ " lucro_Mensal = ? "
					+ "WHERE VendaCodigo = ?";
					
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			for (Venda v : lucro.getVenda()) {
				
				
				stmt.setDate(1, lucro.getMesAno() );
				stmt.setDouble(2, lucro.getLucroMes() );
				stmt.setInt(3, v.getCodigo());
				
				stmt.executeUpdate();
				}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	



	@Override
	public List<RelatorioLucro> buscarRelatorioLucro() {

		List<RelatorioLucro> relatorioLucro = new ArrayList<>();
		try {
			String sql = 
				"select * from Lucro";
			PreparedStatement stmt = con.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				RelatorioLucro rl = new RelatorioLucro();
				
				rl.setCodigo( rs.getInt("codigo")  );
				rl.setMesAno(rs.getDate("data_Lucro"));
				rl.setLucroMes( rs.getFloat("lucro_Mensal") );
				
				
				relatorioLucro.add(rl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return relatorioLucro;
		
	}	



}
