package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.CorteCostura;
import model.Encomenda;
import model.RelatorioLucro;
import model.Tecido;
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

			String sql = "INSERT INTO Lucro " + " VALUES ( ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(3, lucro.getCapital().getCodigo());
			stmt.setDate(1, lucro.getMesAno());
			stmt.setDouble(2, lucro.getLucroMes());
			stmt.execute();
			for (Venda v : lucro.getVenda()) {
				sql = "update Venda set Lucrocodigo = ?  where codigo = ?";
				PreparedStatement stmt2 = con.prepareStatement(sql);
				stmt2.setInt(1,lucro.getCodigo());
				stmt2.setInt(2,v.getCodigo());
				stmt2.executeUpdate();
			}
			for(Encomenda en : lucro.getEncomenda()){
				sql = "update Encomenda set Lucrocodigo = ?  where codigo = ?";
				PreparedStatement stmt2 = con.prepareStatement(sql);
				stmt2.setInt(1,lucro.getCodigo());
				stmt2.setInt(2,en.getCodigo());
				stmt2.executeUpdate();
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
			PreparedStatement stmt = con.prepareStatement(sql);

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
			String sql = "UPDATE Item_Peca SET" + " data = ?,"
					+ " lucro_Mensal = ? " + "WHERE VendaCodigo = ?";

			PreparedStatement stmt = con.prepareStatement(sql);

			for (Venda v : lucro.getVenda()) {

				stmt.setDate(1, lucro.getMesAno());
				stmt.setDouble(2, lucro.getLucroMes());
				stmt.setInt(3, v.getCodigo());

				stmt.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	



	
	@Override
	public double buscarLucro(int mes, int ano) {
		String sql = "Select lucro_Mensal  from Lucro where MONTH(data_Lucro) = ? and YEAR(data_Lucro) = ?";
		PreparedStatement stmt = null;
		double valor = 0;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, mes);
			stmt.setInt(2, ano);
			ResultSet rt = stmt.executeQuery();
			while (rt.next()) {
				valor = rt.getDouble("lucro_Mensal");
			}
			rt.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return valor;
	}

	@Override
	public List<HashMap<String, Object>> buscaDadosLucro(int mes, int ano) {
		List<HashMap<String, Object>> info = new ArrayList<>();
		String sql = "select md.modelo, iv.qtd_Modelo_Vendido as qtd, md.margem_Custo as preco, sum(vd.valor_Total) as valor_Ganho from  Modelo md, Venda vd, Item_Venda iv, Lucro lc"
+ " where md.codigo = iv.Modelocodigo and vd.codigo = iv.Vendacodigo and vd.Lucrocodigo = lc.codigo and lc.codigo in (select codigo from Lucro  where MONTH(data_Lucro) = ? and YEAR(data_Lucro) = ?)"
+ " group by md.modelo, iv.qtd_Modelo_Vendido, md.margem_Custo";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, mes);
			stmt.setInt(2, ano);
			ResultSet rt = stmt.executeQuery();
			while (rt.next()) {
				HashMap<String, Object> dados = new HashMap<>();
				dados.put("Modelo", rt.getString("modelo"));
				dados.put("Qtd Vendida", rt.getInt("qtd"));
				dados.put("Preço de Venda", rt.getDouble("preco"));
				dados.put("Valor Ganho", rt.getDouble("valor_Ganho"));
				info.add(dados);
			}
			rt.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return info;
	}

	
	@Override
	public int getMaxIdLucro(){
		String sql = "select Max(codigo)+1 AS maximo from Lucro";
		PreparedStatement stmt = null;
		int codigo = 0;
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rt = stmt.executeQuery();
			while (rt.next()) {
				codigo = rt.getInt("maximo");
			}
			rt.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codigo;
	}










}



