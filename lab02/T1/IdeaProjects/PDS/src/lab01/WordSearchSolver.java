package lab01;
import java.io.*;
import java.util.*;

public class WordSearchSolver {

    public static void main(String[] args) {

        /*** GET PUZZLE FILE NAME ***/
        Scanner sc = new Scanner(System.in);
        System.out.println("Name of the puzzle file: ");
        String puzzleFile = sc.nextLine();

        /*** IMPORTANT VARIABLES ***/
        String[][] puzzle = new String[40][40];
        ArrayList<String> wordsToFind = new ArrayList<>();
        int numberOfPuzzleRows = 0;
        int numberOfPuzzleColumns = 0;

        /*** READ FILE WITH PUZZLE AND WORDS TO FIND ***/
        try {
            Scanner fileScanner = new Scanner(new File(puzzleFile));

            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();

                // Check for empty lines
                if (line.isEmpty()) {
                    System.err.println("Invalid file -> Empty line");
                    System.exit(-1);
                }

                // Add chars of the current line to the puzzle if all letters are upper cased
                if (line.equals(line.toUpperCase()) && line.matches("^[a-zA-Z]*$")) {

                    // The first line is the standard length of a line
                    if (numberOfPuzzleRows == 0) {
                        numberOfPuzzleColumns = line.length();

                    } else {

                        // Check if all lines of the puzzle are the same size
                        if (line.length() != numberOfPuzzleColumns) {
                            System.err.println("Invalid file -> Lines with different sizes");
                            System.exit(-1);
                        }
                    }
                    // Test if puzzle has more than 40 lines and 40 columns
                    if (numberOfPuzzleRows > 40) {
                        System.err.println("Invalid File -> The puzzle is too big");
                        System.exit(-1);
                    }
                    // Add line to the puzzle
                    puzzle[numberOfPuzzleRows] = line.split("");
                    numberOfPuzzleRows++;

                } else {
                    // Add words of the current line to the words to find on the puzzle
                    String[] words = line.split("[ ,;]");
                    // Same as -> for (String i : words) { wordsToFind.add(i); }
                    wordsToFind.addAll(Arrays.asList(words));

                }
            }
            fileScanner.close();

            // Check if the puzzle is a square
            if (numberOfPuzzleRows != numberOfPuzzleColumns) {
                System.err.println("Invalid file -> Puzzle isn't a square");
                System.exit(-1);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Unable to open file with puzzle");
        }

        /*** SEARCH FOR THE WORDS ON THE PUZZLE ***/
        // Key = word, Value = (row,column) of the first letter
        Map<String, int[]> wordsPosition = new TreeMap<>();
        // Key = word, Value = direction used to find the word on the puzzle
        Map<String, Direction> wordsDirection = new TreeMap<>();

        ArrayList<String> sortedWordsToFind = new ArrayList<>(wordsToFind);
        // Orders words to find from biggest to smallest
        sortedWordsToFind.sort(Comparator.comparing(String::length).reversed());

        for (String word1 : sortedWordsToFind) {

            for (int l = 0; l < numberOfPuzzleRows; l++) {
                word1 = word1.toUpperCase();

                String firstLetter = String.valueOf(word1.charAt(0));

                // Analyse lines that contain, at least once, this letter
                if (Arrays.asList(puzzle[l]).contains(firstLetter)) {

                    for (int c = 0; c < numberOfPuzzleRows; c++) {

                        // Finding occurrences of the letter we're searching for
                        if (puzzle[l][c].equals(firstLetter)) {

                            for (Direction d : Direction.values()) {

                                // Verify direction to read the word when found
                                if (verifyDirection(wordsPosition, wordsDirection, l, c, word1, puzzle, d, 1, numberOfPuzzleRows)) {

                                    if (wordsDirection.containsKey(word1) && !isPalindrome(word1)) {
                                        System.err.println("Invalid file -> Puzzle doesn't have unique words");
                                        System.exit(-1);

                                    } else if (wordsDirection.containsKey(word1) && isPalindrome(word1)) {
                                        // Checking if this palindrome exists more than once on the puzzle
                                        boolean isDifferentL = l + 1 + (d.getRowDirection() * (word1.length() - 1)) != wordsPosition.get(word1)[0];
                                        boolean isDifferentC = c + 1 + (d.getColDirection() * (word1.length() - 1)) != wordsPosition.get(word1)[1];

                                        if (isDifferentL || isDifferentC) {
                                            System.err.println("Invalid file -> Puzzle doesn't have unique words (palindrome)");
                                            System.exit(-1);
                                        }

                                    } else {
                                        // Storing word and its direction
                                        wordsDirection.put(word1, d);
                                        // Storing coordinates of the first letter of the word found (+1 because index starts at 0)
                                        wordsPosition.put(word1, new int[]{l + 1, c + 1});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        /*** PRINT RESULT ***/
        try {
            /*** GET SOlUTION FILE NAME ***/
            System.out.println("Name of the solution file: ");
            String solutionFile = sc.nextLine();
            sc.close();

            PrintWriter out = new PrintWriter(solutionFile);

            for (String w: wordsToFind) {
                String word = w.toUpperCase();
                // Print format: word, length, row(1st letter), column(1st letter), direction to read
                out.printf("%-15s %-3d %3d,%-10d %-10s\n", word.toLowerCase(), word.length(), wordsPosition.get(word)[0], wordsPosition.get(word)[1], wordsDirection.get(word));
            }

            // Solution of the puzzle
            char[][] solution =  getPuzzleSolved(numberOfPuzzleRows, numberOfPuzzleColumns, wordsToFind, wordsPosition, wordsDirection);

            out.println();

            // Formatted print of the solution (image)
            int column = 0;
            for (int i = 0; i < numberOfPuzzleRows; i++) {
                for (int j = 0; j < numberOfPuzzleColumns; j++) {
                    if (column == numberOfPuzzleColumns) {
                        column = 0;
                        out.println();
                    }
                    out.printf("%s ", solution[i][j]);
                    column++;
                }
            }
            out.close();

        } catch (FileNotFoundException e) {
            System.err.println("Unable to open file to write!");
        }
    }

    /*** IMPORTANT FUNCTIONS **/
    public static boolean verifyDirection(Map<String, int[]> wordsPosition, Map<String, Direction> wordsDirection, int l, int c, String word, String[][] puzzle, Direction d, int searchCharIndex, int numberOfPuzzleRows) {

        int row = d.getRowDirection();
        int column = d.getColDirection();

        if (searchCharIndex < word.length()) {
            // Condition for boundaries
            boolean isRowOutOfBound = l + row < 0 || l + row >= numberOfPuzzleRows;
            boolean isColOutOfBound = c + column < 0 || c + column >= numberOfPuzzleRows;

            boolean isContained = containsWord(wordsPosition, wordsDirection, word, l, c, d);

            if (isRowOutOfBound || isColOutOfBound || isContained) {
                return false;
            }
            // Continue analyzing current direction if chars match
            if (puzzle[l + row][c + column].equals(String.valueOf(word.charAt(searchCharIndex)))) {
                searchCharIndex++;
                return verifyDirection(wordsPosition, wordsDirection, l + row, c + column, word, puzzle, d, searchCharIndex, numberOfPuzzleRows);
            }
            return false;
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        int i = 0;

        do {
            if (s1.charAt(i) != s1.charAt(s1.length() - i - 1)) return false;
            i++;
        } while (i < s1.length());
        return true;
    }

    public static boolean containsWord(Map<String, int[]> wordsPosition, Map<String, Direction> wordsDirection, String w, int l, int c, Direction d) {
        for (String key : wordsDirection.keySet()) {
            if (key.contains(w)) {
                // Index of first letter of String w in String key
                int idx = key.indexOf(w.charAt(0));
                // Coordinates of the first letter of the key
                int[] keyPosition = wordsPosition.get(key);
                // Direction of the key
                Direction keyDirection = wordsDirection.get(key);

                boolean isSameRow = l + 1 == keyPosition[0] + (keyDirection.getRowDirection() * idx);
                boolean isSameCol = c + 1 == keyPosition[1] + (keyDirection.getColDirection() * idx);
                boolean isSameDirection = keyDirection == d;

                if (isSameRow && isSameCol && isSameDirection) {
                    return true;
                }
            }
        }
        return false;
    }

    public static char[][] getPuzzleSolved(int numberOfPuzzleRows, int numberOfPuzzleColumns, ArrayList<String> wordsToFind, Map<String, int[]> wordsPosition, Map<String, Direction> wordsDirection) {
        char[][] solution = new char[numberOfPuzzleRows][numberOfPuzzleColumns];

        for (int i = 0; i < numberOfPuzzleRows; i++) {
            for (int j = 0; j < numberOfPuzzleColumns; j++) {
                for (String w : wordsToFind) {
                    String word = w.toUpperCase();
                    // Find the position of the first letter of the word in the solution
                    if (wordsPosition.get(word)[0] - 1 == i && wordsPosition.get(word)[1] - 1 == j) {
                        // Save the rest of the word in the solution
                        for (int k = 0; k < word.length(); k++) {
                            Direction wordDirection = wordsDirection.get(word);
                            int solutionRow = i + (wordDirection.getRowDirection()) * k;
                            int solutionCol = j + (wordDirection.getColDirection()) * k;

                            solution[solutionRow][solutionCol] = word.charAt(k);
                        }
                    } else {
                        // If letter in the puzzle isn't included in any words found
                        if (!Character.isLetter(solution[i][j]))
                            solution[i][j] = '.';
                    }
                }
            }
        }
        return solution;
    }

}