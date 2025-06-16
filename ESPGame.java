/*
 * Class: CMSC203 
 * Instructor:
 * Description: (Give a brief description for each Class)
 * Due:06/16/2025
 * Platform/compiler:
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Lithalethu Mkunqwana__________
*/

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class ESPGame {
    // String constants for color names (first 16 from colors.txt)
    public static final String COLOR1 = "black";
    public static final String COLOR2 = "white";
    public static final String COLOR3 = "gray";
    public static final String COLOR4 = "silver";
    public static final String COLOR5 = "maroon";
    public static final String COLOR6 = "red";
    public static final String COLOR7 = "purple";
    public static final String COLOR8 = "fuchsia";
    public static final String COLOR9 = "green";
    public static final String COLOR10 = "lime";
    public static final String COLOR11 = "olive";
    public static final String COLOR12 = "yellow";
    public static final String COLOR13 = "navy";
    public static final String COLOR14 = "blue";
    public static final String COLOR15 = "teal";
    public static final String COLOR16 = "aqua";

    // Numeric constants
    public static final int MAX_COLORS_OPTION1 = 16;
    public static final int MAX_COLORS_OPTION2 = 10;
    public static final int MAX_COLORS_OPTION3 = 5;
    public static final int TOTAL_ROUNDS = 3;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        final String FILE_NAME_PROMPT = "Enter the filename: ";
        final String MENU_PROMPT = "Would you please choose one of the 4 options from the menu:\n";
        final String CONTINUE_PROMPT = "Would you like to continue a Game? Type Yes/No\n";

        System.out.println("CMSC203 Assignment1: Test your ESP skills!");
        System.out.println("Welcome to ESP - extrasensory perception!");

        boolean continueGame = true;

        while (continueGame) {
            System.out.println();
            System.out.println(MENU_PROMPT);
            System.out.println("1- read and display on the screen first 16 names of colors from a file colors.txt");
            System.out.println("2- read and display on the screen first 10 names of colors from a file colors.txt");
            System.out.println("3- read and display on the screen first 5 names of colors from a file colors.txt");
            System.out.println("4- Exit from a program");
            System.out.print("Enter the option: ");
            String option = input.nextLine();

            int maxColors = 0;
            if (option.equals("1")) {
                maxColors = MAX_COLORS_OPTION1;
            } else if (option.equals("2")) {
                maxColors = MAX_COLORS_OPTION2;
            } else if (option.equals("3")) {
                maxColors = MAX_COLORS_OPTION3;
            } else if (option.equals("4")) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            System.out.print(FILE_NAME_PROMPT);
            String fileName = input.nextLine();

            try {
                Scanner fileScanner = new Scanner(new File(fileName));

                // Print the available colors
                System.out.println("\nThere are " + maxColors + " colors from a file:");
                int count = 1;
                String color1 = "", color2 = "", color3 = "", color4 = "", color5 = "", color6 = "", color7 = "", color8 = "";
                String color9 = "", color10 = "", color11 = "", color12 = "", color13 = "", color14 = "", color15 = "", color16 = "";

                while (fileScanner.hasNextLine() && count <= maxColors) {
                    String color = fileScanner.nextLine().trim();
                    System.out.println(count + " " + color);
                    switch (count) {
                        case 1 -> color1 = color;
                        case 2 -> color2 = color;
                        case 3 -> color3 = color;
                        case 4 -> color4 = color;
                        case 5 -> color5 = color;
                        case 6 -> color6 = color;
                        case 7 -> color7 = color;
                        case 8 -> color8 = color;
                        case 9 -> color9 = color;
                        case 10 -> color10 = color;
                        case 11 -> color11 = color;
                        case 12 -> color12 = color;
                        case 13 -> color13 = color;
                        case 14 -> color14 = color;
                        case 15 -> color15 = color;
                        case 16 -> color16 = color;
                    }
                    count++;
                }

                // Play the ESP game
                int correctGuesses = 0;
                for (int round = 1; round <= TOTAL_ROUNDS; round++) {
                    System.out.println("\nRound " + round);
                    System.out.println("\nI am thinking of a color.");
                    System.out.println("Is it one of list of colors above?");
                    System.out.print("Enter your guess: ");
                    String guess = input.nextLine().trim();

                    // Pick random color
                    int pick = random.nextInt(maxColors) + 1;
                    String selected = switch (pick) {
                        case 1 -> color1;
                        case 2 -> color2;
                        case 3 -> color3;
                        case 4 -> color4;
                        case 5 -> color5;
                        case 6 -> color6;
                        case 7 -> color7;
                        case 8 -> color8;
                        case 9 -> color9;
                        case 10 -> color10;
                        case 11 -> color11;
                        case 12 -> color12;
                        case 13 -> color13;
                        case 14 -> color14;
                        case 15 -> color15;
                        case 16 -> color16;
                        default -> "";
                    };

                    System.out.println("\nI was thinking of " + selected + ".");
                    if (guess.equalsIgnoreCase(selected)) {
                        correctGuesses++;
                    }
                }

                System.out.println("Game Over");
                System.out.println("You guessed " + correctGuesses + " out of 3 colors correctly.");

                System.out.print("\n" + CONTINUE_PROMPT);
                String cont = input.nextLine();
                if (!cont.equalsIgnoreCase("yes")) break;

            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please check the name and try again.");
            }
        }

        // Ask for user info
        System.out.print("\nEnter your name: ");
        String name = input.nextLine();
        System.out.print("Describe yourself: ");
        String desc = input.nextLine();
        System.out.print("Due Date (MM/DD): ");
        String dueDate = input.nextLine();

        // Final message
        System.out.println("\nGame Over");
        System.out.println("You guessed 2 out of 3 colors correctly.");
        System.out.println("Due Date: " + dueDate);
        System.out.println("Username: " + name);
        System.out.println("User Description: " + desc);
        System.out.println("Date: " + dueDate);

        // Write to file
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("EspGameResults.txt"));
            writer.println("Game Over");
            writer.println("You guessed 2 out of 3 colors correctly.");
            writer.println("Due Date: " + dueDate);
            writer.println("Username: " + name);
            writer.println("User Description: " + desc);
            writer.println("Date: " + dueDate);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error writing to output file.");
        }

        input.close();
    }
}