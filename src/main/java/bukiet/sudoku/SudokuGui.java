package bukiet.sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class SudokuGui extends JFrame {
    private Sudoku sud;
    private JTextField[][] cells = new JTextField[9][9];

    public SudokuGui() {
        int[][] emptyBoard = {{5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};
        sud = new Sudoku(emptyBoard);
        setTitle("Sudoku Game");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(9, 9));
        initializeBoard(panel);

        add(panel);
    }

    private void initializeBoard(JPanel panel) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                JTextField cell = new JTextField();
                cell.setHorizontalAlignment(JTextField.CENTER);
                cell.setFont(new Font("Times New Roman", Font.BOLD, 20));
                cell.setOpaque(true);

                int num = sud.getBoard()[row][col];
                if (num != 0) {
                    cell.setText(String.valueOf(num));
                    cell.setEditable(false);
                    cell.setBackground(Color.LIGHT_GRAY);
                } else {
                    cell.setBackground(Color.WHITE);
                    cell.addKeyListener(new SudokuKeyListener(row, col, cell));
                }

                cells[row][col] = cell;
                panel.add(cell);
            }
        }
    }

    private class SudokuKeyListener extends KeyAdapter {
        private int row;
        private int col;
        private JTextField cell;

        public SudokuKeyListener(int row, int col, JTextField cell) {
            this.row = row;
            this.col = col;
            this.cell = cell;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            String text = cell.getText().trim();
            if (text.isEmpty()) {
                sud.getBoard()[row][col] = 0;
            } else {
                int num = Integer.parseInt(text);
                sud.getBoard()[row][col] = num;
            }

            sudokuErrors();
        }
    }


    private void sudokuErrors() {
        List<String> errors = sud.getErrors();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col].setBackground(Color.WHITE);
            }
        }

        for (String error : errors) {
            if (error.contains("Invalid number 0")) {
                continue;
            }
            String[] parts = error.split(" ");
            int num = Integer.parseInt(parts[2]);
            int row = Integer.parseInt(parts[5]);
            int col = Integer.parseInt(parts[7]);

            // Highlight cells based on error type
            if (error.contains("Invalid number")) {
                cells[row][col].setBackground(Color.RED);
            } else if (error.contains("Duplicate number")) {
                cells[row][col].setBackground(Color.PINK);
            }
        }
    }


    public static void main(String[] args) {
        {
            SudokuGui frame = new SudokuGui();
            frame.setVisible(true);
        }
    }
}


