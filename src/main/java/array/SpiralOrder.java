package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0;
        int y = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int direct = 0;
        int[] conditions = {0, n - 1, m - 1, 0};
        List<Integer> res = new ArrayList<>(m * n);
        for (int i = 1; i <= (m * n); i++) {
            res.add(matrix[x][y]);
            int nextX = x + directions[direct][0];
            int nextY = y + directions[direct][1];
            if (nextX < conditions[0] || nextX > conditions[2] || nextY > conditions[1] || nextY < conditions[3]) {
                if (direct == 0 || direct == 3) {
                    conditions[direct] += 1;
                } else {
                    conditions[direct] -= 1;
                }
                direct = (direct + 1) % 4;
                nextX = x + directions[direct][0];
                nextY = y + directions[direct][1];
            }
            x = nextX;
            y = nextY;
        }
        return res;
    }

    public List<Integer> spiralOrderV2(int[][] matrix) {
        if (Objects.isNull(matrix)) {
            return null;
        }
        int m = matrix.length, n = matrix[0].length;
        int left = 0, top = 0, down = m - 1, right = n - 1;
        List<Integer> res = new ArrayList<>();
        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            //重新设定上边界，若上边界大于下边界，则遍历遍历完成，下同
            if (++top > down) {
                break;
            }
            for (int i = top; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left ; i--) {
                res.add(matrix[down][i]);
            }
            if(--down < top){
                break;
            }
            for (int i = down; i >= top ; i--) {
                res.add(matrix[i][left]);
            }
            if(++left > right){
                break;
            }
        }
        return res;
    }
}
