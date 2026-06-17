class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (Integer num : nums) {
            if (hashMap.containsKey(num)) return true;
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        return false;
    }
}