class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < stones.length ; i++) que.add(stones[i]);
        while(que.size() > 1){
            int y = que.poll();
            int x = que.poll();
            if(x != y) que.add(y-x);
        }
        return (que.size() == 0)? 0:que.poll();
    }
}