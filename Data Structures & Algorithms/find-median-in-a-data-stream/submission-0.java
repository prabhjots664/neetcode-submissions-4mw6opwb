class MedianFinder {
    int n = 0;
    PriorityQueue<Integer> mnh = new PriorityQueue<>();
    PriorityQueue<Integer> mxh = new PriorityQueue<>((a,b)->Integer.compare(b,a));

    public MedianFinder() {
        n = 0;
        mnh = new PriorityQueue<>();
        mxh = new PriorityQueue<>((a,b)->Integer.compare(b,a));
    }
    
    public void addNum(int num) {

            if(mxh.size()>0 && num<=mxh.peek()){
                mxh.offer(num);
            } else {
                mnh.offer(num);
            }
            if(mxh.size()<mnh.size()){
                mxh.offer(mnh.poll());
            } else if(mxh.size() > 1 + mnh.size()){
                mnh.offer(mxh.poll());
            }
        
        n++;
    }
    
    public double findMedian() {
        if(n%2==0){
            return (mxh.peek() + mnh.peek())/2.0;
        } else {
            return mxh.peek();
        }
    }
}
