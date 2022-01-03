/*
*   ██████╗ ███████╗██████╗ ██████╗  ██████╗ ██╗      ██████╗ ██████╗ ███████╗███████╗
*   ██╔══██╗██╔════╝██╔══██╗██╔══██╗██╔═══██╗██║     ██╔═══██╗██╔══██╗██╔════╝██╔════╝
*   ██████╔╝█████╗  ██║  ██║██████╔╝██║   ██║██║     ██║   ██║██████╔╝█████╗  ███████╗
*   ██╔═══╝ ██╔══╝  ██║  ██║██╔══██╗██║   ██║██║     ██║   ██║██╔═══╝ ██╔══╝  ╚════██║
*   ██║     ███████╗██████╔╝██║  ██║╚██████╔╝███████╗╚██████╔╝██║     ███████╗███████║
*   ╚═╝     ╚══════╝╚═════╝ ╚═╝  ╚═╝ ╚═════╝ ╚══════╝ ╚═════╝ ╚═╝     ╚══════╝╚══════╝
*   █████╗ ███████╗ █████╗ ██████╗ ███████╗
*  ██╔══██╗╚════██║██╔══██╗╚════██╗╚════██║
*  ╚██████║    ██╔╝╚█████╔╝ █████╔╝    ██╔╝
*   ╚═══██║   ██╔╝ ██╔══██╗██╔═══╝    ██╔╝
*   █████╔╝   ██║  ╚█████╔╝███████╗   ██║
*   ╚════╝    ╚═╝   ╚════╝ ╚══════╝   ╚═╝
*
*/
package jogoGalo;

public class Jogo implements JGaloInterface {
  private char LastPlayer   ;
  private char ActualPlayer ;
  private char table[][] = new char[3][3];

  /**
   *  Sets firstplayer and computes lastPlayer
    * @param firstPlayer sets firstplayer
   */
  public Jogo(char firstPlayer) {
    this.ActualPlayer = firstPlayer;
    this.LastPlayer = (ActualPlayer == 'O') ? 'X' : 'O';
  }

  /**
   *  Method created in order to insert the correct symbol in the matrix table
   *
   * @return symbol of current player
   */
  @Override public char getActualPlayer() {
    return this.ActualPlayer;
  }

  /**
   * Sets a players move by filling a certain <b>lin</b> <b>col</b> of <b>table</b>
   * @param lin goes from 1 to 3
   * @param col goes from 1 to 3
   * @return    true if it was inserted false otherwise
   */

  @Override public boolean setJogada( int lin, int col ) {
    lin = lin  - 1;  // see javadoc commentary
    col = col  - 1;   // see javadoc commentary
    if (this.getSymbol( lin,col ) != 'X' || this.getSymbol( lin,col ) != 'O') { // Check for validity of insertion
      table[lin][col] = this.ActualPlayer;
      // swaps LastPlayer with ActualPlayer
      char temp = this.LastPlayer;
      this.LastPlayer = this.ActualPlayer;
      this.ActualPlayer = temp;
      return true;
    }
    return false;
  }

  /**
   *  Retrives symbol hold at position <b>x, y</b> of <b>table</b>
   * @param x line
   * @param y column
   * @return value in said position
   */
  public char getSymbol( int x, int y ) {
    return this.table[x][y];
  }

  /**
   * <p>
   *   Computes the end of the game by analising first if there's already a winner
   *   In case no winner was yet decided checks to see if every position is filled
   * </p>
   * @return true if the game has finished
   */

  @Override public boolean isFinished() {
    if ( this.checkResult() == 'X' || this.checkResult() == 'O' ) { return true;} // checks for winners first
    for (int i = 0 ; i < table.length ; i++) {
      for (int j = 0 ; j < table.length ; j++) {
        if (! ( this.getSymbol( i, j ) > 'A' && this.getSymbol( i, j ) < 'Z') ) {
          // theres still moves to make
          return false;
        }
      }
    }
    // every position in the matrix was occupied
    return true;
  }

  /**
   * Checks to see if there was a winner
   * @return 'X' if X won 'O' if 'O' won or ' ' in case of stalemate
   */
  @Override public char checkResult() {
    int posX = 0, posY = 0;
    char firstChar = '-';
    // check all lines
    Direction dir = Direction.RIGHT;
    for (posX = 0; posX < table.length ; posX++) {
      posY = 0;
      firstChar = this.getSymbol( posX, posY );
      while (posX < 3 && posY < 3) {
        if ( firstChar != this.getSymbol( posX, posY ) ) {
          firstChar = '-';
          break;
        }
        posY += dir.getY();
      }
      if ( firstChar != '-' )
        return firstChar;
    }

    //check all cols
    dir = Direction.DOWN;
    for (posY = 0; posY < table.length ; posY++) {
      posX = 0;
      firstChar = this.getSymbol( posX, posY );
      while (posX < 3 && posY < 3) {
        if ( firstChar != this.getSymbol( posX, posY ) ) {
          firstChar = '-';
          break;
        }
        posX += dir.getX();
      }
      if ( firstChar != '-' )
        return firstChar;

    }

    // check both diagonals
    // diagonal 0,0
    dir = Direction.DOWNRIGHT;
    posX = 0;
    posY = 0;
    firstChar = this.getSymbol( posX, posY );
    while (posX < 3 && posY < 3) {
      if ( firstChar != this.getSymbol( posX, posY ) ) {
        firstChar = '-';
        break;
      }
      posX += dir.getX();
      posY += dir.getY();
    }

    if ( firstChar != '-' )
      return firstChar; // returns winner symbol

    // diagonal 0,2
    dir = Direction.DOWNLEFT;
    posX = 0;
    posY = 2;
    firstChar = this.getSymbol( posX, posY );
    while (posX < 3 && posY < 3) {
      if ( firstChar != this.getSymbol( posX, posY ) ) {
        firstChar = '-';
        break;
      }
      posX += dir.getX();
      posY += dir.getY();
    }
    if ( firstChar != '-' )
      return firstChar;

    // stalemate
    return ' ';
  }
}
