// 729. My Calendar I

/*  
21ms -> Beats 73.06%
Memory 45.33MB -> Beats 90.13%
*/

import java.util.*;

class MyCalendar {
    TreeMap<Integer, Integer> books;
    public MyCalendar() {
        books = new TreeMap<>();
    }
    
    public boolean book(int s, int e) {
        java.util.Map.Entry<Integer, Integer> floor = books.floorEntry(s), ceiling = books.ceilingEntry(s);
        if (floor != null && s < floor.getValue()) return false; // (s, e) start within floor
        if (ceiling != null && ceiling.getKey() < e) return false; // ceiling start within (s, e)
        books.put(s, e);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */