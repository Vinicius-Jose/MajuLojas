package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import model.Modelagem;
import model.Modelo;
import controller.ControleModelagem;

public class FRMModelagem extends JPanel implements ActionListener{
	private JComboBox cbModelo;
	private JTextField txtPrecoModelagem;
	private JFormattedTextField fttData;
	private ControleModelagem ctrlModelagem = new ControleModelagem();
	private JButton btnPesquisar;

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMModelagem() throws ParseException {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		JLabel lblModelagem = new JLabel("Modelagem");
		lblModelagem.setForeground(Color.BLACK);
		lblModelagem.setBackground(Color.WHITE);
		lblModelagem.setBounds(12, 0, 224, 34);
		lblModelagem.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblModelagem);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(Color.BLACK);
		lblModelo.setBackground(Color.WHITE);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModelo.setBounds(12, 85, 56, 16);
		add(lblModelo);
		
		cbModelo = new JComboBox();
		cbModelo.setForeground(Color.BLACK);
		cbModelo.setBackground(Color.WHITE);
		cbModelo.setBounds(80, 85, 352, 22);
		add(cbModelo);
		
		txtPrecoModelagem = new JTextField();
		txtPrecoModelagem.setForeground(Color.BLACK);
		txtPrecoModelagem.setBackground(Color.WHITE);
		txtPrecoModelagem.setBounds(80, 210, 116, 22);
		add(txtPrecoModelagem);
		txtPrecoModelagem.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setForeground(Color.BLACK);
		lblPreo.setBackground(Color.WHITE);
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreo.setBounds(12, 212, 56, 16);
		add(lblPreo);
		
		JLabel lblDataDaModelagem = new JLabel("Data da Modelagem");
		lblDataDaModelagem.setForeground(Color.BLACK);
		lblDataDaModelagem.setBackground(Color.WHITE);
		lblDataDaModelagem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDaModelagem.setBounds(494, 212, 169, 16);
		add(lblDataDaModelagem);
		
		fttData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		fttData.setForeground(Color.BLACK);
		fttData.setBackground(Color.WHITE);
		fttData.setBounds(654, 210, 83, 22);
		fttData.setEditable(false);
		add(fttData);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(Color.BLACK);
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(442, 84, 89, 23);
		add(btnPesquisar);
		txtPrecoModelagem.setEditable(false);
		
		btnPesquisar.addActionListener(this);
		preencherCombo();

	}

	private void preencherCombo() {
		Set<Modelo> a = ctrlModelagem.buscarModelo();
		cbModelo.removeAllItems();
		for(Modelo b : a) {
			cbModelo.addItem(b);
		}
		
	}
	
    private void colocaTela(Modelagem modelagem) {
    	if(modelagem != null) {
    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//    		cbModelo.setSelectedItem(modelagem.getModelo());
    		txtPrecoModelagem.setText(Float.toString(modelagem.getValor()));
    		fttData.setText(sdf.format(modelagem.getDataModelagem()));
    	}
    }

	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getActionCommand().equals("Pesquisar")) {
			try {
				colocaTela(ctrlModelagem.buscarModelagem((Modelo) cbModelo.getSelectedItem()));
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Campo não preenchido", "Preenchido", JOptionPane.INFORMATION_MESSAGE);
				e.printStackTrace();
			}
		}	
	}
}
