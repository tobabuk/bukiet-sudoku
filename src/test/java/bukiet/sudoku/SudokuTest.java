package bukiet.sudoku;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {

    @Test
    public void correctSudoku() {
        int[][] trueBoard = {{7, 9, 2, 1, 5, 4, 3, 8, 6},
                {6, 4, 3, 8, 2, 7, 1, 5, 9},
                {8, 5, 1, 3, 9, 6, 7, 2, 4},
                {2, 6, 5, 9, 7, 3, 8, 4, 1},
                {4, 8, 9, 5, 6, 1, 2, 7, 3},
                {3, 1, 7, 4, 8, 2, 9, 6, 5},
                {1, 3, 6, 7, 4, 8, 5, 9, 2},
                {9, 7, 4, 2, 1, 5, 6, 3, 8},
                {5, 2, 8, 6, 3, 9, 4, 1, 7}};

        Sudoku su = new Sudoku(trueBoard);
        List<String> results = su.getErrors();
        assertTrue(results.isEmpty());


    }

    @Test
    public void incorrectSudoku() {
        int[][] falseBoard = {{7, 9, 2, 1, 5, 4, 3, 8, 6},
                {6, 4, 3, 8, 30, 7, 1, 5, 9},
                {8, 5, 1, 3, 9, 7, 7, 2, 4},
                {2, 6, 5, 9, 7, 3, 8, 4, 1},
                {4, 8, 9, 5, 6, 1, 2, 7, 3},
                {3, 1, 7, 4, 8, 2, 9, 6, 5},
                {3, 3, 6, 7, 4, 8, 5, 9, 2},
                {9, 7, 4, 2, 1, 5, 2, 3, 8},
                {5, 2, 8, 6, 3, 9, 4, 1, 7}};

        Sudoku su = new Sudoku(falseBoard);
        List<String> results = su.getErrors();
        List<String> rowErrors = List.of(
                "30 is not a valid number",
                "There is a duplicate number 7 in row 2",
                "There is a duplicate number 3 in row 6",
                "There is a duplicate number 2 in row 7"
        );
        assertEquals(rowErrors, su.checkRow());

        List<String> colErrors = List.of("There is a duplicate number 3 in column 0",
                "30 is not a valid number", "There is a duplicate number 7 in column 5",
                "There is a duplicate number 2 in column 6");

        assertEquals(colErrors, su.checkCol());
        List<String> boxErrors = List.of("30 is not a valid number",
                "There is a duplicate number 7 at row 2 column 5",
                "There is a duplicate number 3 at row 6 column 1",
                "There is a duplicate number 2 at row 7 column 6");


        assertEquals(boxErrors, su.checkBox());


    }

}