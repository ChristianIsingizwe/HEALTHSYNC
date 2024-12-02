package Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {
    public static void logError(String message) {
        try (FileWriter writer = new FileWriter("errors.log", true)) {
            writer.write(new Date() + ": " + message + "\n");
        } catch (IOException e) {
            System.err.println("Error logging to file: " + e.getMessage());
        }
    }
}

