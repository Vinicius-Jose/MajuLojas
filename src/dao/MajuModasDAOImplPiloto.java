package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Capital;
import model.Modelo;
import model.Piloto;

public class MajuModasDAOImplPiloto implements MajuModasDAOPiloto {

	private Connection con;
	private String tipoBanco;

	public MajuModasDAOImplPiloto() {
		con = new Conexao().getConnection();
	}

	@Override
	public void adicionar(Piloto piloto) {

		try {
			String sql = "INSERT INTO Piloto " + " VALUES ( ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setDouble(1, piloto.getValorPiloto());
			stmt.setDate(2, piloto.getDataPiloto());
			stmt.setString(3, null);

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Piloto piloto) {

		try {
			String sql = "DELETE FROM Piloto WHERE Codigo = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, piloto.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Piloto piloto) {

		try {
			String sql = "UPDATE Modelagem SET" + " valor_Unitrio = ?,"
					+ " data = ? " + "WHERE codigo = ?";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setFloat(1, piloto.getValorPiloto());
			stmt.setDate(2, piloto.getDataPiloto());
			stmt.setInt(3, piloto.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public List<Piloto> buscarPiloto() {

		List<Piloto> piloto = new ArrayList<>();
		try {
			String sql = "select * from piloto";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Piloto p = new Piloto();
				Capital c = new Capital();

				p.setCodigo(rs.getInt("codigo"));
				p.setValorPiloto(rs.getFloat("valor_Unitario"));
				p.setDataPiloto(rs.getDate("data"));
				c.setCodigo(rs.getInt("capitalCodigo"));
				// p.setCapital(c);
				piloto.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return piloto;

	}

	@Override
	public Piloto buscarPilotoEspecifico(Modelo modelo) {
		Piloto piloto = new Piloto();
		try {
			String sql = "select codigo, valor_Unitario, data_Piloto from piloto where codigo in (select PilotoCodigo from Modelo where codigo = ?) ";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setFloat(1, modelo.getCodigo());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				piloto.setCodigo(rs.getInt("codigo"));
				piloto.setValorPiloto(rs.getFloat("valor_Unitario"));
				piloto.setDataPiloto(rs.getDate("data_Piloto"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return piloto;
	}
	
	@Override
	public int ultimoCadastroPiloto(){
		String sql = "select max(codigo) as maximo from piloto";
		PreparedStatement stmt;
		int num = 0 ;
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rt = stmt.executeQuery();
			rt.next();
			num = rt.getInt("maximo");
			rt.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

}
