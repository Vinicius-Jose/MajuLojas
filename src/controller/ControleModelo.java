/**
 * @autor Vinícius José
 */
package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import model.Aviamento;
import model.Estoque;
import model.Grade;
import model.Modelo;
import model.Tecido;
import dao.MajuModasDAOAviamento;
import dao.MajuModasDAOEstoque;
import dao.MajuModasDAOGrade;
import dao.MajuModasDAOImplAviamento;
import dao.MajuModasDAOImplEstoque;
import dao.MajuModasDAOImplGrade;
import dao.MajuModasDAOImplModelagem;
import dao.MajuModasDAOImplModelo;
import dao.MajuModasDAOImplPiloto;
import dao.MajuModasDAOImplTecido;
import dao.MajuModasDAOModelagem;
import dao.MajuModasDAOModelo;
import dao.MajuModasDAOPiloto;
import dao.MajuModasDAOTecido;

public class ControleModelo{

	
	private MajuModasDAOModelo bdModelo = new MajuModasDAOImplModelo();
	private MajuModasDAOPiloto bdPiloto = new MajuModasDAOImplPiloto();
	private MajuModasDAOModelagem bdModelagem = new MajuModasDAOImplModelagem();
	private MajuModasDAOAviamento bdAviamento = new MajuModasDAOImplAviamento();
	private MajuModasDAOTecido bdTecido = new MajuModasDAOImplTecido();
	private MajuModasDAOGrade bdGrade = new MajuModasDAOImplGrade();
	private MajuModasDAOEstoque  bdEstoque = new MajuModasDAOImplEstoque();
	
	
	public void adicionarModelo(Modelo modelo){
		if(modelo.getPiloto()!=null){
			bdPiloto.adicionar(modelo.getPiloto());
			bdModelagem.adicionar(modelo.getModelagem());
			modelo.getPiloto().setCodigo(bdPiloto.ultimoCadastroPiloto());
			modelo.getModelagem().setCodigo(bdModelagem.ultimoCadastroModelagem());
		}
		bdModelo.adicionar(modelo);
		List<Grade> grade = bdGrade.buscarGrade();
		for(Grade a : grade){
			Estoque estoque = new Estoque();
			estoque.setGrade(a);
			try {
				bdEstoque.adicionar(estoque, bdModelo.ultimoModelo());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, "Modelo adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Set<Modelo> buscar(){
		Set<Modelo> listaModelo = bdModelo.buscarModeloInfoBasica();
		return listaModelo;
	}
	
	public void alterar(Modelo modelo){
		bdModelo.alterar(modelo);
		JOptionPane.showMessageDialog(null, "Modelo alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public List<Aviamento> buscarAviamentos(){
		List<Aviamento> listaAviamento = bdAviamento.buscarAviamento();
		return listaAviamento;
	}
	
	public List<Tecido> buscarTecidos(){
		List<Tecido> listaTecido = bdTecido.buscarTecido();
		return listaTecido;
	}
	
	public Aviamento buscarAviamentoEspecifico(String nome){
		Aviamento av = new Aviamento();
		av.setNome(nome);
		System.out.println(nome);
		return bdAviamento.buscaEspecifico(av);
	}
	
	

	
	
}
