package FlightBooking_Refactored;

import java.util.ArrayList;

public class Plane {
  private final int nRowsExecutive;
  private final int nRowsTourist;
  private final int nRows;
  private final int nSeatsExecutive;
  private final int nSeatsTourist  ;
  private final int nSeats;
  
  private ArrayList<Row> rows = new ArrayList<>();
  
  //Plane with Executive configuration
  public Plane( int rExecutive, int sExecutive, int rTourists, int sTourist ) {
    this.nSeatsExecutive = sExecutive;
    this.nSeatsTourist   = sTourist;
    this.nRowsExecutive = rExecutive;
    this.nRowsTourist   = rTourists;
    this.nRows          = this.nRowsExecutive + this.nRowsTourist;
    this.nSeats         = this.nSeatsExecutive + this.nSeatsTourist;
    int i;
    
    for (i = 0; i < rExecutive ; i++) {
      
      this.rows.add( new Executive( ( i + 1 ), sExecutive ) );
    }
    
    for (i = 0; i < rTourists ; i++) {
      //                         rowNumber+Offset
      this.rows.add( new Tourist( ( i + 1 + rExecutive ),
        
        sTourist ) );
    }
  }
  
  //Plane without Executive configuration
  public Plane( int rTourists, int sTourist ) {
    this.nSeatsExecutive = 0;
    this.nSeatsTourist   = sTourist;
    this.nRowsExecutive = 0;
    this.nRowsTourist = rTourists;
    this.nRows = this.nRowsExecutive + this.nRowsTourist;
    this.nSeats         = this.nSeatsExecutive + this.nSeatsTourist;
    int i;
    for (i = 0; i < rTourists ; i++) {
      this.rows.add( new Tourist( ( i + 1 ), sTourist ) );
    }
  }
  
  public int getnSeatsExecutive() {
    return nSeatsExecutive;
  }
  
  public int getnSeatsTourist() {
    return nSeatsTourist;
  }
  
  public int getnRowsTourist() {
    return nRowsTourist;
  }
  
  public int getnRows() {
    return nRows;
  }
  
  public int getnSeats() {
    return nSeats;
  }
  public Seat findSeat(char ID, int rowID){
    Seat s;
    for(Row r : rows){
      if(r.getRowID() == rowID){
        s = r.findSeat(ID);
        if(s!=null){return s;}
      }
    }
    return null;
  }
  
  public boolean reserve( char rowType, int numSeats, Reservation reserve ) {
    int i = 0;
    Row r;
    switch (rowType) {
      
      case 'E':
        // reserves seats in emptyRows
        for ( ; i < this.nRowsExecutive ; i++) {
          r = this.rows.get( i );
          if ( r.isEmpty() ) {
            // row is empty so reserve as many seats as you can
            numSeats -= r.reserve( numSeats, reserve );
          }
        }
        // checks if all seats were Reserved
        if ( numSeats > 0 ) {
          //find rows with available seats
          for (i = 0; i < this.nRowsExecutive ; i++) {
            r = this.rows.get( i );
            if ( r.freeSeats() != 0 ) {
              // row is empty so reserve as many seats as you can
              numSeats -= r.reserve( numSeats, reserve );
            }
          }
        }
        else {
          // all seats were reserved cool!!
          return true;
        }
        break;
      
      case 'T':
        System.out.print( "OLAAAAAAAAA\n" );
        // reserves seats in emptyRows
        for (i = nRowsExecutive; i < this.nRows; i++) {
          r = this.rows.get( i );
          if ( r.isEmpty() ) {
            // row is empty so reserve as many seats as you can
            numSeats -= r.reserve( numSeats, reserve );
          }
        }
        // checks if all seats were Reserved
        if ( numSeats > 0 ) {
          //find rows with available seats
          for (i = nRowsExecutive; i < this.nRows; i++) {
            r = this.rows.get( i );
            if ( r.freeSeats() != 0 ) {
              // row is empty so reserve as many seats as you can
              numSeats -= r.reserve( numSeats, reserve );
            }
          }
        }
        else {
          // all seats were reserved cool!!
          return true;
        }
        break;
      
      default:
        throw new IllegalArgumentException( "This char is not valid " + rowType + "!" );
    }
    
    //all seats were reserved   : some seats werent reserved
    return ( numSeats == 0 ) ? true : false;
  }
  
  public int getnRowsExecutive() {
    return nRowsExecutive;
  }
  
  public int freeExecutiveSeats() {
    int count = 0;
    for (int i = 0 ; i < this.nRowsExecutive ; i++) {
      count += this.rows.get( i ).freeSeats();
    }
    return count;
  }
  
  public int freeTouristSeats() {
    int count = 0;
    
    for (int i = nRowsExecutive  ; i < this.nRows; i++) {
      count += this.rows.get( i ).freeSeats();
    }
    System.out.print( "\n" + count + "\n" );
    return count;
  }
  
  // return null or reservation if successful
  
  
  public ArrayList<Row> getRows() {
    return rows;
  }
  
  @Override public String toString() {
    return "Plane{" +
      "nRowsExecutive=" + nRowsExecutive +
      ", nRowsTourist=" + nRowsTourist +
      ", nRows=" + nRows +
      ", Rows= " + rows +
      '}';
  }
}
