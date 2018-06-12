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

public class ControleModelo implements ActionListener{
	private JTextField txtModelo;
	private JTextField txtQtdRolo;
	private JTextField txtQtdAviamento;
	private JFormattedTextField txtData;
	private JTextField txtModelagem;
	private JTextField qtdRolo;
	private JTextField txtMargemCusto;
	private JTextField txtCustoConfecção;
	private JRadioButton rbtnSim;
	private JRadioButton rbtnNao;
	private JComboBox<Aviamento> cbAviamento;
	private JButton btnAdicionar;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnAlterar;
	private JComboBox<Tecido> cbTecido;
	
	private MajuModasDAO banco = new MajuModasDAOImpl();
	
	
	
	public ControleModelo(JTextField txtModelo, JTextField txtQtdRolo, JTextField txtQtdAviamento,
			JFormattedTextField txtData, JTextField txtModelagem, JTextField qtdRolo, JTextField txtMargemCusto,
			JTextField txtCustoConfecção, JRadioButton rbtnSim, JRadioButton rbtnNao, JComboBox<Aviamento> cbAviamento,
			JButton btnAdicionar, JButton btnSalvar, JButton btnCancelar, JButton btnAlterar,
			JComboBox<Tecido> cbTecido) {
		super();
		this.txtModelo = txtModelo;
		this.txtQtdRolo = txtQtdRolo;
		this.txtQtdAviamento = txtQtdAviamento;
		this.txtData = txtData;
		this.txtModelagem = txtModelagem;
		this.qtdRolo = qtdRolo;
		this.txtMargemCusto = txtMargemCusto;
		this.txtCustoConfecção = txtCustoConfecção;
		this.rbtnSim = rbtnSim;
		this.rbtnNao = rbtnNao;
		this.cbAviamento = cbAviamento;
		this.btnAdicionar = btnAdicionar;
		this.btnSalvar = btnSalvar;
		this.btnCancelar = btnCancelar;
		this.btnAlterar = btnAlterar;
		this.cbTecido = cbTecido;
	}

	public void adicionarModelo(Modelo modelo){
		banco.adicionar(modelo);
		JOptionPane.showMessageDialog(null, "Modelo adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Modelo buscar(Modelo modelo){
		List<Modelo> listaModelo = banco.buscarModelo();
		return (Modelo) listaModelo;
	}
	
	public void alterar(Modelo modelo){
		banco.alterar(modelo);
		JOptionPane.showMessageDialog(null, "Modelo alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public List<Aviamento> buscarAviamentos(){
		List<Aviamento> listaAviamento = banco.buscarAviamento();
		return listaAviamento;
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Modelo modelo = new Modelo();
		modelo.setModelo(txtModelo.getText());
		// modelo.set
		try {
			modelo.setDtCastastroPeca(new java.sql.Date(sdf.parse(txtData.getText()).getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(cbAviamento.getSelectedItem() != null) {
			modelo = (Modelo) cbAviamento.getSelectedItem();
		}
		if(cbTecido.getSelectedItem() != null) {
			modelo = (Modelo) cbTecido.getSelectedItem();
		}
		
	}
	
}
