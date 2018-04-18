//Hasif Ahmed, Sophia Xia
//APCS2 pd1
//HW #35 -- ...Nor Do Aussies
//2018-04-17

import java.util.ArrayList;

public class ALQueue<T>{
    ArrayList<T> _queue;

    public ALQueue(){
	_queue = new ArrayList<T>(); //instantiate ArrayList
    }

    public T dequeue(){
	//O(n) time because the ArrayList has to make a new array and shift everything over
	T ret = _queue.remove(0); 
	return ret;
    }

    public void enqueue(T x){
	//O(1) time because the element will just add onto the end of the array
	//Note: It will be O(n) if the array in arrayList is too small and needs to be expanded
	_queue.add(x);
    }

    public boolean isEmpty(){
	return _queue.size() == 0;
    }

    public T peekFront(){
	return _queue.get(0);
    }

    public static void main(String[] args){
	
	ALQueue<String> Wings = new ALQueue();
	System.out.println("Wings Queuing...............");
	Wings.enqueue("Begin");
	Wings.enqueue("Lie");
	Wings.enqueue("Stigma");
	Wings.enqueue("First Love");
	Wings.enqueue("Reflection");
	Wings.enqueue("MAMA");
	Wings.enqueue("Awake");
	System.out.println(Wings.dequeue()); //Begin
	System.out.println(Wings.dequeue()); //Lie
	System.out.println(Wings.dequeue()); //Stigma
	System.out.println(Wings.dequeue()); //First Love
	System.out.println(Wings.dequeue()); //Reflection
	System.out.println(Wings.dequeue()); //MAMA
	System.out.println(Wings.dequeue()); //Awake
	
	ALQueue<Integer> Ynwa = new ALQueue();
	System.out.println("Ynwa Queuing...............");
	Ynwa.enqueue(4);
	Ynwa.enqueue(21);
	Ynwa.enqueue(2);
	Ynwa.enqueue(3);
	System.out.println(Ynwa.dequeue()); //4
	System.out.println(Ynwa.dequeue()); //21
	System.out.println(Ynwa.dequeue()); //2
	System.out.println(Ynwa.dequeue()); //3

    }
    
}
