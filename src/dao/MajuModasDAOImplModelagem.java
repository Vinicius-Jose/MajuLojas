package dao;

import java.sql.Connection;
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
		con = new Conexao().getConnection();
	}

	@Override
	public void adicionar(Modelagem modelagem) {

		try {
			String sql = "INSERT INTO Modelagem " + " VALUES (  ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setDouble(1, modelagem.getValor());
			stmt.setDate(2, modelagem.getDataModelagem());
			stmt.setString(3, null);

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Modelagem modelagem) {

		try {
			String sql = "DELETE FROM Modelagem WHERE codigo = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

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
			String sql = "UPDATE Modelagem SET" + " valor_Unitario = ?,"
					+ " data = ? " + "WHERE codigo = ?";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setFloat(1, modelagem.getValor());
			stmt.setDate(2, modelagem.getDataModelagem());
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
			String sql = "select * from Modelagem";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Modelagem m = new Modelagem();
				m.setCodigo(rs.getInt("codigo"));
				m.setValor(rs.getFloat("valor_Unitario"));
				m.setDataModelagem(rs.getDate("data_Modelagem"));

				modelagem.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelagem;

	}

	@Override
	public Modelagem buscarModelagemEspecifica(Modelo modelo) {
		Modelagem modelagem = new Modelagem();
		try {
			String sql = "select codigo, valor_Unitario, data_Modelagem from modelagem where codigo in (select ModelagemCodigo from Modelo where codigo = ?) ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, modelo.getCodigo());
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				modelagem.setCodigo(rs.getInt("codigo"));
				modelagem.setValor(rs.getFloat("valor_Unitario"));
				modelagem.setDataModelagem(rs.getDate("data_Modelagem"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelagem;
	}

}
