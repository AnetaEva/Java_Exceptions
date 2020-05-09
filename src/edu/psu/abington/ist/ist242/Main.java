/*
Author: Aneta O'Donnell
Purpose Details: Lab 13 Solo Work Java Exceptions
Course: IST 242
Date Developed: 4/17/2020
Last Date Changed: 4/17/2020
Rev: n/a
*/

package edu.psu.abington.ist.ist242;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) throws InputMismatchException {

        // Create a Scanner object for keyboard input.
        Scanner scanner = new Scanner(System.in);

        int n;
        double d;
        String s;


        // INTEGER -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
       while (true) {
           try {
               // Get user data
               System.out.println("Input an Integer: ");
               n = Integer.parseInt(scanner.nextLine());
               break;

           } catch (NumberFormatException e) { // NumberFormatException gets thrown because we entered a String, when a String had the wrong format and couldn’t be converted into a number.
               System.out.println("The program does not recognize the number as an integer, be sure you are not typing in a float or alpha character. Please try again.");
           }
       }
        System.out.println("Result = " + n);


        // FLOAT  -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        while(true) {
            try {
                // Get user data
                System.out.println("Input a float: ");
                d = Double.parseDouble(scanner.nextLine()); //d = Double.parseDouble("A") would go to the catch block
                break;
            } catch (NumberFormatException e) {
                System.out.println("The program does not recognize the number as float, be sure you are not typing in an alpha character. Please try again.");
            }
        }
        System.out.println("Result = " + d);


        // STRING -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        while (true) {
        try {
                // Get user data
                System.out.println("Input a string: ");
                s = scanner.nextLine();
                if ((s != null) && (!s.equals(" ")) && (s.matches("^[a-zA-Z]+$"))) { //if it is null and if there is a space then invalid. if regular expression matches
                    System.out.println("String = " + s);
                    break;
                } else { //else block is going to declare that it throw an Exception
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, be sure you did not accidentally enter in a numeric character. Please try again.");
            }
        }


        // INPUT THREE INTEGERS ARRAY -----------------------------------------------------------------------------------------------------------------------------------------------------
        while (true) {
            try {
                // Get user data
                System.out.println("Input any 3 integers on one line with a space in between: ");
                s = scanner.nextLine(); //has to be S because we are inputting as a string then parsing is below
                String ofThreeIntegers[] = s.split(" "); // returns an array of strings after splitting an input String

                // Error checking with an IF STATEMENT
                if (ofThreeIntegers.length > 3) //if more than 3 integers then throwing exception
                    // If error detected
                    throw new NumberFormatException(); //throw statement appears within a try block; if reached, execution jumps immediately to the end of the try block.

                //using java foreach loop to print elements of string array
                for (String kk : ofThreeIntegers)
                    //Integer.valueOf Parses the specified string as a signed decimal integer value.
                    Integer.valueOf(kk); // Integer.valueOf is an inbuilt method which returns an Integer object, holding the value extracted from the specified String when parsed with the base given by the second argument.
                System.out.println(s);
                break;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input, be sure you did not enter more than 3 integers or an alpha character. Please try again.");
            }
        }
        System.out.println("Result = " + s);


        // FILE HANDLING  -----------------------------------------------------------------------------------------------------------------------------------------------------
        while (true) {//validating file name

            try {
                System.out.println("Input the name of file: ");
                s = scanner.next();

                // compile the regex to create pattern
                // using compile() method
                Pattern patternRegex = Pattern.compile("[<>:\"/\\\\|?*]");

                // get a matcher object from pattern
                Matcher matcher = patternRegex.matcher(s); //s is the variable that scanner input was stored in.

                //The find() method of Matcher Class
                //attempts to find the next subsequence of the input sequence that find the pattern.
                if (matcher.find())
                    throw new FileNotFoundException();
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Invalid input, please make sure your file name does not contain any invalid Windows file name restrictions. Please try again.");
            }
        }
        System.out.println("Result = " + s);
    }
}