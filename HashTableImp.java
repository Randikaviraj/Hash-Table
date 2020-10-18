/*********************************************
 
	* CO322: Data structures and algorithms
 
	* Implementation of the hashTable
 *********************************************/
import java.lang.Math;

class HashTableImp implements HashTable {

    

	/* Put your code here */
	private Node hashtable[];
	private int N;
    

	public HashTableImp(int buckets) {
	
	// create a open hash table with given number of buckets 
		this.hashtable=new Node[buckets];
		this.N=buckets;
    
	}



	public void insert(String key){
		int bucket=this.hashFunc(key);

		if(hashtable[bucket]!=null){
			Node next=hashtable[bucket];
			Node prev=hashtable[bucket];
			while(next!=null){
				if (key.equals(next.getKey())) {
					next.addValue();
					return;	
				}
				prev=next;
				next=next.getNext();
			}
			prev.setNext(new Node(key));

		}else{
			hashtable[bucket]=new Node(key);
			return;
		}

	}

	public int search(String key){
		int bucket=this.hashFunc(key);

		if(hashtable[bucket]!=null){
			Node next=hashtable[bucket];
			while(next!=null){
				if (key.equals(next.getKey())) {
					
					return next.getValue();	
				}
				next=next.getNext();
			}
			return 0;

		}else{
			return 0;
		}

	}

	private int hashFunc(String key){
		int val=0;
		for (int i = 0; i < key.length(); i++) {
			val=(int)key.charAt(i)*(128^i);
		}

		return (val+5)%N;
	}

	public double average(){
		double avg=0;
		int count=0;
		for (Node node : hashtable) {
			while(node!=null){
				count++;
				node=node.getNext();
			}
		}
		avg=count/this.N;
		return avg;
	}

	public int max(){
		int max=0;
		int count=0;
		for (Node node : hashtable) {
			while(node!=null){
				count++;
				node=node.getNext();
			}
			if (max<count) {
				max=count;
			}
		}
		
		return max;
	}

	public int min(){
		int min=0;
		int count=0;
		for (Node node : hashtable) {
			while(node!=null){
				count++;
				node=node.getNext();
			}
			if (min >count) {
				min=count;
			}
		}
		return min;
	}

	public double standDV(){
		double std=0;
		double avg=this.average();
		int count=0;
		for (Node node : hashtable) {
			while(node!=null){
				count++;
				node=node.getNext();
			}
			std=std+Math.pow(count-avg,2);
		}

		std=Math.pow(std/(this.N-2),0.5);
		std=std/(this.N-2);
		return std;
	}

    



}// end HashTableImp 
