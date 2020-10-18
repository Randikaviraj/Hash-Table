public class Node {
    private int value;
    private String key;
    private Node next;
    
    public Node(String key){
        this.key=key;
        this.value=1;
        this.next=null;
    }

    public String getKey(){
        return this.key;
    }

    public int getValue(){
        return this.value;
    }

    public Node getNext(){
        return this.next;
    }

    public void addValue(){
        this.value++;
    }

    public void setNext(Node next){
        this.next=next;
    }
}
