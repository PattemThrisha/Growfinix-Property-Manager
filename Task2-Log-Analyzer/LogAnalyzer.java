import java.nio.file.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class LogAnalyzer {
    public static void main(String[] args) throws Exception {

        
        Path path = Paths.get("logs.txt");

        
        Pattern pattern = Pattern.compile("ERROR\\s(\\d+)");

        
        Map<String, Long> errorCount = Files.lines(path)
                .map(line -> {
                    Matcher matcher = pattern.matcher(line);

                    
                    if (matcher.find()) {
                        return matcher.group(1); 
                    }
                    return "UNKNOWN";
                })
                
                .collect(Collectors.groupingBy(
                        code -> code,
                        Collectors.counting()
                ));

        
        System.out.println("=== ERROR CODE ANALYSIS ===");

        errorCount.forEach((code, count) -> {
            System.out.println("Error " + code + " = " + count + " times");
        });
    }
}
