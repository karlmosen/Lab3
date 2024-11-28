package lab3;

import java.io.*;
import java.util.regex.*;

public class Main {

        public static void main(String[] args) {

            if (args.length != 3 || !args[0].equals("search")) {
                return;
            }
    
            String pattern = args[1];
            String fileName = args[2];
    

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                int lineNumber = 0;
                Pattern regex = Pattern.compile(pattern);
    
                while ((line = reader.readLine()) != null) {
                    lineNumber++;
                    Matcher matcher = regex.matcher(line);
                    if (matcher.find()) {
                        System.out.println("Line " + lineNumber + ": " + line);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + fileName);
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        }
}