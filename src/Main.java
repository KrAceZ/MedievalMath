import java.util.Scanner;

public class Main {
    public static String UserInput() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter something: ");
        return scn.nextLine();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

        String userInput = UserInput();
        System.out.println("User input: " + userInput);
        System.out.println("testing 123");
        System.out.println("Did it work?");
    }


}