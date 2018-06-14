package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Fornecedor;
import model.Tecido;


public class MajuModasDAOImplTecido implements MajuModasDAOTecido {
	
	private Connection con;
	private String tipoBanco;
	
	public MajuModasDAOImplTecido() { 
		con = new Conexao().getConnection();
	}



	@Override
	public void adicionar(Tecido tecido) {
		
		try {			
			String sql = "INSERT INTO Tecido " +
					" VALUES ( ?, ?, ?, ?, ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, tecido.getCodigo() );
			stmt.setDate(2, tecido.getData() );
			stmt.setDouble(3, tecido.getValor() );
			stmt.setInt(4, tecido.getQuantidade() );
			stmt.setString(5, tecido.getTipo() );
			stmt.setString(6, tecido.getCor());
			stmt.setInt(7, tecido.getFornecedor().getId());
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}




	@Override
	public void remover(Tecido tecido) {
		
		try {			
			String sql = "DELETE FROM Tecido WHERE Codigo = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			
			stmt.setInt(1, tecido.getCodigo());
			
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	@Override
	public void alterar(Tecido tecido) {
		
		try {			
			String sql = "UPDATE Tecido SET"
					+ " data = ?,"
					+ " valor_Unitario = ?, "
					+ "qtd_Rolo = ?, "
					+ "tipo = ?, "
					+ "cor = ?, "
					+ "FornecedorId = ? "
					+ "WHERE codigo = ?";
					
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setDate(1, tecido.getData() );
			stmt.setFloat(2, tecido.getValor() );
			stmt.setInt(3, tecido.getQuantidade());
			stmt.setString(4, tecido.getCor());
			stmt.setInt(5, tecido.getFornecedor().getId());
			stmt.setInt(6, tecido.getCodigo());
			
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	@Override
	public List<Tecido> buscarTecido() {

		List<Tecido> tecido = new ArrayList<>();
		try {
			String sql = 
				"select * from tecido";
			PreparedStatement stmt = con.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Tecido t = new Tecido();
				Fornecedor fornecedor = new Fornecedor();
				
				t.setCodigo( rs.getInt("codigo")  );
				t.setData(rs.getDate("data_Tecido"));
				t.setValor( rs.getFloat("valor_Unitario") );
				t.setQuantidade( rs.getInt("quantidade_Rolo"));
				t.setTipo(rs.getString("tipo"));
				t.setCor(rs.getString("cor"));
				fornecedor.setId(rs.getInt("Fornecedorid"));
				t.setFornecedor(fornecedor);
				
				tecido.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tecido;
		
	}



}
