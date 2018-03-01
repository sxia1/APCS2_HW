// Sophia Xia
// APCS2 pd1
// HW10 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
// 2018-02-28

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

//Props to Kenny(not in my class) for helping me problem solve.
// Good Advice I was reminded of
// COMMENT LIBERALLY
// Use SOP statements and look at terminal results
// REREAD THE ASSIGNMENT AND MAKE SURE YOU FULFILLED ALL CONDITIONS GIVEN
// You think you done? Psyche. Look again for ways to improve
// mistakes are lurking in places you don't think about; so think about them

public class QueenBoard{
    private int[][] _board;
    
    public QueenBoard( int size){
	_board = new int[size][size];
    }

  
    /***
     * precondition: board is filled with 0's only.
     * postcondition: If a solution is found, board shows position of N queens, 
     * returns true. If no solution, board is filled with 0's, returns false.
     */
    public boolean solve(){
	return solveH(0);
    }
    
    
    /**
     *Helper method for solve. 
     */
    //NOTE: No need to repeat addQueen after the if statement because when it
    // it is evaluated, the code is executed and the Queen is placed if possible
    private boolean solveH(int col){
	//Go through each row in the column
	for(int row = 0;row < _board.length; row ++){

	    //otherwise check all the rows in that column and call solveH
	    //for those that work.

	    if(addQueen(row, col)){

		//if its the last col, print the solution and return true
		if(col == _board.length -1){
		    printSolution();
		    //removeQueen(row,col);
		    //taken out because no need to print all slns
		    //cause the last col to have no 1 when board is printed
		    return true;
		}

		//removing this if statement will cause all slns to print
		//and the method to ret false
		if (solveH(col +1)){
		    return true;
		}
		removeQueen(row, col);
	    }
	}
	return false;
    }

    /** Print board, a la toString...
	    Except:
	    all negs and 0's replaced with underscore
	    all 1's replaced with 'Q'
	*/
    public void printSolution(){
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		if(_board[r][c] <= 0){
		    ans += "_\t";
		}
		else{
		    ans += "Q\t";
		}
	    }
	    ans += "\n";
	}
	System.out.println(ans);
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * Adds a Queen at the given coordinates if it is possible and makes the spaces
     * in the Queen's line of movement unavailable to place other Queens (returns true).
     * Returns false if a Queen can not be placed. 
     * precondition: Space must have a value of 0 and also must be in the matrix
     * postcondition: Space gains a value of 1 and all spaces horizontal or diagonal from it lose a value of 1
     */
    private boolean addQueen(int row, int col){
	if(_board[row][col] != 0){
	    return false;
	}
	_board[row][col] = 1;
	int offset = 1;
	while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
		_board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
		_board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * Removes a Queen at the given coordinates if a Queen exists(returns true).
     * It will also remove the line of movements caused by the Queen.
     * If there is no Queen, it will return false.
     * precondition: Space must have a value of 1 and also must be in the matrix
     * postcondition: Space's value becomes 0 and all spaces horizontal or diagonal from it gain a value of 1
     */
    private boolean removeQueen(int row, int col){
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;
	int offset = 1;

	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * Print out the 2D array instead of the memory location
     * precondition: a board exists
     * postcondition: prints out the values on the 2Darray _board in a 2D
     * fashion with tabs(\t) separating the values.
     */
    public String  toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	QueenBoard four = new QueenBoard(4);
	four.solve();
	QueenBoard five = new QueenBoard(5);
	five.solve();
	QueenBoard six = new QueenBoard(6);
	six.solve();
	QueenBoard seven = new QueenBoard(7);
	seven.solve();
	QueenBoard eight = new QueenBoard(8);
	eight.solve();
	QueenBoard nine = new QueenBoard(9);
	nine.solve();
	System.out.print(nine);
    }
    
}//end class
