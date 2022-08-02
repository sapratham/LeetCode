class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>(k);
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
               que.offer(matrix[i][j]); 
            }
        }
        for(int i = 0 ; i < k - 1 ; i++){
            que.poll();
        }
        return que.poll();
    }
}