/**
 * @autor Tela: Vinícius José; Métodos: Alicia Yoshida 
 * 
 */
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

import model.Modelo;
import model.Piloto;
import controller.ControlePiloto;

public class FRMPiloto extends JPanel implements ActionListener{
	private JComboBox cbModelo;
	private JTextField txtPrecoPiloto;
	private JFormattedTextField fttData;
	private ControlePiloto ctrlPiloto = new ControlePiloto();
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMPiloto() throws ParseException {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		JLabel lblAviamento = new JLabel("Piloto");
		lblAviamento.setForeground(Color.BLACK);
		lblAviamento.setBackground(Color.WHITE);
		lblAviamento.setBounds(12, 0, 224, 34);
		lblAviamento.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblAviamento);
		
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
		
		txtPrecoPiloto = new JTextField();
		txtPrecoPiloto.setForeground(Color.BLACK);
		txtPrecoPiloto.setBackground(Color.WHITE);
		txtPrecoPiloto.setBounds(80, 210, 116, 22);
		add(txtPrecoPiloto);
		txtPrecoPiloto.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setForeground(Color.BLACK);
		lblPreo.setBackground(Color.WHITE);
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreo.setBounds(12, 212, 56, 16);
		add(lblPreo);
		
		JLabel lblDataDoPiloto = new JLabel("Data do Piloto");
		lblDataDoPiloto.setForeground(Color.BLACK);
		lblDataDoPiloto.setBackground(Color.WHITE);
		lblDataDoPiloto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDoPiloto.setBounds(494, 212, 169, 16);
		add(lblDataDoPiloto);
		
		fttData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		fttData.setForeground(Color.BLACK);
		fttData.setBackground(Color.WHITE);
		fttData.setBounds(654, 210, 83, 22);
		fttData.setEditable(false);
		txtPrecoPiloto.setEditable(false);
		add(fttData);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(Color.BLACK);
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(442, 84, 89, 23);
		add(btnPesquisar);
		
		btnPesquisar.addActionListener(this);
		preencherCombo();
		
	}
	
	
	private void preencherCombo() {
		Set<Modelo> a = ctrlPiloto.buscarModelo();
		cbModelo.removeAllItems();
		for(Modelo b : a) {
			cbModelo.addItem(b);
		}
		
	}
	
	private void colocaTela(Piloto piloto) {
		if(piloto != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			txtPrecoPiloto.setText(Float.toString(piloto.getValorPiloto()));
			fttData.setText(sdf.format(piloto.getDataPiloto()));
		}
	}


	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getActionCommand().equals("Pesquisar")) {
			try {
				
				colocaTela(ctrlPiloto.buscarPiloto((Modelo)cbModelo.getSelectedItem()));
			} catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Campo não preenchido", "Preenchido", JOptionPane.INFORMATION_MESSAGE);
			}
		}	
	}

}
