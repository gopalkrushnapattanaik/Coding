public class HitCounter {
    int [] times;
    int [] counts;
    public HitCounter(){
       this.times = new int[300];
        this.counts = new int[300];
    }

    public void hit(int timestamp){
        int times_index = timestamp % 300;
        if(times[times_index]== timestamp){
            System.out.println("timestamp eixsts "+ times_index);
            counts[times_index]++;
        }else{
            times[times_index]=timestamp;
            counts[times_index]=1;
        }
    }

    //return the hit count of last 5 mins
    public int getHits(int timeStamp){
        int totalHits=0;
        for (int i=0;i<300;i++){
            //add the counts only if the time diffrence from the current time is less than 5 mins
           if(timeStamp- times[i] < 300){
               totalHits=totalHits+counts[i];
           }
        }
        return totalHits;
    }

}
