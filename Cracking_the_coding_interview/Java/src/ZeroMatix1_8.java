
public class ZeroMatix1_8 {
	
	/**
	 *ref: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2001.%20Arrays%20and%20Strings/Q1_08_Zero_Matrix/QuestionA.java
	 *O(N^2), Space O(N)
	 **/
	public static void nullifyRow(int[][] matrix, int row) {
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}
	}
	
	public static void nullifyColumn(int [][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}
	
	public static int[][] setZeros(int[][] matrix) {
		boolean[] row = new boolean [matrix.length];
		boolean[] column = new boolean [matrix[0].length];
		
		//Store the row and column index with value 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					//해당 줄에 0이 여러번 등장하더라도 행열을 0으로 바꾸는건 한 번만..
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		
		//Nullify rows
		for (int i = 0; i < row.length; i++) {
			if (row[i]) {
				nullifyRow(matrix, i);
			}
		}
		
		//Nullify row
		for (int j = 0; j < column.length; j++) {
			if (column[j]) {
				nullifyColumn(matrix, j);
			}
		}
		
		return matrix;
	}
	
	/**
	 *ref: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2001.%20Arrays%20and%20Strings/Q1_08_Zero_Matrix/QuestionA.java
	 *O(N^2), Space O(1)
	 *using the 1st row as 'row array' and the 1st column as a 'column array'
	 * @return 
	 **/
	
	public static int[][] setZeros2(int[][] matrix) {
		boolean rowHasZero = false;
		boolean colHasZero = false;
		
		//Check if the first row has a zero
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}
		
		//Check if the first column has a zero
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				colHasZero = true;
				break;
			}
		}
		
		//Check for zeros in the rest of the array
		for (int i = 1; i <matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++){
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		//Nullify rows based on values in the first column
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				nullifyRow(matrix, i);
			}
		}
		
		//Nullify rows based on values in the first column
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				nullifyColumn(matrix, j);
			}
		}
		
		if (rowHasZero){
			nullifyRow(matrix, 0);
		}
		
		if (colHasZero) {
			nullifyColumn(matrix, 0);
		}
		return matrix;
		
	}
	
	
	public static void main(String args[]){
		int[][] sample = { {1,0,3},
				   			{2,3,4},
				   			{3,4,5}};
		int [][] result = setZeros(sample);
		for (int i = 0; i < result.length; i++) {		
			System.out.println();
			for (int j = 0; j < result.length; j++) {
				System.out.print(result[i][j] + " ");
			}
		}
		
		
		
		int[][] sample2 = { {1,5,2,3},
	   						{2,3,0,4},
	   						{3,4,4,5}};
		int [][] result2 = setZeros2(sample2);
		for (int i = 0; i < result2.length; i++) {		
			System.out.println();
			for (int j = 0; j < result2[0].length; j++) {
				System.out.print(result2[i][j] + " ");
			}
		}	
	}
	
}
