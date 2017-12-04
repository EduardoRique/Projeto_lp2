import java.util.HashSet;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
// TODO: Auto-generated Javadoc

/**
 * The Class Indexacao.
 */

/**
 * @author luis
 *
 */
public class Indexacao {
	
	/** The arquivos. */
	HashSet<Arquivo> arquivos = new HashSet<Arquivo>();
	
	private static String[] caracteresInvalidos = {";", ",", ".", "/", "<", ">", ":", "]", "[", "{", "}", "'", "`", "+", "*"} ;

	/**
	 * Adds the arquivo.
	 *
	 * @param arquivo the arquivo
	 * @return true, if successful
	 */
	public boolean addArquivo(Arquivo arquivo) {
		boolean contem = false;
		for(Arquivo arq : arquivos) {
			if(arq.getNome().equals(arquivo.getNome())) {
				contem = true;
			}
		}
		if(!contem)
			arquivos.add(arquivo);
		
		return !contem;
	}
	
	/**
	 * Del arquivo.
	 *
	 * @param arquivo the arquivo
	 */
	public void delArquivo(Arquivo arquivo) {
		Iterator<Arquivo> i = arquivos.iterator();
		while (i.hasNext()) {
			Arquivo arq = i.next();
			if(arq.getNome().equals(arquivo.getNome()))
				i.remove();
}
	}
	
	/**
	 * Lista arquivos.
	 *
	 * @return the hash set
	 */
	public HashSet<Arquivo> listaArquivos() {
		return arquivos;
	}
	
	/**
	 * Prints the arquivos.
	 */
	public void printArquivos() {
		for(Arquivo arquivo : arquivos)
			System.out.println(arquivo.getNome() + " - " + arquivo.getQntdPalavras());
	}
	
	public boolean importar(TreeTrie trie, Arquivo arquivo) {
		BufferedReader buffer = null;
		String textoLinha;
		try {
			buffer = new BufferedReader(new FileReader(arquivo.getCaminho() + arquivo.getNome()));
			int linha = 1;
			arquivo.setQntdPalavras(0);
            while ((textoLinha = buffer.readLine()) != null) {
            	textoLinha = trataString(textoLinha);
                String[] arr = textoLinha.split(" ");
                for(String ss : arr) {
                	if(!ss.trim().equals(""))
                		trie.insertWord(ss, linha, arquivo);
                	  	arquivo.increaseQntdPalavras();
                 }
                linha++;
            }
            buffer.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean limpar(TreeTrie trie, Arquivo arquivo) {
		BufferedReader buffer = null;
		String textoLinha;
		try {
			buffer = new BufferedReader(new FileReader(arquivo.getCaminho() + arquivo.getNome()));
			int linha = 1;
            while ((textoLinha = buffer.readLine()) != null) {
                String[] arr = textoLinha.split(" ");
                for(String ss : arr) {
                	if(!ss.trim().equals("")) {
                		trie.removeWord(ss);
                	}	
                 }
                linha++;
            }

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}
	
	private static String trataString(String texto) {
		texto = Normalizer.normalize(texto, Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		for(int i = 0; i < caracteresInvalidos.length; i++)
			texto = texto.replace(caracteresInvalidos[i], " ");
		return texto;
	}
	/**
	 * @return the arquivos
	 */
	public HashSet<Arquivo> getArquivos() {
		return arquivos;
	}

	
}
