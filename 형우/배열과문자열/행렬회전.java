public class 행렬회전 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrixForRotate = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrixForRotate = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] rotatedMatrix = rotate90Degree(matrixForRotate);
        prettyPrint(matrix);
        System.out.println("----------");
        prettyPrint(rotatedMatrix);
    }

    private static void prettyPrint(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] rotate90Degree(int[][] matrix) {
        int temp = 0;
        for (int start = 0, end = matrix.length - 1; start < end; start++, end--) {
            for (int i = start, j = end; i < end; i++, j--) {
                temp = matrix[start][i];
                matrix[start][i] = matrix[j][start];
                matrix[j][start] = matrix[end][j];
                matrix[end][j] = matrix[i][end];
                matrix[i][end] = temp;
            }
        }
        return matrix;
    }
}