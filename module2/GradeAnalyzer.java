import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
 
    public static void main(String[] args) {
        String filename = "scores.txt";
        int[] skippedLineCount = new int[1];
        ArrayList<Integer> scores = readScores(filename, skippedLineCount);
        double average = calculateAverage(scores);

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
            if (score < lowest) {
                lowest = score;
            }
        }

        writeReport(scores, average, highest, lowest, skippedLineCount[0], "report.txt");
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename, int[] skippedLineCount) {
        ArrayList<Integer> scores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean hasData = false;

            while ((line = reader.readLine()) != null) {
                hasData = true;
                line = line.trim();
                if (!line.isEmpty()) {
                    try {
                        scores.add(Integer.parseInt(line));
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid line: " + line);
                        skippedLineCount[0]++;
                    }
                }
            }

            if (!hasData) {
                System.out.println("The file is empty. No scores were processed.");
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }

        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here 
        if (scores.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   int skippedLines, String outputFile) {
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int dCount = 0;
        int fCount = 0;

        for (int score : scores) {
            if (score >= 90) {
                aCount++;
            } else if (score >= 80) {
                bCount++;
            } else if (score >= 70) {
                cCount++;
            } else if (score >= 60) {
                dCount++;
            } else {
                fCount++;
            }
        }

        String[] lines = {
            "=== Grade Analysis Report ===\n",
            String.format("Scores processed: %d%n", scores.size()),
            String.format("Lines skipped: %d%n", skippedLines),
            String.format("Average score: %.2f%n", avg),
            String.format("Highest score: %d%n", high),
            String.format("Lowest score: %d%n", low),
            String.format("Grade counts:%n"),
            String.format("  %-5s %d%n", "A (90-100)", aCount),
            String.format("  %-5s %d%n", "B (80-89)", bCount),
            String.format("  %-5s %d%n", "C (70-79)", cCount),
            String.format("  %-5s %d%n", "D (60-69)", dCount),
            String.format("  %-5s %d%n", "F (Below 60)", fCount)
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String line : lines) {
                writer.write(line);
                System.out.print(line);
            }
        } catch (IOException e) {
            System.out.println("Could not write report: " + e.getMessage());
        }
    }
} 
