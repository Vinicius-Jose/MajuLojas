package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
}
