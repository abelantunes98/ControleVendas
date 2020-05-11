package sistema.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import principal.Principal;
import javax.swing.DropMode;

public class AdicionarProdutoPanel extends JPanel {
	
	private JTextField valNomeProduto;
	private JTextField valDescricao;
	private JTextField valCodigoProduto;
	
	private Principal principal;
	private JanelaFrame frame;
	private JTextField valPrecoProduto;
	
	/**
	 * Create the panel.
	 */
	public AdicionarProdutoPanel(Principal principal, JanelaFrame frame) {
		
		this.principal = principal;
		this.frame = frame;

		setLayout(null);

		JLabel lblAdicionarProduto = new JLabel("Adicionar Produto");
		lblAdicionarProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarProduto.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAdicionarProduto.setBounds(643, 16, 612, 222);
		add(lblAdicionarProduto);

		JLabel nomeProduto = new JLabel("Nome:");
		nomeProduto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nomeProduto.setBounds(73, 290, 178, 43);
		add(nomeProduto);

		JLabel descricaoProduto = new JLabel("Descri\u00E7\u00E3o:");
		descricaoProduto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		descricaoProduto.setBounds(73, 349, 178, 45);
		add(descricaoProduto);

		JLabel codigoProduto = new JLabel("C\u00F3digo:");
		codigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		codigoProduto.setBounds(73, 599, 178, 43);
		add(codigoProduto);

		valNomeProduto = new JTextField();
		valNomeProduto.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valNomeProduto.setBounds(206, 291, 612, 43);
		add(valNomeProduto);
		valNomeProduto.setColumns(10);

		valDescricao = new JTextField();
		valDescricao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		valDescricao.setColumns(10);
		valDescricao.setBounds(206, 351, 612, 45);
		add(valDescricao);

		valCodigoProduto = new JTextField();
		valCodigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valCodigoProduto.setColumns(10);
		valCodigoProduto.setBounds(206, 600, 178, 43);
		add(valCodigoProduto);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnSalvar.setBounds(600, 703, 125, 43);
		add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnLimpar.setBounds(845, 703, 125, 43);
		add(btnLimpar);
		
		JLabel precoProduto = new JLabel("Pre\u00E7o:");
		precoProduto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		precoProduto.setBounds(73, 411, 125, 43);
		add(precoProduto);
		
		valPrecoProduto = new JTextField();
		valPrecoProduto.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valPrecoProduto.setBounds(206, 412, 103, 43);
		add(valPrecoProduto);
		valPrecoProduto.setColumns(10);
		
		/*
		 * Ações dos botões.
		 */
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cadastrarProduto();
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

		valNomeProduto.setText("");
		valDescricao.setText("");
		valPrecoProduto.setText("");
		valCodigoProduto.setText("");
	}

	private void cadastrarProduto() {
		
		try {
			String nomeProduto = valNomeProduto.getText();
			String descricaoProduto = valDescricao.getText();
			double precoProduto = Double.parseDouble(valPrecoProduto.getText());
			String codigoProduto = valCodigoProduto.getText();

			this.principal.cadastrarProduto(codigoProduto, nomeProduto, precoProduto, descricaoProduto);
			// Mensagem de sucesso.
			JOptionPane.showMessageDialog(null, "Produto Cadastrado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			limparCampos();
			this.frame.reload();

		}
		// Mostrando erro.
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
