package FlightBooking;

public class Class {

  private int numberOfSeats;
  private int numberOfRows;
  private boolean occupied = false;
  private int occupiedSeats = 0;
  private int freeSeats;

  public Class( int numOfSeats, int numberOfRows ) {
    this.numberOfSeats = numOfSeats;
    this.numberOfRows = numberOfRows;
    this.freeSeats = numOfSeats;
  }

  public int getNumberOfSeats() {
    return numberOfSeats;
  }

  public void setNumberOfSeats( int numberOfSeats ) {
    this.numberOfSeats = numberOfSeats;
  }

  public int getNumberOfRows() {
    return numberOfRows;
  }

  public void setNumberOfRows( int numberOfRows ) {
    this.numberOfRows = numberOfRows;
  }

  public boolean isOccupied() {
    return occupied;
  }

  public void setOccupied( boolean occupied ) {
    this.occupied = occupied;
  }

  public int getOccupiedSeats() {
    return occupiedSeats;
  }

  public void setOccupiedSeats( int occupiedSeats ) {
    this.occupiedSeats = occupiedSeats;
  }

  public int getFreeSeats() {
    return freeSeats;
  }

  public void setFreeSeats( int freeSeats ) {
    this.freeSeats = freeSeats;
  }
}
