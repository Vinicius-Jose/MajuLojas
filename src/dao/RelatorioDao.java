package dao;

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
import model.Tecido;
import model.Venda;

public class RelatorioDao {
	MajuModasDAOImpl banco = new MajuModasDAOImpl();

	public List<Integer> buscaMesesCapital() {
		List<Integer> meses = new ArrayList();
		String sql = "Select Distinct(Month(data_Capital)) as meses from Capital Order by meses";
		PreparedStatement stmt = null;
		try {
			stmt = banco.getCon().prepareStatement(sql);
			ResultSet rt = stmt.executeQuery();
			while (rt.next()) {
				meses.add(rt.getInt("meses"));
			}
			rt.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return meses;
	}

	public List<Integer> buscaAnoCapital() {
		List<Integer> ano = new ArrayList();
		String sql = "Select DISTINCT(Year(data_Capital)) as ano from Capital Order by ano";
		PreparedStatement stmt = null;
		try {
			stmt = banco.getCon().prepareStatement(sql);
			ResultSet rt = stmt.executeQuery();
			while (rt.next()) {
				ano.add(rt.getInt("ano"));
			}
			rt.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ano;
	}

	public double buscarCapital(int mes, int ano) {
		String sql = "Select valor_Capital  from Capital where MONTH(data_Capital) = ? and YEAR(data_Capital) = ?";
		PreparedStatement stmt = null;
		double valor = 0;
		try {
			stmt = banco.getCon().prepareStatement(sql);
			stmt.setInt(1, mes);
			stmt.setInt(2, ano);
			ResultSet rt = stmt.executeQuery();
			while (rt.next()) {
				valor = rt.getDouble("valor_Capital");
			}
			rt.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return valor;
	}

	public List<HashMap<String, Object>> buscaDadosCapital(int mes, int ano) {
		List<HashMap<String, Object>> info = new ArrayList<>();
		String sql = "Select  DISTINCT(md.modelo), md.preco_Custo as custoConfeccao, cc.qtd_Peca_Cortada as cortado, cc.valor_Corte as valCorte,  cc.valor_Costura as costura, tec.valor_Unitario  as tecido,case when (pl.Capitalcodigo!= cap.codigo) then 0 else pl.valor_Unitario end as piloto , case  when (ml.CapitalCodigo != cap.codigo) then 0 else ml.valor_Unitario end as modelagem from Capital cap , Modelo md , Corte_Costura cc, Tecido tec, Modelagem ml,Piloto pl "
				+ "where MONTH(data_Capital) = ? and YEAR(data_Capital) = ? and md.Tecidocodigo = tec.codigo and cc.codigo = md.Corte_Costuracodigo and ml.codigo = md.Modelagemcodigo";
		PreparedStatement stmt = null;
		try {
			stmt = banco.getCon().prepareStatement(sql);
			stmt.setInt(1, mes);
			stmt.setInt(2, ano);
			ResultSet rt = stmt.executeQuery();
			while (rt.next()) {
				HashMap<String, Object> dados = new HashMap<>();
				dados.put("Modelo", rt.getString("modelo"));
				dados.put("Corte", rt.getDouble("valCorte"));
				dados.put("Costura", rt.getDouble("costura"));
				dados.put("Quantidade Cortada", rt.getInt("cortado"));
				dados.put("Modelagem", rt.getDouble("modelagem"));
				dados.put("Piloto", rt.getDouble("piloto"));
				dados.put("Tecido", rt.getDouble("tecido"));
				dados.put("Custo Confec\u00E7\u00E3o",
						rt.getDouble("custoConfeccao"));
				info.add(dados);
			}
			rt.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return info;
	}

	public boolean ultimoCapital() {

		String sql = "select DATEDIFF(month,max(data_capital), getDate()) as data from Capital";
		PreparedStatement stmt = null;
		try {
			stmt = banco.getCon().prepareStatement(sql);
			ResultSet rt = stmt.executeQuery();
			if (rt.next()) {
				if (rt.getInt("data") > 1) {
					return true;
				}
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public double buscarLucro(int mes, int ano) {
		String sql = "Select lucro_Mensal  from Lucro where MONTH(data_Lucro) = ? and YEAR(data_Lucro) = ?";
		PreparedStatement stmt = null;
		double valor = 0;
		try {
			stmt = banco.getCon().prepareStatement(sql);
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

	public List<HashMap<String, Object>> buscaDadosLucro(int mes, int ano) {
		List<HashMap<String, Object>> info = new ArrayList<>();
		String sql = "select md.modelo, iv.qtd_Modelo_Vendido as qtd, md.margem_Custo as preco, sum(vd.valor_Total) as valor_Ganho from  Modelo md, Venda vd, Item_Venda iv, Lucro lc"
+ " where md.codigo = iv.Modelocodigo and vd.codigo = iv.Vendacodigo and vd.Lucrocodigo = lc.codigo and lc.codigo in (select codigo from Lucro  where MONTH(data_Lucro) = ? and YEAR(data_Lucro) = ?)"
+ " group by md.modelo, iv.qtd_Modelo_Vendido, md.margem_Custo";
		PreparedStatement stmt = null;
		try {
			stmt = banco.getCon().prepareStatement(sql);
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

	public Set<CorteCostura> buscarCorte() {
		String sql = "select * from Corte_Costura where DATEDIFF(MONTH,data,getdate()) = 1";
		PreparedStatement stmt = null;
		Set<CorteCostura> lista = new HashSet();
		try {
			stmt = banco.getCon().prepareStatement(sql);
			ResultSet rt = stmt.executeQuery();
			while (rt.next()) {
				CorteCostura corte = new CorteCostura();
				corte.setCodigo(rt.getInt("codigo"));
				corte.setDataCorte(rt.getDate("data"));
				corte.setQuantidadePecasCortadas(rt.getInt("qtd_Peca_Cortada"));
				corte.setValorCorte(rt.getFloat("valor_Corte"));
				corte.setValorCostura(rt.getFloat("valor_Costura"));
				lista.add(corte);
			}
			rt.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Set<Tecido> buscarTecidos() {
		String sql = "select * from Tecido where DATEDIFF(MONTH,data_Tecido,getdate()) = 1";
		PreparedStatement stmt = null;
		Set<Tecido> lista = new HashSet();
		try {
			stmt = banco.getCon().prepareStatement(sql);
			ResultSet rt = stmt.executeQuery();
			while (rt.next()) {
				Tecido tecido = new Tecido();
				tecido.setCodigo(rt.getInt("codigo"));
				tecido.setData(rt.getDate("data_Tecido"));
				tecido.setValor(rt.getFloat("valor_Unitario"));
				tecido.setTipo((rt.getString("tipo")));
				tecido.setCor(rt.getString("cor"));
				tecido.setQuantidade(rt.getInt("qtd_Rolo"));
				lista.add(tecido);
			}
			rt.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	

	public Set<Venda> buscarVenda() {
		String sql = "select * from Venda where DATEDIFF(MONTH,data_Venda,getdate()) = 1";
		PreparedStatement stmt = null;
		Set<Venda> lista = new HashSet();
		try {
			stmt = banco.getCon().prepareStatement(sql);
			ResultSet rt = stmt.executeQuery();
			while (rt.next()) {
				Venda venda = new Venda();
				venda.setCodigo(rt.getInt("codigo"));
				venda.setDtVenda(rt.getDate("data_Venda"));
				venda.setValorTotal(rt.getFloat("valor_Total"));
				lista.add(venda);
			}
			rt.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	public Set<Encomenda> buscarEncomendas() {
		String sql = "select * from Encomenda where DATEDIFF(MONTH,data_Encomenda,getdate()) = 1";
		PreparedStatement stmt = null;
		Set<Encomenda> lista = new HashSet();
		try {
			stmt = banco.getCon().prepareStatement(sql);
			ResultSet rt = stmt.executeQuery();
			while (rt.next()) {
				Encomenda encomenda = new Encomenda();
				encomenda.setCodigo(rt.getInt("codigo"));
				encomenda.setDataEncomenda(rt.getDate("data_Encomenda"));
				encomenda.setValorTotalEncomenda(rt.getFloat("valor_Total"));
				lista.add(encomenda);
			}
			rt.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public int getMaxIdCapital() {
		String sql = "select Max(codigo) AS maximo from Capital";
		PreparedStatement stmt = null;
		int codigo = 1000;
		try {
			stmt = banco.getCon().prepareStatement(sql);
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
	
	public int getMaxIdLucro(){
		String sql = "select Max(codigo)+1 AS maximo from Lucro";
		PreparedStatement stmt = null;
		int codigo = 0;
		try {
			stmt = banco.getCon().prepareStatement(sql);
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
