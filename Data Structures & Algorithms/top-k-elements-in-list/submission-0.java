class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (Integer num: nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) result.add(findKMostFrequentElements(frequencyMap, k));

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    public int findKMostFrequentElements(Map<Integer, Integer> frequencyMap, int k) {
        int maxFreq = 0;
        int mostFrequentElement = 0;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostFrequentElement = entry.getKey();
            }
        }
        frequencyMap.put(mostFrequentElement, -1);

        return mostFrequentElement;

    }
}
