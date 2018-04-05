
public class Rotation1_7 {

	
	public static boolean rotate(int[][] matrix) {
		if(matrix.length == 0 || matrix.length != matrix[0].length)
			return false; // Not a square
		int n = matrix.length;
		
		for (int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i]; //save top
				
				//left -> top
				matrix[first][i] = matrix[last-offset][first];
				
				//bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset];
				
				// right -> bottom
				matrix[last][last-offset] = matrix[i][last];
				
				// top -> right
				matrix[i][last] = top; //right <- saved top
			}
		}
		return true;
		
		
	}
	public static void main(String args[]){
		int[][] it = { {1,2,3,4,5},
				       {2,3,4,5,6} };
		System.out.println(it.length);//2 (row, За)
		System.out.println(it[0].length);//5 (column, ї­)
		
		int[][] sample = { {1,2,3},
						   {2,3,4},
						   {3,4,5}};
		
		
		rotate(sample);
		for (int i = 0; i < sample.length; i++) {
			System.out.println();
			for (int j = 0; j < sample[i].length; j++){
				System.out.print(sample[i][j] + " ");
			}
		}
		
		
		
	}
}

