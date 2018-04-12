/*****************************************************
 * class Stckr
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr 
{
    public static void main( String[] args )
    {
	System.out.println("hotcakes: ALStack----------------------------------");
	//ARRAY LIST------------------------------------------------------------
	Stack<String> hotcakes = new ALStack<String>();

	System.out.println("Empty?: " + hotcakes.isEmpty());
	System.out.println("\nStacking...");
	hotcakes.push("oh");
	hotcakes.push("dear");
	hotcakes.push("!");
	hotcakes.push("the");
	hotcakes.push("house");
	hotcakes.push("caught");
	hotcakes.push("on");
	hotcakes.push("fire");
	hotcakes.push("insfire");
	hotcakes.push("man");
	System.out.println("Empty?: " + hotcakes.isEmpty());

	System.out.println("\nPoppin...\n");
	//man
	System.out.print(hotcakes.peek());
	System.out.println(hotcakes.pop());
	//insfire
	System.out.print(hotcakes.peek());
	System.out.println(hotcakes.pop());
	//fire
	System.out.print(hotcakes.peek());
	System.out.println(hotcakes.pop());
	//on
	System.out.print(hotcakes.peek());
	System.out.println(hotcakes.pop());
	//caught
	System.out.print(hotcakes.peek());
	System.out.println(hotcakes.pop());
	//house
	System.out.print(hotcakes.peek());
	System.out.println(hotcakes.pop());
	//the
	System.out.print(hotcakes.peek());
	System.out.println(hotcakes.pop());
	//!
	System.out.print(hotcakes.peek());
	System.out.println(hotcakes.pop());
	//dear
	System.out.print(hotcakes.peek());
	System.out.println(hotcakes.pop());
	//oh
	System.out.print(hotcakes.peek());
	System.out.println(hotcakes.pop());

	System.out.println("\nEmpty?: " + hotcakes.isEmpty());

	
	System.out.println("\nTeacakes: LLStack------------------------------");
	//ARRAY LIST------------------------------------------------------------
	Stack<String> teacakes = new LLStack<String>();

	System.out.println("Empty?: " + teacakes.isEmpty());
	System.out.println("\nStacking...");
	teacakes.push("oh");
	teacakes.push("dear");
	teacakes.push("!");
	teacakes.push("the");
	teacakes.push("house");
	teacakes.push("caught");
	teacakes.push("on");
	teacakes.push("fire");
	teacakes.push("insfire");
	teacakes.push("man");
	System.out.println("Empty?: " + teacakes.isEmpty());

	System.out.println("\nPoppin...\n");
	//man
	System.out.print(teacakes.peek());
	System.out.println(teacakes.pop());
	//insfire
	System.out.print(teacakes.peek());
	System.out.println(teacakes.pop());
	//fire
	System.out.print(teacakes.peek());
	System.out.println(teacakes.pop());
	//on
	System.out.print(teacakes.peek());
	System.out.println(teacakes.pop());
	//caught
	System.out.print(teacakes.peek());
	System.out.println(teacakes.pop());
	//house
	System.out.print(teacakes.peek());
	System.out.println(teacakes.pop());
	//the
	System.out.print(teacakes.peek());
	System.out.println(teacakes.pop());
	//!
	System.out.print(teacakes.peek());
	System.out.println(teacakes.pop());
	//dear
	System.out.print(teacakes.peek());
	System.out.println(teacakes.pop());
	//oh
	System.out.print(teacakes.peek());
	System.out.println(teacakes.pop());

	System.out.println("\nEmpty?: " + teacakes.isEmpty());

    }//end main

}//end class

