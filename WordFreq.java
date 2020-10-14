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
		}public class WordFreq implements Comparable<WordFreq> {
	public WordFreq(String lang){
		word = lang; 
		freq = 0;
	}
	private Integer freq;// stores how many times its been used
	private String word;// store the word
	private class matchCase{// how well it matches
		public matchCase(){
			matches = new String[10];
			off = new int[10]; 
		}
		public matchCase(String mat, int offby, int place){
			matches[place] = mat;
			off = offby;
		}
		String[] matches;
		int[] off; 
		public void printMatches(){
			for(int i = 0; i < 10; i++){
				System.out.print(matches[i] + "(" + off[i] + "), ");
			}
		}
	}
	
	
	@Override
	public int compareTo(WordFreq cWord){
		return this.word.compareTo(cWord.word);
	}
	
	public void incFreq(){
		this.freq++; 
	}
	public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        //System.out.print( "minDistance " + word1 + " " + word2 + ": ");
        // len1+1, len2+1, because finally return dp[len1][len2]
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        //iterate though, and check last char
        for (int i = 0; i < len1; i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = word2.charAt(j);

                //if last two chars equal
                if (c1 == c2) {
                    //update dp value for +1 length
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int delete= dp[i][j + 1] + 1;
                    int insert = dp[i + 1][j] + 1;

                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    dp[i + 1][j + 1] = min;
                }
            }
        }
        //System.out.println(dp[len1][len2]);
        return dp[len1][len2];
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
		findClose(cleft);// goes to left
		findClose(cright);	// goes to right
	}
}
