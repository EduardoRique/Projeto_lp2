import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FrameSystem extends JFrame{

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private boolean busca = false;
	private boolean indexacao = false;

	/**
	 * Create the application.
	 */
	public FrameSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		setLocation(100, 50);
		
		JLabel lblBemVindo = new JLabel("Bem vindo!");
		lblBemVindo.setFont(new Font("Dialog", Font.BOLD, 40));
		lblBemVindo.setBounds(89, 12, 309, 77);
		frame.getContentPane().add(lblBemVindo);
		
		JLabel lblEscolhaSuaSeo = new JLabel("Escolha sua seção de trabalho:");
		lblEscolhaSuaSeo.setBounds(23, 101, 235, 30);
		frame.getContentPane().add(lblEscolhaSuaSeo);
		
		JButton btnBusca = new JButton("Busca");
		btnBusca.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				busca = true;				
			}
		});
		btnBusca.setBounds(59, 143, 129, 38);
		frame.getContentPane().add(btnBusca);
		
		JButton btnIndexao = new JButton("Indexação");
		btnIndexao.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				indexacao = true;
			}
		});
		btnIndexao.setBounds(238, 143, 129, 38);
		frame.getContentPane().add(btnIndexao);
		frame.setVisible(true);
	}

	/**
	 * @return the busca
	 */
	public boolean isBusca() {
		return busca;
	}

	/**
	 * @param busca the busca to set
	 */
	public void setBusca(boolean busca) {
		this.busca = busca;
	}

	/**
	 * @return the indexacao
	 */
	public boolean isIndexacao() {
		return indexacao;
	}

	/**
	 * @param indexacao the indexacao to set
	 */
	public void setIndexacao(boolean indexacao) {
		this.indexacao = indexacao;
	}
	
}
