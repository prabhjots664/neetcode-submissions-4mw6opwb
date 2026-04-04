class MedianFinder {

    PriorityQueue<Integer> left = new PriorityQueue<>((a,b)->(Integer.compare(b,a)));//maxHeap - will contain extra or odd element
    PriorityQueue<Integer> right = new PriorityQueue<>();
    int n = 0;

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        n++;
        if(left.size()>0 && num <= left.peek()){
            left.offer(num);
        } else {
            right.offer(num);
        }
        if(right.size() > left.size()){
            left.offer(right.poll());
        } else if(left.size() > 1 + right.size()){
            right.offer(left.poll());
        }
    }
    
    public double findMedian() {
        if(n%2==0){
            return (left.peek()+right.peek())/2.0;
        } else {
            return left.peek();
        }
    }
}
