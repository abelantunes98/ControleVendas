package sistema.gui.vendas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import principal.Principal;
import sistema.gui.JanelaFrame;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MesasPanel extends JPanel {
	private JTextField valCodigoMesa;
	private JTextField valCodigosMesas;
	private final ButtonGroup buttonGroupOpcao = new ButtonGroup();
	private JTable tableMesas;
	
	private JLabel codigoMesa;
	private JLabel codigosMesas;
	private JLabel codigosMesas2;
	private JRadioButton rdbtnOcuparMesa;
	private JRadioButton rdbtnLiberarMesa ;
	private JRadioButton rdbtnJuntarMesas;
	
	private Principal principal;
	private JanelaFrame frame;

	/**
	 * Create the panel.
	 */
	public MesasPanel(Principal principal, JanelaFrame frame) {
		
		this.principal = principal;
		this.frame = frame;
		
		setLayout(null);
		
		JLabel titulo = new JLabel("Mesas");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titulo.setBounds(979, 93, 169, 95);
		add(titulo);
		
		codigoMesa = new JLabel("C\u00F3digo da mesa:");
		codigoMesa.setFont(new Font("Tahoma", Font.PLAIN, 25));
		codigoMesa.setBounds(176, 346, 222, 68);
		add(codigoMesa);
		
		valCodigoMesa = new JTextField();
		valCodigoMesa.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valCodigoMesa.setBounds(413, 362, 182, 41);
		add(valCodigoMesa);
		valCodigoMesa.setColumns(10);
		
		codigosMesas = new JLabel("C\u00F3digos das mesas:");
		codigosMesas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		codigosMesas.setBounds(176, 474, 222, 68);
		codigosMesas.setEnabled(false);
		add(codigosMesas);
		
		codigosMesas2 = new JLabel("(Separados por espa\u00E7o)");
		codigosMesas2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		codigosMesas2.setBounds(186, 523, 212, 41);
		codigosMesas2.setEnabled(false);
		add(codigosMesas2);
		
		valCodigosMesas = new JTextField();
		valCodigosMesas.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valCodigosMesas.setBounds(413, 493, 288, 41);
		add(valCodigosMesas);
		valCodigosMesas.setColumns(10);
		valCodigosMesas.setEnabled(false);
		
		rdbtnOcuparMesa = new JRadioButton("Ocupar mesa");
		buttonGroupOpcao.add(rdbtnOcuparMesa);
		rdbtnOcuparMesa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnOcuparMesa.setBounds(243, 686, 155, 41);
		add(rdbtnOcuparMesa);
		
		rdbtnLiberarMesa = new JRadioButton("Liberar mesa");
		buttonGroupOpcao.add(rdbtnLiberarMesa);
		rdbtnLiberarMesa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnLiberarMesa.setBounds(483, 686, 174, 41);
		add(rdbtnLiberarMesa);
		
		rdbtnJuntarMesas = new JRadioButton("Juntar mesas");
		buttonGroupOpcao.add(rdbtnJuntarMesas);
		rdbtnJuntarMesas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnJuntarMesas.setBounds(717, 686, 169, 41);
		add(rdbtnJuntarMesas);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnConfirmar.setBounds(283, 846, 169, 55);
		add(btnConfirmar);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(569, 846, 169, 55);
		add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1232, 243, 464, 386);
		add(scrollPane);
		
		tableMesas = new JTable();
		scrollPane.setViewportView(tableMesas);
		
		// Ouvindo botões.
		
		rdbtnOcuparMesa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				codigoMesa.setEnabled(true);
				valCodigoMesa.setEnabled(true);
				valCodigosMesas.setEnabled(false);
				codigosMesas.setEnabled(false);
				codigosMesas2.setEnabled(false);
			}
		});	
		
		rdbtnLiberarMesa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				codigoMesa.setEnabled(true);
				valCodigoMesa.setEnabled(true);
				valCodigosMesas.setEnabled(false);
				codigosMesas.setEnabled(false);
				codigosMesas2.setEnabled(false);
			}
		});
		
		rdbtnJuntarMesas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				codigoMesa.setEnabled(false);
				valCodigoMesa.setEnabled(false);
				valCodigosMesas.setEnabled(true);
				codigosMesas.setEnabled(true);
				codigosMesas2.setEnabled(true);
			}
		});	

	}

}
