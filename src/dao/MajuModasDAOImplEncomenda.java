package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Cliente;
import model.Encomenda;
import model.ItemEncomenda;
import model.Modelo;
import model.Status;


public class MajuModasDAOImplEncomenda implements MajuModasDAOEncomenda {
	
	private Connection con;
	private String tipoBanco;
	
	public MajuModasDAOImplEncomenda() { 
		con = new Conexao().getConnection();
	}
	


	@Override
	public void adicionar(Encomenda encomenda) {

		try {
			String sql = "INSERT INTO Encomenda(clienteId, data_Encomenda, data_Retirada, valor_Total, Status_encomenda, Motoristanum_Placa) "
					+ " VALUES ( ?, ?, ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, encomenda.getCliente().getId());
			stmt.setDate(2, encomenda.getDataEncomenda());
			stmt.setDate(3, encomenda.getDataRetirada());
			stmt.setDouble(4, encomenda.getValorTotalEncomenda());
			stmt.setString(5, encomenda.getStatus().toString());
			if(encomenda.getMotorista() != null){
			stmt.setString(6, encomenda.getMotorista().getNumPlaca());
			}else stmt.setString(6, null);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String sql = "select max(codigo) as maximo from encomenda";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rt  = stmt.executeQuery();
			rt.next();
			encomenda.setCodigo(rt.getInt("maximo"));
			sql = "INSERT INTO Item_Encomenda "
					+ " VALUES ( ?, ?, ?, ? ) ";
			stmt = con.prepareStatement(sql);

			for (ItemEncomenda ie : encomenda.getItemEncomenda()) {

				stmt.setInt(1, ie.getModelo().getCodigo());
				stmt.setInt(2, ie.getQuantidade());
				stmt.setFloat(3, ie.getValorItemEncomenda());
				stmt.setInt(4, encomenda.getCodigo());

				stmt.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Encomenda encomenda, Integer codigoEncomenda) {
		try {
			String sql = "DELETE FROM Encomenda WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, encomenda.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String sql = "DELETE FROM Item_Encomenda "
					+ "WHERE EncomendaCliendeId = ? AND " + "ModeloCodigo = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, encomenda.getCliente().getId());
			stmt.setInt(2, codigoEncomenda);

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Encomenda encomenda) {

		try {
			String sql = "UPDATE Encomenda SET" + " data_Encomenda = ?, "
					+ " data_Retirada = ?, " + "valor_Total = ?,"
					+ "status_Encomenda = ?, " + "motoristanum_Placa = ? "
					+ "WHERE id = ? ";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setDate(1, encomenda.getDataEncomenda());
			stmt.setDate(2, encomenda.getDataRetirada());
			stmt.setFloat(3, encomenda.getValorTotalEncomenda());
			stmt.setString(4, encomenda.getStatus().toString());
			stmt.setString(5, encomenda.getMotorista().getNumPlaca());
			stmt.setInt(6, encomenda.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String sql = "UPDATE Item_Encomenda SET" + " qunatidade = ?,"
					+ " valor_Item_Encomenda = ? "
					+ "WHERE EncomendaCienteId = ? AND" + "ModeloCodigo = ?";

			PreparedStatement stmt = con.prepareStatement(sql);

			for (ItemEncomenda ie : encomenda.getItemEncomenda()) {

				stmt.setInt(1, encomenda.getCliente().getId());
				stmt.setInt(2, ie.getQuantidade());
				stmt.setDouble(3, ie.getValorItemEncomenda());
				stmt.setInt(4, ie.getModelo().getCodigo());

				stmt.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public List<Encomenda> buscarEncomenda( Cliente cliente) {

		List<Encomenda> encomenda = new ArrayList<>();
		try {
			String sql = 
				"select  en.codigo, en.Status_encomenda, en.data_Encomenda, en.data_Retirada, mot.nome  from  encomenda en, Cliente cl, Motorista mot "
+ " where en.Clienteid = cl.id and en.Motoristanum_Placa = mot.num_Placa and cl.id = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			stmt.setInt(1,cliente.getId());
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Encomenda en = new Encomenda();
				en.setCodigo( rs.getInt("codigo")  );
				en.setDataEncomenda( rs.getDate("data_Encomenda")  );
				en.setDataRetirada( rs.getDate("data_Retirada")  );
				en.setStatus(Status.valueOf(rs.getString("Status_Encomenda")));
				en.setItemEncomenda(buscarItens(en));
				encomenda.add(en);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encomenda;
		
	}
	
	
	private Set<ItemEncomenda> buscarItens(Encomenda encomenda){
		Set<ItemEncomenda> itens = new HashSet();
		try {
			String sql = 
				"select ien.quantidade, md.codigo, md.modelo, ien.valor_Item_Encomenda from Item_Encomenda  ien, Modelo md where Encomendacodigo = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			stmt.setInt(1,encomenda.getCodigo());
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				ItemEncomenda ien = new ItemEncomenda();
				ien.setQuantidade(rs.getInt("quantidade"));
				Modelo mod = new Modelo();
				mod.setCodigo(rs.getInt("codigo"));
				mod.setModelo(rs.getString("modelo"));
				ien.setModelo(mod);
				ien.setValorItemEncomenda(rs.getFloat("valor_item_encomenda") );
				itens.add(ien); 
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itens;
		
	}
	}



