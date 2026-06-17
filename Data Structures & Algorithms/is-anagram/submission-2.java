class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() == 1 || t.length() == 1) {
            if (!s.equals(t)) return false;
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }

        int[] alphs = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphs[(int) s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphs[(int) t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < alphs.length; i++) {
            if (alphs[i] >= 1 || alphs[i] < 0) return false;
        }
        return true;
    }
}
