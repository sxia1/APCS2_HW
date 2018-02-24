//Sophia Xia
//APCS2 pd1
//HW07 -- A Man, A Plan, A Canal: Panama!
//2018-02-13

public class Resrever{

    //linRev
    /***
	A method that will flip a String in linear runtime exists. It will take the characters from the string going from right to left and put them into a new String one by one.
     ***/
    public static String linRev(String str){
	String ret = "";
	int pos = str.length();
	while(pos > 0){
	    ret += str.substring(pos-1, pos);
	    pos = pos -1;
	}
	return ret;
    }

    //logRev
    /***
	A method that will flip a String in logarithmic runtime should be feasible. The method below is my attempt at writing a logarithmic flip method. It will divide the String in half and flip those recursively if they not greater than 1 in length.
     ***/    
    public static String logRev(String str){
	
	//courtesy of Thet for showing me the usefulness of having this
	int half = str.length()/2;
	
	if(str.length() > 1){
	    str = logRev(str.substring(half)) + logRev(str.substring(0, half));
	}
	return str;
    }

    public static void main(String[] args){
	System.out.println(linRev("stressed"));
	System.out.println(logRev("stressed"));
	System.out.println(linRev("evil"));
	System.out.println(logRev("evil"));
	System.out.println(linRev("spoons"));
	System.out.println(logRev("spoons"));
	System.out.println(linRev("raw"));
	System.out.println(logRev("raw"));

    }
}
