package blance;

import java.util.Arrays;

public class SmoothlyWeightBalance {

    private int[] weights;

    private int[] currentWeights;

    private int sum;

    public SmoothlyWeightBalance(int... weights) {
        this.weights = weights.clone();
        this.currentWeights = weights.clone();
        this.sum = Arrays.stream(weights).sum();
    }

    public int pick() {
        int maxIndex = 0;
        for (int i = 1; i < currentWeights.length; i++) {
            if (currentWeights[i] > currentWeights[maxIndex]) {
                maxIndex = i;
            }
        }

        currentWeights[maxIndex] = currentWeights[maxIndex] - sum;
        for (int i = 0; i < currentWeights.length; i++) {
            currentWeights[i] += weights[i];
        }
        return maxIndex;
    }
}
