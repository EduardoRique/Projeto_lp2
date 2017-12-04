/**
 * 
 */

/**
 * @author luis
 *
 */
public class ControlSystem {
	
	private FrameSystem system;
	private	Indexacao index;
	private TreeTrie trie;
	
	public static void main(String[] args) {
		ControlSystem sim = new ControlSystem();
        sim.run();
    }

	/**
	 * 
	 */
	public ControlSystem() {
		index = new Indexacao();
		trie = new TreeTrie();
		system = new FrameSystem();
	}
	
	public void run() {
		
		boolean vdd = true;
		
		while(vdd) {
			if(system.isIndexacao()) {
				FrameIndex windowIndex = new FrameIndex(index, trie);
				windowIndex.getBounds();
				system.setIndexacao(false);
			}
			else if(system.isBusca()) {
				FrameBusca windowBusca = new FrameBusca(trie);
				windowBusca.getBounds();
				system.setBusca(false);
			}
			else {
    			try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					}	
    		}
		}
		
	}

}
