/**
 * 
 */

/**
 * @author luis
 *
 */
public class Arquivo {

	/**
	 * @param qntdPalavras the qntdPalavras to set
	 */
	public void setQntdPalavras(int qntdPalavras) {
		this.qntdPalavras = qntdPalavras;
	}

	private String caminho;
	private String nome;
	private int qntdPalavras;
	
	public Arquivo(String caminho, String nome) {
		this.caminho = caminho;
		this.nome = nome;
		this.qntdPalavras = 0;
	}

	public String getCaminho() {
		return caminho;
	}

	public String getNome() {
		return nome;
	}

	public int getQntdPalavras() {
		return qntdPalavras;
	}
	
	public void increaseQntdPalavras() {
		this.qntdPalavras++;
	}
}
