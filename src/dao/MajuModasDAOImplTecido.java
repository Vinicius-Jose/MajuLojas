package dao;

import java.sql.Connection;
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
			String sql = "INSERT INTO Tecido "
					+ " VALUES (  ?, ?, ?, ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);


			stmt.setDate(1, tecido.getData());
			stmt.setDouble(2, tecido.getValor());
			stmt.setInt(3, tecido.getQuantidade());
			stmt.setString(4, tecido.getTipo());
			stmt.setString(5, tecido.getCor());
			stmt.setInt(6, tecido.getFornecedor().getId());
			stmt.setString(7,null);

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
			PreparedStatement stmt = con.prepareStatement(sql);

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
			String sql = "UPDATE Tecido SET" + " data = ?,"
					+ " valor_Unitario = ?, " + "qtd_Rolo = ?, " + "tipo = ?, "
					+ "cor = ?, " + "FornecedorId = ? " + "WHERE codigo = ?";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setDate(1, tecido.getData());
			stmt.setFloat(2, tecido.getValor());
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
				t.setQuantidade( rs.getInt("qtd_Rolo"));
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
	
	@Override
	public Tecido buscarTecidoEspecifico(Tecido tecido){
		try {
			String sql = 
				"select tec.tipo, tec.cor, tec.data_Tecido, tec.codigo, tec.qtd_Rolo, "
			  + "tec.valor_Unitario, fn.id,fn.nome "
			  + "from Tecido tec, Fornecedor fn "
			  + "where tec.Fornecedorid = fn.id and tipo like ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			stmt.setString(1,"%" + tecido.getTipo() + "%");
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) { 
				Fornecedor fornecedor = new Fornecedor();
				tecido.setCodigo( rs.getInt("codigo")  );
				tecido.setData(rs.getDate("data_Tecido"));
				tecido.setValor( rs.getFloat("valor_Unitario") );
				tecido.setQuantidade( rs.getInt("qtd_Rolo"));
				tecido.setTipo(rs.getString("tipo"));
				tecido.setCor(rs.getString("cor"));
				fornecedor.setId(rs.getInt("id"));
				fornecedor.setNome(rs.getString("nome"));
				tecido.setFornecedor(fornecedor);
				return tecido;
			}else return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



}
