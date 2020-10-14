public class WordFreq implements Comparable<WordFreq> {
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
		//return this.word.compareTo(cWord.word);
		return this.freq.compareTo(cWord.freq);
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
	public void findClose(List<WordFreq> list){// replace for going through a list of the dictionary
		for(int j = 0; j < list.length; j++){
			int distance = minDistance(this.word, list.get(j));// to get distance between this word and the current dic word 
			for (int i = 0; i < 10; i++){// goes through the " close matches list " 
				if (this.matchCase.off[i] == 0 || this.matchCase.off[i] > distance){// if it hasn't been filled or the distance of the current dic word is shorter
					this.matchCase.matches[i] = list.get(j);// the place in matches will be filled with current dic word 
					this.matchCase.off[i] = distance; 
					break;// and out of loop it goes 
				} 
			}
		}
	}
}
