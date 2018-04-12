//*******************************************************************
//HW1 for PennSD1x
//NL 04/12/2018 
//...long way to go...
//*******************************************************************

import java.lang.Math; // headers MUST be above the first class
import java.util.*;
//one class needs to have a main() method  

public class WhackAMole {
  int score;
  int molesLeft;
  int attemptsLeft;
  char[][] moleGrid;

  /*
   * Constructor for the game, specifies total number of whacks allowed, and the
   * grid dimension. After reading through the assignment, make sure to initialize
   * the moleGrid with the appropriate character.
   */
  public WhackAMole(int numAttempts, int gridDimension) {
    this.score = 0;
    this.molesLeft = 0;
    this.attemptsLeft = numAttempts;
    this.moleGrid = new char[gridDimension][gridDimension];
    for (char[] arr : moleGrid) {
      Arrays.fill(arr, '*');
    }
  }

  /*
   * Given a location, place a mole at that location. Return true if you can.
   * (Also update number of moles left.)
   */
  boolean place(int x, int y) {
    if (moleGrid[x][y] == 'M') {
      return false;
    } else {
      moleGrid[x][y] = 'M';
      molesLeft += 1;
      return true;
    }
  }

  /*
   * Given a location, take a whack at that location. If that location contains a
   * mole, the score, number of attemptsLeft, and molesLeft is updated. If that
   * location does not contain a mole, only attemptsLeft is updated
   */
  void whack(int x, int y) {
    if (moleGrid[x][y] == 'M') {
      score += 10;
      molesLeft--;
      moleGrid[x][y] = 'W';
    }
    attemptsLeft--;
  }

  /*
   * Print the grid without showing where the moles are. For every spot that has
   * recorded a “whacked mole,” print out a W, or * otherwise.
   */
  void printGridToUser() {
    for (char[] arr : moleGrid) {
      for (char c : arr) {
        if (c != 'W') {
          System.out.print('*');
        } else {
          System.out.print('W');
        }
      }
      System.out.println();
    }
  }

  /*
   * Print the grid completely. This is effectively dumping the 2d array on the
   * screen. The places where the moles are should be printed as an ‘M’. The
   * places where the moles have been whacked should be printed as a ‘W’. The
   * places that don’t have a mole should be printed as *.
   */
  void printGrid() {
    for (char[] arr : moleGrid) {
      for (char c : arr) {
        System.out.print(c);
      }
      System.out.println();
    }

  }

  // Main method!!! arguments are passed using the text field below this editor
  /**
   * Begin by creating a 10 by 10 grid where you randomly place the moles. Place a
   * total of 10 moles. Now allow the user to enter the x and y coordinates of
   * where they would like to take a whack. Tell them they have a maximum of 50
   * attempts to get all the moles. At any point in the game, they can input
   * coordinates of -1, -1 in order to indicate that they are giving up. If the
   * user gives up they get to see the entire grid. The game ends if the user is
   * able to uncover all the moles or if the user runs out of attempts.
   */

  public static void main(String[] args) {

    WhackAMole game = new WhackAMole(50, 10); // creating a new game with 10*10 grid, 50 attempts
    Random random = new Random(); // randomly place 10 moles
    for (int i = 0; i < 10; i++) {
      game.place(random.nextInt(10), random.nextInt(10));
    }

    Scanner sc = new Scanner(System.in);

    while (game.attemptsLeft > 0 && game.molesLeft > 0) {
      System.out.println("You have " + game.attemptsLeft + "attempts left.");
      System.out.println("Current score: " + game.score);
      game.printGridToUser();
      System.out.print("Choose row and collumn number (1~10) to whack, enter -1 twice to exit: ");

      int x = sc.nextInt();
      int y = sc.nextInt();

      if (x == -1 && y == -1) {
        game.printGrid();
        break;
      }
      game.whack(x - 1, y - 1);
    }

    if (game.molesLeft == 0) {
      System.out.println("You win!");
    } else {
      System.out.println("Game Over!");
    }

  }

}
