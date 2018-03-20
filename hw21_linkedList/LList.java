// Sophia Xia, Selina Zou
// APCS2 pd1
// HW21c -- Rockin’ Through the Night
// 2018-03-19

public class LList implements List{
    
    public LLNode car;
    public LLNode cdr;
    public int size;
    
    //add node to list, containing input String as its data
    public boolean add( String x ){
	//if the node is not empty
	if (cdr.getCargo() != null){
	    //set car to the next node and
	    //cdr to the next node of that node
	    car = car.getNext();
	    cdr = car.getNext();
	    return add(x);
	}
	//otherwise set the value of the node to the String
	else{
	    car.setCargo(x);
	    return true;
	}
    } 

    //return data in element at position i
    public String get( int i ){
	for(int num = 0; num < i; i++){
	    car = car.getNext();
	    cdr = car.getNext();
	}
	return car.getCargo();
    }

    //overwrite data in element at position i
    public String set( int i, String x ){
	for(int num = 0; num < i; i++){
	    car = car.getNext();
	    cdr = car.getNext();
	}
	return car.setCargo(x);
    }

    //return length of list
    public int size(){
	int num = 0;
	for(; car.getCargo() != null; num++){
	    car = car.getNext();
	    cdr = car.getNext();
	}
	return num;
    }

    public static void main (String[] args){
	LList firstList = new LList();
	firstList.add("Sup");
	System.out.println(firstList.get(0));
	firstList.add("MaMa");
	System.out.println(firstList.get(1));
	firstList.add("How");
	System.out.println(firstList.get(2));
	firstList.add("Are");
	System.out.println(firstList.get(3));
	firstList.add("You?");
	System.out.println(firstList.get(4));
	
    }   
}
