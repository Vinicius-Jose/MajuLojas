package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import dao.MajuModasDAO;
import dao.MajuModasDAOEstoque;
import dao.MajuModasDAOImpl;
import dao.MajuModasDAOImplEstoque;

import model.Estoque;
import model.Modelo;

public class ControleEstoque {
	

	private MajuModasDAO banco = new MajuModasDAOImpl();
	private MajuModasDAOEstoque bdEstoque  = new MajuModasDAOImplEstoque();
	
	public Set<Modelo> buscarModelos(){
		Set<Modelo> listaModelo = banco.buscarModelo1();
		return listaModelo;
	}
	
	public List<HashMap<String, Object>> buscarEstoque(Modelo modelo){
		return bdEstoque.buscarEspecifico(modelo);
	}

}
