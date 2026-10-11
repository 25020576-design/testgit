class Pair<K,V>{
    private K Key;
    private V Value;
    public Pair(K Key, V Value){
        this.Key=Key;
        this.Value=Value;
    }
    public K getKey() {
        return Key;
    }
    public V getValue() {
        return Value;
    }
    public void setKey(K key) {
        Key = key;
    }
    public void setValue(V value) {
        Value = value;
    }
    
}  
public class Main {
    public static void main(String[] args) {
        Pair<String,Integer> n1 = new Pair("tuoi",20);
        Pair<String,String> n2 = new Pair("Ma sv","Sv001   ");
        Pair<Integer,Integer> n3 = new Pair("105",20);
        
    }
}