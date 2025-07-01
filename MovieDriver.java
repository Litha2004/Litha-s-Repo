import java.util.Scanner;

public class MovieDriver {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the keyboard
        Scanner scanner = new Scanner(System.in);

        // Create a new Movie object
        Movie movie = new Movie();

        // Prompt the user to enter the title of the movie
        System.out.print("Enter the name of a movie: ");
        String title = scanner.nextLine();
        movie.setTitle(title);

        // Prompt the user to enter the movie’s rating
        System.out.print("Enter the rating of the movie: ");
        String rating = scanner.nextLine();
        movie.setRating(rating);

        // Prompt the user to enter the number of tickets sold
        System.out.print("Enter the number of tickets sold: ");
        int ticketsSold = scanner.nextInt();
        movie.setSoldTickets(ticketsSold);

        // Print out the movie information using toString
        System.out.println();
        System.out.println(movie.toString());

        // Close the scanner
        scanner.close();
    }
}