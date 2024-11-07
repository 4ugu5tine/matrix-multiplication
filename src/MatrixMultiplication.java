import java.util.Arrays;
import java.util.Scanner;

public class MatrixMultiplication {

                                                                          //initialise the matrix size
    public int rowA, rowB, colA, colB;

                                                                        //initialise the matrices using
    public int [][] matrixA, matrixB;

    public void collect (){

        try(Scanner scanner = new Scanner((System.in))) {

                                                                        //collect the size of both matrices from the user
            System.out.print("Number of rows of the Matrix A: ");
            rowA = scanner.nextInt();

            System.out.print("Number of columns of the Matrix A: ");
            colA = scanner.nextInt();

            System.out.print("Number of rows of the Matrix B: ");
            rowB = scanner.nextInt();

            System.out.print("Number of columns of the Matrix B: ");
            colB = scanner.nextInt();

            System.out.println("enter the numbers for Matrix A");
            System.out.println();

            matrixA = new int[rowA][colA];
            matrixB = new int[rowB][colB];

                                                                    //check if the matrices have compatible sizes
            if (colA != rowB) {
                System.out.println("incompatible matrices");
                return;
            }


                                                                     //collect the array elements for both arrays
            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < colA; j++) {
                    System.out.print("Enter value for Matrix A" + "[" + i + "]" + "[" + j + "] :");
                    matrixA[i][j] = scanner.nextInt();
                }
            }

            System.out.println();

            for (int i = 0; i < rowB; i++) {
                for (int j = 0; j < colB; j++) {
                    System.out.print("Enter value for Matrix B" + "[" + i + 1 + "]" + "[" + (j + 1) + "] :");
                    matrixB[i][j] = scanner.nextInt();
                }
            }
        } catch (Exception e) {
            System.out.println("something went wrong");
        }

                                                                //print out matrices for the user
        System.out.println("Matrix A");
        System.out.println(Arrays.deepToString(matrixA));

        System.out.println("Matrix B");
        System.out.println(Arrays.deepToString(matrixB));

        System.out.println();

    }

    public void multiply (){



                                                                //initialise the resulting matrix using the rowA and colB
        int [][] matrixC = new int[rowA][colB];

                                                                //compute the elements of the resulting matrix by looping through matrixA and matrixB
        for (int i = 0; i < rowA ;i++ ) {
            for (int j = 0; j < colB; j++) {
                for (int x = 0; x < colA; x++) {
                    matrixC[i][j] += matrixA[i][x] * matrixB[x][j];
                }
            }
        }

                                                                //print out the resulting matrix with preceding and trailing |
        System.out.println("Matrix C");
        for(int [] array : matrixC){
            System.out.print("| ");
            for (int i : array){
                System.out.print(i + " ");
            }
            System.out.println(" |");
        }
    }

    public static void main(String[] args) {
        MatrixMultiplication matrixMultiplication = new MatrixMultiplication();
        matrixMultiplication.collect();
        matrixMultiplication.multiply();
    }

}
