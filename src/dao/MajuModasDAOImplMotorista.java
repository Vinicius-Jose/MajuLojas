package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Motorista;


public class MajuModasDAOImplMotorista implements MajuModasDAOMotorista {
	
	private Connection con;

	
	public MajuModasDAOImplMotorista() { 
		Conexao conB = new Conexao();
		con = conB.getConnection();
	}
	
	
	
	@Override
	public void adicionar(Motorista motorista) {	
		try {			
			String sql = "INSERT INTO Motorista " +
					" VALUES ( ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setString(1, motorista.getNome() );
			stmt.setString(2, motorista.getNumPlaca() );
			stmt.setString(3, motorista.getTelefoneContato() );
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	@Override
	public void remover(Motorista motorista) {
		
		try {			
			String sql = "DELETE FROM Motorista " +
					" WHERE num_Placa = ? ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setString(1, motorista.getNumPlaca() );
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	@Override
	public void alterar(Motorista motorista) {
		
		try {			
			String sql = "UPDATE Motorista SET"
					+ "nome = ? , "
					+ "num_Placa = ?, "
					+ "telefone = ? "
					+ "WHERE num_Placa = ? ";
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setString(1, motorista.getNome() );
			stmt.setString(2, motorista.getNumPlaca() );
			stmt.setString(3, motorista.getTelefoneContato() );
			stmt.setString(4, motorista.getNumPlaca());
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	@Override
	public List<Motorista> buscarMotorista() {
		List<Motorista> motorista = new ArrayList<>();
		try {
			String sql = 
				"select * from motorista";
			PreparedStatement stmt = con.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Motorista a = new Motorista();
				a.setNumPlaca( rs.getString("num_Placa")  );
				a.setNome( rs.getString("nome")  );
				a.setTelefoneContato( rs.getString("telefone")  );
				
				motorista.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return motorista;
		
	}
	
	@Override
	public Motorista buscarMotoristaEspecifico(Motorista motorista){
		try {
			String sql = 
				"select * from motorista where nome like ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			stmt.setString(1, "%"+motorista.getNome()+"%");
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) { 
				motorista.setNumPlaca( rs.getString("num_Placa")  );
				motorista.setNome( rs.getString("nome")  );
				motorista.setTelefoneContato( rs.getString("telefone")  );
				return motorista;
			}else return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



}
