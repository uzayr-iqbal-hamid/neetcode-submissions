class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int maxLength = 0;

        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            while (seen.containsKey(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l += 1;
            }
            seen.put(s.charAt(r), 1);
            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }
}
