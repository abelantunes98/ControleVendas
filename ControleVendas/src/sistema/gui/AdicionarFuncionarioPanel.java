package sistema.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import principal.Principal;

public class AdicionarFuncionarioPanel extends JPanel {
	private JTextField valNomeFuncionario;
	private JTextField valCpfFuncionario;
	private JTextField valEmailFuncionario;
	private JTextField valTelefoneFuncionario;
	private JTextField valCodigoFuncionario;

	private Principal principal;
	private JanelaFrame frame;

	/**
	 * Create the panel.
	 */
	public AdicionarFuncionarioPanel(Principal principal, JanelaFrame frame) {

		this.principal = principal;
		this.frame = frame;

		setLayout(null);

		JLabel lblAdicionarFuncionario = new JLabel("Adicionar Funcion\u00E1rio");
		lblAdicionarFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAdicionarFuncionario.setBounds(643, 16, 612, 222);
		add(lblAdicionarFuncionario);

		JLabel nomeFuncionario = new JLabel("Nome:");
		nomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nomeFuncionario.setBounds(73, 290, 178, 43);
		add(nomeFuncionario);

		JLabel cpfFuncionario = new JLabel("CPF:");
		cpfFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cpfFuncionario.setBounds(73, 349, 178, 45);
		add(cpfFuncionario);

		JLabel emailFuncionario = new JLabel("E-Mail:");
		emailFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		emailFuncionario.setBounds(73, 408, 178, 45);
		add(emailFuncionario);

		JLabel telefoneFuncionario = new JLabel("Telefone:");
		telefoneFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		telefoneFuncionario.setBounds(73, 467, 178, 44);
		add(telefoneFuncionario);

		JLabel codigoFuncionario = new JLabel("C\u00F3digo:");
		codigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		codigoFuncionario.setBounds(73, 527, 178, 43);
		add(codigoFuncionario);

		valNomeFuncionario = new JTextField();
		valNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valNomeFuncionario.setBounds(186, 291, 612, 43);
		add(valNomeFuncionario);
		valNomeFuncionario.setColumns(10);

		valCpfFuncionario = new JTextField();
		valCpfFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valCpfFuncionario.setColumns(10);
		valCpfFuncionario.setBounds(186, 349, 226, 43);
		add(valCpfFuncionario);

		valEmailFuncionario = new JTextField();
		valEmailFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valEmailFuncionario.setColumns(10);
		valEmailFuncionario.setBounds(186, 410, 612, 43);
		add(valEmailFuncionario);

		valTelefoneFuncionario = new JTextField();
		valTelefoneFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valTelefoneFuncionario.setColumns(10);
		valTelefoneFuncionario.setBounds(186, 469, 226, 43);
		add(valTelefoneFuncionario);

		valCodigoFuncionario = new JTextField();
		valCodigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valCodigoFuncionario.setColumns(10);
		valCodigoFuncionario.setBounds(186, 528, 178, 43);
		add(valCodigoFuncionario);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnSalvar.setBounds(600, 703, 125, 43);
		add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnLimpar.setBounds(845, 703, 125, 43);
		add(btnLimpar);
		
		/*
		 * Ações dos botões.
		 */
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cadastrarFuncionario();
			}
		});

		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();                       
			}
		});

	}

	private void limparCampos() {

		valNomeFuncionario.setText("");
		valCpfFuncionario.setText("");
		valEmailFuncionario.setText("");
		valTelefoneFuncionario.setText("");
		valCodigoFuncionario.setText("");
	}

	private void cadastrarFuncionario() {

		String nomeFuncionario = valNomeFuncionario.getText();
		String cpfFuncionario = valCpfFuncionario.getText();
		String emailFuncionario = valEmailFuncionario.getText();
		String telefoneFuncionario = valTelefoneFuncionario.getText();
		String codigoFuncionario = valCodigoFuncionario.getText();

		try {
			this.principal.adicionarFuncionario(nomeFuncionario, cpfFuncionario, telefoneFuncionario, 
					emailFuncionario, codigoFuncionario);
			// Mensagem de sucesso.
			JOptionPane.showMessageDialog(null, "Usuário Cadastrado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			limparCampos();
			this.frame.reload();

		}
		// Mostrando erro.
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
