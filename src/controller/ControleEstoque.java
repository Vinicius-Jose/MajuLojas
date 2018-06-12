package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;

import model.Estoque;
import model.Modelo;

public class ControleEstoque implements ActionListener, TableModel{
	private JButton btnPesquisar;
	private JComboBox<Modelo> cbModelo;
	private JTable tabela;
	private List<Estoque> estoque;
	
	
	
	public ControleEstoque(JButton btnPesquisar, JComboBox<Modelo> cbModelo) {
		super();
		this.btnPesquisar = btnPesquisar;
		this.cbModelo = cbModelo;
	}

	private MajuModasDAO banco = new MajuModasDAOImpl();
	
	public List<Modelo> buscarModelos(){
		List<Modelo> listaModelo = banco.buscarModelo();
		return listaModelo;
	}
	
	public List<Estoque> buscarEstoque(Modelo modelo){
		estoque = banco.buscarEstoque();
		return estoque;
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		Modelo modelo = new Modelo();
		if(cbModelo.getSelectedItem() != null) {
			modelo = (Modelo) cbModelo.getSelectedItem();
		}
		if(a.getActionCommand().equals("Pesquisar")) {
			buscarEstoque(modelo);
		}
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?> [] coluna = {String.class, String.class,Integer.class};
		return coluna[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String [] nomeColunas = {"Modelo", "Grade", "Quantidade em Estoque"};
		return nomeColunas[columnIndex];
	}

	@Override
	public int getRowCount() {
		return estoque.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Estoque e = estoque.get(rowIndex);
		if(columnIndex == 0) {
			return e.getModelo();
		}
		if(columnIndex == 1) {
			return e.getGrade();
		}
		if(columnIndex == 2) {
			return e.getQuantidade();
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
	
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
		
	}
}
