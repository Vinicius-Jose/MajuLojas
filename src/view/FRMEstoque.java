package view;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControleEstoque;

import javax.swing.JButton;

import model.Modelo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class FRMEstoque extends JPanel implements ActionListener {
	private JTable tabelaEstoque;
	private JButton btnPesquisar;
	private JComboBox cbModelo;
	private ControleEstoque ctrlEstoque = new ControleEstoque();

	/**
	 * Create the panel.
	 */
	public FRMEstoque() {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 31, 1040, 660);
		setLayout(null);

		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setForeground(Color.BLACK);
		lblEstoque.setBackground(Color.WHITE);
		lblEstoque.setBounds(12, 0, 224, 34);
		lblEstoque.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblEstoque);

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setBounds(0, 44, 1034, 11);
		add(separator);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(Color.BLACK);
		lblModelo.setBackground(Color.WHITE);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModelo.setBounds(50, 84, 63, 14);
		add(lblModelo);

		cbModelo = new JComboBox();
		cbModelo.setForeground(Color.BLACK);
		cbModelo.setBackground(Color.WHITE);
		cbModelo.setBounds(123, 81, 224, 20);
		add(cbModelo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 153, 543, 198);
		add(scrollPane);
		
		tabelaEstoque = new JTable();
		tabelaEstoque.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Modelo", "Grade", "Quantidade em Estoque"
			}
		));
		tabelaEstoque.getColumnModel().getColumn(2).setPreferredWidth(145);
		scrollPane.setViewportView(tabelaEstoque);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(Color.BLACK);
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(421, 82, 108, 23);
		add(btnPesquisar);
		
	
		btnPesquisar.addActionListener(this);
		preencherCombo();
	}

	private void preencherCombo() {
		cbModelo.removeAll();
		for(Modelo a : ctrlEstoque.buscarModelos()){
			cbModelo.addItem(a);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		preencherTabela(ctrlEstoque.buscarEstoque((Modelo) cbModelo.getSelectedItem()));
		
	}

	private void preencherTabela(List<HashMap<String, Object>> buscarEstoque) {
		DefaultTableModel md = (DefaultTableModel) tabelaEstoque.getModel();
		md.setRowCount(0);
		for(HashMap<String, Object> a : buscarEstoque){
			Object linha[] = new Object[3];
			linha[0] = a.get("Modelo");
			linha[1] = a.get("Grade");
			linha[2] = a.get("Quantidade");
			md.addRow(linha);
		}
		
	}

}
