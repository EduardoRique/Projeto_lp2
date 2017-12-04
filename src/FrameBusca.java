import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FrameBusca extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtDigiteASua;
	private JButton btnBuscar_1;
	private TreeTrie blackList = new TreeTrie();

	/**
	 * Create the application.
	 */
	public FrameBusca(TreeTrie trie) {
		initialize(trie);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(TreeTrie trie) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		List list = new List();
		list.setBounds(71, 156, 290, 107);
		frame.getContentPane().add(list);
		
		txtDigiteASua = new JTextField();
		txtDigiteASua.setText("Digite a sua busca aqui");
		txtDigiteASua.setBounds(71, 88, 290, 25);
		frame.getContentPane().add(txtDigiteASua);
		txtDigiteASua.setColumns(10);
		
		BufferedReader buffer = null;
		String textoLinha;
		Arquivo arquivo = new Arquivo("arquivos/", "blacklist.txt");
		try {
			buffer = new BufferedReader(new FileReader(arquivo.getCaminho() + arquivo.getNome()));
			int linha = 1;
			arquivo.setQntdPalavras(0);
            while ((textoLinha = buffer.readLine()) != null) {
            	//textoLinha = trataString(textoLinha);
                String[] arr = textoLinha.split(" ");
                for(String ss : arr) {
                	if(!ss.trim().equals(""))
                		blackList.insertWord(ss, linha, arquivo);
                	  	arquivo.increaseQntdPalavras();
                 }
                linha++;
            }
            buffer.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		JButton btnBuscar = new JButton("Buscar <OR>");
		btnBuscar.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				list.removeAll();
				String strBusca = "";
				if(!txtDigiteASua.getText().isEmpty()) {
					strBusca = txtDigiteASua.getText();
				}
				String strAux = "";
				for(int i = 0; i < strBusca.length(); i++) {
					char c = strBusca.charAt(i);
					if(c == ' ' || i == strBusca.length() - 1) {
						if(i == strBusca.length() - 1) {
							strAux += Character.toString(c);
						}
						if(blackList.search(strAux)) {
			        		JOptionPane.showMessageDialog(btnBuscar, "Palavra " + strAux + " proibida");
			        	}
						else {
							TrieNode t = trie.searchNode(strAux);
					        if(t != null && t.isLeaf) {
				        		for(Infos info : t.getInfos()) {
				        			list.add(info.getArquivo() + ": " + info.getQntd() + " ocorrência(s)​ ​ da​ ​ palavra " + strAux + " na linha: " + info.getLinha());
				        		}
					        }
				        }
					strAux = "";
					}
					else {
						strAux += Character.toString(c);
					}
				}
			}
		});
		btnBuscar.setBounds(71, 125, 139, 25);
		frame.getContentPane().add(btnBuscar);
		
		btnBuscar_1 = new JButton("Buscar <AND>");
		btnBuscar_1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				list.removeAll();
				String strBusca = "";
				if(!txtDigiteASua.getText().isEmpty()) {
					strBusca = txtDigiteASua.getText();
				}
				String strAux = "";
				ArrayList<ArrayList<Infos>> vetorEncontradas = new ArrayList<ArrayList<Infos>>();
				HashSet<String> encontradas = new HashSet<String>();
				for(int i = 0; i < strBusca.length(); i++) {
					char c = strBusca.charAt(i);
					if(c == ' ' || i == strBusca.length() - 1) {
						if(i == strBusca.length() - 1) {
							strAux += Character.toString(c);
						}
						if(blackList.search(strAux)) {
			        		JOptionPane.showMessageDialog(btnBuscar_1, "Palavra " + strAux + " proibida");
			        	}else {
							TrieNode t = trie.searchNode(strAux);
					        if(t != null && t.isLeaf) {
					        	vetorEncontradas.add(t.getInfos());
					        }
			        	}
					strAux = "";
					}
					else {
						strAux += Character.toString(c);
					}
				}
				for(Infos info : vetorEncontradas.get(0))
					encontradas.add(info.getArquivo());
				for(int i = 1; i < vetorEncontradas.size(); i++) {
					for(Infos info : vetorEncontradas.get(i)) {
						if(!encontradas.contains(info.getArquivo())) {
							encontradas.remove(info.getArquivo());
						}
					}
				}
				for(int i = 0; i < strBusca.length(); i++) {
					char c = strBusca.charAt(i);
					if(c == ' ' || i == strBusca.length() - 1) {
						if(i == strBusca.length() - 1) {
							strAux += Character.toString(c);
						}
		        		TrieNode t = trie.searchNode(strAux);
				        if(t != null && t.isLeaf) {
				        	for(Infos info : t.getInfos()) {
				        		if(encontradas.contains(info.getArquivo())) {	
				        			list.add(info.getArquivo() + ": " + info.getQntd() + " ocorrência(s)​ ​ da​ ​ palavra " + strAux + " na linha: " + info.getLinha());
				        		}
				        	}	
				        }
			        	
					strAux = "";
					}
					else {
						strAux += Character.toString(c);
					}
				}
			}
		});
		btnBuscar_1.setBounds(222, 125, 139, 25);
		frame.getContentPane().add(btnBuscar_1);
		
		JLabel lblB = new JLabel("B");
		lblB.setFont(new Font("Dialog", Font.BOLD, 24));
		lblB.setForeground(Color.BLUE);
		lblB.setBounds(71, 37, 22, 39);
		frame.getContentPane().add(lblB);
		
		JLabel lblU = new JLabel("U");
		lblU.setFont(new Font("Dialog", Font.BOLD, 24));
		lblU.setForeground(Color.RED);
		lblU.setBounds(115, 43, 29, 27);
		frame.getContentPane().add(lblU);
		
		JLabel lblS = new JLabel("S");
		lblS.setFont(new Font("Dialog", Font.BOLD, 24));
		lblS.setForeground(Color.BLUE);
		lblS.setBounds(224, 41, 22, 31);
		frame.getContentPane().add(lblS);
		
		JLabel lblC = new JLabel("C");
		lblC.setFont(new Font("Dialog", Font.BOLD, 24));
		lblC.setForeground(Color.GREEN);
		lblC.setBounds(281, 41, 22, 31);
		frame.getContentPane().add(lblC);
		
		JLabel lblA = new JLabel("A");
		lblA.setFont(new Font("Dialog", Font.BOLD, 24));
		lblA.setForeground(Color.RED);
		lblA.setBounds(332, 41, 29, 31);
		frame.getContentPane().add(lblA);
		
		JLabel lblU_1 = new JLabel("U");
		lblU_1.setFont(new Font("Dialog", Font.BOLD, 24));
		lblU_1.setForeground(Color.YELLOW);
		lblU_1.setBounds(166, 41, 29, 30);
		frame.getContentPane().add(lblU_1);
		
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
