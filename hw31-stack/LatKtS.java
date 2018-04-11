// Sophia Xia
// APCS2 pd1
// HW31 -- Stack: What Is It Good For?               well, this.
// 2018-04-10

/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s )
    {
	Latkes temp = new Latkes(s.length());
	int ctr = 0;
        String retStr = "";
	//push each char in the String into a stack
	while(ctr < s.length()){
	    temp.push(s.substring(ctr, ctr +1));
	    ctr ++;
	}
	//pop each char and add to retStr
	while(ctr != 0){
	    retStr = retStr + temp.pop();
	    ctr --;
	}
	return retStr;
    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s )
    {
	Latkes temp = new Latkes(s.length());
	int ctr = 0;
	//if only Latkes had a accessor for _stackSize...
	int size = 0;
	while(ctr < s.length()){
	    //System.out.print(s.substring(ctr, ctr +1));
	    temp.push(s.substring(ctr, ctr +1));
	    if(size >= 1){
		//System.out.println("pass");
		//System.out.print(temp.peek());
		if(temp.peek().equals("(") &&
		   s.substring(ctr, ctr +1).equals(")")){
		    temp.pop();
		    temp.pop();
		    size = size -2;
		}
		else if(temp.peek().equals("[") &&
		   s.substring(ctr, ctr +1).equals("]")){
		    temp.pop();
		    temp.pop();
		    size = size -2;
		}
		else if(temp.peek().equals("{") &&
		   s.substring(ctr, ctr +1).equals("}")){
		    temp.pop();
		    temp.pop();
		    size = size -2;
		}		
	    }
	    ctr ++;
	    size ++;
	}
	return temp.isEmpty();
    }//end allMatched()


    //main method to test
    public static void main( String[] args )
    {
	  System.out.println(flip("stressed"));
	  System.out.println(allMatched( "({}[()])" )); //true
	  System.out.println(allMatched( "([)]" ) ); //false
	  System.out.println(allMatched( "(){([])}" ) ); //true
	  System.out.println(allMatched( "](){([])}" ) ); //false
	  System.out.println(allMatched( "(){([])}(" ) ); //false
	  System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }

}//end class LatKtS
