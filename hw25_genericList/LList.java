// Selina Zou
// APCS2 pd1
// HW24: On the DLL
// 2018-03-26

/*****************************************************
 * class LList
 * Implements linked list of DLLNodes
 * new in v3: DLLNodes
 *****************************************************/

public class LList<T> implements List<T> //your List interface must be in same dir
{ 

    //instance vars
    private DLLNode<T> _head;
    private DLLNode<T> _tail;
    private int _size;

    // constructor -- initializes instance vars
    public LList( )
    {
	_head = null;
	_tail = null;
	_size = 0;
    }


    //--------------v  List interface methods  v--------------
    
    public boolean add( T newVal )
    {
	_tail = new DLLNode<T>( _tail, newVal, null );

	if ( _size == 0 ) 
	    _head = _tail;
	else 
	    _tail.getPrev().setNext( _tail );
	
	_size++;
	return true;
    }

    
    public T get( int index )
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	T retVal;
	DLLNode<T> tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    }


    public T set( int index, T newVal )
    {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode<T> tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	T oldVal = tmp.getCargo();

	//modify target node's cargo
	tmp.setCargo( newVal );

	return oldVal;
    }


    //return number of nodes in list
    public int size() { return _size; }

    public T getFirst() { return _head.getCargo(); }

    public T getLast() { return _tail.getCargo(); }
    

    //insert a node containing newVal at position index
    public void add( int index, T newVal ) {
		
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
	
	if (index == 0){
	    add( newVal );
	}
	
	if (index == size()){
	    _tail = new DLLNode<T>( _tail, newVal, null );

	    if ( _size == 0 ) 
		_head = _tail;
	    else 
		_tail.getPrev().setNext( _tail );
	    _size++;
	}

	else {
	    DLLNode<T> newNode = new DLLNode<T>( null, newVal, null );
	    DLLNode<T> tmp = _head; //create alias to head

	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
		tmp = tmp.getNext();

	    //pointer to insertion index
	    DLLNode<T> tmp1 = tmp.getNext();
	    
	    //insert new node
	    newNode.setNext( tmp1 );
	    newNode.setPrev( tmp );
	    tmp.setNext( newNode );
	    tmp.setPrev( newNode );
	    
	    //increment size attribute
	    _size++;
	}
    }


    //remove node at pos index, return its cargo
    public T remove( int index ) {

	T retVal;

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
	
	if ( index == 0){
	    retVal = getFirst();
	    if ( size() == 1 ) {
		_head = _tail = null;
	    }
	    else {
		_head = _head.getNext();
		_head.setPrev( null );
	    }
	    _size--;
	    return retVal;
	}
	    
	if (index == size() -1){
	    retVal = getLast();
	    if ( size() == 1 ) {
		_head = _tail = null;
	    }
	    else {
		_tail = _tail.getPrev();
		_tail.setNext( null );
	    }
	    _size--;
	    return retVal;
	}
	
	else{
	    DLLNode<T> tmp = _head; //create alias to head

	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
		tmp = tmp.getNext();

	    //check target node's cargo hold
	    retVal = tmp.getNext().getCargo();

	    //remove target node
	    tmp.setNext( tmp.getNext().getNext() );
	    tmp.getNext().setPrev(tmp);
    
	    //decrement size attribute
	    _size--;

	    return retVal;
	}
    }

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString()
    {
	String retStr = "HEAD->";
	DLLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args )
    {

	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
	System.out.println( james );

	james.add(0,"whut");
	System.out.println( "...after add(0,whut): " );
	System.out.println( james );

	james.add(4,"phat");
	System.out.println( "...after add(4,phat): " );
	System.out.println( james );

	System.out.println( "...after remove last: " 
			    + james.remove( james._size-1) );
	System.out.println( james );

	System.out.println( "...after remove(0): " + james.remove(0) );
	System.out.println( james );

	System.out.println( "...after remove(0): " + james.remove(0) );
	System.out.println( james );

	System.out.println( "...after remove(0): " + james.remove(0) );
	System.out.println( james );
    }

}//end class LList


