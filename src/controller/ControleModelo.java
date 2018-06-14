package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Aviamento;
import model.Modelo;
import model.Tecido;
import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;

public class ControleModelo{

	
	private MajuModasDAO banco = new MajuModasDAOImpl();
	

	public void adicionarModelo(Modelo modelo){
		if(modelo.getPiloto()!=null){
			banco.adicionar(modelo.getPiloto());
			banco.adicionar(modelo.getModelagem());
			modelo.getPiloto().setCodigo(banco.ultimoCadastroPiloto());
			modelo.getModelagem().setCodigo(banco.ultimoCadastroModelagem());
		}
		banco.adicionar(modelo);
		JOptionPane.showMessageDialog(null, "Modelo adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public List<Modelo> buscar(){
		List<Modelo> listaModelo = banco.buscarModelo();
		return listaModelo;
	}
	
	public void alterar(Modelo modelo){
		banco.alterar(modelo);
		JOptionPane.showMessageDialog(null, "Modelo alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public List<Aviamento> buscarAviamentos(){
		List<Aviamento> listaAviamento = banco.buscarAviamento();
		return listaAviamento;
	}
	
	public List<Tecido> buscarTecidos(){
		List<Tecido> listaTecido = banco.buscarTecido();
		return listaTecido;
	}
	
	public Aviamento buscarAviamentoEs(String nome){
		Aviamento av = new Aviamento();
		av.setNome(nome);
		System.out.println(nome);
		return banco.buscaEspecifico(av);
	}
	
	

	
	
}
