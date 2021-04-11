package lambdas.executearound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecuteAroundApplication {

    public static void main(String... args) throws IOException {

        System.out.println("Usage without behaviour parameterization : " + processFileLimit());

        System.out.println("With behaviour parameterization : " + processFile((BufferedReader br) -> br.readLine()));

        System.out.println("Two lines with behaviour parameterization : " +
                processFile((BufferedReader br) -> br.readLine() + br.readLine()));

    }

    private static String processFileLimit() throws IOException {
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(ClassLoader.getSystemResourceAsStream("lambdas/example2/data.txt")))) {
            return br.readLine();
        }
    }

    private static String processFile(ExecuteAroundInterface bufferedProcessor) throws IOException {
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(ClassLoader.getSystemResourceAsStream("lambdas/example2/data.txt")))) {
            return bufferedProcessor.process(br);
        }

    }
}
