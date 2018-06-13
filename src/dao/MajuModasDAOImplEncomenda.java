package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Encomenda;
import model.ItemEncomenda;
import model.Status;


public class MajuModasDAOImplEncomenda implements MajuModasDAOEncomenda {
	
	private Connection con;
	private String tipoBanco;
	
	public MajuModasDAOImplEncomenda() { 
		try {
			tipoBanco = "mariadb";
			String drivers = "org.mariadb.jdbc.Driver";
			String porta = "3306";
			String nomeBanco = "MajuModas";
			String usuario = "root";
			String senha = "";
			
			Class.forName(drivers);
			String urlDb = "jdbc:"+ tipoBanco +"//localhost:"+ porta +"/"+ nomeBanco +"?allowMultiQueries=true";
			con = DriverManager.getConnection(urlDb, usuario , senha);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	


	@Override
	public void adicionar(Encomenda encomenda) {
		
		try {			
			String sql = "INSERT INTO Encomenda " +
					" VALUES ( ?, ?, ?, ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, encomenda.getCodigo() );
			stmt.setInt(2, encomenda.getCliente().getId() );
			stmt.setDate(3, encomenda.getDataEncomenda() );
			stmt.setDate(4, encomenda.getDataRetirada() );
			stmt.setDouble(5, encomenda.getValorTotalEncomenda() );
			stmt.setString(6, encomenda.getStatus().getValorEnum());
			stmt.setString(7, encomenda.getMotorista().getNumPlaca());
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {			
			String sql = "INSERT INTO Item_Encomenda " +
					" VALUES ( ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			for (ItemEncomenda ie : encomenda.getItemEncomenda()) {
				
			
			stmt.setInt(1, encomenda.getCliente().getId());
			//pegar o codigo do modelo
			stmt.setInt(2, ie.getModelo().getCodigo());
			stmt.setInt(3, ie.getQuantidade() );
			stmt.setDouble(4, ie.getValorItemEncomenda() );
			
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
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, encomenda.getCodigo() );
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {			
			String sql = "DELETE FROM Item_Encomenda "
					+ "WHERE EncomendaCliendeId = ? AND "
					+ "ModeloCodigo = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
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
			String sql = "UPDATE Encomenda SET"
					+ " data_Encomenda = ?, "
					+ " data_Retirada = ?, "
					+ "valor_Total = ?,"
					+ "status_Encomenda = ?, "
					+ "motoristanum_Placa = ? "
					+ "WHERE id = ? ";
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setDate(1, encomenda.getDataEncomenda() );
			stmt.setDate(2, encomenda.getDataRetirada() );
			stmt.setFloat(3, encomenda.getValorTotalEncomenda());
			stmt.setString(4, encomenda.getStatus().getValorEnum());
			stmt.setString(5, encomenda.getMotorista().getNumPlaca());
			stmt.setInt(6, encomenda.getCodigo());
			
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {			
			String sql = "UPDATE Item_Encomenda SET"
					+ " qunatidade = ?,"
					+ " valor_Item_Encomenda = ? "
					+ "WHERE EncomendaCienteId = ? AND"
					+ "ModeloCodigo = ?";
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			for (ItemEncomenda ie : encomenda.getItemEncomenda()) {
				
				
				stmt.setInt(1, encomenda.getCliente().getId());
				stmt.setInt(2, ie.getQuantidade() );
				stmt.setDouble(3, ie.getValorItemEncomenda() );
				stmt.setInt(4, ie.getModelo().getCodigo());
				
				stmt.executeUpdate();
				}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	@Override
	public List<Encomenda> buscarEncomenda() {

		List<Encomenda> encomenda = new ArrayList<>();
		try {
			String sql = 
				"select * from Encomenda";
			PreparedStatement stmt = con.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Encomenda en = new Encomenda();
				en.setCodigo( rs.getInt("codigo")  );
				en.setDataEncomenda( rs.getDate("data_Encomenda")  );
				en.setDataRetirada( rs.getDate("data_Retirada")  );
				en.setValorTotalEncomenda(rs.getFloat("valor_Total"));
				/*
				 * Ver como ficaria o Status depois
				 */
				en.setStatus(Status.valueOf(rs.getString("status")));
				
				
				encomenda.add(en);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encomenda;
		
	}


}
