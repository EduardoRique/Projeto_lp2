
public class Infos {
	
	private String arquivo;
	private int linha;
	private int qntd;
	
	
	/**
	 * @param arquivo
	 * @param linha
	 */
	public Infos(String arquivo, int linha) {
		this.arquivo = arquivo;
		this.linha = linha;
		this.qntd = 1;
	}
	/**
	 * @return the arquivo
	 */
	public String getArquivo() {
		return arquivo;
	}
	/**
	 * @param arquivo the arquivo to set
	 */
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	/**
	 * @return the linha
	 */
	public int getLinha() {
		return linha;
	}
	/**
	 * @param linha the linha to set
	 */
	public void setLinha(int linha) {
		this.linha = linha;
	}
	/**
	 * @return the qntd
	 */
	public int getQntd() {
		return qntd;
	}
	/**
	 * @param qntd the qntd to set
	 */
	public void setQntd() {
		this.qntd++;
	}

	

}
