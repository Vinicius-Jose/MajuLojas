package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;


public class MajuModasDAOImplCliente implements MajuModasDAOCliente {
	
	private Connection con;
	private String tipoBanco;
	
	public MajuModasDAOImplCliente() { 
		Conexao banco = new Conexao();
		con = banco.getConnection();
	}
	
	


	@Override
	public void adicionar(Cliente cliente) {

		try {
			String sql = "INSERT INTO Cliente " + " VALUES (  ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefoneContato());
			System.out.println("Adicionei " + cliente.getTelefoneContato()) ;
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Cliente cliente) {

		try {
			String sql = "DELETE FROM Cliente WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, cliente.getId());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Cliente cliente) {

		try {
			String sql = "UPDATE Cliente SET" + " nome = ? ," + " telefone = ?"
					+ "WHERE id = ? ";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefoneContato());
			stmt.setInt(3, cliente.getId());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	@Override
	public List<Cliente> buscarCliente() {

		List<Cliente> cliente = new ArrayList<>();
		try {
			String sql = 
				"select * from cliente";
			PreparedStatement stmt = con.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Cliente a = new Cliente();
				a.setId( rs.getInt("id")  );
				a.setNome( rs.getString("nome")  );
				a.setTelefoneContato( rs.getString("telefone")  );
				
				cliente.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
		
	}
	
	
	@Override
	public Cliente buscarClienteEspecifico(Cliente cliente){
		
		try {
			String sql = 
				"select * from cliente where nome like ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			stmt.setString(1,"%" + cliente.getNome() + "%");
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) { 
				cliente.setNome(rs.getString("nome"));
				cliente.setTelefoneContato(rs.getString("telefone"));
				cliente.setId(rs.getInt("id"));
				return cliente;
			}else return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
