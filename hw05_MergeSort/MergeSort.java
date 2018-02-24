//Sophia Xia
//APCS2 pd1
//HW05 -- Step 1: Split, Step 2: ?, Step 3: Sorted!. . .
//2018-02-06

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
  It takes an array and divides it in half until the array is sorted through recursion. Once they are sorted(1 element long), the algorithm will begin to merge them together to create one sorted array.
  It uses two functions to do this. Sort takes an array and divides it up and calls merge. Merge will combine 2 sorted lists into one sorted list.
  ======================================*/

public class MergeSort{
    /******************************************************
     * int[] merge(int[],int[])
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ){

	int[]c = new int[a.length + b.length];
	//these vars keep track of position in array
	int posA = a.length -1;
	int posB = b.length -1;
	int posC = c.length -1;

	//for loop compares the values at the current position of array a and b
	//and adds that larger one to array c going from the right to the left.
	for(;posA >= 0 && posB >= 0; posC --){
	    if(b[posB] >= a[posA]){
		c[posC] = b[posB];
		posB --;
	    }
	    else{
		c[posC] = a[posA];
		posA --;
	    }
	}

	//these if statements check to see when one of the arrays is done
	//and adds the rest of the other array to array c
	if(posA >= 0){
	    for(;posA >= 0; posA --){
		c[posC] = a[posA];
		posC --;
	    }
	}
	else if(posB >= 0){
	    for(;posB >= 0; posB --){
		c[posC] = b[posB];
		posC --;
	    }
	}
	return c;
    }//end merge()
    

    /******************************************************
     * int[] sort(int[])
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ){
	if(arr.length != 1){
	    int arr1[] = new int[arr.length/2];
	    int arr2[] = new int[arr.length/2];
	    for(int ctr = 0; ctr < arr.length/2; ctr ++){
		arr1[ctr] = arr[ctr];
	    }
	    for(int ctr = 0; ctr < arr.length/2; ctr ++){
		arr2[ctr] = arr[ctr + arr.length/2];
	    }
	    //only did sort() instead of arr_ = sort(arr_)
	    //meant my returns were not being used = out of sorts
	    //Visualizer help me a lot here ^^
	    arr1 = sort(arr1);
	    arr2 = sort(arr2);
	    arr = merge(arr1, arr2);
	    return arr;
	}
	return arr;
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	  int[] arr0 = {0};
	  int[] arr1 = {1};
	  int[] arr2 = {1,2};
	  int[] arr3 = {3,4};
	  //int[] arr2 = {1,2,3,4,5,6};
	  //int[] arr3 = {3,4,5,6,7,8};
	  int[] arr4 = {1,2,3,4};
	  int[] arr5 = {4,3,2,1};
	  int[] arr6 = {9,42,17,63,0,512,23};
	  int[] arr7 = {9,42,17,63,0,9,512,23,9};

	  //the mess(arr3)totally screwed me up
	  //my code for merge worked, but I thought it didn't because I was seeing so many zeros. Turns out it's because of mess -_- I wasted so much time trying to figure out what went wrong and scrapped my code twice T^T
	  //sadness
	  /***
	  System.out.println("\nTesting mess-with-array method...");
	  printArray( arr3 );
	  mess(arr3);
	  printArray( arr3 );
	  ***/
	  
	  System.out.println("\nMerging arr1 and arr0: ");
	  printArray( merge(arr1,arr0) ); //[0,1]
	  printArray( merge(arr2,arr3) ); //[1,2,3,4]
	  	  
	  System.out.println("\nMerging arr4 and arr6: ");
	  printArray( merge(arr4,arr6) );
	  
	  System.out.println("\nSorting arr4-7...");
	  printArray( sort( arr3 ) );
	  printArray( sort( arr4 ) );
	  printArray( sort( arr5 ) );
	  printArray( sort( arr6 ) );
	  printArray( sort( arr7 ) );
	  
	  /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort
