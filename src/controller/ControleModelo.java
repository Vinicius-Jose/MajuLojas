package controller;

import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import model.Aviamento;
import model.Modelo;
import model.Tecido;
import dao.MajuModasDAOAviamento;
import dao.MajuModasDAOImplAviamento;
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
	
	public void adicionarModelo(Modelo modelo){
		if(modelo.getPiloto()!=null){
			bdPiloto.adicionar(modelo.getPiloto());
			bdModelagem.adicionar(modelo.getModelagem());
			modelo.getPiloto().setCodigo(bdPiloto.ultimoCadastroPiloto());
			modelo.getModelagem().setCodigo(bdModelagem.ultimoCadastroModelagem());
		}
		bdModelo.adicionar(modelo);
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
