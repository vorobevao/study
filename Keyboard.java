import java.util.Scanner;

public class Keyboard {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
                char input = scanner.next().charAt(0);
                        String keyboard = "qwertyuiopasdfghjklzxcvbnm";
                        int index = keyboard.indexOf(input);
                        int leftIndex = (index - 1 + keyboard.length()) % keyboard.length();
                        char result = keyboard.charAt(leftIndex);
                        System.out.println(result);
    }

}
