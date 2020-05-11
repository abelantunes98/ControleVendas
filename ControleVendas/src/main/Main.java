package main;

import sistema.gui.JanelaFrame;

public class Main {

	public static void main(String[] args) {
		new Main().iniciarTela();

	}

	private void iniciarTela(){
		JanelaFrame frame = new JanelaFrame();
		frame.setVisible(true);
	}
}
