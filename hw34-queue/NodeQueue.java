//Sophia Xia
//APCS2 pd1
//HW34-- The English Do Not Wait In Line for Soup or Anything Else; They "Queue Up"
//2018-04-13

public class NodeQueue<Quasar> implements Queue<Quasar>{

    private LLNode<Quasar> _head;

    public NodeQueue(){
	_head = null;
    }
    
    //~~~~~~~~~~~~~~~~~~begin AP subset~~~~~~~~~~~~~~~~~~

    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public Quasar dequeue(){
	Quasar temp = _head.getValue();
	_head = _head.getNext();
	return temp;
    }

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( Quasar x ){
	LLNode<Quasar> temp = _head;
	LLNode<Quasar> newNode = new LLNode(x, null);
	if(_head == null){
	    _head = newNode;
	}
	else{
	    while(temp.getNext()!= null){
		temp = temp.getNext();
	    }
	    temp.setNext(newNode);
	}
    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty(){
	return _head.getValue() == null;
    }

    //Returns the first element of the queue without dequeuing it.
    public Quasar peekFront(){
	return _head.getValue();
    }
    
    //~~~~~~~~~~~~~~~~~~~end AP subset~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args){
	
	NodeQueue<String> Wings = new NodeQueue();
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
	
	NodeQueue<Integer> Ynwa = new NodeQueue();
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
