
/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: Movie Driver Lab 1. Collects information on a users movie of choice
 * Due: 06/30/2025
 * Platform/compiler:VSCode
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Madison
*/
import java.util.Scanner;

public class MovieDriverTask1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Movie newMovie = new Movie();

        System.out.println("Enter the title of a movie: ");
        newMovie.setTitle(keyboard.nextLine());

        System.out.println("Enter the movies rating: ");
        newMovie.setRating(keyboard.nextLine());

        System.out.println("Enter the number of tickets sold at the theatre: ");
        newMovie.setSoldTickets(keyboard.nextInt());

        // consume newline
        keyboard.nextLine();

        System.out.println(newMovie.toString());
    }
}