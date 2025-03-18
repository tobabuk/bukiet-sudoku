package bukiet.sudoku;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SudokuController {

    private Sudoku sud;
    private JTextField[][] cells;

    public SudokuController(Sudoku sud, JTextField[][] cells) {
        this.sud = sud;
        this.cells = cells;
    }

    void sudokuErrors() {
        List<SudokuErrors> errors = sud.getErrors();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                cells[row][col].setBackground(Color.WHITE);
            }

        }


        for (SudokuErrors error : errors) {
            if ("Invalid number".equals(error.type())) {
                cells[error.row()][error.col()].setBackground(Color.RED);
            } else if ("Duplicate number".equals(error.type())) {
                cells[error.row()][error.col()].setBackground(Color.PINK);
            }
        }
    }

}


