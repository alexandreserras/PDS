package FlightBooking;

import java.util.TreeSet;

public class TouristClass {
  private Row[] r;
  private int freeSeats;
  private int nSeats;
  private int nRows;

  public TouristClass( int nRows, int nSeats ){
    this.nRows = nRows;
    this.nSeats = nSeats;
    this.r = new Row[nRows];
    for( int i = 0 ; i < nRows ; i++){
      this.r[i] = new Row(nSeats, nSeats);
    }
    this.freeSeats = nRows * nSeats;
  }

  public boolean hasSeats(int seatsNeeded){
    return (this.freeSeats - seatsNeeded >= 0);
  }

  public int findEmptyRow(){
    for( int i = 0 ; i < this.nRows  ; i++){
      if(this.r[i].isEmpty()){
        return i;
      }
    }
    return -1;
  }

  public int findRow(){
    if(this.findEmptyRow() != -1) {return this.findEmptyRow();}
    for( int i = 0 ; i < this.nRows ; i++){
      if(this.r[i].hasSeats()){
        return i;
      }
    }
    return -1;
  }

  public boolean reserveSeats(int n, Reservation r){
    int row;
    int rowFseats;
    while( n > 0){
      row = this.findRow();
      if(row == -1){
        return false;
      }
      rowFseats = this.r[row].getFreeSeats();
      if ( rowFseats >= n ){
        this.r[row].reserve( n, r );
        n -=n;
      }else{
        this.r[row].reserve( rowFseats, r );
        n -= rowFseats;
      }
    }
    return true;
  }

  public String toString(){
    String ret = "";
    for (Row rr: this.r) {
      ret += "   " +  rr.toString();
    }
    return "" + this.nSeats + " " + this.nRows + "" +ret ;
  }


}
