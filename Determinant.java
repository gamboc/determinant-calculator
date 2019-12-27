
import java.util.Arrays;
import java.util.Scanner;

public class Determinant {

	public static int potenca(int n, int e) {
		int a = n;
		for (int i = 0; i < e; i++) {
			a *= n;
		}

		return a;
	}

	public static int[][] reduce(int[][] matrix, int n, int i, int j) {
		int[][] ma = new int[n][n];
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				if (a < i && b < j) {
					ma[a][b] = matrix[a][b];
				}
				else if (a < i && b >= j) {
					ma[a][b] = matrix[a][b + 1];
				}
				else if (a >= i && b < j) {
					ma[a][b] = matrix[a + 1][b];
				}
				else {
					ma[a][b] = matrix[a + 1][b + 1];
				}
			}
		}

		return ma;
	}

	public static int calcDeterminant(int[][] matrix, int n) {
		if (n == 1) {
			return matrix[0][0];
		}
		else {
			int a = 0;
			for (int i = 0; i < n; i++) {
				if(matrix[i][0] != 0) {
					a += potenca(-1, i + 1) * matrix[i][0] * calcDeterminant(reduce(matrix, n - 1, i, 0), n - 1);
				}
			}
			return a;
		}
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n;
		System.out.print("Enter the size of the matrix: ");
		n = sc.nextInt();

		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			System.out.print("Enter the numbers in the next row separated by spaces: ");
			for (int j = 0; j < n; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		System.out.println(calcDeterminant(matrix, n));
	}
}
