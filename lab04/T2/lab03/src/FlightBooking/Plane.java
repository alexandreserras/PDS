package FlightBooking;

public class Plane {
  private ExecutiveClass classExecutive;
  private TouristClass classTourist;
  private boolean executive;

  public Plane( String executiveConfiguration, String touristConfiguration ) {
    int seatsExecutive = Integer.parseInt( executiveConfiguration.split( "x" )[0] );
    int rowsExecutive = Integer.parseInt( executiveConfiguration.split( "x" )[1] );
    this.classExecutive = new ExecutiveClass( seatsExecutive, rowsExecutive );

    int seatsTourist = Integer.parseInt( touristConfiguration.split( "x" )[0] );
    int rowsTourist = Integer.parseInt( touristConfiguration.split( "x" )[1] );
    this.classTourist = new TouristClass(seatsTourist, rowsTourist);
    this.executive = true;
  }
  public Plane( String touristConfiguration ) {
    int seatsTourist = Integer.parseInt( touristConfiguration.split( "x" )[0] );
    int rowsTourist = Integer.parseInt( touristConfiguration.split( "x" )[1] );
    this.classTourist = new TouristClass(seatsTourist, rowsTourist);
    this.executive = false;
  }
  
  public boolean isExecutive() {
    return executive;
  }
  
  public boolean makeReservation( int nSeats, char classT, Reservation r ) {
    if ( this.hasSeats( nSeats, classT ) ) {
      switch (classT) {
        case 'E':
          return this.classExecutive.reserveSeats( nSeats, r );
        case 'T':
          return this.classTourist.reserveSeats( nSeats, r );
        default:
          System.err.println( "Wrong class" );
      }
    }
    else {
      System.err.println( "no sufficient seats" );

    }
    return false;
  }

  public boolean hasSeats( int nSeats, char classT ) {
    switch (classT) {
      case 'E':
        return this.classExecutive.hasSeats( nSeats );
      case 'T':
        return this.classTourist.hasSeats( nSeats );
      default:
        System.err.println( "Wrong class" );
        return false;
    }
  }

  public String toString() {
    return "" + this.classExecutive + " " + this.classTourist;
  }

}
