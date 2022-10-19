class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((x, y) -> (x.getValue() == y.getValue() ? x.getKey().compareTo(y.getKey()) : y.getValue() - x.getValue()));

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        while (k-- > 0) {
            res.add(pq.poll().getKey());
        }

        return res;
    }
}
