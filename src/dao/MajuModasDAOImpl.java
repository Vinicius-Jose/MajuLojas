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

import model.Aviamento;
import model.Capital;
import model.Cliente;
import model.CorteCostura;
import model.Encomenda;
import model.Estoque;
import model.Fornecedor;
import model.Grade;
import model.ItemEncomenda;
import model.ItemPeca;
import model.ItemVenda;
import model.Modelagem;
import model.Modelo;
import model.Motorista;
import model.Piloto;
import model.RelatorioLucro;
import model.Tecido;
import model.Venda;

public class MajuModasDAOImpl implements MajuModasDAO {

	private Connection con;
	private String tipoBanco;

	public MajuModasDAOImpl() {
		try {
			tipoBanco = "mariadb";
			tipoBanco = "SQLSERVER";
			String drivers = "org.mariadb.jdbc.Driver";
			drivers = "net.sourceforge.jtds.jdbc.Driver";
			String porta = "3306";
			String nomeBanco = "MajuLoja";
			String usuario = "root";
			String senha = "";
			senha = "root";
			String urlMS = "jdbc:jtds:sqlserver://%s:1433;database=%s;user=%s;password=%s;";
			Class.forName(drivers);
			// String urlDb = "jdbc:"+ tipoBanco +"//localhost:"+ porta +"/"+
			// nomeBanco +"?allowMultiQueries=true";
			// con = DriverManager.getConnection(urlDb, usuario , senha);
			con = DriverManager
					.getConnection(String
							.format("jdbc:jtds:sqlserver://localhost:1433;database=%s;user=%s;password=%s;",
									nomeBanco, usuario, senha));
			System.out.println("Conectado");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * MovimentaÃ§Ã£o dos dados da tabela Motorista
	 * 
	 */

	@Override
	public void adicionar(Motorista motorista) {
		try {
			String sql = "INSERT INTO Motorista " + " VALUES ( ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, motorista.getNome());
			stmt.setString(2, motorista.getNumPlaca());
			stmt.setString(3, motorista.getTelefoneContato());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void remover(Motorista motorista) {

		try {
			String sql = "DELETE FROM Motorista " + " WHERE num_Placa = ? ";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, motorista.getNumPlaca());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Motorista motorista) {

		try {
			String sql = "UPDATE Motorista SET" + "nome = ?' , "
					+ "num_Placa = ?, " + "telefone = ? "
					+ "WHERE num_Placa = ? ";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, motorista.getNome());
			stmt.setString(2, motorista.getNumPlaca());
			stmt.setString(3, motorista.getTelefoneContato());
			stmt.setString(4, motorista.getNumPlaca());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * MovimentaÃ§Ã£o dos dados da tabela Aviamento
	 * 
	 */

	@Override
	public void adicionar(Aviamento aviamento) {
		try {
			String sql = "INSERT INTO Aviamento "
					+ " VALUES ( ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);


			stmt.setDate(1, aviamento.getDataCompra());
			stmt.setDouble(2, aviamento.getValorCompra());
			stmt.setString(3, aviamento.getNome());
			stmt.setInt(4, aviamento.getFornecedor().getId());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Aviamento aviamento) {
		try {
			String sql = "DELETE FROM Aviamento WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, aviamento.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Aviamento aviamento) {

		try {
			String sql = "UPDATE Aviamento SET" + " data = ?' ,"
					+ " valor_Unitario = ?," + " nome = ?,"
					+ " FornecedorId = ? " + "WHERE codigo = ? ";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setDate(1, aviamento.getDataCompra());
			stmt.setDouble(2, aviamento.getValorCompra());
			stmt.setString(3, aviamento.getNome());
			stmt.setInt(4, aviamento.getFornecedor().getId());
			stmt.setInt(5, aviamento.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * MovimentaÃ§Ã£o dos dados da tabela Capital
	 * 
	 */

	@Override
	public void adicionar(Capital capital) {

		try {
			String sql = "INSERT INTO Capital " + " VALUES ( ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setDate(1, capital.getMesAno());
			stmt.setDouble(2, capital.getValorCapital());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Capital capital) {
		try {
			String sql = "DELETE FROM Capital WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, capital.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Capital capital) {

		try {
			String sql = "UPDATE Capital SET" + " data = ?, "
					+ " valor_Capital = ?" + "WHERE codigo = ? ";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setDate(1, capital.getMesAno());
			stmt.setDouble(2, capital.getValorCapital());
			stmt.setInt(3, capital.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * MovimentaÃ§Ã£o dos dados da tabela Cliente
	 * 
	 */

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

	/**
	 * MovimentaÃ§Ã£o dos dados da tabela Corte_Costura
	 * 
	 */

	@Override
	public void adicionar(CorteCostura corteCostura) {

		try {
			String sql = "INSERT INTO Corte_Costura "
					+ " VALUES ( ?, ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setDouble(1, corteCostura.getValorCorte());
			stmt.setDouble(2, corteCostura.getValorCostura());
			stmt.setInt(3, corteCostura.getQuantidadePecasCortadas());
			stmt.setDate(4, corteCostura.getDataCorte());
			stmt.setString(5, null);

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public void remover(CorteCostura corteCostura) {
		try {
			String sql = "DELETE FROM Corte_Costura WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, corteCostura.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(CorteCostura corteCostura) {

		try {
			String sql = "UPDATE Corte_Costura SET" + " valor_Corte = ?, "
					+ " valor_Costura = ?, " + "qtd_Peca_Cortada = ?, "
					+ "data = ?" + "WHERE id = ? ";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setFloat(1, corteCostura.getValorCorte());
			stmt.setFloat(2, corteCostura.getValorCostura());
			stmt.setInt(3, corteCostura.getQuantidadePecasCortadas());
			stmt.setDate(4, corteCostura.getDataCorte());
			stmt.setInt(5, corteCostura.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * MovimentaÃ§Ã£o dos dados da tabela Encomenda
	 * 
	 */

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

	/**
	 * MovimentaÃ§Ã£o dos dados da tabela Estoque
	 * 
	 */

	@Override
	public void adicionar(Estoque estoque) {

		try {
			String sql = "INSERT INTO Estoque " + " VALUES ( ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, estoque.getQuantidade());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@Override
	public void alterar(Estoque estoque, int codigoModelo) {

		try {
			String sql = "update Estoque set qtd_Grade = ? "
					   + "where Estoque.Modelocodigo = ? and Gradecodigo in "
					   + "(select codigo from Grade "
					   + "where letra = ?) ";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, estoque.getQuantidade());
			stmt.setInt(2, codigoModelo);
			stmt.setString(3,estoque.getGrade().getLetra());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * MovimentaÃ§Ã£o dos dados da tabela Fornecedor
	 * 
	 */

	@Override
	public void adicionar(Fornecedor fornecedor) {

		try {
			String sql = "INSERT INTO Fornecedor " + " VALUES ( ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);


			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getTelefoneFornecedor());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Fornecedor fornecedor) {

		try {
			String sql = "DELETE FROM Fornecedor WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, fornecedor.getId());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Fornecedor fornecedor) {

		try {
			String sql = "UPDATE Fornecedor SET" + " nome = ?,"
					+ "telefone = ? " + "WHERE id = ? ";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getTelefoneFornecedor());
			stmt.setInt(3, fornecedor.getId());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * MovimentaÃ§Ã£o dos dados da tabela Grade
	 * 
	 */

	@Override
	public void adicionar(Grade grade) {

		try {
			String sql = "INSERT INTO Grade " + " VALUES ( ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, grade.getCodigo());
			stmt.setInt(2, grade.getNumTamanhoMaximo());
			stmt.setInt(3, grade.getNumTamanhoMinimo());
			stmt.setString(4, grade.getLetra());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Grade grade) {

		try {
			String sql = "DELETE FROM Grade WHERE codigo = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, grade.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Grade grade) {

		try {
			String sql = "UPDATE Grade SET" + " num_Tamanho_Minimo = ?,"
					+ " num_Tamanho_Maximo = ?, " + "letra = ? "
					+ "WHERE codigo = ? ";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, grade.getNumTamanhoMinimo());
			stmt.setInt(2, grade.getNumTamanhoMaximo());
			stmt.setString(3, grade.getLetra());
			stmt.setInt(4, grade.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * MovimentaÃ§Ã£o dos dados da tabela Lucro
	 * 
	 */

	@Override
	public void adicionar(RelatorioLucro lucro) {

		try {

			String sql = "INSERT INTO Lucro " + " VALUES ( ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(3, lucro.getCapital().getCodigo());
			stmt.setDate(1, lucro.getMesAno());
			stmt.setDouble(2, lucro.getLucroMes());
			stmt.execute();
			for (Venda v : lucro.getVenda()) {
				sql = "update Venda set Lucrocodigo = ?  where codigo = ?";
				PreparedStatement stmt2 = con.prepareStatement(sql);
				stmt2.setInt(1,lucro.getCodigo());
				stmt2.setInt(2,v.getCodigo());
				stmt2.executeUpdate();
			}
			for(Encomenda en : lucro.getEncomenda()){
				sql = "update Encomenda set Lucrocodigo = ?  where codigo = ?";
				PreparedStatement stmt2 = con.prepareStatement(sql);
				stmt2.setInt(1,lucro.getCodigo());
				stmt2.setInt(2,en.getCodigo());
				stmt2.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Integer codigoVenda) {

		try {
			String sql = "DELETE FROM Lucro WHERE VendaCodigo = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			// precisa pegar apenas um codigo de uma venda ja realizada
			stmt.setInt(1, codigoVenda);

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(RelatorioLucro lucro) {

		try {
			String sql = "UPDATE Item_Peca SET" + " data = ?,"
					+ " lucro_Mensal = ? " + "WHERE VendaCodigo = ?";

			PreparedStatement stmt = con.prepareStatement(sql);

			for (Venda v : lucro.getVenda()) {

				stmt.setDate(1, lucro.getMesAno());
				stmt.setDouble(2, lucro.getLucroMes());
				stmt.setInt(3, v.getCodigo());

				stmt.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * MovimentaÃ§Ã£o dos dados da tabela Modelagem
	 * 
	 */
//  m�todo alterado
	@Override
	public void adicionar(Modelagem modelagem) {

		try {
			String sql = "INSERT INTO Modelagem " + " VALUES (  ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);


			stmt.setDouble(1, modelagem.getValor());
			stmt.setDate(2,modelagem.getDataModelagem());
			stmt.setString(3,null);

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Modelagem modelagem) {

		try {
			String sql = "DELETE FROM Modelagem WHERE VendaCodigo = ?";
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

	/**
	 * MovimentaÃ§Ã£o dos dados da tabela Modelo
	 * 
	 */
//  M�todo alterado e deve constar no novo dao
	@Override
	public void adicionar(Modelo modelo) {
		
		try {
			String sql = "INSERT INTO Modelo(modelo, margem_Custo, preco_custo, PilotoCodigo, ModelagemCodigo, Corte_Costuracodigo, TecidoCodigo)  "
					+ " VALUES ( ?, ?, ?, ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, modelo.getModelo());
			stmt.setDouble(2, modelo.getMargemCusto());
			stmt.setDouble(3, modelo.getCustoConfeccao());
			
			if(modelo.getPiloto() == null) stmt.setString(4, null);
			else stmt.setInt(4, modelo.getPiloto().getCodigo());
			
			if(modelo.getModelagem() == null )  stmt.setString(5, null);
			else stmt.setInt(5, modelo.getModelagem().getCodigo());
			
			if(modelo.getCorteCostura()!= null) stmt.setInt(6, modelo.getCorteCostura().getCodigo());
			else stmt.setString(6,null);
			
			System.out.println( modelo.getTecido().getCodigo());
			stmt.setInt(7, modelo.getTecido().getCodigo());
			
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String sql = "INSERT INTO Capital_Modelo " + " VALUES ( ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, modelo.getCodigo());
			stmt.setString(2, null);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String sql = "select max(codigo) as maximo from modelo";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rt = stmt.executeQuery();
			rt.next();
			modelo.setCodigo(rt.getInt("maximo"));
			sql = "INSERT INTO Item_Peca " + " VALUES ( ?, ?, ?, ?, ? ) ";
			stmt = con.prepareStatement(sql);

			for (ItemPeca ip : modelo.getItemPeca()) {
				stmt.setInt(1, ip.getAviamento().getCodigo());
				stmt.setInt(2, modelo.getCodigo());
				stmt.setDouble(3, ip.getQuantidadeAviamento());
				stmt.setDouble(4, ip.getValorAviamento());
				stmt.setString(5, null);
				stmt.executeUpdate();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Modelo modelo, Integer codigoAviamento) {

		try {
			String sql = "DELETE FROM Modelo WHERE Codigo = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, modelo.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String sql = "DELETE FROM Capital_Modelo WHERE ModeloCodigo = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, modelo.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String sql = "DELETE FROM Item_Peca WHERE AviamentoCodigo = ? AND"
					+ "ModeloCodigo = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, codigoAviamento);
			stmt.setInt(2, modelo.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Modelo modelo) {

		try {
			String sql = "UPDATE Modelo SET" + " modelo = ?,"
					+ " margem_Custo = ?," + "preco_Custo = ?,"
					+ "PilotoCodigo = ?," + "ModelagemCodigo = ?,"
					+ "Corte_CosturaCodigo = ?," + "TecidoCodigo = ? "
					+ "WHERE codigo = ?";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, modelo.getModelo());
			stmt.setFloat(2, modelo.getMargemCusto());
			stmt.setFloat(3, modelo.getCustoConfeccao());
			stmt.setInt(4, modelo.getPiloto().getCodigo());
			stmt.setInt(5, modelo.getModelagem().getCodigo());
			stmt.setInt(6, modelo.getCorteCostura().getCodigo());
			stmt.setInt(7, modelo.getTecido().getCodigo());
			stmt.setInt(8, modelo.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String sql = "UPDATE Item_Peca SET" + " qtd_Aviamento = ?,"
					+ " valor_Item_Peca = ? "
					+ "WHERE AviamentoCodigo = ? AND " + "ModeloCodigo = ?";

			PreparedStatement stmt = con.prepareStatement(sql);

			for (ItemPeca ip : modelo.getItemPeca()) {

				stmt.setDouble(1, ip.getQuantidadeAviamento());
				stmt.setDouble(2, ip.getValorAviamento());
				stmt.setInt(3, ip.getAviamento().getCodigo());
				stmt.setInt(4, modelo.getCodigo());

				stmt.executeUpdate();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * MovimentaÃ§Ã£o dos dados da tabela Piloto
	 * 
	 */
// M�todo alterado
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

	/**
	 * MovimentaÃ§Ã£o dos dados da tabela Tecido
	 * 
	 */
// m�todo alterado
	@Override
	public void adicionar(Tecido tecido) {

		try {
			String sql = "INSERT INTO Tecido "
					+ " VALUES (  ?, ?, ?, ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement(sql);


			stmt.setDate(1, tecido.getData());
			stmt.setDouble(2, tecido.getValor());
			stmt.setInt(3, tecido.getQuantidade());
			stmt.setString(4, tecido.getTipo());
			stmt.setString(5, tecido.getCor());
			stmt.setInt(6, tecido.getFornecedor().getId());
			stmt.setString(7,null);

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Tecido tecido) {

		try {
			String sql = "DELETE FROM Tecido WHERE Codigo = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, tecido.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Tecido tecido) {

		try {
			String sql = "UPDATE Tecido SET" + " data = ?,"
					+ " valor_Unitario = ?, " + "qtd_Rolo = ?, " + "tipo = ?, "
					+ "cor = ?, " + "FornecedorId = ? " + "WHERE codigo = ?";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setDate(1, tecido.getData());
			stmt.setFloat(2, tecido.getValor());
			stmt.setInt(3, tecido.getQuantidade());
			stmt.setString(4, tecido.getCor());
			stmt.setInt(5, tecido.getFornecedor().getId());
			stmt.setInt(6, tecido.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * MovimentaÃ§Ã£o dos dados da tabela Venda
	 * 
	 */

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
	public List<Aviamento> buscarAviamento() {

		List<Aviamento> aviamento = new ArrayList<>();
		try {
			String sql = "select * from Aviamento";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Aviamento a = new Aviamento();
				a.setCodigo(rs.getInt("codigo"));
				a.setDataCompra(rs.getDate("data_Aviamento"));
				a.setValorCompra(rs.getFloat("valor_Unitario"));
				a.setNome(rs.getString("nome"));
				/**
				 * ver depois como fazer *
				 */
				a.setFornecedor(null);
				aviamento.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aviamento;

	}

	@Override
	public List<Capital> buscarCapital() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarCliente() {

		List<Cliente> cliente = new ArrayList<>();
		try {
			String sql = "select * from cliente";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente a = new Cliente();
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nome"));
				a.setTelefoneContato(rs.getString("telefone"));
				cliente.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;

	}

	@Override
	public List<CorteCostura> buscarCorteCostura() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Encomenda> buscarEncomenda() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estoque> buscarEstoque() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornecedor> buscarFornecedor() {
		List<Fornecedor> fornecedor = new ArrayList<>();
		try {
			String sql = 
				"select * from fornecedor";
			PreparedStatement stmt = con.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Fornecedor a = new Fornecedor();
				a.setId( rs.getInt("id")  );
				a.setNome( rs.getString("nome")  );
				a.setTelefoneFornecedor( rs.getString("telefone")  );
				
				fornecedor.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fornecedor;
	}

	@Override
	public List<Grade> buscarGrade() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Modelagem> buscarModelagem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Modelo> buscarModelo() {
		return null;
	}

	@Override
	public Set<Modelo> buscarModelo1() {
		Set<Modelo> modelos = new HashSet<>();
		String sql = "Select *   from Modelo ";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rt = stmt.executeQuery();
			while (rt.next()) {
				Modelo mod = new Modelo();
				mod.setCodigo(rt.getInt("codigo"));
				mod.setCustoConfeccao(rt.getFloat("preco_Custo"));
				mod.setMargemCusto(rt.getFloat("margem_Custo"));
				mod.setModelo(rt.getString("modelo"));
				modelos.add(mod);
			}
			rt.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return modelos;
	}

	@Override
	public List<Motorista> buscarMotorista() {
		List<Motorista> motorista = new ArrayList<>();
		try {
			String sql = "select * from motorista";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Motorista a = new Motorista();
				a.setNumPlaca(rs.getString("num_Placa"));
				a.setNome(rs.getString("nome"));
				a.setTelefoneContato(rs.getString("telefone"));

				motorista.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return motorista;

	}

	@Override
	public List<Piloto> buscarPiloto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RelatorioLucro> buscarRelatorioLucro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tecido> buscarTecido() {
		List<Tecido> tecido = new ArrayList<>();
		try {
			String sql = 
				"select * from tecido";
			PreparedStatement stmt = con.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Tecido t = new Tecido();
				Fornecedor fornecedor = new Fornecedor();
				
				t.setCodigo( rs.getInt("codigo")  );
				t.setData(rs.getDate("data_Tecido"));
				t.setValor( rs.getFloat("valor_Unitario") );
				t.setQuantidade( rs.getInt("qtd_Rolo"));
				t.setTipo(rs.getString("tipo"));
				t.setCor(rs.getString("cor"));
				fornecedor.setId(rs.getInt("Fornecedorid"));
				t.setFornecedor(fornecedor);
				
				tecido.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tecido;
	}

	@Override
	public List<Venda> buscarVenda() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verificarUsuario(String usuario, String senha) {
		boolean existe = false;
		String sql;
		try {

			if (tipoBanco == "mariadb") {
				sql = "select * from usuarios " + "WHERE nome = ? AND "
						+ "senha = MD5(?)";
			} else {
				sql = "select PWDCOMPARE(?, senha) as valido from usuarios "
						+ "WHERE nome = ?";
			}
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, senha);
			stmt.setString(2, usuario);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				existe = true;
			} else {
				existe = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return existe;
	}
	
	
	@Override
	public Aviamento buscaEspecifico(Aviamento aviamento) {
		
		try {
			String sql = 
				  "select av.codigo, av.data_Aviamento, av.valor_Unitario,"
			    + "forn.id AS codigo_fornecedor, forn.nome AS nome_fornecedor "
			    + "from aviamento av, Fornecedor forn"
			    + " where forn.id = av.Fornecedorid AND av.nome like ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setString(1, "%" + aviamento.getNome() + "%");
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Fornecedor forn = new Fornecedor();
				aviamento.setCodigo( rs.getInt("codigo")  );
				aviamento.setDataCompra( rs.getDate("data_Aviamento")  );
				aviamento.setValorCompra( rs.getFloat("valor_Unitario")  );
				forn.setId(rs.getInt("codigo_fornecedor"));
				forn.setNome(rs.getString("nome_fornecedor"));
				aviamento.setFornecedor( forn );
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aviamento;
		
	}

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
	
	public int ultimoCadastroModelagem(){
		String sql = "select max(codigo) as maximo from modelagem";
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

	@Override
	public void remover(Estoque estoque) {
		// TODO Auto-generated method stub
		
	}



}
