import java.util.Scanner;

public class MatrixMultiplication {

    public static class Matrix {
        private final int[][] data;

        public Matrix(int[][] data) {
            this.data = data;
        }

        public int getRows() {
            return data.length;
        }

        public int getColumns() {
            return data[0].length;
        }

        public int getValue(int i, int j) {
            return data[i][j];
        }
    }

    public static class MatrixMultiplier {
        public static Matrix multiply(Matrix A, Matrix B) {
            if (A.getColumns() != B.getRows()) {
                throw new IllegalArgumentException("The number of columns in the first matrix must be equal to the number of rows in the second matrix.");
            }

            int rowsA = A.getRows();
            int colsA = A.getColumns();
            int colsB = B.getColumns();

            int[][] result = new int[rowsA][colsB];

            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsB; j++) {
                    for (int k = 0; k < colsA; k++) {
                        result[i][j] += A.getValue(i, k) * B.getValue(k, j);
                    }
                }
            }

            return new Matrix(result);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows for matrix A: ");
        int rowsA = scanner.nextInt();

        System.out.print("Enter the number of columns for matrix A: ");
        int colsA = scanner.nextInt();

        int[][] dataA = new int[rowsA][colsA];
        System.out.println("Enter the elements of matrix A:");

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                dataA[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter the number of rows for matrix B: ");
        int rowsB = scanner.nextInt();

        System.out.print("Enter the number of columns for matrix B: ");
        int colsB = scanner.nextInt();

        int[][] dataB = new int[rowsB][colsB];
        System.out.println("Enter the elements of matrix B:");

        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                dataB[i][j] = scanner.nextInt();
            }
        }

        Matrix A = new Matrix(dataA);
        Matrix B = new Matrix(dataB);

        try {
            Matrix result = MatrixMultiplier.multiply(A, B);

            System.out.println("Resultant matrix:");
            for (int i = 0; i < result.getRows(); i++) {
                for (int j = 0; j < result.getColumns(); j++) {
                    System.out.print(result.getValue(i, j) + " ");
                }
                System.out.println();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

