//Selina Zou, Sophia Xia
//APCS2 pd01
//HW21b -- We Got a Little Ol’ Convoy...
//2018-03-20

/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class LLNode
{
    //instance vars
    private String _cargo; //data stored
    private LLNode _nextNode; //pointer to next LLNode
    
    // constructor 
    public LLNode(String val, LLNode next)
    {
	_cargo = val;
	_nextNode = next;
    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo()
    {
	return _cargo;
    }

    public LLNode getNext()
    {
	return _nextNode;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCargo )
    {
	String retCargo = getCargo();
	_cargo = newCargo;
	return retCargo;
    }

    public LLNode setNext( LLNode next )
    {
	LLNode retNext = getNext();
	_nextNode = next;
	return retNext;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    {
	return _cargo.toString();
    }


    //main method for testing
    public static void main( String[] args )
    {
	//declares and prints new node
        LLNode firstNode = new LLNode ( "first", null);
	System.out.println(firstNode);

	//sets and prints linked node
	firstNode.setNext(new LLNode ( "second", null));
	System.out.println(firstNode.getNext());

	//sets and prints third linked node
	firstNode.getNext().setNext(new LLNode ( "third", null));
	System.out.println(firstNode.getNext().getNext());

	//sets and prints fourth linked node
	firstNode.getNext().getNext().setNext(new LLNode ("fourth", null));
	System.out.println(firstNode.getNext().getNext().getNext());
	
    }//end main

}//end class LLNode
 
