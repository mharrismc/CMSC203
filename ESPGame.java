/*
 * Class: CMSC203 
 * Instructor: Professor Grinber
 * Description: This program prompts a user to correctly guess a randomly selected color from 
 *              a list of 5, 10 or 16 colors. The program simulates an ESP game
 * ASSIGNMENT 1
 * Due: 06/14/2025
 * Platform/compiler: VSCode
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Madison Harris
*/


import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class ESPGame
{
    public static void main(String[] args) throws IOException
    {    
        //declaring constant variables
        final int maxGuesses=3;
        final String fileName="colors.txt";
        final String outputFileName="EspGameResults.txt";

        //Create scanner variable for to read user input
        var input = new Scanner(System.in);

        //Declare+initialize global variable
        char userChoice;
        int correct=0;

        do
        {
            //Holds number of how many colors should be shown based on user option
            int displayNum=0;

            //Holds number chosen by random number generator
            int randColorNum;


            //Displays four option menu
            do{
            System.out.println("Choose one of the 4 options below: ");
            System.out.println("a. read and display on the screen the first 16 names of colors from a file colors.txt");
            System.out.println("b. read and display on the screen the first 10 names of colors from a file colors.txt ");
            System.out.println("c. read and display on the screen the first 5 names of colors from a file colors.txt");
            System.out.println("d. Exit Program");

            //Collects user input from above
            userChoice = input.nextLine().charAt(0);
            //loops until user enters valid choice
            }while(userChoice !='a' && userChoice !='b' && userChoice !='c' && userChoice !='d');

            //declares file and scanner object
            Scanner colorFile = new Scanner(new File(fileName));

            //Switch statement based on what option user chooses from menu
            if(userChoice=='a' || userChoice=='b' || userChoice=='c')
            {
                switch(userChoice)
                {
                    case 'a':
                    for (int i=1; i<=16 && colorFile.hasNextLine(); i++)
                    {
                        //Display 16 lines
                        String line=colorFile.nextLine();
                        System.out.println(line);
                        displayNum=16;
                    }
                    break;

                    case 'b':
                    for (int i=1; i<=10 && colorFile.hasNextLine(); i++)
                    {
                        //Display 10 lines
                        String line=colorFile.nextLine();
                        System.out.println(line);
                        displayNum=10;
                    }
                        break;

                    case 'c':
                    for (int i=1; i<=5 && colorFile.hasNextLine(); i++)
                    {
                        //Display 5 lines
                        String line=colorFile.nextLine();
                        System.out.println(line);
                        displayNum=5;
                    }
                        break;
                }
                colorFile.close();
        
                //Declaring+initializing variables to be used in do while loop
            
                //holds line number in file
                int currentLine;
                //Holds selected color to be guessed
                String color;
                //Holds number of guesses by user
                int guesses=0;

                do
                {
                    //Re declaring file and scanner object
                    Scanner colorFile2 = new Scanner(new File(fileName)); 

                    //initializing variables used in loop
                    color = " "; 
                    currentLine = 1; 

                    //Choosing random number between 1 and (5,10 or 16) based on user choice above
                    Random randomNumbers = new Random();
                    randColorNum = randomNumbers.nextInt(displayNum) + 1;


                    while (colorFile2.hasNextLine() && color.equals(" "))
                    {
                        //holds name of current color
                        String line = colorFile2.nextLine();

                        //if current line holds the name of the color chosen by random number
                        if (currentLine == randColorNum)
                        {
                            color = line;
                            break;
                        }
                        //move down a line (increase line number by 1 if color not found in file yet)
                        currentLine++;
                    }
                    colorFile2.close();
                

                    //collects user guesses
                    System.out.println("Guess the color: ");
                    String userGuess = input.nextLine();

                    //Validating users guess
                    int valid=0;
                    Scanner colorFile3 = new Scanner(new File(fileName));
                    for (int i=1; i<=displayNum; i++)
                    {
                        String validate = colorFile3.nextLine();
                        if (validate.equalsIgnoreCase(userGuess))
                        {
                            valid++;
                        } 
                    }

                    if (valid == 0)
                    {
                        System.out.println("This guess is not valid. Choose a color from the list!");
                    }
                    //increase amount of guesses by 1 if guess is valid
                    else
                    {
                        guesses++;
                        //reveals correct color
                        System.out.println("The correct color was: " + color);
                    }
                    colorFile3.close();
                

                    //increase correct count if color guessed correctly
                    if (userGuess.equalsIgnoreCase(color)) 
                    {
                        correct++;
                    }

                } while (guesses < maxGuesses);


            //reveals how many correct guesses
            System.out.println("You guessed "+ correct + " out of 3 colors correctly.");

            //prompts user to play again and collects input
            System.out.println("Would you like to play again? (yes or no): ");
            String playAgain=input.nextLine();

            //ends game is user selects no
            if (playAgain.equalsIgnoreCase("no"))
                userChoice='d';
        }
        }while(userChoice != 'd'); //game repeats if user selects yes



        //Get user name
        System.out.println("What is your name? ");
        String name=input.nextLine();

        //Ask student to describe themselves
        System.out.println("Describe yourself? ");
        String description=input.nextLine();

        //Enter due date
        System.out.println("Enter due date (MM/DD/YY)");
        String dueDate=input.nextLine();

        //writes users answers to the output file
        PrintWriter outputFile = new PrintWriter(outputFileName);
        outputFile.println("Game Over");
        outputFile.println("You guessed " + correct + " out of " + maxGuesses + " colors correctly.");
        outputFile.println("Due Date: " + dueDate);
        outputFile.println("Username: " + name);
        outputFile.println("User Description: " + description);
        outputFile.println("Date: " + dueDate);

        //Closing open files
        outputFile.close();
    }
}
