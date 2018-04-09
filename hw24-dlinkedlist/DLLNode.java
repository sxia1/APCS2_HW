/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

public class DLLNode{
    
    private String _cargo;    //cargo may only be of type String
    private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

    
    // constructor 
    public LLNode(String val, LLNode next){
	_cargo = val;
	_nextNode = next;
    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo(){
	return _cargo;
    }

    public LLNode getNext(){
	return _nextNode;
    }

    public LLNode getPrev(){
	return _prevNode;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCargo ){
	String retCargo = getCargo();
	_cargo = newCargo;
	return retCargo;
    }

    public LLNode setNext( LLNode next ){
	LLNode retNext = getNext();
	_nextNode = next;
	return retNext;
    }

    public LLNode setPrev( LLNode prev ){
	LLNode retPrev = getPrev();
	_prevNode = prev;
	return retPrev;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString(){
	return _cargo.toString();
    }

}//end class DLLNode
