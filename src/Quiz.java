




import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Quiz extends JFrame implements ActionListener{
	String [][] perguntas = new String[3][6];
	JRadioButton [] jrPerguntas = new JRadioButton[4];
	JLabel jlPergunta = new JLabel("");
	JLabel jlPontuacao = new JLabel("Pontua��o: 0");
	int posAtual = 0;
	int pontos = 0;
	JButton jbResponder = new JButton("Responder");
	ButtonGroup bgOp = new ButtonGroup();
	public Quiz() {
		super("Quiz");
		setLayout(new GridLayout(7,1));
		carregaPerguntas();
		for (int id=0;id<4;id++){
			jrPerguntas[id] = new JRadioButton();
			bgOp.add(jrPerguntas[id]);
		}
		montaTela();
		jlPontuacao.setHorizontalAlignment(JTextField.RIGHT);
		add(jlPergunta);
		add(jrPerguntas[0]);
		add(jrPerguntas[1]);
		add(jrPerguntas[2]);
		add(jrPerguntas[3]);
		add(jlPontuacao);
		add(jbResponder);
		jbResponder.addActionListener(this);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void carregaPerguntas(){
		perguntas[0][0] = "Qual o maior �rg�o do corpo humano?";
		perguntas[0][1] = "cora��o";
		perguntas[0][2] = "pele";
		perguntas[0][3] = "f�gado";
		perguntas[0][4] = "pulm�o";
		perguntas[0][5] = "2";
		
		perguntas[1][0] = "Qual maior mam�fero do planeta?";
		perguntas[1][1] = "le�o";
		perguntas[1][2] = "rinoceronte";
		perguntas[1][3] = "baleia";
		perguntas[1][4] = "elefante";
		perguntas[1][5] = "3";
		
		perguntas[2][0] = "Qual das linguagens � orientada a obeto?";
		perguntas[2][1] = "Assembler";
		perguntas[2][2] = "Clipper";
		perguntas[2][3] = "Delfhi";
		perguntas[2][4] = "Java";
		perguntas[2][5] = "4";
		
		
	}
	public void montaTela() {
		jlPergunta.setText(perguntas[posAtual][0]);
		for (int id=0;id<4;id++){
			jrPerguntas[id].setText(perguntas[posAtual][id+1]);
		}
	}
	public static void main(String [] args){
		new Quiz();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int respostaCerta = Integer.parseInt(perguntas[posAtual][5]);
		
		if (jrPerguntas[respostaCerta-1].isSelected()){
			pontos++;
		} else{
			pontos--;
		}
		jlPontuacao.setText("Pontua��o: " + pontos);
		if (posAtual<2)
			posAtual++;
		else
			JOptionPane.showMessageDialog(this, "Fim do jogo sua pontua��o foi de " + pontos + " pontos");
		montaTela();

		
	}

}

