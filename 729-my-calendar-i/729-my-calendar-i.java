class MyCalendar {
    ArrayList<int[]> booking;
    public MyCalendar() {
        booking = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] i : booking){
            if(i[0] < end && i[1] > start){
                return false;
            }
        }
        booking.add(new int[]{start , end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */