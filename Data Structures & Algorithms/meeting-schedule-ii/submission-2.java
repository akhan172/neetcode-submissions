class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals.isEmpty()) {
            return 0;
        }

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Interval curr : intervals) {

            // A room has become free
            if (!pq.isEmpty() && curr.start >= pq.peek()) {
                pq.poll();
            }

            // Occupy a room
            pq.offer(curr.end);
        }

        return pq.size();
    }
}