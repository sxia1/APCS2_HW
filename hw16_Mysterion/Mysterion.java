//Sophia Xia
//APCS2 pd1
//HW16 -- About Face
//2018-03-07

public class Mysterion{

    /* Purpose of function: ???
       parameter a: is the lower bound for the area of effect
       parameter b: is the upper bound for the area of effect
       only area a to b will be changed in the area unless parameter c is outside of the upper lower bound limits
       parameter c: ???
     */
    
    //Mysterion = ??
    //a = lower bound
    //b = upper bound
    //c = ??
    public static int Mysterion(int[] arr, int a, int b, int c){
	int v = arr[c];

	int temp = arr[c];
	arr[c] = arr[b];
	arr[b] = temp;

	int s = a;
	for(int i = a; i < b-1; i++){
	    if (arr[i] < v){
		temp = arr[s];
		arr[s] = arr[i];
		arr[i] = temp;
		s += 1;
	    }
	}
	temp = arr[b];
	arr[b] = arr[s];
	arr[s] = temp;
	return s;
    }

    public static String toString(int[] arr){
	String str = "";
	for (int i = 0; i < arr.length; i++){
	    str = str + arr[i] + " ";
	}
	return str;
    }
    
    public static void main (String[] args){

	int[] arrA = {7,1,5,12,3};
	int[] arrB = {1,2,3,4,5};
	int[] arrC = {5,4,3,2,1};
	int[] arrD = {1,2,3,4,5,6,7,8,9};
	int[] arrE = {9,8,7,6,5,4,3,2,1};
	
	// TESTING ARRA
	System.out.println(toString(arrA)); //7 1 5 12 3

	//Mysterion(arrA,0,4,0);
	//System.out.println(toString(arrA)); //3 1 5 7 12
	
	//Mysterion(arrA,0,4,1);
	//System.out.println(toString(arrA)); //1 3 5 12 7

	//Mysterion(arrA,0,4,2);
	//System.out.println(toString(arrA)); //1 3 5 12 7

	//Mysterion(arrA,0,4,3);
	//System.out.println(toString(arrA)); //7 1 5 12 3
	
	//Mysterion(arrA,0,4,4);
	System.out.println(toString(arrA)); //1 3 5 12 7
	
	// TESTING ARRB
	System.out.println(toString(arrB)); //1 2 3 4 5
	//c = 0 to 3 then // 1 2 3 4 5
	Mysterion(arrB,0,4,4);
	System.out.println(toString(arrB)); //1 2 3 5 4

	// TESTING ARRC
	System.out.println(toString(arrC)); //5 4 3 2 1
	Mysterion(arrC,0,4,2);
	System.out.println(toString(arrC)); //1 3 5 2 4

	// TESTING ARRD
	System.out.println(toString(arrD)); //1 2 3 4 5 6 7 8 9
	Mysterion(arrD,0,4,2);
	System.out.println(toString(arrD)); //1 2 3 4 5 6 7 8 9

	// TESTING ARRE
	System.out.println(toString(arrE)); //9 8 7 6 5 4 3 2 1
	//Mysterion(arrE,0,4,2);
	//System.out.println(toString(arrE)); //5 7 9 6 8 4 3 2 1
	Mysterion(arrE,5,8,6);
	System.out.println(toString(arrE)); //9 8 7 6 5 1 3 2 4

    }
}

