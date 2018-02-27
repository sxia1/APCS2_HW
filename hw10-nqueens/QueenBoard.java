/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard{
    private int[][] _board;
    
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
    }

  
    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     */
    public boolean solve(){
	return false;
    }
    
    
    /**
     *Helper method for solve. 
     */
    private boolean solveH(int col){
	return false;
    }
    
    
    public void printSolution(){
	/** Print board, a la toString...
	    Except:
	    all negs and 0's replaced with underscore
	    all 1's replaced with 'Q'
	*/
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * <General description>
     * precondition: Space must have a value of 0 and also must be in the matrixb.addQueen(1,0);
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
     * <General description>
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
     * <General description>
     * precondition: 
     * postcondition: 
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
	QueenBoard b = new QueenBoard(5);
	System.out.println(b);
	b.addQueen(0,1);
	b.addQueen(1,3);
	b.addQueen(2,0);
	b.addQueen(3,2);
	System.out.println(b);
	//b.removeQueen(3,0);
	//System.out.println(b);
    }
    
}//end class
