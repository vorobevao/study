import java.util.Scanner;

public class Arrow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();
        int count = 0;

        for (int i = 0; i <= sequence.length() - 5; i++) {
            if (sequence.charAt(i) == '>'
                    && sequence.charAt(i+1) == '>'
                    && sequence.charAt(i+2) == '-'
                    && sequence.charAt(i+3) == '-'
                    && sequence.charAt(i+4) == '>'
            )
            {
                count++;
            } else if (sequence.charAt(i) == '<'
                    && sequence.charAt(i+1) == '-'
                    && sequence.charAt(i+2) == '-'
                    && sequence.charAt(i+3) == '<'
                    && sequence.charAt(i+4) == '<'

            ) {
                count++;
            }
        }
        System.out.println(count);
    }
}

