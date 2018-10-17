import java.util.ArrayList;

/**Dictionary.java is a special dictionary with coding words which you'll used your whole career as a programmer. 
 * The following class gives you access to the dictionary in many different ways for information such as the page where the word's at (index), if the word exist, etc.
 * The objective is to complete the tasks so the dictionary works perfectly. 
 * 
 * Important: If you've never worked with ArrayLists before, it's recommended to study the API of ArrayList before
 * 
 * @author Maria Novoa
 * @updated Luis Rivera
 *
 */
public class Dictionary {

	private ArrayList<String> dictionary = new ArrayList<>();

	public Dictionary(ArrayList<String> dictionary) {
		this.dictionary = dictionary;
	}

	public ArrayList<String> getDictionary(){
		return dictionary;
	}

	/**Overrides from the class Object to check if the dictionary sent and the this are actually the same.
	 * 
	 * @param other
	 * 
	 *Note that instanceOf makes sure that the object sent is an instance of the class (You'll see this later on class)
	 */

	@Override
	public boolean equals(Object other) {
		if(other == null) 
			return false;
		if(!(other instanceof Dictionary))
			return false;

		Dictionary dother = (Dictionary) other;

		if(this.dictionary.size() != dother.dictionary.size())
			return false;
		for (int i = 1; i <= this.dictionary.size(); i++) {
			if(!(this.dictionary.get(i-1).equals(dother.dictionary.get(i-1))))
				return false;
		}
		return true;
	}


	/**PageSeach method search for the page (index) where the word is at. 
	 * It should return -1 if the dictionary is empty or the word doesn't exist.
	 * Else return the page number.
	 * 
	 * @param target
	 * @return
	 */
	public int pageSearch(String target){
		if(dictionary.contains(target)) {
			return dictionary.indexOf(target);
		}
		return -1;
	}

	/**EliminateDuplicates method receives a target and should return number of repetitions of the target on the list.
	 * If the number of repetitions is more than 1, it should eliminate the duplicates till that number equals one.
	 * If the word doesn't exist return 0.
	 * 
	 * Note: At the end of the method, if the number of repetitions > 1, the dictionary should be different than the original.
	 * 
	 * @param target
	 * @return
	 */
	public int eliminateDuplicates(String target){
		int counter = 0;
		ArrayList<Integer> wordPos = new ArrayList<Integer>();
		for(int i = 0; i<dictionary.size(); i++) {
			if(dictionary.get(i).equals(target)) {
				counter++;
				wordPos.add(i);
			}
		}
		if(counter>1) {
			for(int n = 0; n<wordPos.size(); n++) {
				if(n == 0) {
					continue;
				}
				this.dictionary.remove(this.dictionary.get(wordPos.get(n)));
				for(int m = n+1; m<wordPos.size(); m++) {
					wordPos.set(m, wordPos.get(m)-1);
				}
			}
		}
		return counter;
	}

	/**ReverseDictionary method returns a new dictionary almost the same as the original except that it has to be in a different order.
	 * The word at end now has to be the first position and the first must go to the last position and successively.
	 *  Return null if the dictionary is empty.
	 * 
	 * @return
	 */
	public ArrayList<String> reverseDictionary(){
		ArrayList<String> reversed = new ArrayList<>();
		if(!(dictionary.isEmpty())) {
			for(int i = 0; i<dictionary.size(); i++) {
				for(int j = dictionary.size(); j == 0; j--) {

					reversed.add(i, dictionary.get(j));
				}
			}
			return reversed;
		}
		
		return null;

	}
}