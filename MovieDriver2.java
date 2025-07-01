import java.util.Scanner;

public class MovieDriver2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueInput;

        do {
            // Create a new Movie object
            Movie movie = new Movie();

            // Prompt and read movie title
            System.out.print("Enter the name of a movie: ");
            String title = scanner.nextLine();
            movie.setTitle(title);

            // Prompt and read movie rating
            System.out.print("Enter the rating of the movie: ");
            String rating = scanner.nextLine();
            movie.setRating(rating);

            // Prompt and read number of tickets sold
            System.out.print("Enter the number of tickets sold: ");
            int ticketsSold = scanner.nextInt();
            movie.setSoldTickets(ticketsSold);

            // Print movie info
            System.out.println();
            System.out.println(movie.toString());
            System.out.println();

            // Clear the scanner buffer (reads the leftover newline character)
            scanner.nextLine();

            // Ask the user if they want to enter another movie
            System.out.print("Do you want to enter another movie? (y/n): ");
            continueInput = scanner.nextLine();

            System.out.println();

        } while (continueInput.equalsIgnoreCase("y"));

        // End message
        System.out.println("Goodbye!");

        scanner.close();
    }
}