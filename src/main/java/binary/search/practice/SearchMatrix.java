package binary.search.practice;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int maxRowIndex = matrix.length - 1;
        int l = 0, r = maxRowIndex;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (matrix[mid][0] <= target) {
                if (mid == maxRowIndex || matrix[mid + 1][0] > target) {
                    l = mid;
                    break;
                } else {
                    l = mid + 1;
                }
            } else {
                r = mid - 1;
            }
        }
        int targetRow = l;

        l = 0;
        r = matrix[0].length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (matrix[targetRow][mid] == target) {
                return true;
            } else if (matrix[targetRow][mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        int[][] nums = new int[3][4];
        nums[0] = new int[]{1, 3, 5, 7};
        nums[1] = new int[]{10, 11, 16, 20};
        nums[2] = new int[]{23, 30, 34, 50};
        boolean b = searchMatrix.searchMatrix(nums, 11);
        System.out.println(b);
    }
}
