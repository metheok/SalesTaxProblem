import java.util.ArrayList;
import java.util.Scanner;

public class IO {
    public ArrayList<String> takeLinesFromIO() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<String>();
        System.out.println("Enter each product description in a new line");
        System.out.println("To end the prompt type end in a new line");
        System.out.println("Please write here:");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("end")) {
                break;
            }
            if (line.length() < 1) {
                continue;
            }
            line = line.trim();
            lines.add(line);
        }

        scanner.close();
        return lines;
    }

    public void printLines(ArrayList<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
