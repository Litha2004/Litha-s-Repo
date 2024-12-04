import java.io.*;
import java.util.ArrayList;

public class TwoDimRaggedArrayUtility {

    public static double[][] readFile(File file) throws IOException {
        ArrayList<double[]> rows = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] numbers = line.split(" ");
            double[] row = new double[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                row[i] = Double.parseDouble(numbers[i]);
            }
            rows.add(row);
        }
        reader.close();
        return rows.toArray(new double[rows.size()][]);
    }

    public static void writeToFile(double[][] data, File file) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(file));
        for (double[] row : data) {
            for (int j = 0; j < row.length; j++) {
                writer.print(row[j]);
                if (j < row.length - 1) writer.print(" ");
            }
            writer.println();
        }
        writer.close();
    }

    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }

    public static double getAverage(double[][] data) {
        double total = getTotal(data);
        int count = 0;
        for (double[] row : data) {
            count += row.length;
        }
        return total / count;
    }

    public static double getRowTotal(double[][] data, int rowIndex) {
        double total = 0;
        for (double value : data[rowIndex]) {
            total += value;
        }
        return total;
    }

    public static double getColumnTotal(double[][] data, int colIndex) {
        double total = 0;
        for (double[] row : data) {
            if (colIndex < row.length) {
                total += row[colIndex];
            }
        }
        return total;
    }

    public static double getHighestInRow(double[][] data, int rowIndex) {
        double max = Double.NEGATIVE_INFINITY;
        for (double value : data[rowIndex]) {
            max = Math.max(max, value);
        }
        return max;
    }

    public static int getHighestInRowIndex(double[][] data, int rowIndex) {
        int index = -1;
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data[rowIndex].length; i++) {
            if (data[rowIndex][i] > max) {
                max = data[rowIndex][i];
                index = i;
            }
        }
        return index;
    }

    public static double getLowestInRow(double[][] data, int rowIndex) {
        double min = Double.POSITIVE_INFINITY;
        for (double value : data[rowIndex]) {
            min = Math.min(min, value);
        }
        return min;
    }

    public static int getLowestInRowIndex(double[][] data, int rowIndex) {
        int index = -1;
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data[rowIndex].length; i++) {
            if (data[rowIndex][i] < min) {
                min = data[rowIndex][i];
                index = i;
            }
        }
        return index;
    }

    public static double getHighestInArray(double[][] data) {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] row : data) {
            for (double value : row) {
                max = Math.max(max, value);
            }
        }
        return max;
    }

    public static double getLowestInArray(double[][] data) {
        double min = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            for (double value : row) {
                min = Math.min(min, value);
            }
        }
        return min;
    }
}