//Sophia Xia
//APCS2 pd1
//HW18 -- So So Quick
//2018-03-12

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): It will access whether or not the numbers within the bounds are sorted or not. Sorted being there is only one number. If not sorted, the pivot position is set to the partition of the array. Then the two parts of the array separated by the pivot position get sorted through a recursive call. 
 *
 * 2a. Worst pivot choice and associated runtime: The worst pivot choices are ones that start from one extreme and consecutively increase by 1. O(n^2)
 *
 * 2b. Best pivot choice and associated runtime: The best pivot choices are those that continuously land in the middle of the given bounds. O(nlogn)
 *
 * 3. Approach to handling duplicate values in array: The code appears to work even in the presence of duplicates? It sorts the array just fine... Sooo I have no approach because that isn't a concern?
 *
 *****************************************************/

public class QuickSort{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------

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

	return storPos;
    }



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort(int[] d){ 
	qsortH(d, 0, d.length -1);
    }

    //you may need a helper method...
    public static void qsortH(int[] arr, int left, int right){
	if (left < right){
	    int pvtPos = partition (arr,left,right, left);
	    qsortH(arr, left, pvtPos -1);
	    qsortH(arr, pvtPos +1, right);
	}
    }

    //main method for testing
    public static void main( String[] args ){

	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

	shuffle(arrN);
	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);

	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/



	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

	shuffle(arrMatey);
	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort
