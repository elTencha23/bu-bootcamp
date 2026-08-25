
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class FileDemo {
    public static void main(String[] args) {
        String filename = "numbers.txt";
        int number = 0;
        double amount = 0.0;
 
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                number = Integer.parseInt(line.trim());
                amount = Double.parseDouble(line.trim());
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid value: " + line);
                }
                System.out.println("Number: " + number + ", Amount: " + amount);
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }
} 