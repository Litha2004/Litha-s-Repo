public class HolidayBonus {

    public static final double HIGHEST_BONUS = 5000.0;
    public static final double LOWEST_BONUS = 1000.0;
    public static final double OTHER_BONUS = 2000.0;

    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];
        for (int col = 0; col < getMaxColumns(data); col++) {
            int highestIndex = getHighestInColumnIndex(data, col);
            int lowestIndex = getLowestInColumnIndex(data, col);

            for (int row = 0; row < data.length; row++) {
                if (col < data[row].length) {
                    if (row == highestIndex) {
                        bonuses[row] += HIGHEST_BONUS;
                    } else if (row == lowestIndex) {
                        bonuses[row] += LOWEST_BONUS;
                    } else {
                        bonuses[row] += OTHER_BONUS;
                    }
                }
            }
        }
        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] data) {
        double[] bonuses = calculateHolidayBonus(data);
        double total = 0;
        for (double bonus : bonuses) {
            total += bonus;
        }
        return total;
    }

    private static int getHighestInColumnIndex(double[][] data, int colIndex) {
        double max = Double.NEGATIVE_INFINITY;
        int index = -1;
        for (int row = 0; row < data.length; row++) {
            if (colIndex < data[row].length && data[row][colIndex] > max) {
                max = data[row][colIndex];
                index = row;
            }
        }
        return index;
    }

    private static int getLowestInColumnIndex(double[][] data, int colIndex) {
        double min = Double.POSITIVE_INFINITY;
        int index = -1;
        for (int row = 0; row < data.length; row++) {
            if (colIndex < data[row].length && data[row][colIndex] < min) {
                min = data[row][colIndex];
                index = row;
            }
        }
        return index;
    }

    private static int getMaxColumns(double[][] data) {
        int max = 0;
        for (double[] row : data) {
            max = Math.max(max, row.length);
        }
        return max;
    }
}