package controller;

import model.Motorista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;

public class ControleMotorista implements ActionListener{
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtPlaca;
	private JButton btnSalvar;
	private JButton btnCancelar;
	
	public ControleMotorista(JTextField txtNome, JTextField txtFone, JTextField txtPlaca, JButton btnSalvar,
	JButton btnCancelar) {
		super();
		this.txtNome = txtNome;
		this.txtFone = txtFone;
		this.txtPlaca = txtPlaca;
		this.btnSalvar = btnSalvar;
		this.btnCancelar = btnCancelar;
	}

	private MajuModasDAO banco = new MajuModasDAOImpl();
	public void adicionarMotorista(Motorista motorista){
		banco.adicionar(motorista);
		JOptionPane.showMessageDialog(null, "Motorista adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Motorista buscar(Motorista motorista){
		List<Motorista> listaMotorista = banco.buscarMotorista();
		return (Motorista) listaMotorista;
	}
	
	public void alterar(Motorista motorista){
		banco.alterar(motorista);
		JOptionPane.showMessageDialog(null, "Motorista alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		Motorista motorista = new Motorista();
		motorista.setNome(txtNome.getText());
		motorista.setTelefoneContato(txtFone.getText());
		motorista.setNumPlaca(txtPlaca.getText());
		if(a.getActionCommand().equals("Salvar")) {
			adicionarMotorista(motorista);
		}else 
			if(a.getActionCommand().equals("Cancelar")) {
				txtNome.setText("");
				txtFone.setText("");
				txtPlaca.setText("");
			}
		    if(a.getActionCommand().equals("Pesquisar")) {
		    	buscar(motorista);
		    }
		    if(a.getActionCommand().equals("Alterar")) {
		    	alterar(motorista);
		    }
	}
	
}
