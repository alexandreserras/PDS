package lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class WordSearchGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*** GET ARGUMENTS ***/
        System.out.println("Arguments to generate puzzle: ");
        String[] arguments = sc.nextLine().split(" ");
        sc.close();

        String listWordsFile = "";
        int puzzleSize = 0;
        String puzzleFile = "out.txt";
        ArrayList<String> listOfWords = new ArrayList<>();

        /*** CONTROL OF ARGUMENTS ***/
        if (arguments.length < 2) {
            System.err.println("Invalid number of arguments!");
            System.exit(-1);
        } else if (arguments.length == 2) {
            listWordsFile = arguments[0];
            puzzleSize = Integer.parseInt(arguments[1]);
        } else {
            listWordsFile = arguments[0];
            puzzleSize = Integer.parseInt(arguments[1]);
            puzzleFile = arguments[2];
        }

        /*** READ FILE WITH WORDS TO GENERATE PUZZLE ***/
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File(listWordsFile));

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] words = line.split("[ ,;]");
                listOfWords.addAll(Arrays.asList(words));
            }

        } catch (FileNotFoundException e) {
            System.err.println("Unable to open list of words file!");
            System.exit(-1);
        }

        char[][] puzzle = new char[puzzleSize][puzzleSize];

        for (String word : listOfWords) {

            Direction d;
            int[] coordinates;

            do {
                // Generate direction and coordinates of the first letter of a word
                d = generateDirection();
                coordinates = generateCoordinates(puzzleSize);

            }  while (!(isInBoundaries(coordinates, d, word, puzzleSize) && isPositionAvailable(coordinates, d, word, puzzle)));

            // Add word, that verifies conditions, to the puzzle
            addToPuzzle(coordinates, d, word, puzzle);
        }

        // Generate letters for empty positions in the puzzle
        generateMissingLetters(puzzle,puzzleSize);

        /*** PRINT PUZZLE INTO FILE ***/
        try {
            PrintWriter out = new PrintWriter(puzzleFile);

            int column = 0;
            for (int i = 0; i < puzzleSize; i++) {
                for (int j = 0; j < puzzleSize; j++) {
                    if (column == puzzleSize) {
                        column = 0;
                        out.println();
                    }
                    out.printf("%s", puzzle[i][j]);
                    column++;
                }
            }
            out.println();

            for(String s: listOfWords){
                out.print(s + " ");
            }
            out.println();

            out.close();

        } catch (FileNotFoundException e) {
            System.err.println("Unable to open file to write puzzle!");
            System.exit(-1);
        }

    }

    public static Direction generateDirection() {

        Random r = new Random();
        int i = r.nextInt(8);

        for (Direction d : Direction.values()) {
            // Each direction has an integer value associated, checking if the value matches generated direction (i)
            if (i == d.ordinal()) return d;
        }
        return null;
    }

    public static int[] generateCoordinates(int puzzleSize) {

        Random r = new Random();
        return new int[]{r.nextInt(puzzleSize), r.nextInt(puzzleSize)};
    }

    public static boolean isInBoundaries(int[] coordinates, Direction d, String word, int puzzleSize) {

        int row = d.getRowDirection();
        int column = d.getColDirection();

        // Condition for boundaries
        int lastRow = coordinates[0] + row * (word.length() - 1);
        int lastCol = coordinates[1] + column * (word.length() - 1);

        boolean isRowOutOfBound = lastRow < 0 || lastRow >= puzzleSize;
        boolean isColOutOfBound =  lastCol < 0 || lastCol >= puzzleSize;

        return !(isRowOutOfBound || isColOutOfBound);
    }

    public static boolean isPositionAvailable(int[] coordinates, Direction d, String word, char[][] puzzle) {

        int row = d.getRowDirection();
        int col = d.getColDirection();

        for (int i = 0; i < word.length(); i++) {

            int nextRow = coordinates[0] + row * i;
            int nextLine = coordinates[1] + col * i;

            // Check if position is unavailable
            if (Character.isLetter(puzzle[nextRow][nextLine]) && puzzle[nextRow][nextLine] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void addToPuzzle(int[] coordinates, Direction d, String word, char[][] puzzle){

        int row = d.getRowDirection();
        int col = d.getColDirection();

        for (int i = 0; i < word.length(); i++) {

            int nextRow = coordinates[0] + row * i;
            int nextLine = coordinates[1] + col * i;

            puzzle[nextRow][nextLine] = word.toUpperCase().charAt(i);
        }
    }

    public static void generateMissingLetters(char[][] puzzle, int puzzleSize){

        Random r = new Random();

        // For each line
        for (int i = 0; i < puzzleSize; i++) {
            // For each column
            for (int j = 0; j < puzzleSize; j++) {

                // Check if position in puzzle is empty
                if(!Character.isLetter(puzzle[i][j])) {
                    // Generate int between 0 and 25 and convert to char upper-cased
                    char c = (char)(r.nextInt(26) + 'A');
                    puzzle[i][j] = c;
                }
            }
        }
    }

}
