//Sophia Xia
//APCS2 pd1
//HW17 -- So So Fast
//2018-03-11

public class FastSelect{

    //PARTITION
    //moves the element at the pvtPos to its correct position in the array if it were sorted. All the elements to the left of it will be less than the number in no specific order. All the numbers to the right of it will be more than it in no specific order. This only applies to the numbers within the bounds of left and right.
    //returns position of the element
    
    public static int partition(int[] arr, int left, int right, int pvtPos){
	int pvtVal = arr[pvtPos];

	//moves pivot to the end
	int temp = arr[pvtPos];
	arr[pvtPos] = arr[right];
	arr[right] = temp;

	int storPos = left;
	for(int i = left; i < right; i++){
	    if (arr[i] <= pvtVal){
		temp = arr[storPos];
		arr[storPos] = arr[i];
		arr[i] = temp;
		storPos += 1;
	    }
	}
	//moves pivot back to previous position
	temp = arr[right];
	arr[right] = arr[storPos];
	arr[storPos] = temp;

	printArray(arr);
	return storPos;
    }

    //ythSmallest
    //call partition and if the returned value is equal to y, return that val
    //if more than y call partition on new bounds, pvtPos is left bound.
    //if less than y call partition on new bounds, pvtPos is left bound.
    public static int ythSmallest(int[] arr, int y){
	int left = 0;
	int right = arr.length -1;
	int pvtPos = 0;

	int retPos = partition(arr, left, right, pvtPos);

	//while retPos isn't y
	while (retPos != y){

	    //if retPos > y
	    if(retPos > y){
		//moves right bound to the left 
		right = retPos -1;
		//resets retPos
		retPos = partition(arr, left, right, pvtPos);
		printArray(arr);
	    }
	    //if retPos < y
	    else if(retPos < y){
		//moves left bound to the right
		left = retPos +1;
	        //moves the pvtPos to the first num int he range
		pvtPos = left;
		retPos = partition(arr, left, right, pvtPos);
		printArray(arr);
	    }
	}
	System.out.println(arr[y]);
	return arr[y];
    }
    
    //PrintArray
    public static String printArray(int[] arr){
	String str = "";
	for (int i = 0; i < arr.length; i++){
	    str = str + arr[i] + " ";
	}
	System.out.println(str);
	return str;
    }

    //Main Method
    public static void main (String[] args){

	int[] arrA = {7,1,5,12,3};
	int[] arrB = {1,2,3,4,5};
	int[] arrC = {5,4,3,2,1};
	int[] arrD = {1,2,3,4,5,6,7,8,9};
	int[] arrE = {9,8,7,6,5,4,3,2,1};

	/* CHECKING PARTITION
	System.out.println(partition(arrA, 0, 2, 0));
	System.out.println(partition(arrB, 0, 4, 0));
	System.out.println(partition(arrC, 0, 4, 0));
	System.out.println(partition(arrD, 0, 4, 0));
	System.out.println(partition(arrE, 0, 4, 0));
	*/
	
	ythSmallest(arrA, 1);//3
	ythSmallest(arrB, 4);//5
	ythSmallest(arrC, 0);//1
	ythSmallest(arrD, 6);//7
	ythSmallest(arrE, 8);//9
    }
}

