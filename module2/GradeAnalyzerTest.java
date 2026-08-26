

import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*; 
import java.util.ArrayList; 
import java.util.Arrays; 
import java.nio.file.Files;
import java.nio.file.Path;
 
public class GradeAnalyzerTest { 
 
    @Test
    void calculateAverage_returnsZero_whenListIsEmpty() { 
        ArrayList<Integer> scores = new ArrayList<>(); 
        assertEquals(0.0, GradeAnalyzer.calculateAverage(scores)); 
    } 
 
    @Test
    void calculateAverage_returnsCorrectAverage_forTypicalScores() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(80, 90, 100)); 
        assertEquals(90.0, GradeAnalyzer.calculateAverage(scores));
    }
 
    @Test
    void calculateAverage_returnsSingleValue_whenListHasOneItem() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(75)); 
        assertEquals(75.0, GradeAnalyzer.calculateAverage(scores));
    } 
 
    @Test
    void calculateAverage_returnsDouble_notInteger() { 
        // 1 + 2 = 3, divided by 2 = 1.5, not 1
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(1, 2)); 
        assertEquals(1.5, GradeAnalyzer.calculateAverage(scores)); 
    } 
 
    @Test 
    void calculateAverage_handlesAllSameValues() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(88, 88, 88)); 
        assertEquals(88.0, GradeAnalyzer.calculateAverage(scores)); 
    }

    @Test
    void calculateAverage_returnsExactAverage_forTenValues() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100));
        assertEquals(55.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void readScores_skipsStringBetweenNumbers() throws Exception {
        Path inputFile = Files.createTempFile("scores-test-", ".txt");
        Files.write(inputFile, Arrays.asList("10", "not a number", "20"));
        int[] skippedLineCount = new int[1];

        ArrayList<Integer> scores = GradeAnalyzer.readScores(inputFile.toString(), skippedLineCount);

        assertEquals(Arrays.asList(10, 20), scores);
        assertEquals(1, skippedLineCount[0]);
        Files.deleteIfExists(inputFile);
    }
}
