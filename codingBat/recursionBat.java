// SOPHIA XIA
// APCS2 PD1
// HW08 -- WARMING IT UP
// 2018-02-20

public class recursionBat{

    /* ------------------------------FACTORIAL------------------------------
       Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).
    */
    public int factorial(int n) {
	int total = 1;
	if (n == 0){
	    return total;
	}
	total = total * n * factorial(n -1);
	return total;
    }
    
    /* ------------------------------BUNNYEARS------------------------------
       We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
    */
    public int bunnyEars(int bunnies) {
	int ears = 0;
	if (bunnies == 0){
	    return ears;
	}
	ears = ears + 2 + bunnyEars(bunnies -1);
	return ears;
    }


    /* ------------------------------FIBONACCI------------------------------
       The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition. The first two values in the sequence are 0 and 1 (essentially 2 base cases). Each subsequent value is the sum of the previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. Define a recursive fibonacci(n) method that returns the nth fibonacci number, with n=0 representing the start of the sequence.
    */
    public int fibonacci(int n) {
	int total = 0;
	if(n == 0){
	    total = total + 0;
	    return total;
	}
	if(n == 1){
	    total = total + 1;
	    return total;
	}
	total = fibonacci(n -1) + fibonacci(n -2);
	return total;
    }

    
    /* ------------------------------BUNNYEARS2------------------------------
       We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
    */
    public int bunnyEars2(int bunnies) {
	int retEars = 0;
	if(bunnies == 0){
	    retEars += 0;
	}
	else{
	    retEars = retEars + 3 - bunnies%2 + bunnyEars2(bunnies-1);
	}
	return retEars;
    }

    /* ------------------------------TRIANGLE------------------------------
       We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.
    */
    public int triangle(int rows) {
	int blocks = 0;
	if (rows == 0){
	    blocks += rows;
	}
	else{
	    blocks = blocks + rows + triangle(rows -1);
	}
	return blocks;
    }
    
    /* ------------------------------SUMDIGITS------------------------------
       Given a non-negative int n, return the sum of its digits recursively (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
    */
    public int sumDigits(int n){
	int sum = 0;
	if(n/10 == 0){
	    sum += n;
	}
	else {
	    sum = sum + n % 10 + sumDigits(n/10);
	}
	return sum;
    }
    /* ------------------------------COUNT7------------------------------
       Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2. (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
    */
    public int count7(int n){
	int ctr = 0;
	if(n % 10 == 7 || n == 7){
	    ctr += 1;
	}
	if (n/10 != 0){
	    ctr = ctr + count7(n/10);
	}
	return ctr;
    }
    /* ------------------------------COUNT8------------------------------
       Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit, except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4. Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
    */
    public int count8(int 8){
	int ctr = 0;
	if(n % 10 == 8 || n == 8){
	    ctr += 1;
	}
	if(n % 100 == 88){
	    ctr += 1;
	}
	if (n/10 != 0){
	    ctr = ctr + count8(n/10);
	}
	return ctr;
    }
    /* ------------------------------POWERN------------------------------
       Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power, so powerN(3, 2) is 9 (3 squared).
    */
    public int powerN(int base, int n){
	int num = 1;
	if(n == 0){
	    num = num * 1;
	}
	if(n == 1){
	    num = num * base;
	}
	num = num * base * powerN(base, n-1);
	return num;
    }
    /* ------------------------------COUNTX------------------------------
       Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
    */
    //looked at the java example solution code to figure out the problem
    //USE .equals NOT == WHEN DEALING WITH STRINGS
    public int countX(String str) {
	int ctr = 0;
	if(str.length() != 0 && str.substring(0,1).equals("x")){
	    ctr += 1;
	}
	if (str.length() != 0){
	    ctr = ctr + countX(str.substring(1));
	}
	return ctr;
    }

    /* ------------------------------COUNTHI------------------------------
       Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.
    */
    public int countHi(String str){
	int ctr = 0;
	if(str.length() >= 2 && str.substring(0,2).equals("hi")){
	    ctr += 1;
	}
	if (str.length() != 0){
	    ctr = ctr + countHi(str.substring(1));
	}
	return ctr;
    }
    /* ------------------------------CHANGEXY------------------------------
       Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.
    */
    public String changeXY(String str){
	String retStr = "";
	if(str.length() != 0 && str.substring(0,1).equals("x")){
	    retStr = retStr + "y";
	}
	else if(str.length() != 0){
	    retStr = retStr + str.substring(0,1);
	}
	if(str.length() != 0){
	    retStr = retStr + changeXY(str.substring(1));
	}
	return retStr;
    }
    
    /* ------------------------------CHANGEPI------------------------------
       Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".
    */
    public String changePi(String str){
	String retStr = "";
	if(str.length() >= 2 && str.substring(0,2).equals("pi")){
	    retStr = retStr + "3.14" + changePi(str.substring(2));
	}
	else if(str.length() != 0){
	    retStr = retStr + str.substring(0,1) + changePi(str.substring(1));
	}
	return retStr;
    }
    /* ------------------------------NOX------------------------------
      Given a string, compute recursively a new string where all the 'x' chars have been removed.
     */
    public String noX(String str){
	String retStr = "";
	if(str.length() != 0 && str.substring(0,1).equals("x")){
	    retStr = retStr + "";
	}
	else if(str.length() != 0){
	    retStr = retStr + str.substring(0,1);
	}
	if(str.length() != 0){
	    retStr = retStr + noX(str.substring(1));
	}
	return retStr;
    }
    /* ------------------------------ARRAY6------------------------------
      Given an array of ints, compute recursively if the array contains a 6. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
     */
    // remember to return the recursive call
    // otherwise, it's evaluated but its return value doesn't matter
    // and only the original call's return value will count
    public boolean array6(int[] nums, int index) {
	boolean ret = false;
	if(index < nums.length && nums[index] == 6){
	    ret = true;
	    return true;
	}
	if(index +1 <= nums.length){
	    return array6(nums, index +1);
	}
	return ret;
    }
    
    /* ------------------------------ARRAY11------------------------------
Given an array of ints, compute recursively the number of times that the value 11 appears in the array. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
     */
    public int array11(int[] nums, int index){
	int ctr = 0;
	if(index < nums.length && nums[index] == 11){
	    ctr ++;
	}
	if(index +1 <= nums.length){
	    ctr = ctr + array11(nums, index +1);
	}
	return ctr;
    }
    
    /* ------------------------------ARRAY220------------------------------
Given an array of ints, compute recursively if the array contains somewhere a value followed in the array by that value times 10. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
     */
    public boolean array220(int[] nums, int index){
	boolean ret = false;
	if(nums.length != 0 && index <= nums.length){
	    for(int i = index; i < nums.length; i++){
		if(nums[index] * 10 == nums[i]){
		    return true;
		}
	    }
	}
	if(index +1 <= nums.length){
	    return array220(nums, index +1);
	}
	return ret;
    }
    /*
     */
    /*
     */
    /*
     */
    /*
     */
    /*
     */
    /*
     */
    /*
     */
    /*
     */
    /*
     */
    /*
     */
    /*
     */
    /*
     */
    /*
     */
}
