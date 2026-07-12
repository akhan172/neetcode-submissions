class MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;
    public MedianFinder() {
        left = new PriorityQueue<Integer>(Comparator.reverseOrder());
        right = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(left.size()==0 || num <= left.peek()){
            left.offer(num);
        }else{
            right.offer(num);
        }
        if(left.size()>right.size()+1){
            right.offer(left.poll());
        }else if(right.size()>left.size()){
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() ==  right.size()){
            return (left.peek()+right.peek())/2.0;
        }
        return left.peek();
    }
}
