public class GradeBook {
    private double[] scores;
    private int scoresSize;

    public GradeBook(int capacity) {
        scores = new double[capacity];
        scoresSize = 0;
    }

    public boolean addScore(double score) {
        if (scoresSize < scores.length) {
            scores[scoresSize] = score;
            scoresSize++;
            return true;
        }
        return false;
    }

    public double sum() {
        double total = 0;
        for (int i = 0; i < scoresSize; i++) {
            total += scores[i];
        }
        return total;
    }

    public double minimum() {
        if (scoresSize == 0) return 0;
        double smallest = scores[0];
        for (int i = 1; i < scoresSize; i++) {
            if (scores[i] < smallest) {
                smallest = scores[i];
            }
        }
        return smallest;
    }

    public double finalScore() {
        if (scoresSize == 0) return 0;
        if (scoresSize == 1) return scores[0];
        return sum() - minimum();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < scoresSize; i++) {
            result.append(scores[i]).append(" ");
        }
        return result.toString();
    }

    public int getScoreSize() {
        return scoresSize;
    }
}