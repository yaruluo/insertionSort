import java.util.ArrayList;

public class Insert {

    public static void insert1( List_inArraySlots list, int alreadyInserted){
	int valueToInsert = list.get( alreadyInserted);

	if( list.get( 0) < valueToInsert){
	    shift( list, 0, alreadyInserted);
            drop( list, 0, valueToInsert);
	}

	else{
	    for( int indexToCompare = alreadyInserted-1
		     ; indexToCompare != -1
		     ; indexToCompare--){
		if( valueToInsert < list.get( indexToCompare)){
		    shift( list, indexToCompare, alreadyInserted);
		  	}
		 else 
		    drop( list, indexToCompare, valueToInsert);
	    }
	}
    }

    public static void shift( List_inArraySlots list, int begin, int end){
	for( int index = end; index != begin; index--)
	    list.get( index) = list.get( index-1);
    }

    public static void drop( List_inArraySlots list, int index, int value){
	list.set( index, value);
    }

    public static void insertionSort( List_inArraySlots list){
	for( int boundary = 1
		 ; boundary < list.size()
		 ; boundary++){
	    insert1( list, boundary);
	    // for debugging
	    System.out.println( "    dbg: "
				+ "after inserting element " + boundary
				+ " elements: " + list
				);
	}
    }

    public static void main( String[] commandLine){
	List_inArraySlots list = new List_inArraySlots();
	list.add( 2);
	list.add( 17);
	list.add( 8);

	System.out.println( "    initial: " + list);
	insertionSort( list);
	System.out.println( "    sorted: " + list);
    }
    
}
