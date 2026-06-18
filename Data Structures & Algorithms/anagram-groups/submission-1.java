class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 1) return List.of(List.of(strs[0]));

        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> seenWords = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            if (seenWords.containsKey(strs[i])) continue;
            seenWords.put(strs[i], 1);
            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(strs[i], strs[j])) {
                    temp.add(strs[j]);
                    seenWords.put(strs[j], 1);
                }
            }
            result.add(temp);
        }

        return result;
    }

    public boolean isAnagram(String x, String y) {
        if (x.length() != y.length()) return false;
        
        int[] alphs = new int[26];

        for (int i = 0; i < x.length(); i++) {
            alphs[(int) x.charAt(i) - 'a']++;
        }
        for (int i = 0; i < y.length(); i++) {
            alphs[(int) y.charAt(i) - 'a']--;
        }

        for (int i = 0;  i < alphs.length; i++) {
            if (alphs[i] > 0 || alphs[i] < 0) {
                return false;
            }
        }

        return true;
    }
}
