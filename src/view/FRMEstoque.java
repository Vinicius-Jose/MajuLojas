package view;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;

public class FRMEstoque extends JPanel {
	private JTable table;

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

		JComboBox cbModelo = new JComboBox();
		cbModelo.setForeground(Color.BLACK);
		cbModelo.setBackground(Color.WHITE);
		cbModelo.setBounds(123, 81, 224, 20);
		add(cbModelo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 153, 543, 198);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Modelo", "Grade", "Quantidade em Estoque"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(145);
		scrollPane.setViewportView(table);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(Color.BLACK);
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(421, 82, 108, 23);
		add(btnPesquisar);
	}

}
