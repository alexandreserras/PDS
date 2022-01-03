package FlightBooking;

public interface Reservable {
  /**
   * @returns true if there are enough seats to make a reservation
   */
  boolean hasEnoughSeats( int seatsToBeReserved ); // at the class level not Row level


  /**
   * @returns true if it all seats were reserved as planned
   */
  boolean reserveSeats( int numSeats );  // Processes availability


}
 /**
   *
   *          Finds First empty Row
   *
   *           @return position of the first Empty Row
   *        int findEmptyRow();

   *          Finds First Row with empty seats
   *
   *          @return position of the first row with free seats
   *   int findNonEmptyRow();
   *
   */
