package FlightBooking_Refactored;

import java.util.ArrayList;

public class MainTester {
  public static void main( String[] args ) {
    Flight f = new Flight( "TP1020", 3,2,2,4 );
    System.out.println(f);
    System.out.println(f.addReservation( "E", 1 ));
    System.out.println(f.addReservation( "E", 2 ));
    System.out.println(f.addReservation( "E", 2 ));
    System.out.println(f.addReservation( "T", 5 ));
    System.out.println(f.addReservation( "T", 3 ));
  
    System.out.println(f);
    
    
    
    f.showReservationMap();
    return;
  }
}

/**     1A 1B
 *      2A 2B
 *      3A 3B
 *
 */