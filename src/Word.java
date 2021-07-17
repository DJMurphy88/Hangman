public class Word {

        private String word;
        public String getWord() {
            return word;
        }
        public void setWord(String word) {
            this.word = word;
        }

        private int length;
        public int getLength() {
            return length;
        }
        public void setLength(int length) {
            this.length = length;
        }

        public Word (String word, int length) {
            setWord(word);
            setLength(length);
        }
    }