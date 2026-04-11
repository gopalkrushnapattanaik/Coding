
public class CacheEntry<V> {

     V value;

     long ttl;
     
     long creationTime;

     long defaultttl= 30;

    public  CacheEntry(V value, Long ttl){
        this.value=value;
        this.ttl=  ttl!=null ? ttl :defaultttl;
        this.creationTime = System.currentTimeMillis();
    }

    public CacheEntry(){}

     public void  setValue(V value){
        this.value= value;
     }

     public void setTtl(long ttl){
        this.ttl= ttl;
     }

     public long getTtl(){
        return this.ttl;
     }

     public V getValue(){
        return this.value;
     }
     
     public long getCreationTime(){
        return this.creationTime;
     }
     
     public boolean isExpired(){
        long currentTime = System.currentTimeMillis();
        long ageInSeconds = (currentTime - creationTime) / 1000;
        return ageInSeconds > ttl;
     }

}
