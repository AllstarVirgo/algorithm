package binary.other;


public class SquareNumber {

    public int squareNumber(int x) {
        if (x < 0) {
            throw new IllegalArgumentException();
        }
        if (x == 0 || x == 1) {
            return x;
        }
        double left = 0, right = x;
        while (left < right) {
            double mid = (left + right) / 2.0;
            double multiply = (mid * mid);
            if (Math.abs(multiply - x) < 0.00001) {
                return (int) Math.floor(mid);
            } else if (multiply < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
