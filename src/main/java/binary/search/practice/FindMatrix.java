package binary.search.practice;

public class FindMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        // find last equal or less in column 0
//        int left = -1;
//        int right = matrix.length;
//        while ((left + 1) != right) {
//            int mid = left + ((right - left) >> 1);
//            if (matrix[mid][0] <= target) {
//                left = mid;
//            } else {
//                right = mid;
//            }
//        }

        int left = 0;
        int right = matrix.length - 1;
        int targetRow = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (matrix[mid][0] <= target) {
                if (mid == (matrix.length - 1) || matrix[mid + 1][0] > target) {
                    targetRow = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        if (targetRow == -1) {
            targetRow = left;
        }
        left = 0;
        right = matrix[0].length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (matrix[targetRow][mid] == target) {
                return true;
            } else if (matrix[targetRow][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindMatrix findMatrix = new FindMatrix();
        int[][] matrix = new int[3][4];
        matrix[0] = new int[]{1, 3, 5, 7};
        matrix[1] = new int[]{10, 11, 16, 20};
        matrix[2] = new int[]{23, 30, 34, 60};

        System.out.println(findMatrix.searchMatrix(matrix, 3));
    }

    public int findLastLessOrEqual(int[] array, int target) {
        int l = 0, right = array.length - 1;
        while (l <= right) {
            int mid = l + ((right - l) >> 1);
            if (array[mid] == target) {
                if (mid == (array.length - 1) || array[mid + 1] > target) {
                    return mid;
                } else {
                    l = mid + 1;
                }
            } else if (array[mid] < target) {
                l = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
