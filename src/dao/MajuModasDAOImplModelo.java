package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import model.ItemPeca;
import model.Modelo;


public class MajuModasDAOImplModelo implements MajuModasDAOModelo {
	
	private Connection con;
	private String tipoBanco;
	
	public MajuModasDAOImplModelo() { 
		con = new Conexao().getConnection();
	}
	
	

public void adicionar(Modelo modelo) {
		
		try {
			String sql = "INSERT INTO Modelo(modelo, margem_Custo, preco_custo, PilotoCodigo, ModelagemCodigo, Corte_Costuracodigo, TecidoCodigo)  "
					+ " VALUES ( ?, ?, ?, ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, modelo.getModelo());
			stmt.setDouble(2, modelo.getMargemCusto());
			stmt.setDouble(3, modelo.getCustoConfeccao());
			
			if(modelo.getPiloto() == null) stmt.setString(4, null);
			else stmt.setInt(4, modelo.getPiloto().getCodigo());
			
			if(modelo.getModelagem() == null )  stmt.setString(5, null);
			else stmt.setInt(5, modelo.getModelagem().getCodigo());
			
			if(modelo.getCorteCostura()!= null) stmt.setInt(6, modelo.getCorteCostura().getCodigo());
			else stmt.setString(6,null);
			
			System.out.println( modelo.getTecido().getCodigo());
			stmt.setInt(7, modelo.getTecido().getCodigo());
			
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String sql = "INSERT INTO Capital_Modelo " + " VALUES ( ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, modelo.getCodigo());
			stmt.setString(2, null);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String sql = "select max(codigo) as maximo from modelo";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rt = stmt.executeQuery();
			rt.next();
			modelo.setCodigo(rt.getInt("maximo"));
			sql = "INSERT INTO Item_Peca " + " VALUES ( ?, ?, ?, ?, ? ) ";
			stmt = con.prepareStatement(sql);

			for (ItemPeca ip : modelo.getItemPeca()) {
				stmt.setInt(1, ip.getAviamento().getCodigo());
				stmt.setInt(2, modelo.getCodigo());
				stmt.setDouble(3, ip.getQuantidadeAviamento());
				stmt.setDouble(4, ip.getValorAviamento());
				stmt.setString(5, null);
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
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, modelo.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String sql = "DELETE FROM Capital_Modelo WHERE ModeloCodigo = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, modelo.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String sql = "DELETE FROM Item_Peca WHERE AviamentoCodigo = ? AND"
					+ "ModeloCodigo = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

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
			String sql = "UPDATE Modelo SET" + " modelo = ?,"
					+ " margem_Custo = ?," + "preco_Custo = ?,"
					+ "PilotoCodigo = ?," + "ModelagemCodigo = ?,"
					+ "Corte_CosturaCodigo = ?," + "TecidoCodigo = ? "
					+ "WHERE codigo = ?";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, modelo.getModelo());
			stmt.setFloat(2, modelo.getMargemCusto());
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
			String sql = "UPDATE Item_Peca SET" + " qtd_Aviamento = ?,"
					+ " valor_Item_Peca = ? "
					+ "WHERE AviamentoCodigo = ? AND " + "ModeloCodigo = ?";

			PreparedStatement stmt = con.prepareStatement(sql);

			for (ItemPeca ip : modelo.getItemPeca()) {

				stmt.setDouble(1, ip.getQuantidadeAviamento());
				stmt.setDouble(2, ip.getValorAviamento());
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
	public Set<Modelo> buscarModeloInfoBasica() {
		Set<Modelo> modelos = new HashSet();
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








	



}
