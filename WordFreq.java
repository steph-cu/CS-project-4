class WordFreq<AnyType extends Comparable<? super AnyType> {
	public WordFreq(AnyType lang){
		word = lang; 
		freq = 0;
	}
	private Integer freq;// stores how many times its been used
	private AnyType word;// store the word
	private matchCase{// how well it matches
		public matchCase(){
			matches = new String[10];
			off = 0; 
		}
		public matchCase(String mat, int offby, int place){
			matches[place] = mat;
			off = offby;
		}
		String[] matches;
		int off; 
	}
	
	
	@Override
	public int compareTo(WordFreq cWord){
		return this.word.compareTo(cWord.word)
	}
	
	public void incFreq(){
		this.freq++; 
	}
	public void findClose(AVLTree<AnyType> t){
		
	}
}