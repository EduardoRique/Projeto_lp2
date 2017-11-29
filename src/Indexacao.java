import java.util.HashSet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Pattern;
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
			if(arq.getCaminho().equals(arquivo.getCaminho())) {
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
		arquivos.remove(arquivo);
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
            while ((textoLinha = buffer.readLine()) != null) {
                //System.out.println(textoLinha);
                	//textoLinha = limpar(textoLinha);
                //System.out.println(textoLinha);
                String[] arr = textoLinha.split(" ");
                for(String ss : arr) {
                	if(!ss.trim().equals(""))
                		trie.insertWord(ss, linha, arquivo);
                	  	arquivo.increaseQntdPalavras();
                 }
                linha++;
            }

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

}
