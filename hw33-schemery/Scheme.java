//Sophia Xia
//APCS2 pd1
//HW -- 33: What a Racket or: How I Learned to Stop Worrying and Love the Stack
//2018-04-12

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. split the string into an array according to whitespace
 *   2. starting from the beginning of the array, push strings into stacks
 *   3. if an operation, push to operations stack using numerical representation
 *   4. if open parenthesis or number push to numbers stack
 *   5. if closed parenthesis, add the return val of unloading numbers using
 *      the first operand in operations stack
 *   6. repeat the procedure until you iterate through the entire array
 *   7. return the pop val of numbers stack. PROFIT!
 *
 * STACK OF CHOICE: Linked List by Sophia Xia
 * b/c ... Using two stacks, means that using an ArrayList will waste memory
 * while LinkedLists won't.
 ******************************************************/

public class Scheme
{
    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns the simplified value of the expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
    public static String evaluate( String expr ) 
    {
	String[] exprArr = expr.split("\\s+");
	int ctr = 0;
	LLStack<String> numbers = new LLStack();
	LLStack<Integer> operations = new LLStack();

	while(exprArr.length > ctr){
	    // If the String is an Operation
	    if(exprArr[ctr].equals("+")){
		operations.push(1);
	    }
	    else if(exprArr[ctr].equals("-")){
		operations.push(2);
	    }
	    else if(exprArr[ctr].equals("*")){
		operations.push(3);
	    }
	    // If the String is a parenthesis
	    else if(exprArr[ctr].equals("(")){
		numbers.push(exprArr[ctr]);
	    }
	    else if(exprArr[ctr].equals(")")){
		String temp = unload(operations.pop(), numbers);
		System.out.println(temp);
		System.out.println(numbers.pop());
		numbers.push(temp);
	    }
	    // If the String is a number
	    else{
		numbers.push(exprArr[ctr]);
	    }
	    ctr ++;
	}
	return numbers.pop();
    }//end evaluate()


    /****************************************************** 
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren is seen thru peek().
     *           Returns the result of operating on sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload( int op, LLStack<String> numbers ) 
    {
	int result = 0;
	if(op == 1){
	    while(!numbers.peek().equals("(")){
		result = result + Integer.parseInt(numbers.pop());
	    }
	}
	else if(op == 2){
	    int temp = 0;
	    while(!numbers.peek().equals("(")){
		temp = Integer.parseInt(numbers.pop());
		result = result - temp;
	    }
	    result = result + temp + temp;
	}
	else if(op == 3){
	    result = 1;
	    while(!numbers.peek().equals("(")){
		result = result * Integer.parseInt(numbers.pop());
	    }
	}
	return "" + result;
    }//end unload()

    
    /*
    //optional check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber( String s ) {
    try {
    Integer.parseInt(s);
    return true;
    }
    catch( NumberFormatException e ) {
    return false;
    }
    }
    */


    //main method for testing
    public static void main( String[] args )
    {

	  String zoo1 = "( + 4 3 )";
	  System.out.println(zoo1);
	  System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	  //...7

	  String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	  System.out.println(zoo2);
	  System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	  //...17

	  String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	  System.out.println(zoo3);
	  System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	  //...29

	  String zoo4 = "( - 1 2 3 )";
	  System.out.println(zoo4);
	  System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	  //...-4
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }//main

}//end class Scheme
