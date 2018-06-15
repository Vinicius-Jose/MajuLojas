package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Estoque;
import model.Grade;
import model.Modelo;


public class MajuModasDAOImplEstoque implements MajuModasDAOEstoque {
	
	private Connection con;

	
	public MajuModasDAOImplEstoque() { 
		con = new Conexao().getConnection();
	}


	@Override
	public void adicionar(Estoque estoque) {
		
		try {			
			String sql = "INSERT INTO Estoque " +
					" VALUES ( ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, estoque.getQuantidade() );
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void remover(Estoque estoque, int idModelo) {
		try {			
			String sql = "DELETE FROM Estoque WHERE gradeCodigo = ? and ModeloCodigo = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, estoque.getGrade().getCodigo() );
			stmt.setInt(2, idModelo);
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}






	@Override
	public void alterar(Estoque estoque, int idModelo) {
		
		try {			
			String sql = "UPDATE Estoque SET"
					+ " qtd_Grade = ? "
					+ "WHERE gradeCodigo = ? and ModeloCodigo = ? ";
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, estoque.getQuantidade() );
			stmt.setInt(2, estoque.getGrade().getCodigo() );
			stmt.setInt(3, idModelo);
			
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

	@Override
	public List<Estoque> buscarEstoque() {

		List<Estoque> estoque = new ArrayList<>();
		try {
			String sql = 
				"select * from estoque";
			PreparedStatement stmt = con.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Estoque es = new Estoque();
				Grade gra = new Grade();
				gra.setCodigo(rs.getInt("codigo"));
				es.setGrade( gra );
				es.setQuantidade( rs.getInt("qtd_Grade")  );
				
				
				estoque.add(es);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estoque;
		
	}
	
	
	public List<HashMap<String,Object>> buscarEspecifico(Modelo modelo){
		List<HashMap<String,Object>> itens = new ArrayList<>();
		
		String sql = "select md.modelo , gd.letra as grade, es.qtd_Grade as quantidade  from estoque es, Modelo md, Grade gd"
				+" where md.codigo = es.Modelocodigo and gd.codigo = es.Gradecodigo and es.Modelocodigo = ?";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, modelo.getCodigo());
			ResultSet rt = stmt.executeQuery();
			while(rt.next()){
				HashMap<String,Object> linha = new HashMap<>();
				linha.put("Modelo",rt.getString("modelo"));
				linha.put("Grade",rt.getString("grade"));
				linha.put("Quantidade",rt.getInt("quantidade"));
				itens.add(linha);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itens;
		
	}


	@Override
	public List<Estoque> buscarEstoque(Modelo modelo) {
		List<Estoque> estoque = new ArrayList<>();
		try {
			String sql = 
				"select es.ModeloCodigo as modelo, es.qtd_Grade as quantidade, es.gradeCodigo, gd.letra from grade gd, Estoque es where es.Gradecodigo = gd.codigo and es.Modelocodigo = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			stmt.setInt(1,modelo.getCodigo());
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Estoque es = new Estoque();
				Grade gra = new Grade();
				es.setQuantidade(( rs.getInt("quantidade")));
				gra.setCodigo(rs.getInt("GradeCodigo"));
				gra.setLetra(rs.getString("letra"));
				es.setGrade( gra );
				estoque.add(es);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estoque;
	}



}
