import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
//import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class TreeTrie.
 */
public class TreeTrie {
	
	/** The root. */
	private TrieNode root;
	//private static Scanner ler;
	 
    /**
     * Trie.
     */
    public TreeTrie() {
        root = new TrieNode();
    }
    
 /**
  * Insert word.
  *
  * @param word the word
  */
    public void insertWord(String word, int linha, Arquivo arquivo) {
        HashMap<Character, TrieNode> children = root.children;
 
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
 
            TrieNode t;
            if(children.containsKey(c)){
                    t = children.get(c);
            }else{
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;
 
            //set leaf node
            if(i==word.length()-1) {
            	t.isLeaf = true;
            	t.addInfos(arquivo.getNome(), linha);
            }
                  
        }
    }
 
    /**
     * Removes the word.
     *
     * @param word the word
     */
    public void removeWord(String word) {
    	
    	HashMap<Character, TrieNode> children = root.children;
    	
    	String c = "";
    	if(this.search(word)) {
    		for(int i=0; i<word.length(); i++){
    			TrieNode t = children.get(word.charAt(i));
    			c = c + word.charAt(i);

                if(!this.startsWith(c)) {
                	children.remove(word.charAt(i));
                }
                
                children = t.children;
                
              //set leaf node
                if(i==word.length()-1)
                    t.isLeaf = false;    
            }
    	}
    }
    
    public boolean removeArquivo(String nomeArquivo) {
		Iterator<TrieNode> i = root.getChildren().values().iterator();
		while (i.hasNext()) {
			TrieNode filho = i.next();
			filho.removeArquivo(nomeArquivo);
			if((filho.getInfos().size() == 0) && (filho.getChildren().size() == 0))
				i.remove();
		}
		return true;
}
    
    /**
  * Returns if there is any word in the trie that starts with the given prefix.
  *
  * @param prefix the prefix
  * @return true, if successful
  */
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null) 
            return false;
        else
            return true;
    }
    
    /**
     * Search.
     *
     * @param word the word
     * @return true, if successful
     */
    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);
 
        if(t != null && t.isLeaf) {
        	for(Infos info : t.getInfos()) {
        		System.out.println(info.getArquivo() + ": " + info.getQntd() + " ocorrência(s)​ ​ da​ ​ palavra " + word + " na linha: " + info.getLinha());
        	}
        	return true;
        } 
        else {
        	System.out.println("Palavra não encontrada");
        	return false;
        }       
    }
 
    /**
     * Search node.
     *
     * @param str the str
     * @return the trie node
     */
    public TrieNode searchNode(String str){
        HashMap<Character, TrieNode> children = root.children; 
        TrieNode t = null;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else{
                return null;
            }
        }
 
        return t;
    }
    
    public void printTrie() {    	
    	for(Entry<Character, TrieNode> filho : root.children.entrySet()) {
		    //Character key = filho.getKey();
		    TrieNode value = filho.getValue();
		    value.print();
		}
    	System.out.println("");
    }

}
