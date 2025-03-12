package bukiet.sudoku;

import java.util.List;
import java.util.ArrayList;

/**
 * 0 1 2   3 4 5    6 7 8
 * -------+-------+-------+
 * 0 | _ _ _ | _ _ _ | _ _ _ |
 * 1 | _ _ _ | _ _ _ | _ _ _ |
 * 2 | _ _ _ | _ _ _ | _ _ _ |
 * +-------+-------+-------+
 * 3 | _ _ _ | _ _ _ | _ _ _ |
 * 4 | _ _ _ | _ _ _ | _ _ _ |
 * 5 | _ _ _ | _ _ _ | _ _ _ |
 * +-------+-------+-------+
 * 6 | _ _ _ | _ _ _ | _ _ _ |
 * 7 | _ _ _ | _ _ _ | _ _ _ |
 * 8 | _ _ _ | _ _ _ | _ _ _ |
 * +-------+-------+-------+
 **/
public class Sudoku {

    private int[][] board = new int[9][9];

    public Sudoku(int[][] board) {
        this.board = board;

    }

    public int[][] getBoard() {
        return board;
    }

    public List<SudokuErrors> getErrors() {
        List<SudokuErrors> errorList = new ArrayList<>();
        errorList.addAll(checkRow());
        errorList.addAll(checkCol());
        errorList.addAll(checkBox());
        return errorList;
    }

    //check that the row is correct

    private List<SudokuErrors> checkRow() {
        List<SudokuErrors> errorList = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            boolean[] checked = new boolean[10];
            for (int col = 0; col < 9; col++) {
                int num = board[row][col];
                if (num != 0) {
                    if (num < 1 || num > 9) {
                        errorList.add(new SudokuErrors(row, col, num));
                    } else if (checked[num]) {
                        errorList.add(new SudokuErrors(row, col, num));

                    } else {
                        checked[num] = true;
                    }
                }
            }
        }
        return errorList;

    }


    private List<SudokuErrors> checkCol() {
        List<SudokuErrors> errorList = new ArrayList<>();
        // check that the colum is correct
        for (int col = 0; col < 9; col++) {
            boolean[] checked = new boolean[10];
            for (int row = 0; row < 9; row++) {
                int num = board[row][col];
                if (num != 0) {
                    if (num < 1 || num > 9) {
                        errorList.add(new SudokuErrors(row, col, num));
                    } else if (checked[num]) {
                        errorList.add(new SudokuErrors(row, col, num));
                    } else {
                        checked[num] = true;
                    }
                }
            }
        }
        return errorList;
    }


    private List<SudokuErrors> checkBox() {
        List<SudokuErrors> errorList = new ArrayList<>();
        for (int boxrow = 0; boxrow < 9; boxrow += 3) {

            for (int boxcol = 0; boxcol < 9; boxcol += 3) {
                boolean[] checked = new boolean[10];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int row = boxrow + i;
                        int col = boxcol + j;
                        int num = board[row][col];
                        if (num != 0) {
                            if (num < 1 || num > 9) {
                                errorList.add(new SudokuErrors(row, col, num));
                            } else if (checked[num]) {
                                errorList.add(new SudokuErrors(row, col, num));
                            } else {
                                checked[num] = true;
                            }
                        }
                    }
                }
            }

        }

        return errorList;
    }
}










