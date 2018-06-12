package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ControleRelatorio;

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
	private ButtonGroup grupo;
	private ControleRelatorio ctrlRelatorio = new ControleRelatorio();
	/**
	 * Create the panel.
	 */
	public FRMRelatorio() {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 31, 1040, 660);
		setLayout(null);

		JLabel lblRelatorio = new JLabel("Relatorio");
		lblRelatorio.setForeground(Color.BLACK);
		lblRelatorio.setBackground(Color.WHITE);
		lblRelatorio.setBounds(12, 0, 224, 34);
		lblRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblRelatorio);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(Color.BLACK);
		lblTipo.setBackground(Color.WHITE);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipo.setBounds(12, 93, 67, 34);
		add(lblTipo);
		
		rdbCapital = new JRadioButton("Capital");
		rdbCapital.setForeground(Color.BLACK);
		rdbCapital.setBackground(Color.WHITE);
		rdbCapital.setSelected(true);
		rdbCapital.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbCapital.setBounds(85, 101, 109, 23);
		add(rdbCapital);
		
		rdbtnLucro = new JRadioButton("Lucro");
		rdbtnLucro.setForeground(Color.BLACK);
		rdbtnLucro.setBackground(Color.WHITE);
		rdbtnLucro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnLucro.setBounds(85, 147, 109, 23);
		add(rdbtnLucro);
		
		JLabel lblPerodo = new JLabel("Per\u00EDodo");
		lblPerodo.setForeground(Color.BLACK);
		lblPerodo.setBackground(Color.WHITE);
		lblPerodo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPerodo.setBounds(385, 101, 77, 18);
		add(lblPerodo);
		
		cbMes = new JComboBox();
		cbMes.setForeground(Color.BLACK);
		cbMes.setBackground(Color.WHITE);
		cbMes.setModel(new DefaultComboBoxModel(new String[] {"M\u00EAs"}));
		cbMes.setBounds(485, 102, 86, 20);
		add(cbMes);
		
		cbAno = new JComboBox();
		cbAno.setForeground(Color.BLACK);
		cbAno.setBackground(Color.WHITE);
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
				"Modelo", "Corte", "Costura", "Quantidade Cortada", "Modelagem", "Piloto", "Tecido", "Custo Confec\u00E7\u00E3o"
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
		txtCapital.setEditable(false);
		txtCapital.setForeground(Color.BLACK);
		txtCapital.setBackground(Color.WHITE);
		txtCapital.setBounds(787, 531, 86, 20);
		add(txtCapital);
		txtCapital.setColumns(10);
		
		lblCapitalMensal = new JLabel("Capital Mensal");
		lblCapitalMensal.setForeground(Color.BLACK);
		lblCapitalMensal.setBackground(Color.WHITE);
		lblCapitalMensal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCapitalMensal.setBounds(662, 530, 109, 18);
		add(lblCapitalMensal);
		
		btnEmitirRelatrio = new JButton("Emitir Relat\u00F3rio");
		btnEmitirRelatrio.setForeground(Color.BLACK);
		btnEmitirRelatrio.setBackground(Color.WHITE);
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
		
		
		grupo = new ButtonGroup();
		grupo.add(rdbCapital);
		grupo.add(rdbtnLucro);
		rdbCapital.addActionListener(this);
		rdbtnLucro.addActionListener(this);
		btnEmitirRelatrio.addActionListener(this);
		
		montaTelaCapital();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent a) {
		if (a.getActionCommand().equals("Capital")){
			montaTelaCapital();
		    
		}else if(a.getActionCommand().equals("Lucro")){
			scrollPane.setViewportView(tabelaLucro);
		    lblCapitalMensal.setText("Lucro Mensal");
		}else if(a.getActionCommand().contains("Emitir")){
			int ano = (int) cbAno.getSelectedItem();
			int mes = (int) cbMes.getSelectedItem();
			txtCapital.setText(Double.toString(ctrlRelatorio.buscarCapital(mes, ano)));
			List<HashMap<String,Object>> dados = ctrlRelatorio.buscaDadosCapital(0,0);
			for(HashMap<String,Object> b : dados){
				DefaultTableModel modelo = (DefaultTableModel) tabelaCapital.getModel();
				Object[] linha = new Object[b.size()];
				linha[1] =b.get("Modelo");
				linha[2] =b.get("Corte");
				linha[3] =b.get("Costura");
				linha[4] =b.get("Quantidade Cortada");
				linha[5] =b.get("Modelagem");
				linha[6] =b.get("Piloto");
				linha[7] =b.get("Tecido");
				linha[8] =b.get("Custo Confec\u00E7\u00E3o");
				modelo.addRow(linha);
			}
		}
		
	}



	private void montaTelaCapital() {
		scrollPane.setViewportView(tabelaCapital);
		lblCapitalMensal.setText("Capital Mensal");
		cbMes.removeAll();
		List<Integer> meses  = ctrlRelatorio.mesesCapital();
		for(Integer b : meses){
			cbMes.addItem(b.intValue());
		}
		List<Integer> ano = ctrlRelatorio.anosCapital();
		cbAno.removeAllItems();
		for(Integer b: ano){
			cbAno.addItem(b.intValue());
		}
		List<HashMap<String,Object>> dados = ctrlRelatorio.buscaDadosCapital(0,0);
		for(HashMap<String,Object> b : dados){
			DefaultTableModel modelo = (DefaultTableModel) tabelaCapital.getModel();
			Object[] linha = new Object[b.size()];
			linha[1] =b.get("Modelo");
			linha[2] =b.get("Corte");
			linha[3] =b.get("Costura");
			linha[4] =b.get("Quantidade Cortada");
			linha[5] =b.get("Modelagem");
			linha[6] =b.get("Piloto");
			linha[7] =b.get("Tecido");
			linha[8] =b.get("Custo Confec\u00E7\u00E3o");
			modelo.addRow(linha);
		}
	}

}
