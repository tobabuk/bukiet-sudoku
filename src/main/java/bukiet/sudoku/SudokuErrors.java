package bukiet.sudoku;



public class SudokuErrors {
    private String errorType;
    private int row;
    private int col;
    private int value;

    public SudokuErrors(String errorType, int row, int col, int value) {
        this.errorType = errorType;
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public String getErrorType() {
        return errorType;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getValue() {
        return value;
    }
}