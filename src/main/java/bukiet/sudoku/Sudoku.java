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

    public List<String> getErrors() {
        List<String> stringList = new ArrayList<>();
        stringList.addAll(checkRow());
        stringList.addAll(checkCol());
        stringList.addAll(checkBox());
        return stringList;
    }

    //check that the row is correct

    public List<String> checkRow() {
        List<String> stringList = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            boolean[] checked = new boolean[10];
            for (int col = 0; col < 9; col++) {
                int num = board[row][col];
                if (num < 1 || num > 9) {
                    stringList.add(String.format("%d is not a valid number", num));
                } else if (checked[num]) {
                    stringList.add(String.format(
                            "There is a duplicate number %d in row %d", num, row));
                } else {
                    checked[num] = true;
                }
            }
        }
        return stringList;

    }


    public List<String> checkCol() {
        List<String> stringList = new ArrayList<>();
        // check that the colum is correct
        for (int col = 0; col < 9; col++) {
            boolean[] checked = new boolean[10];
            for (int row = 0; row < 9; row++) {
                int num = board[row][col];
                if (num < 1 || num > 9) {
                    stringList.add(String.format("%d is not a valid number", num));
                } else if (checked[num]) {
                    stringList.add(String.format("There is a duplicate number %d in column %d", num, col));
                } else {
                    checked[num] = true;
                }
            }
        }
        return stringList;
    }


    public List<String> checkBox() {
        List<String> stringList = new ArrayList<>();
        for (int row = 0; row < 9; row += 3) {

            for (int col = 0; col < 9; col += 3) {
                boolean[] checked = new boolean[10];
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {

                        int num = board[i][j];
                        if (num < 1 || num > 9) {
                            stringList.add(String.format("%d is not a valid number", num));
                        } else if (checked[num]) {
                            stringList.add(String.format(
                                    "There is a duplicate number %d at row %d column %d", num, row, col));
                        } else {
                            checked[num] = true;
                        }
                    }

                }

            }
        }
        return stringList;
    }

}










