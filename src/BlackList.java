/**
 * 
 */
import java.util.ArrayList;
/**
 * @author luis
 *
 */
public class BlackList {

	private ArrayList<String> blackList = new ArrayList<String>();

	/**
	 * @return the blackList
	 */
	public ArrayList<String> getBlackList() {
		return blackList;
	}
	
	public void addProibida(String proibida) {
		blackList.add(proibida);
	}
	
	public boolean removeProibida(String liberada) {
		return blackList.remove(liberada);
	}
	
}
