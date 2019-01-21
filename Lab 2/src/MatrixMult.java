//Multiplication of two square matrices of size n X n each

import java.util.Scanner;

public class MatrixMult 
{
	 public static void main(String[] args) 
	 {
		 //obtains inputs from user
		 Scanner keyboard = new Scanner(System.in);
		 int n;                                                   //n x n matrix
		 double num;
		 System.out.print("Enter the size of each matrix: ");
		 n = keyboard.nextInt();
		 System.out.print("Enter the matrix element (");
		 System.out.print("all elements of the matrices are assumed to be the same): ");
		 num = keyboard.nextDouble();
		 
		 //declare two n x n matrix and assign their elements to be num
		 double[][] matrix1 = new double[n][n];
		 for (int i = 0; i < n; i++)
			 for (int j = 0; j < n; j++)
				 matrix1[i][j] = num;
		 double[][] matrix2 = new double[n][n];
		 for (int i = 0; i < n; i++)
			 for (int j = 0; j < n; j++)
				 matrix2[i][j] = num;
		 
		 //starts measuring time
		 long startTime, endTime, executionTime;
		 startTime = System.currentTimeMillis();
		 
		 //calls the multiplyMatrix method to multiply matrix1 and matrix2
		 //declare a resultMatrix for the result returned by multiplyMatrix method
		 double[][] resultMatrix = multiplyMatrix(matrix1, matrix2);
		 
		 //finishes measuring time
		 endTime = System.currentTimeMillis();
		 executionTime = endTime - startTime;
		 
		 //prints result
		 System.out.println("Execution time: " + executionTime + " millisecs");
	 }
	 
	 /** The method for multiplying two matrices
	  * @param a matrix 1
	  * @param b matrix 2
	  * @return return the resulting matrix
	  */
	
	 public static double[][] multiplyMatrix(double[][] a, double[][] b)
	 {
		 //declare a resultMatrix to store results, its size is n, which is obtained from a.length
		 //it is initialized to zero by default
		 double[][] resultMatrix = new double[a.length][a.length];
		 
		 //the method is based on the formula: c[i][j] = a[i][1]*b[1][j] + a[i][2]*b[2][j] + a[i][3]*b[3][j]+ a[i][n]*b[n][j]
		 //clearly, this formula can be implemented with 3 nested for loops
		 //i and j are rows and columns, and they start with 0 and ends with n-1
		 //k is the referring to the multiplications and additions required for each element, also starts with 0 and ends with n-1
		 //although formula shows k starts at 1, but in array, the index starts with 0
		 for (int i=0; i<a.length; i++)
			 for (int j=0; j<a.length; j++)
				 for(int k=0; k<a.length; k++)
					 resultMatrix[i][j] += a[i][k]*b[k][j];
		 
		 return resultMatrix;
	 }

}
