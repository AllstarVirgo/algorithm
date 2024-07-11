package dp.practice;

public class MaximumLength {
    private int maxPoint;

    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        boolean[] selected = new boolean[enemyEnergies.length];
        backtrace(selected, enemyEnergies, currentEnergy, 0, 0);
        return maxPoint;
    }

    private void backtrace(boolean[] selected, int[] enemyEnergies, int currentEnergy, int point, int selectedCount) {
        if (selectedCount == enemyEnergies.length) {
            return;
        }
        for (int i = 0; i < enemyEnergies.length; i++) {
            while (currentEnergy >= enemyEnergies[i]) {
                currentEnergy -= enemyEnergies[i];
                point += 1;
            }
            if (point >= 1) {
                selected[i] = true;
                currentEnergy += enemyEnergies[i];
                backtrace(selected, enemyEnergies, currentEnergy, point, selectedCount + 1);
                selected[i] = false;
                currentEnergy -= enemyEnergies[i];
            }
            while (currentEnergy >= enemyEnergies[i]) {
                currentEnergy -= enemyEnergies[i];
                point += 1;
            }
            maxPoint = Math.max(point, maxPoint);
        }
    }

    public static void main(String[] args) {
        int[] array = {2,3,4};
        System.out.println(new MaximumLength().maximumPoints(array, 2));
    }
}
