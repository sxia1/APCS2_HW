// Sophia Xia
// APCS2 pd1
// HW30 -- Stacks on Stacks on Stacks on Stacks… …  (Do I Smell Recursion?)
// 2018-04-09

/*****************************************************
 * skeleton for class Latkes
 * Implements a stack of Strings using an encapsulated array
 *****************************************************/

//Research Corner: When an array is initialized and not the individual
//indexes, the indexes of the array will be filled with 0s or nulls
//depending on the data type.

//So if they default to 0 or null, why don't we just set those indexes back
//to the default to remove elements rather than copying the entire array
//into another array of the same size just without the element that is being
//removed?

public class Latkes
{
    //I don't think that arrays are the best data structure to use.
    //     It uses memory even for the empty indexes, and copying all the
    //     data into a new array of a different size seems inefficient.
    //I considered using DLLNodes and LList for this but I couldn't figure
    //     out a way around making another variable to store the maxSize.
    
    private String [] _stack;
    private int _stackSize;

    //constructor
    public Latkes( int size )
    {
	_stack = new String[size];
	_stackSize = 0;
    }

    //means of insertion
    public void push( String s )
    {
	if( !isFull() ){
	    _stack[_stackSize] = s;
	    _stackSize ++;
	}
    }

    //means of removal
    public String pop( )
    {
	if( !isEmpty() ){
	    String remVal = _stack[_stackSize -1];
	    //I'm pretty sure this is not a good idea...
	    //I could copy the entire array, but isn't that too costly
	    //runtime wise for extremely large stacks?
	    _stack[_stackSize -1] = "empty";
	    _stackSize --;
	    return remVal;
	}
	return "Stack is Empty";
    }

    //chk for emptiness
    public boolean isEmpty()
    {
	return _stackSize == 0;
    }

    //chk for fullness
    public boolean isFull()
    {
	return _stackSize == _stack.length;
    }


    //main method for testing
    public static void main( String[] args )
    {
	Latkes tastyStack = new Latkes(10);

	tastyStack.push("aoo");
	tastyStack.push("boo");
	tastyStack.push("coo");
	tastyStack.push("doo");
	tastyStack.push("eoo");
	tastyStack.push("foo");
	tastyStack.push("goo");
	tastyStack.push("hoo");
	tastyStack.push("ioo");
	tastyStack.push("joo");
	tastyStack.push("coocoo");
	tastyStack.push("cachoo");

	//cachoo
	System.out.println( tastyStack.pop() );
	//coocoo
	System.out.println( tastyStack.pop() );
	//joo
	System.out.println( tastyStack.pop() );
	//ioo
	System.out.println( tastyStack.pop() );
	//hoo
	System.out.println( tastyStack.pop() );
	//goo
	System.out.println( tastyStack.pop() );
	//foo
	System.out.println( tastyStack.pop() );
	//eoo
	System.out.println( tastyStack.pop() );
	//doo
	System.out.println( tastyStack.pop() );
	//coo
	System.out.println( tastyStack.pop() );
	//boo
	System.out.println( tastyStack.pop() );
	//aoo
	System.out.println( tastyStack.pop() );

	//stack empty by now; SOP(null)
	System.out.println( tastyStack.pop() );
      
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main()

}//end class Latkes
