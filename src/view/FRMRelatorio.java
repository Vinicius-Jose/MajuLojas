package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import model.Capital;

public class FRMRelatorio extends JPanel implements ActionListener {
	private JTable tabelaLucro;
	private JTable tabelaCapital;
	private JTextField txtCapital;
	private JButton btnEmitirRelatrio;
	private JRadioButton rdbCapital;
	private JRadioButton rdbtnLucro;
	private JComboBox cbAno,cbMes;
	private JScrollPane scrollPane;
	private JLabel lblCapitalMensal;
	/**
	 * Create the panel.
	 */
	public FRMRelatorio() {
		setBounds(0, 31, 1040, 660);
		setLayout(null);

		JLabel lblRelatorio = new JLabel("Relatorio");
		lblRelatorio.setBounds(12, 0, 224, 34);
		lblRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblRelatorio);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipo.setBounds(12, 93, 67, 34);
		add(lblTipo);
		
		rdbCapital = new JRadioButton("Capital");
		rdbCapital.setSelected(true);
		rdbCapital.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbCapital.setBounds(85, 101, 109, 23);
		add(rdbCapital);
		
		rdbtnLucro = new JRadioButton("Lucro");
		rdbtnLucro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnLucro.setBounds(85, 147, 109, 23);
		add(rdbtnLucro);
		
		JLabel lblPerodo = new JLabel("Per\u00EDodo");
		lblPerodo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPerodo.setBounds(385, 101, 77, 18);
		add(lblPerodo);
		
		cbMes = new JComboBox();
		cbMes.setModel(new DefaultComboBoxModel(new String[] {"M\u00EAs"}));
		cbMes.setBounds(485, 102, 86, 20);
		add(cbMes);
		
		cbAno = new JComboBox();
		cbAno.setModel(new DefaultComboBoxModel(new String[] {"Ano"}));
		cbAno.setBounds(622, 102, 86, 20);
		add(cbAno);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(85, 250, 788, 237);
		add(scrollPane);

		tabelaCapital = new JTable();
		tabelaCapital.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Modelo", "Aviamento", "Corte & Costura", "Modelagem", "Piloto", "Tecido", "Custo Confec\u00E7\u00E3o"
			}
		));
		tabelaCapital.getColumnModel().getColumn(0).setPreferredWidth(157);
		tabelaCapital.getColumnModel().getColumn(1).setPreferredWidth(91);
		tabelaCapital.getColumnModel().getColumn(2).setPreferredWidth(122);
		tabelaCapital.getColumnModel().getColumn(3).setPreferredWidth(116);
		tabelaCapital.getColumnModel().getColumn(4).setPreferredWidth(104);
		tabelaCapital.getColumnModel().getColumn(5).setPreferredWidth(101);
		tabelaCapital.getColumnModel().getColumn(6).setPreferredWidth(110);
		scrollPane.setViewportView(tabelaCapital);
		
		txtCapital = new JTextField();
		txtCapital.setBounds(787, 531, 86, 20);
		add(txtCapital);
		txtCapital.setColumns(10);
		
		lblCapitalMensal = new JLabel("Capital Mensal");
		lblCapitalMensal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCapitalMensal.setBounds(662, 530, 109, 18);
		add(lblCapitalMensal);
		
		btnEmitirRelatrio = new JButton("Emitir Relat\u00F3rio");
		btnEmitirRelatrio.setBounds(761, 101, 126, 23);
		add(btnEmitirRelatrio);
		

		tabelaLucro = new JTable();
		tabelaLucro.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Modelo", "Qtd Vendida", "Preço de Venda", "Valor Ganho"
			}
		));
		tabelaLucro.getColumnModel().getColumn(0).setPreferredWidth(157);
		tabelaLucro.getColumnModel().getColumn(1).setPreferredWidth(91);
		tabelaLucro.getColumnModel().getColumn(2).setPreferredWidth(122);
		tabelaLucro.getColumnModel().getColumn(3).setPreferredWidth(116);
		
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbCapital);
		grupo.add(rdbtnLucro);
		rdbCapital.addActionListener(this);
		rdbtnLucro.addActionListener(this);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent a) {
		if (a.getActionCommand().equals("Capital")){
			scrollPane.setViewportView(tabelaCapital);
		    lblCapitalMensal.setText("Capital Mensal");
		}else if(a.getActionCommand().equals("Lucro")){
			scrollPane.setViewportView(tabelaLucro);
		    lblCapitalMensal.setText("Lucro Mensal");
		}
		
	}

}
