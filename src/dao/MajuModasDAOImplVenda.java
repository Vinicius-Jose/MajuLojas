package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ItemVenda;
import model.Venda;


public class MajuModasDAOImplVenda implements MajuModasDAOVenda {
	
	private Connection con;
	private String tipoBanco;
	
	public MajuModasDAOImplVenda() { 
		con = new Conexao().getConnection();
	}
	


	@Override
	public void adicionar(Venda venda) {

		try {
			String sql = "INSERT INTO Venda(data_Venda, valor_Total) " + " VALUES ( ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);


			stmt.setDate(1, venda.getDtVenda());
			stmt.setDouble(2, venda.getValorTotal());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String sql = "select Max(codigo) as maximo from venda";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rt = stmt.executeQuery();
			rt.next();
			venda.setCodigo(rt.getInt("maximo"));
			sql = "INSERT INTO Item_Venda " + " VALUES ( ?, ?, ?, ? ) ";
			stmt = con.prepareStatement(sql);

			for (ItemVenda a : venda.getItemVenda()) {
				stmt.setInt(1, a.getModelo().getCodigo());
				stmt.setInt(2, venda.getCodigo());
				stmt.setInt(3, a.getQuantidade());
				stmt.setDouble(4, a.getValorTotalPeca());
				stmt.execute();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Venda venda) {

		try {
			String sql = "DELETE FROM Venda WHERE Codigo = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, venda.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String sql = "DELETE FROM Item_Venda WHERE Codigo = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, venda.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Venda venda) {

		try {
			String sql = "UPDATE Venda SET" + " data = ?," + " valor_Total = ?"
					+ "WHERE codigo = ?";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setDate(1, venda.getDtVenda());
			stmt.setFloat(2, venda.getValorTotal());
			stmt.setInt(3, venda.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String sql = "UPDATE Item_Venda SET" + " qtd_Modelo_Vendido = ?,"
					+ " valor_ItemVenda = ? " + "WHERE ModeloCodigo = ? AND "
					+ "VendaCodigo = ?";

			PreparedStatement stmt = con.prepareStatement(sql);

			for (ItemVenda a : venda.getItemVenda()) {
				stmt.setInt(1, a.getQuantidade());
				stmt.setFloat(2, a.getValorTotalPeca());
				stmt.setInt(3, a.getModelo().getCodigo());
				stmt.setDouble(4, venda.getCodigo());

			}

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public List<Venda> buscarVenda() {

		List<Venda> venda = new ArrayList<>();
		try {
			String sql = 
				"select * from Venda";
			PreparedStatement stmt = con.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Venda a = new Venda();
				a.setCodigo( rs.getInt("codigo")  );
				a.setDtVenda( rs.getDate("data")  );
				a.setValorTotal( rs.getFloat("valor_Total")  );
				
				venda.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return venda;
		
	}



}
