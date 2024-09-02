package interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomII {

    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 使用小顶堆存储会议的结束时间
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++){
            // 如果当前会议的开始时间 >= 堆中最早的结束时间，弹出最早的结束时间
            if(intervals[i][0] > pq.peek()){
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}
