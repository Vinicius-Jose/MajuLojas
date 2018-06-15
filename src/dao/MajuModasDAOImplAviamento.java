package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aviamento;
import model.Fornecedor;


public class MajuModasDAOImplAviamento implements MajuModasDAOAviamento {
	
	private Connection con;
	private String tipoBanco;
	
	public MajuModasDAOImplAviamento() { 
		con = new Conexao().getConnection();
	}
	
	


	@Override
	public void adicionar(Aviamento aviamento) {
		try {
			String sql = "INSERT INTO Aviamento "
					+ " VALUES ( ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);


			stmt.setDate(1, aviamento.getDataCompra());
			stmt.setDouble(2, aviamento.getValorCompra());
			stmt.setString(3, aviamento.getNome());
			stmt.setInt(4, aviamento.getFornecedor().getId());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Aviamento aviamento) {
		try {
			String sql = "DELETE FROM Aviamento WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, aviamento.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Aviamento aviamento) {

		try {
			String sql = "UPDATE Aviamento SET" + " data_aviamento = ? ,"
					+ " valor_Unitario = ?," + " nome = ?,"
					+ " Fornecedorid = ? " + "WHERE codigo = ? ";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setDate(1, aviamento.getDataCompra());
			stmt.setDouble(2, aviamento.getValorCompra());
			stmt.setString(3, aviamento.getNome());
			stmt.setInt(4, aviamento.getFornecedor().getId());
			stmt.setInt(5, aviamento.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Aviamento> buscarAviamento() {

		List<Aviamento> aviamento = new ArrayList<>();
		try {
			String sql = 
				  "select av.codigo, av.data, av.valor_Unitario,"
			    + "forn.id AS codigo_fornecedor, forn.nome AS nome_fornecedor "
			    + "from aviamento av, fornecedor forn"
			    + "where forn.id = av.Fornecedorid";
			PreparedStatement stmt = con.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Aviamento a = new Aviamento();
				Fornecedor forn = new Fornecedor();
				a.setCodigo( rs.getInt("codigo")  );
				a.setDataCompra( rs.getDate("data_Aviamento")  );
				a.setValorCompra( rs.getFloat("valor_Unitario")  );
				a.setNome( rs.getString("nome")  );
				forn.setId(rs.getInt("codigo_fornecedor"));
				forn.setNome(rs.getString("nome_fornecedor"));
				a.setFornecedor( forn );
				aviamento.add( a );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aviamento;
		
	}




	@Override
	public Aviamento buscaEspecifico(Aviamento aviamento) {
		
		try {
			String sql = 
				  "select av.nome as aviamento, av.codigo, av.data_Aviamento, av.valor_Unitario, "
			    + "forn.id AS codigo_fornecedor, forn.nome AS nome_fornecedor "
			    + "from aviamento av, fornecedor forn "
			    + "where forn.id = av.Fornecedorid AND av.nome like ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setString(1, "%" + aviamento.getNome()+"%");
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) { 
				Fornecedor forn = new Fornecedor();
				aviamento.setCodigo( rs.getInt("codigo")  );
				aviamento.setDataCompra( rs.getDate("data_Aviamento")  );
				aviamento.setValorCompra( rs.getFloat("valor_Unitario")  );
				forn.setId(rs.getInt("codigo_fornecedor"));
				forn.setNome(rs.getString("nome_fornecedor"));
				aviamento.setFornecedor( forn );
				aviamento.setNome(rs.getString("aviamento"));
				return aviamento;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}


}
