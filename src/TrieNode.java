import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

// TODO: Auto-generated Javadoc
/**
 * The Class TrieNode.
 */

/**
 * @author luis
 * https://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
 */
public class TrieNode {
	
	/** The c. */
	char c;
    
    /** The children. */
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    
    /** The is leaf. */
    boolean isLeaf;
    
    /** The infos. */
    ArrayList<Infos> infos = new ArrayList<Infos>();

	/**
	 * Instantiates a new trie node.
	 */
	public TrieNode() { }
	

	/**
	 * Instantiates a new trie node.
	 *
	 * @param c the c
	 */
	public TrieNode(char c) {
		this.c = c;
	}


	/**
	 * Gets the c.
	 *
	 * @return the c
	 */
	public char getC() {
		return c;
	}


	/**
	 * Sets the c.
	 *
	 * @param c the c to set
	 */
	public void setC(char c) {
		this.c = c;
	}


	/**
	 * Gets the children.
	 *
	 * @return the children
	 */
	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}


	/**
	 * Sets the children.
	 *
	 * @param children the children to set
	 */
	public void setChildren(HashMap<Character, TrieNode> children) {
		this.children = children;
	}


	/**
	 * Checks if is leaf.
	 *
	 * @return the isLeaf
	 */
	public boolean isLeaf() {
		return isLeaf;
	}


	/**
	 * Sets the leaf.
	 *
	 * @param isLeaf the isLeaf to set
	 */
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	/**
	 * Prints the.
	 */
	public void print() {
		System.out.print(c);
		if(isLeaf) System.out.println("");
		for(Entry<Character, TrieNode> filho : children.entrySet()) {
		    //Character key = filho.getKey();
		    TrieNode value = filho.getValue();
		    value.print();   
		}	
	}


	/**
	 * Gets the infos.
	 *
	 * @return the infos
	 */
	public ArrayList<Infos> getInfos() {
		return infos;
	}


	/**
	 * Adds the infos.
	 *
	 * @param linha the linha
	 * @param arquivo the arquivo
	 */
	public void addInfos(String arquivo, int linha) {
		boolean found = false;
		for(Infos teste : infos) {
			if(teste.getArquivo().equals(arquivo)) {
				if(teste.getLinha() == linha) {
					teste.setQntd();
					found = true;
				}
			}
		}
		if(!found) {
			infos.add(new Infos(arquivo, linha));
		}
	}
	

}
