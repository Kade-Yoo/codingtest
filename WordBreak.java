import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        String firstStr = wordDict.get(0);

        Pair beforePair = new Pair(s.indexOf(firstStr), firstStr.length());
        while(s.length() > 1) {
            if (beforePair.getIndex() == -1) {
                return false;
            }

            for (String segmentedStr : wordDict) {
                int index = s.indexOf(segmentedStr);
                System.out.println("beforeIndex : " + beforePair.getIndex() + " " + " : " + index + " length : " + beforePair.getLength());

                if ((beforePair.getIndex() + beforePair.getLength()) == index) {
                    beforePair.setIndex(0);
                    beforePair.setLength(segmentedStr.length());
                    s = s.substring(index);
                    System.out.println("s = " + s);
                    break;
                }
            }
        }

        return true;
    }

    public static class Pair {
        int index;
        int length;

        public Pair(int index, int length) {
            this.index = index;
            this.length = length;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        boolean firstTest = wordBreak.wordBreak("leetcode", Arrays.asList("leet","code"));
        System.out.println("firstTest = " + firstTest);

        boolean secondTest = wordBreak.wordBreak("applepenapple", Arrays.asList("apple","pen"));
        System.out.println("secondTest = " + secondTest);

        boolean thirdTest = wordBreak.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat"));
        System.out.println("secondTest = " + thirdTest);
    }
}
