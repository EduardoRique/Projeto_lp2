import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class FrameSystem {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameSystem window = new FrameSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		JLabel lblBemVindo = new JLabel("Bem vindo!");
		lblBemVindo.setFont(new Font("Dialog", Font.BOLD, 40));
		lblBemVindo.setBounds(89, 12, 309, 77);
		frame.getContentPane().add(lblBemVindo);
		
		JLabel lblEscolhaSuaSeo = new JLabel("Escolha sua seção de trabalho:");
		lblEscolhaSuaSeo.setBounds(23, 101, 235, 30);
		frame.getContentPane().add(lblEscolhaSuaSeo);
		
		JButton btnBusca = new JButton("Busca");
		btnBusca.setBounds(59, 143, 129, 38);
		frame.getContentPane().add(btnBusca);
		
		JButton btnIndexao = new JButton("Indexação");
		btnIndexao.setBounds(238, 143, 129, 38);
		frame.getContentPane().add(btnIndexao);
	}
}
