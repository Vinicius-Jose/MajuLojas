package view;

import java.awt.Font;
import java.awt.ScrollPane;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FRMVenda extends JPanel {
	private JTextField txtQtd;
	private JTable tabelaVenda;
	private JTextField txtValortotal;


	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMVenda() throws ParseException {
		setBounds(0, 31, 1040, 660);
		setLayout(null);

		JLabel lblVenda = new JLabel("Venda");
		lblVenda.setBounds(12, 0, 224, 34);
		lblVenda.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblVenda);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);

		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(736, 108, 61, 14);
		add(lblData);
		
		JFormattedTextField fttDataEncomenda = new JFormattedTextField(
				new MaskFormatter("##/##/####"));
		fttDataEncomenda.setBounds(791, 106, 83, 22);
		add(fttDataEncomenda);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModelo.setBounds(12, 114, 63, 14);
		add(lblModelo);

		JComboBox cbModelo = new JComboBox();
		cbModelo.setBounds(85, 111, 168, 20);
		add(cbModelo);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidade.setBounds(309, 116, 103, 17);
		add(lblQuantidade);
		
		txtQtd = new JTextField();
		txtQtd.setBounds(439, 113, 46, 20);
		add(txtQtd);
		txtQtd.setColumns(10);
		
		tabelaVenda = new JTable();
		tabelaVenda.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Modelo", "Qtd", "Valor"
			}
		));
		tabelaVenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tabelaVenda.setBounds(38, 197, 588, 159);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 197, 495, 159);
		add(scrollPane);
		scrollPane.setViewportView(tabelaVenda);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(509, 112, 89, 23);
		add(btnAdicionar);
		
		txtValortotal = new JTextField();
		txtValortotal.setBounds(446, 412, 86, 20);
		add(txtValortotal);
		txtValortotal.setColumns(10);
		
		JLabel lblValorTotal = new JLabel("Valor Total");
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorTotal.setBounds(351, 413, 89, 14);
		add(lblValorTotal);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(153, 539, 112, 23);
		add(btnCancelar);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(351, 539, 112, 23);
		add(btnFinalizar);
	
		
	}
}