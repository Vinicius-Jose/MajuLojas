package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public MajuModasDAOImpl() { 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String urlDb = "jdbc:mariadb://localhost:3306/MajuModas?allowMultiQueries=true";
			con = DriverManager.getConnection(urlDb, "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Movimentação dos dados da tabela Motorista
	 *
	 */
	
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
					+ "nome = ?' , "
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



	/**
	 * Movimentação dos dados da tabela Aviamento
	 * 
	 */


	@Override
	public void adicionar(Aviamento aviamento) {
		try {			
			String sql = "INSERT INTO Aviamento " +
					" VALUES ( ?, ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, aviamento.getCodigo() );
			stmt.setDate(2, aviamento.getDataCompra() );
			stmt.setDouble(3, aviamento.getValorCompra() );
			stmt.setString(4, aviamento.getNome() );
			stmt.setInt(5, aviamento.getFornecedor().getId() );
			
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
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, aviamento.getCodigo() );
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}






	@Override
	public void alterar(Aviamento aviamento) {
		
		try {			
			String sql = "UPDATE Aviamento SET"
					+ " data = ?' ,"
					+ " valor_Unitario = ?,"
					+ " nome = ?,"
					+ " FornecedorId = ? "
					+ "WHERE codigo = ? ";
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setDate(1, aviamento.getDataCompra() );
			stmt.setDouble(2, aviamento.getValorCompra() );
			stmt.setString(3, aviamento.getNome() );
			stmt.setInt(4, aviamento.getFornecedor().getId());
			stmt.setInt(5, aviamento.getCodigo());
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}




	/**
	 * Movimentação dos dados da tabela Capital
	 * 
	 */

	@Override
	public void adicionar(Capital capital) {

		
		try {			
			String sql = "INSERT INTO Capital " +
					" VALUES ( ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, capital.getCodigo());
			stmt.setDate(2, capital.getMesAno() );
			stmt.setDouble(3, capital.getValorCapital() );
			
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
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, capital.getCodigo() );
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}






	@Override
	public void alterar(Capital capital) {
		
		try {			
			String sql = "UPDATE Capital SET"
					+ " data = ?, "
					+ " valor_Capital = ?"
					+ "WHERE codigo = ? ";
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setDate(1, capital.getMesAno() );
			stmt.setDouble(2, capital.getValorCapital() );
			stmt.setInt(3, capital.getCodigo() );
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}




	/**
	 * Movimentação dos dados da tabela Cliente
	 * 
	 */


	@Override
	public void adicionar(Cliente cliente) {
		
		try {			
			String sql = "INSERT INTO Cliente " +
					" VALUES ( ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, cliente.getId() );
			stmt.setString(2, cliente.getNome() );
			stmt.setString(3, cliente.getTelefoneContato() );
			
			
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
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, cliente.getId() );
				
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void alterar(Cliente cliente) {
		
		try {			
			String sql = "UPDATE Cliente SET"
					+ " nome = ? ,"
					+ " telefone = ?"
					+ "WHERE id = ? ";
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setString(1, cliente.getNome() );
			stmt.setString(2, cliente.getTelefoneContato() );
			stmt.setInt(3, cliente.getId() );
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}




	/**
	 * Movimentação dos dados da tabela Corte_Costura
	 * 
	 */

	@Override
	public void adicionar(CorteCostura corteCostura) {
		
		try {			
			String sql = "INSERT INTO Corte_Costura " +
					" VALUES ( ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, corteCostura.getCodigo());
			stmt.setDouble(2, corteCostura.getValorCorte() );
			stmt.setDouble(3, corteCostura.getValorCostura() );
			stmt.setInt(4, corteCostura.getQuantidadePecasCortadas() );
			stmt.setDate(5, corteCostura.getDataCorte() );
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void remover(CorteCostura corteCostura) {
		try {			
			String sql = "DELETE FROM Corte_Costura WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, corteCostura.getCodigo() );
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}






	@Override
	public void alterar(CorteCostura corteCostura) {
		
		try {			
			String sql = "UPDATE Corte_Costura SET"
					+ " valor_Corte = ?, "
					+ " valor_Costura = ?, "
					+ "qtd_Peca_Cortada = ?, "
					+ "data = ?"
					+ "WHERE id = ? ";
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setFloat(1, corteCostura.getValorCorte() );
			stmt.setFloat(2, corteCostura.getValorCostura() );
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
	 * Movimentação dos dados da tabela Encomenda
	 * 
	 */


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



	/**
	 * Movimentação dos dados da tabela Estoque
	 * 
	 */


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
	public void remover(Estoque estoque) {
		try {			
			String sql = "DELETE FROM Estoque WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, estoque.getId() );
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}






	@Override
	public void alterar(Estoque estoque) {
		
		try {			
			String sql = "UPDATE Estoque SET"
					+ " qtd_Grade = ? "
					+ "WHERE id = ? ";
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, estoque.getQuantidade() );
			stmt.setInt(2, estoque.getId() );
			
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	/**
	 * Movimentação dos dados da tabela Fornecedor
	 * 
	 */


	@Override
	public void adicionar(Fornecedor fornecedor) {
		
		try {			
			String sql = "INSERT INTO Fornecedor " +
					" VALUES ( ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, fornecedor.getId() );
			stmt.setString(2, fornecedor.getNome() );
			stmt.setString(3, fornecedor.getTelefoneFornecedor() );
			
			
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
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, fornecedor.getId() );
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void alterar(Fornecedor fornecedor) {
		
		try {			
			String sql = "UPDATE Fornecedor SET"
					+ " nome = ?,"
					+ "telefone = ? "
					+ "WHERE id = ? ";
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setString(1, fornecedor.getNome() );
			stmt.setString(2, fornecedor.getTelefoneFornecedor() );
			stmt.setInt(3, fornecedor.getId());
			
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	/**
	 * Movimentação dos dados da tabela Grade
	 * 
	 */


	@Override
	public void adicionar(Grade grade) {
		
		try {			
			String sql = "INSERT INTO Grade " +
					" VALUES ( ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, grade.getCodigo() );
			stmt.setInt(2, grade.getNumTamanhoMaximo() );
			stmt.setInt(3, grade.getNumTamanhoMinimo() );
			stmt.setString(4, grade.getLetra() );
			
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
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, grade.getCodigo() );
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void alterar(Grade grade) {
		
		try {			
			String sql = "UPDATE Grade SET"
					+ " num_Tamanho_Minimo = ?,"
					+ " num_Tamanho_Maximo = ?, "
					+ "letra = ? "
					+ "WHERE codigo = ? ";
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, grade.getNumTamanhoMinimo() );
			stmt.setInt(2, grade.getNumTamanhoMaximo() );
			stmt.setString(3, grade.getLetra());
			stmt.setInt(4, grade.getCodigo());
			
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}





	/**
	 * Movimentação dos dados da tabela Lucro
	 * 
	 */


	
	@Override
	public void adicionar(RelatorioLucro lucro) {
		
		try {			
			
			String sql = "INSERT INTO Lucro " +
					" VALUES ( ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
		
			for (Venda v : lucro.getVenda()) {
				
			
			stmt.setInt(1, v.getCodigo());
			stmt.setInt(2, 0);
			stmt.setDate(3, lucro.getMesAno() );
			stmt.setDouble(4, lucro.getLucroMes() );
			
			stmt.executeUpdate();
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
			PreparedStatement stmt = con.prepareStatement( sql );
			
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
			String sql = "UPDATE Item_Peca SET"
					+ " data = ?,"
					+ " lucro_Mensal = ? "
					+ "WHERE VendaCodigo = ?";
					
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			for (Venda v : lucro.getVenda()) {
				
				
				stmt.setDate(1, lucro.getMesAno() );
				stmt.setDouble(2, lucro.getLucroMes() );
				stmt.setInt(3, v.getCodigo());
				
				stmt.executeUpdate();
				}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

	/**
	 * Movimentação dos dados da tabela Modelagem
	 * 
	 */


	@Override
	public void adicionar(Modelagem modelagem) {
		
		try {			
			String sql = "INSERT INTO Modelagem " +
					" VALUES ( ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, modelagem.getCodigo() );
			stmt.setDouble(2, modelagem.getValor() );
			stmt.setDate(3, modelagem.getDataModelagem() );
			
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
			PreparedStatement stmt = con.prepareStatement( sql );
			
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
			String sql = "UPDATE Modelagem SET"
					+ " valor_Unitario = ?,"
					+ " data = ? "
					+ "WHERE codigo = ?";
					
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setFloat(1, modelagem.getValor() );
			stmt.setDate(2, modelagem.getDataModelagem() );
			stmt.setInt(3, modelagem.getCodigo());
			
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	/**
	 * Movimentação dos dados da tabela Modelo
	 * 
	 */


	@Override
	public void adicionar(Modelo modelo) {
		
		try {			
			String sql = "INSERT INTO Modelo " +
					" VALUES ( ?, ?, ?, ?, ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, modelo.getCodigo() );
			stmt.setString(2, modelo.getModelo() );
			stmt.setDouble(3, modelo.getMargemCusto() );
			stmt.setDouble(4, modelo.getCustoConfeccao() );
			stmt.setInt(5, modelo.getPiloto().getCodigo() );
			stmt.setInt(6, modelo.getModelagem().getCodigo());
			stmt.setInt(7, modelo.getCorteCostura().getCodigo());
			stmt.setInt(8, modelo.getTecido().getCodigo());
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {			
			String sql = "INSERT INTO Capital_Modelo " +
					" VALUES ( ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			stmt.setInt(1, modelo.getCodigo());
			stmt.setInt(2, 0);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {			
			String sql = "INSERT INTO Item_Peca " +
					" VALUES ( ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			for (ItemPeca ip : modelo.getItemPeca()) {
				
			
			stmt.setInt(1, ip.getAviamento().getCodigo());
			//teria que pegar o codigo do modelo, ver onde pegar esse codigo depois
			stmt.setInt(2, modelo.getCodigo());
			stmt.setDouble(3, ip.getQuantidadeAviamento() );
			stmt.setDouble(4, ip.getValorAviamento() );
			
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
			PreparedStatement stmt = con.prepareStatement( sql );
			
			
			stmt.setInt(1, modelo.getCodigo());
			
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {			
			String sql = "DELETE FROM Capital_Modelo WHERE ModeloCodigo = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			
			stmt.setInt(1, modelo.getCodigo());
			
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {			
			String sql = "DELETE FROM Item_Peca WHERE AviamentoCodigo = ? AND"
					+ "ModeloCodigo = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
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
			String sql = "UPDATE Modelo SET"
					+ " modelo = ?,"
					+ " margem_Custo = ?,"
					+ "preco_Custo = ?,"
					+ "PilotoCodigo = ?,"
					+ "ModelagemCodigo = ?,"
					+ "Corte_CosturaCodigo = ?,"
					+ "TecidoCodigo = ? "
					+ "WHERE codigo = ?";
					
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setString(1, modelo.getModelo() );
			stmt.setFloat(2, modelo.getMargemCusto() );
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
			String sql = "UPDATE Item_Peca SET"
					+ " qtd_Aviamento = ?,"
					+ " valor_Item_Peca = ? "
					+ "WHERE AviamentoCodigo = ? AND "
					+ "ModeloCodigo = ?";
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			for (ItemPeca ip : modelo.getItemPeca()) {
				
				
				stmt.setDouble(1, ip.getQuantidadeAviamento() );
				stmt.setDouble(2, ip.getValorAviamento() );
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
	 * Movimentação dos dados da tabela Piloto
	 * 
	 */


	@Override
	public void adicionar(Piloto piloto) {
		
		try {			
			String sql = "INSERT INTO Piloto " +
					" VALUES ( ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, piloto.getCodigo() );
			stmt.setDouble(2, piloto.getValorPiloto() );
			stmt.setDate(3, piloto.getDataPiloto() );
			stmt.setInt(4, 0);
			
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
			PreparedStatement stmt = con.prepareStatement( sql );
			
			
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
			String sql = "UPDATE Modelagem SET"
					+ " valor_Unitrio = ?,"
					+ " data = ? "
					+ "WHERE codigo = ?";
					
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setFloat(1, piloto.getValorPiloto() );
			stmt.setDate(2, piloto.getDataPiloto() );
			stmt.setInt(3, piloto.getCodigo());
			
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	/**
	 * Movimentação dos dados da tabela Tecido
	 * 
	 */


	@Override
	public void adicionar(Tecido tecido) {
		
		try {			
			String sql = "INSERT INTO Tecido " +
					" VALUES ( ?, ?, ?, ?, ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, tecido.getCodigo() );
			stmt.setDate(2, tecido.getData() );
			stmt.setDouble(3, tecido.getValor() );
			stmt.setInt(4, tecido.getQuantidade() );
			stmt.setString(5, tecido.getTipo() );
			stmt.setString(6, tecido.getCor());
			stmt.setInt(7, tecido.getFornecedor().getId());
			
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
			PreparedStatement stmt = con.prepareStatement( sql );
			
			
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
			String sql = "UPDATE Tecido SET"
					+ " data = ?,"
					+ " valor_Unitario = ?, "
					+ "qtd_Rolo = ?, "
					+ "tipo = ?, "
					+ "cor = ?, "
					+ "FornecedorId = ? "
					+ "WHERE codigo = ?";
					
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setDate(1, tecido.getData() );
			stmt.setFloat(2, tecido.getValor() );
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
	 * Movimentação dos dados da tabela Venda
	 * 
	 */


	@Override
	public void adicionar(Venda venda) {
		
		try {			
			String sql = "INSERT INTO Venda " +
					" VALUES ( ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, venda.getCodigo() );
			stmt.setDate(2, venda.getDtVenda() );
			stmt.setDouble(3, venda.getValorTotal() );

			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {			
			String sql = "INSERT INTO Item_Venda " +
					" VALUES ( ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			for (ItemVenda a : venda.getItemVenda()) {
				stmt.setInt(1, a.getModelo().getCodigo());
				stmt.setInt(2, venda.getCodigo());
				stmt.setInt(3, a.getQuantidade());
				stmt.setDouble(4, a.getValorTotalPeca());
				
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
			PreparedStatement stmt = con.prepareStatement( sql );
			
			
			stmt.setInt(1, venda.getCodigo());
			
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {			
			String sql = "DELETE FROM Item_Venda WHERE Codigo = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			
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
			String sql = "UPDATE Venda SET"
					+ " data = ?,"
					+ " valor_Total = ?"
					+ "WHERE codigo = ?";
					
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setDate(1, venda.getDtVenda() );
			stmt.setFloat(2, venda.getValorTotal() );
			stmt.setInt(3, venda.getCodigo());
			
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {			
			String sql = "UPDATE Item_Venda SET"
					+ " qtd_Modelo_Vendido = ?,"
					+ " valor_ItemVenda = ? "
					+ "WHERE ModeloCodigo = ? AND "
					+ "VendaCodigo = ?";
					
			
			PreparedStatement stmt = con.prepareStatement( sql );
			
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
			String sql = 
				"select * from selecao";
			PreparedStatement stmt = con.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) { 
				Aviamento a = new Aviamento();
				a.setCodigo( rs.getInt("codigo")  );
				a.setDataCompra( rs.getDate("data")  );
				a.setValorCompra( rs.getFloat("valor_Unitario")  );
				a.setNome( rs.getString("nome")  );
				/** ver depois como fazer				*
				*/
				a.setFornecedor(  );
				aviamento.add( a );
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Motorista> buscarMotorista() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Venda> buscarVenda() {
		// TODO Auto-generated method stub
		return null;
	}



}
