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
        List<SudokuErrors> results = su.getErrors();


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
        List<SudokuErrors> results = su.getErrors();

        List<String> actualErrors = new ArrayList<>();
        for (SudokuErrors error : results) {
            actualErrors.add(error.getErrorType());
        }
        List<String> expectedErrors = new ArrayList<>(Arrays.asList(
                "Duplicate number", "Duplicate number",
                "Duplicate number", "Duplicate number", "Duplicate number",
                "Duplicate number", "Duplicate number", "Duplicate number",
                "Duplicate number", "Invalid number", "Invalid number", "Invalid number"
        ));


        Collections.sort(actualErrors);


        Collections.sort(expectedErrors);

        assertEquals(expectedErrors, actualErrors);

    }

}