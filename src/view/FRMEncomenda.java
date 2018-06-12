package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JRadioButton;
import java.awt.Color;

public class FRMEncomenda extends JPanel {
	private JTextField txtQtd;
	private JTable tabelaEncomenda;
	private JLabel lblMotorista; 
	private JComboBox cbMotorista;

	/**
	 * Create the panel.
	 * 
	 * @throws ParseException
	 */
	public FRMEncomenda() throws ParseException {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 31, 1040, 660);
		setLayout(null);

		JLabel lblEncomenda = new JLabel("Encomenda");
		lblEncomenda.setForeground(Color.BLACK);
		lblEncomenda.setBackground(Color.WHITE);
		lblEncomenda.setBounds(12, 0, 224, 34);
		lblEncomenda.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblEncomenda);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(Color.BLACK);
		lblCliente.setBackground(Color.WHITE);
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCliente.setBounds(12, 74, 99, 14);
		add(lblCliente);

		JComboBox cbCliente = new JComboBox();
		cbCliente.setForeground(Color.BLACK);
		cbCliente.setBackground(Color.WHITE);
		cbCliente.setBounds(102, 73, 168, 20);
		add(cbCliente);

		JLabel lblDataDaEncomenda = new JLabel("Data da Encomenda");
		lblDataDaEncomenda.setForeground(Color.BLACK);
		lblDataDaEncomenda.setBackground(Color.WHITE);
		lblDataDaEncomenda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDaEncomenda.setBounds(10, 185, 160, 14);
		add(lblDataDaEncomenda);

		JFormattedTextField fttDataEncomenda = new JFormattedTextField(
				new MaskFormatter("##/##/####"));
		fttDataEncomenda.setForeground(Color.BLACK);
		fttDataEncomenda.setBackground(Color.WHITE);
		fttDataEncomenda.setBounds(168, 183, 83, 22);
		add(fttDataEncomenda);

		JLabel lblDataDaRetirada = new JLabel("Data da Retirada");
		lblDataDaRetirada.setForeground(Color.BLACK);
		lblDataDaRetirada.setBackground(Color.WHITE);
		lblDataDaRetirada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDaRetirada.setBounds(299, 185, 132, 14);
		add(lblDataDaRetirada);

		JFormattedTextField fttDataRetirada = new JFormattedTextField(
				new MaskFormatter("##/##/####"));
		fttDataRetirada.setForeground(Color.BLACK);
		fttDataRetirada.setBackground(Color.WHITE);
		fttDataRetirada.setBounds(441, 183, 83, 22);
		add(fttDataRetirada);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(Color.BLACK);
		lblModelo.setBackground(Color.WHITE);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModelo.setBounds(10, 240, 63, 14);
		add(lblModelo);

		JComboBox cbModelo = new JComboBox();
		cbModelo.setForeground(Color.BLACK);
		cbModelo.setBackground(Color.WHITE);
		cbModelo.setBounds(83, 237, 187, 20);
		add(cbModelo);

		JLabel lblQuantidadeEncomendada = new JLabel("Quantidade Encomendada");
		lblQuantidadeEncomendada.setForeground(Color.BLACK);
		lblQuantidadeEncomendada.setBackground(Color.WHITE);
		lblQuantidadeEncomendada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadeEncomendada.setBounds(299, 236, 199, 23);
		add(lblQuantidadeEncomendada);

		txtQtd = new JTextField();
		txtQtd.setForeground(Color.BLACK);
		txtQtd.setBackground(Color.WHITE);
		txtQtd.setBounds(521, 239, 35, 20);
		add(txtQtd);
		txtQtd.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 293, 579, 211);
		add(scrollPane);
		
		tabelaEncomenda = new JTable();
		tabelaEncomenda.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cliente", "Modelo", "Qtd.", "Encomenda", "Retirada", "Status"
			}
		));
		tabelaEncomenda.getColumnModel().getColumn(0).setPreferredWidth(179);
		tabelaEncomenda.getColumnModel().getColumn(1).setPreferredWidth(193);
		tabelaEncomenda.getColumnModel().getColumn(3).setPreferredWidth(91);
		tabelaEncomenda.getColumnModel().getColumn(4).setPreferredWidth(83);
		scrollPane.setViewportView(tabelaEncomenda);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setBackground(Color.WHITE);
		btnAdicionar.setBounds(566, 238, 89, 23);
		add(btnAdicionar);
		
		JButton btnFinalizarEncomenda = new JButton("Finalizar Encomenda");
		btnFinalizarEncomenda.setForeground(Color.BLACK);
		btnFinalizarEncomenda.setBackground(Color.WHITE);
		btnFinalizarEncomenda.setBounds(793, 290, 151, 23);
		add(btnFinalizarEncomenda);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(793, 392, 151, 23);
		add(btnCancelar);
		
		lblMotorista = new JLabel("Motorista");
		lblMotorista.setForeground(Color.BLACK);
		lblMotorista.setBackground(Color.WHITE);
		lblMotorista.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMotorista.setBounds(12, 129, 89, 14);
		add(lblMotorista);
		
		cbMotorista = new JComboBox();
		cbMotorista.setForeground(Color.BLACK);
		cbMotorista.setBackground(Color.WHITE);
		cbMotorista.setBounds(111, 128, 206, 20);
		add(cbMotorista);
		
		JLabel lblRetiradaNaLoja = new JLabel("Retirada na Loja ?");
		lblRetiradaNaLoja.setForeground(Color.BLACK);
		lblRetiradaNaLoja.setBackground(Color.WHITE);
		lblRetiradaNaLoja.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRetiradaNaLoja.setBounds(497, 76, 158, 14);
		add(lblRetiradaNaLoja);
		
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setForeground(Color.BLACK);
		rdbtnSim.setBackground(Color.WHITE);
		rdbtnSim.setSelected(true);
		rdbtnSim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnSim.setBounds(661, 70, 71, 23);
		add(rdbtnSim);
		
		JRadioButton rdbtnNo = new JRadioButton("N\u00E3o");
		rdbtnNo.setForeground(Color.BLACK);
		rdbtnNo.setBackground(Color.WHITE);
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNo.setBounds(740, 70, 109, 23);
		add(rdbtnNo);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnNo);
		grupo.add(rdbtnSim);
		
		rdbtnSim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblMotorista.setVisible(false);
				cbMotorista.setVisible(false);
				
			}
		});
		
		
		rdbtnNo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblMotorista.setVisible(true);
				cbMotorista.setVisible(true);
				
			}
		});
		
	}
}

