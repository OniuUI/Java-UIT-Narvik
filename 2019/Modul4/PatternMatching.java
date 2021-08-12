package Modul4;

public class PatternMatching {
    public int PatternMatcher(String str, String ptrn) {
        if (str == null || ptrn == null || str.isEmpty() || ptrn.isEmpty()){
            return -1;
        }
        int k = 0, foundMatch = 0;
        for (int i = 0; i < str.length(); i++) {
            if (ptrn.charAt(k) == str.charAt(i)) {
                k++;
                if (k == 1) {
                    foundMatch = i;
                }
                if (k == ptrn.length()) {
                    return foundMatch;
                }
            } else if (k > 0) {
                k = 0; i--;
            }
        }return -1;
    }
}
