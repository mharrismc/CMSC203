import java.util.Scanner;

public class MovieDriver
{
    public static void main(String[] args)
    {
        Scanner keyboard= new Scanner(System.in);
        Movie newMovie = new Movie();
        String input;

        do{

        System.out.println("Enter the title of a movie: ");
        newMovie.setTitle(keyboard.nextLine());

        System.out.println("Enter the movies rating: ");
        newMovie.setRating(keyboard.nextLine());

        System.out.println("Enter the number of tickets sold at the theatre: ");
        newMovie.setSoldTickets(keyboard.nextInt());

        //consume newline
        keyboard.nextLine();

        System.out.println(newMovie.toString());

        System.out.println("Do you want to enter another movie? (y/n)");
        input=keyboard.nextLine();

        }while (input.equals("y"));

    }
}