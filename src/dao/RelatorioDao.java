package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Capital;

public class RelatorioDao {
	MajuModasDAOImpl banco = new MajuModasDAOImpl();

	public List<Integer> buscaMesesCapital() {
		List<Integer> meses = new ArrayList();
		String sql = "Select Month(data_Capital) as meses from Capital Order by meses";
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

		String sql = "Select  md.modelo, md.preco_Custo as custoConfeccao, cc.qtd_Peca_Cortada as cortado, cc.valor_Corte as valCorte,  cc.valor_Costura as costura,case when (tec.Capitalcodigo!= cap.codigo) then 0 else tec.valor_Unitario  end as tecido,case when (pl.Capitalcodigo!= cap.codigo) then 0 else pl.valor_Unitario end as piloto , case  when (ml.CapitalCodigo != cap.codigo) then 0 else ml.valor_Unitario end as modelagem from Capital cap , Modelo md , Corte_Costura cc, Tecido tec, Modelagem ml,Piloto pl "
				+ "where MONTH(data_Capital) = 02 and YEAR(data_Capital) = 2018 and md.Tecidocodigo = tec.codigo and cc.codigo = md.Corte_Costuracodigo and ml.codigo = md.Modelagemcodigo";
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
}
