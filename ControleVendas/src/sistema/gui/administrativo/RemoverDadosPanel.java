package sistema.gui.administrativo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sistema.gui.JanelaFrame;

public class RemoverDadosPanel extends JPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -6599506580080924639L;
	
	private JanelaFrame frame;
	/**
	 * Create the panel.
	 */
	public RemoverDadosPanel(JanelaFrame frame) {
		
		this.frame = frame;
		setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVoltar.setBounds(125, 729, 107, 33);
		add(btnVoltar);

		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				carregarPainelPrincipal();                       
			}
		});

	}
	
	private void carregarPainelPrincipal() {
		try {
			this.frame.setTitulosPrincipal();
			this.frame.reloadAllPrincipal();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

}
