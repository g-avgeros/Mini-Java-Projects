package gr.aueb.cf.ch10.projects;

public class SwallowDeepCopy {

    public static void main(String[] args) {
        int[][] arr = {{12, 25, 4}, {1, 5, 6}};

        // Creates a swallow copy of the arr
        int[][] swallowCopy = swallowCopy(arr);

        // Creates a deep copy of the arr
        int[][] deepCopy = deepCopy(arr);

        // Modify an element of the original array
        arr[0][0] = 5;

        // Prints the original arr
        print2DArray(arr);
        System.out.println();

        // Prints a deep copy
        print2DArray(swallowCopy);
        System.out.println();

        // Prints a deep copy
        print2DArray(deepCopy);
    }

    // Swallow copy method
    public static int[][] swallowCopy(int[][] arr) {
        return arr.clone();
    }


    // Deep copy method
    public static int[][] deepCopy(int[][] arr) {
        int[][] copy = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }

    // Method to print a 2D array
    public static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
