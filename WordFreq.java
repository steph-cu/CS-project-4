class WordFreq implements Comparable<WordFreq> {
	public WordFreq(String lang){
		word = lang; 
		freq = 0;
	}
	private Integer freq;// stores how many times its been used
	private String word;// store the word
	private matchCase{// how well it matches
		public matchCase(){
			matches = {"0"} ;
			off = {0}; 
		}
		public matchCase(String mat, int offby, int place){
			matches[place] = mat;
			off = offby;
		}
		String[10] matches;
		int[10] off; 
		public void printMatches(){
			for(int i = 0; i < 10; i++){
				System.out.print(matches[i] + "(" + off[i] + "), ");
			}
		}
	}
	
	
	@Override
	public int compareTo(WordFreq cWord){
		return this.word.compareTo(cWord.word)
	}
	
	public void incFreq(){
		this.freq++; 
	}
	public void findClose(AvlNode<WordFreq> curr){
		if (curr == null) return;//returns nothing
		cleft = curr.left;// probably needs changing along with the parameter
		cright = curr.right;
		int distance = minDistance(this.word, curr.elemtent);// to get distance between this word and the current dic word 
		for (int i = 0; i < 10; i++){// goes through the " close matches list " 
			if (this.matchCase.off[i] == 0 || this.matchCase.off[i] > distance){// if it hasn't been filled or the distance of the current dic word is shorter
				curr.element.matches[i] = curr.element.word;// the place in matches will be filled with current dic word 
				break;// and out of loop it goes 
			} 
		}
		findClose(cleft);// goes to left
		findClose(cright);	// goes to right
	}
}
