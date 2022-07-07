class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parent = new int[s.length()];
        rank = new int[s.length()];
        
        for(int i=0; i<s.length(); i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(List<Integer> list : pairs) {
            int xl = find(list.get(0));
            int yl = find(list.get(1));
            
            if(xl != yl) {
                union(xl, yl);
            }
        }
        
        PriorityQueue<Character>[] pq = new PriorityQueue[s.length()];
        for(int i=0; i<s.length(); i++) {
            pq[i] = new PriorityQueue<>();
        }
        
        for(int i=0; i<s.length(); i++) {
            int il = find(i);
            pq[il].add(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            int il = find(i);
            char ch = pq[il].remove();
            sb.append(ch);
        }
        
        return sb.toString();
    }
    
    int parent[];
    int rank[];
    
    public int find(int x) {
        if(parent[x] == x) {
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    public void union(int x, int y) {
        if(rank[x] > rank[y]) {
            parent[y] = x;
        } else if(rank[y] > rank[x]) {
            parent[x] = y;
        } else {
            parent[y] = x;
            rank[x]++;
        }
    }
    
}
