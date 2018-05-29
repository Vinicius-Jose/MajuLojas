package view;

import java.awt.Font;
import java.awt.Label;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JScrollPane;

public class FRMModelo extends JPanel {
	private JTextField txtModelo;
	private JTextField txtQtd;
	private JTable table;
	private JTextField txtModelagem;
	private JTextField qtdRolo;
	private JTextField txtMargemCusto;
	private JTextField txtCustoConfecção;

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMModelo() throws ParseException {
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(12, 0, 83, 34);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblModelo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);
		
		JLabel lblModelo_1 = new JLabel("Modelo");
		lblModelo_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModelo_1.setBounds(10, 68, 69, 16);
		add(lblModelo_1);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(91, 68, 315, 22);
		add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblNovoModelo = new JLabel("Novo Modelo ?");
		lblNovoModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNovoModelo.setBounds(484, 68, 124, 16);
		add(lblNovoModelo);
		
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setSelected(true);
		rdbtnSim.setBounds(616, 64, 69, 25);
		add(rdbtnSim);
		
		JRadioButton rdbtnNo = new JRadioButton("N\u00E3o");
		rdbtnNo.setBounds(713, 64, 69, 25);
		add(rdbtnNo);
		
		ButtonGroup grupoBotao = new ButtonGroup();
		grupoBotao.add(rdbtnNo);
		grupoBotao.add(rdbtnSim);
		
		JFormattedTextField fttData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		fttData.setBounds(888, 68, 83, 22);
		
		add(fttData);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(835, 68, 53, 16);
		add(lblData);
		
		JLabel lblConfeco = new JLabel("Confec\u00E7\u00E3o");
		lblConfeco.setBounds(12, 143, 83, 16);
		add(lblConfeco);
		
		JLabel lblAviamento = new JLabel("Aviamento");
		lblAviamento.setBounds(38, 176, 83, 16);
		add(lblAviamento);
		
		JComboBox cbAviamento = new JComboBox();
		cbAviamento.setBounds(118, 176, 200, 22);
		add(cbAviamento);
		
		txtQtd = new JTextField();
		txtQtd.setBounds(428, 173, 47, 22);
		add(txtQtd);
		txtQtd.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(330, 176, 86, 16);
		add(lblQuantidade);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(511, 172, 97, 25);
		add(btnAdicionar);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Aviamento", "Quantidade", "Custo Aviamento", "A\u00E7\u00E3o"
			}
		)
		);
		table.getColumnModel().getColumn(0).setPreferredWidth(252);
		table.getColumnModel().getColumn(1).setPreferredWidth(107);
		table.getColumnModel().getColumn(2).setPreferredWidth(188);
		table.setBounds(38, 289, 570, -53);
		
		Label lblModelagem = new Label("Modelagem\r\n");
		lblModelagem.setBounds(38, 318, 70, 24);
		add(lblModelagem);
		
		txtModelagem = new JTextField();
		txtModelagem.setBounds(117, 320, 116, 22);
		add(txtModelagem);
		txtModelagem.setColumns(10);
		
		JLabel lblTecido = new JLabel("Tecido");
		lblTecido.setBounds(38, 392, 56, 16);
		add(lblTecido);
		
		JComboBox cbTecido = new JComboBox();
		cbTecido.setBounds(91, 389, 200, 22);
		add(cbTecido);
		
		qtdRolo = new JTextField();
		qtdRolo.setBounds(479, 389, 53, 22);
		add(qtdRolo);
		qtdRolo.setColumns(10);
		
		JLabel lblQuantidadeDeRolos = new JLabel("Quantidade de Rolos");
		lblQuantidadeDeRolos.setBounds(330, 392, 145, 16);
		add(lblQuantidadeDeRolos);
		
		JLabel lblMargemDeCusto = new JLabel("Margem de Custo");
		lblMargemDeCusto.setBounds(12, 531, 116, 16);
		add(lblMargemDeCusto);
		
		txtMargemCusto = new JTextField();
		txtMargemCusto.setBounds(133, 528, 116, 22);
		add(txtMargemCusto);
		txtMargemCusto.setColumns(10);
		
		JLabel lblCustoDeConfeco = new JLabel("Custo de Confec\u00E7\u00E3o");
		lblCustoDeConfeco.setBounds(402, 531, 139, 16);
		add(lblCustoDeConfeco);
		
		txtCustoConfecção = new JTextField();
		txtCustoConfecção.setBounds(553, 528, 116, 22);
		add(txtCustoConfecção);
		txtCustoConfecção.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(733, 195, 97, 25);
		add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar\r\n");
		btnCancelar.setBounds(733, 350, 97, 25);
		add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 211, 494, 83);
		scrollPane.setViewportView(table);
		add(scrollPane);
		
		

	}
}
