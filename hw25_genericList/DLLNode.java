// Selina Zou
// APCS2 pd01
// HW25
// 2018-03-26

/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

public class DLLNode<T>
{
    private T _cargo;    //cargo may only be of type String
    private DLLNode<T> _nextNode, _prevNode; //pointers to next, prev DLLNodes

    public DLLNode(  DLLNode<T> prev, T value, DLLNode<T> next ){
	_cargo = value;
	_nextNode= next;
	_prevNode= prev;
    }

    public T getCargo(){
	return _cargo;
    }

    public DLLNode<T> getNext(){
	return _nextNode;
    }
    
    public DLLNode<T> getPrev(){
	return _prevNode;
    }

    public T setCargo( T newCargo ){
	_cargo = newCargo;
	return _cargo;
    }

    public DLLNode<T> setNext( DLLNode<T> newNext ){
	_nextNode = newNext;
	return _nextNode;
    }


    public DLLNode<T> setPrev (DLLNode<T> newPrev){
	_prevNode = newPrev;
	return newPrev;
    }

    // override inherited toString
    public String toString(){
	return _cargo.toString();
    }

    
}//end class DLLNode
