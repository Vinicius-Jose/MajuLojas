package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.*;


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
	public void Remover(Motorista motorista) {
		
		try {			
			String sql = "DELETE Motorista " +
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
	public void Alterar(Motorista motoriste) {
		// TODO Auto-generated method stub
		
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
	public void Remover(Aviamento aviamento) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void Alterar(Aviamento aviamento) {
		// TODO Auto-generated method stub
		
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
	public void Remover(Capital capital) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void Alterar(Capital capital) {
		// TODO Auto-generated method stub
		
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
	public void Remover(Cliente cliente) {
		
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
	public void Alterar(Cliente cliente) {
		// TODO Auto-generated method stub
		
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
	public void Remover(CorteCostura corteCostura) {
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
	public void Alterar(CorteCostura corteCostura) {
		// TODO Auto-generated method stub
		
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
		
		
	}


	
	
	

	@Override
	public void Remover(Encomenda encomenda) {
		try {			
			String sql = "DELETE FROM Encomenda WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, encomenda.getCodigo() );
				
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}






	@Override
	public void Alterar(Encomenda encomenda) {
		// TODO Auto-generated method stub
		
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
	public void Remover(Estoque estoque) {
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
	public void Alterar(Estoque estoque) {
		// TODO Auto-generated method stub
		
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
	public void Remover(Fornecedor fornecedor) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void Alterar(Fornecedor fornecedor) {
		// TODO Auto-generated method stub
		
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
	public void Remover(Grade grade) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void Alterar(Grade grade) {
		// TODO Auto-generated method stub
		
	}



	/**
	 * Movimentação dos dados da tabela Item_Encomenda
	 * 
	 */


	@Override
	public void adicionar(ItemEncomenda itemEncomenda) {
		
		try {			
			String sql = "INSERT INTO Item_Encomenda " +
					" VALUES ( ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			stmt.setInt(1, itemEncomenda.getQuantidade() );
			stmt.setDouble(2, itemEncomenda.getValorItemEncomenda() );
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void Remover(ItemEncomenda itemEncomenda) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void Alterar(ItemEncomenda itemEncomenda) {
		// TODO Auto-generated method stub
		
	}



	/**
	 * Movimentação dos dados da tabela Item_Peca
	 * 
	 */


	@Override
	public void adicionar(ItemPeca itemPeca) {
		
		try {			
			String sql = "INSERT INTO Item_Peca " +
					" VALUES ( ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			
			stmt.setDouble(1, itemPeca.getQuantidadeAviamento() );
			stmt.setDouble(2, itemPeca.getValorAviamento() );
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void Remover(ItemPeca itemPeca) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void Alterar(ItemPeca itemPeca) {
		// TODO Auto-generated method stub
		
	}



	/**
	 * Movimentação dos dados da tabela Item_Venda
	 * 
	 */


	@Override
	public void adicionar(ItemVenda itemVenda) {
		
		
		
		
	}






	@Override
	public void Remover(ItemVenda itemVenda) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void Alterar(ItemVenda itemVenda) {
		// TODO Auto-generated method stub
		
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
		
			stmt.setDate(3, lucro.getMesAno() );
			stmt.setDouble(4, lucro.getLucroMes() );
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public void Remover(RelatorioLucro lucro) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void Alterar(RelatorioLucro lucro) {
		// TODO Auto-generated method stub
		
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
	public void Remover(Modelagem modelagem) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void Alterar(Modelagem modelagem) {
		// TODO Auto-generated method stub
		
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
			String sql = "INSERT INTO Modelo " +
					" VALUES ( ?, ?, ?, ?, ?, ?, ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void Remover(Modelo modelo) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void Alterar(Modelo modelo) {
		// TODO Auto-generated method stub
		
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
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}






	@Override
	public void Remover(Piloto piloto) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void Alterar(Piloto piloto) {
		// TODO Auto-generated method stub
		
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
	public void Remover(Tecido tecido) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void Alterar(Tecido tecido) {
		// TODO Auto-generated method stub
		
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
					" VALUES ( ?, ? ) ";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			for (venda.getItemVenda() a : venda.getItemVenda()) {
				
			}
				
			
			
			
			
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}






	@Override
	public void Remover(Venda venda) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void Alterar(Venda venda) {
		// TODO Auto-generated method stub
		
	}


	
	
	

	

}
