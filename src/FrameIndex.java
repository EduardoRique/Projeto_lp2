import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;

public class FrameIndex {

	private JFrame frame;
	private JTextField txtNomeDoArquivo;
	private JTextField txtCaminhoDoArquivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameIndex window = new FrameIndex();
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
	public FrameIndex() {
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
		
		JButton btnExcluirArquivo = new JButton("Excluir arquivo");
		btnExcluirArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluirArquivo.setBounds(12, 173, 166, 25);
		frame.getContentPane().add(btnExcluirArquivo);
		
		JButton btnAdicionarArquivo = new JButton("Adicionar arquivo");
		btnAdicionarArquivo.setBounds(12, 136, 166, 25);
		frame.getContentPane().add(btnAdicionarArquivo);
		
		JButton btnListarArquivos = new JButton("Listar arquivos");
		btnListarArquivos.setBounds(12, 210, 166, 25);
		frame.getContentPane().add(btnListarArquivos);
		
		JLabel lblIndexao = new JLabel("Indexação");
		lblIndexao.setFont(new Font("Dialog", Font.BOLD, 24));
		lblIndexao.setBounds(149, 27, 146, 34);
		frame.getContentPane().add(lblIndexao);
		
		txtNomeDoArquivo = new JTextField();
		txtNomeDoArquivo.setText("Nome do arquivo");
		txtNomeDoArquivo.setBounds(12, 105, 114, 19);
		frame.getContentPane().add(txtNomeDoArquivo);
		txtNomeDoArquivo.setColumns(10);
		
		txtCaminhoDoArquivo = new JTextField();
		txtCaminhoDoArquivo.setText("Caminho do arquivo");
		txtCaminhoDoArquivo.setBounds(149, 105, 136, 19);
		frame.getContentPane().add(txtCaminhoDoArquivo);
		txtCaminhoDoArquivo.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(201, 136, 206, 99);
		frame.getContentPane().add(textPane);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(390, 136, 17, 99);
		frame.getContentPane().add(scrollBar);
	}
}
