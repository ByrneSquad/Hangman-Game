
package program3;

public class WordHider {

    private String secretWord;
    private String wordMask;
    private final String HIDE_CHAR = "*";

    WordHider() {
        secretWord = new String();
        wordMask = new String();
    }

    public String getWordMask() {
        return wordMask;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String newSecretWord) {
        secretWord = newSecretWord.toLowerCase();
        if (secretWord.length() > 0) {
            wordMask = HIDE_CHAR;
            for (int i = 1; i < secretWord.length(); i++) {
                wordMask += HIDE_CHAR;
            }
        }
    }

    public boolean isHiddenWordFound() {
        for (int i = 0; i < wordMask.length(); i++) {
            if(wordMask.charAt(i) == HIDE_CHAR.charAt(0)) {
                return false;
            }
        }
        return true;
    }
    public int revealLetter(String letter) {
        int count = 0;
        String newFoundWord = "";
        if (letter.length() == 1) {
            for (int i = 0; i < secretWord.length(); i++) {
                if ((secretWord.charAt(i) == letter.charAt(0))
                        && (wordMask.charAt(i) == HIDE_CHAR.charAt(0))) {
                    count++;
                    newFoundWord += letter;
                }
                else {
                    newFoundWord += wordMask.charAt(i);
                }
            }
        }
        wordMask = newFoundWord;
        return count;
    }
}