import java.util.ArrayList;
import java.util.List;

/*
    This problem was asked by Palantir.

    Write an algorithm to justify text. Given a sequence of words and an integer line length k,
    return a list of strings which represents each line, fully justified.

    More specifically, you should have as many words as possible in each line. There should be
    at least one space between each word. Pad extra spaces when necessary so that each line has exactly length k.
    Spaces should be distributed as equally as possible, with the extra spaces, if any, distributed
    starting from the left.

    If you can only fit one word on a line, then you should pad the right-hand side with spaces.

    Each word is guaranteed not to be longer than k.

    For example, given the list of words ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"]
    and k = 16, you should return the following:

    ["the  quick brown", # 1 extra space on the left
    "fox  jumps  over", # 2 extra spaces distributed evenly
    "the   lazy   dog"] # 4 extra spaces distributed evenly
 */
public class Solution {

    /**
     * Brute force solution. Still have bugs but the point is there.
     * 
     * @param words
     * @param k
     * @return
     */
    public List<String> justify(String[] words, int k) {
        String space = " ";
        int lineSize = 0;
        List<String> ans = new ArrayList<>();
        List<String> line = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            int spaceLeft = k - lineSize;
            String word = words[i];
            int wordLen = word.length();
            if(wordLen == spaceLeft) {
                //space left just fit the word
                line.add(word);
                ans.add(convert(line));
                lineSize = 0;
                line = new ArrayList<>();
            } else if(wordLen < spaceLeft) {
                //more space to add
                line.add(word + space);
                lineSize += word.length() + 1;
            } else if(wordLen > spaceLeft) {
                //space is not enough. two scenarios
                //1. this is a one word line. append extra space on right hand side and add this word
                //2. this is a multi word line. distribute space at the end of each existing word, return a line and add this word.
                if(line.size() == 0) {
                    //one word line
                    while(spaceLeft > 0) {
                        word += space;
                        spaceLeft--;
                    }
                    ans.add(word);
                } else {
                    while(spaceLeft > 0) {
                        for(int j = 0; j < line.size() - 1; j++) {
                            line.set(j, line.get(j) + space);
                            spaceLeft--;
                        }
                    }
                    ans.add(convert(line));
                    line = new ArrayList<>();
                    line.add(word + space);
                    lineSize = word.length() + 1;
                }
            }
        }

        ans.add(convert(line));

        return ans;
    }

    String convert(List<String> line) {
        StringBuilder builder = new StringBuilder();
        for(String s : line) {
            builder.append(s);
        }
        return builder.toString();
    }
}
