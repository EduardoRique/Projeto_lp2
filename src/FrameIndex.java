import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import javax.swing.JList;

public class FrameIndex extends JFrame{

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtNomeDoArquivo;
	private JTextField txtCaminhoDoArquivo;

	/**
	 * Create the application.
	 */
	public FrameIndex(Indexacao indexacao, TreeTrie trie) {
		initialize(indexacao, trie);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Indexacao indexacao, TreeTrie trie) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		List list = new List();
		list.setBounds(195, 137, 243, 126);
		frame.getContentPane().add(list);
		
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
		
		JButton btnExcluirArquivo = new JButton("Excluir arquivo");
		btnExcluirArquivo.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				String caminho = "";
				String nome = "";
				if(!txtNomeDoArquivo.getText().isEmpty()) {
					nome = txtNomeDoArquivo.getText();
				}
				if(!txtCaminhoDoArquivo.getText().isEmpty()) {
					caminho = txtCaminhoDoArquivo.getText();
				}
				
				try {
					FileReader file = new FileReader(caminho + nome);
					Arquivo novoArquivo = new Arquivo(caminho, nome);
					trie.removeArquivo(novoArquivo.getNome());
					//System.out.println("OPA");
					indexacao.delArquivo(novoArquivo);
					//indexacao.limpar(trie, novoArquivo);
					
				}
				catch(Exception E){
					System.out.println("Arquivo não encontrado");
				}
			}
		});
		btnExcluirArquivo.setBounds(12, 167, 166, 25);
		frame.getContentPane().add(btnExcluirArquivo);
		
		JButton btnAdicionarArquivo = new JButton("Adicionar arquivo");
		btnAdicionarArquivo.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				String caminho = "";
				String nome = "";
				if(!txtNomeDoArquivo.getText().isEmpty()) {
					nome = txtNomeDoArquivo.getText();
				}
				if(!txtCaminhoDoArquivo.getText().isEmpty()) {
					caminho = txtCaminhoDoArquivo.getText();
				}
				
				try {
					FileReader file = new FileReader(caminho + nome);
					Arquivo novoArquivo = new Arquivo(caminho, nome);
					indexacao.addArquivo(novoArquivo);
					indexacao.importar(trie, novoArquivo);
				}
				catch(Exception E){
					System.out.println("Arquivo não encontrado");
				}
			}
		});
		btnAdicionarArquivo.setBounds(12, 136, 166, 25);
		frame.getContentPane().add(btnAdicionarArquivo);
		
		JButton btnListarArquivos = new JButton("Listar arquivos");
		btnListarArquivos.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				list.removeAll();
		        for(Arquivo arquivo : indexacao.getArquivos()) {
		        		list.add("Arquivo '" + arquivo.getNome() + "' no caminho '" + arquivo.getCaminho() + "' possui " + arquivo.getQntdPalavras() + " palavras ");
		        }
			}
		});
		btnListarArquivos.setBounds(12, 236, 166, 25);
		frame.getContentPane().add(btnListarArquivos);
		
		JLabel lblIndexao = new JLabel("Indexação");
		lblIndexao.setFont(new Font("Dialog", Font.BOLD, 24));
		lblIndexao.setBounds(159, 25, 146, 34);
		frame.getContentPane().add(lblIndexao);
		
		JButton btnAtualizarArquivo = new JButton("Atualizar arquivo");
		btnAtualizarArquivo.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				try {
					for(Arquivo novoArquivo : indexacao.getArquivos()) {
					trie.removeArquivo(novoArquivo.getNome());
					indexacao.delArquivo(novoArquivo);
					indexacao.addArquivo(novoArquivo);
					indexacao.importar(trie, novoArquivo);
					}
				}
				catch(Exception E){
					System.out.println("Arquivo não encontrado");
				}
			}
		});
		btnAtualizarArquivo.setBounds(12, 199, 166, 25);
		frame.getContentPane().add(btnAtualizarArquivo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnVoltar.setBounds(0, 0, 117, 25);
		frame.getContentPane().add(btnVoltar);

		frame.setVisible(true);
	}
}
