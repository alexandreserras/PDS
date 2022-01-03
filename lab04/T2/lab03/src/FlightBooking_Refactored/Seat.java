package FlightBooking_Refactored;

import java.util.Objects;

public class Seat{
  private char ID;//A
  private int  rowID; // 3
  private boolean occupied = false;
  private boolean executive;
  private int  resNumber = 0;
  
  public int getResNumber() {
    return resNumber;
  }
  
  public boolean isExecutive() {
    return executive;
  }
  
  public Seat( char ID , int rowID, boolean executive){
    this.ID = ID;
    this.rowID = rowID;
    this.executive = executive;
  }
  
  public char getID() {
    return ID;
  }
  
  public int getRowID() {
    return rowID;
  }
  
  public boolean isOccupied(){
    return this.occupied;
  }
  public boolean occupy(int resNumber){
    if ( this.occupied ){
      return false;
    }else{
      this.resNumber = resNumber;
      this.occupied = true;
      return true;
    }
  }
  
  @Override public boolean equals( Object o ) {
    if ( this == o ) return true;
    if ( o == null || getClass() != o.getClass() ) return false;
    Seat seat = (Seat) o;
    return ID == seat.ID && rowID == seat.rowID && occupied == seat.occupied;
  }
  
  @Override public int hashCode() {
    return Objects.hash( ID, rowID, occupied );
  }
  
  public String toString(){
    return "" + this.rowID + "" + this.ID;
  }
}
