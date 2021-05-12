package assignments;
/******************************************************
 *Assignment #2 Question #1 ASCII number
 *Written by: Xu Zhou Hu 40167460
 *For COMP 248 Section P-KX Fall 2020
 *
 *This program will ask the user to enter a lowercase letter. This program will convert
 *the letter to the corresponding ASCII number and will indicate to the user whether it
 *is even or odd number. Finally, the program will indicate to the user if the number
 *is a multiple of 2; 3; 5; 7; or none of them.
 ******************************************************/
import java.util.Scanner;
public class A2_asciinumber 
{
	public static void main(String[] args) 
	{
		//define variable letter as a character, ask user to input letter, enable program to read input
		Scanner keyboard = new Scanner(System.in);
        char letter;
        System.out.print("Please enter a letter from a to z: ");
        letter = keyboard.next().charAt(0);
        //use the casting type of conversion, converting letter to ascii number
        int asciinumber = (int) letter ;
        //set variable remainder for asciinumber % 2
        int remainder; 
        //if the remainder is 0, number is even; else (1), it's odd
        if (asciinumber % 2 == 0)
            remainder = 0;
        else
            remainder = 1;
        //use switch for both cases: depending on the number being even or odd
        //the message displayed to the user will be different
        switch(remainder) 
        {
            case 0:
            	System.out.println("The ASCII number of " + letter + " is even number " + asciinumber + ".");
                break;
            case 1:
                System.out.println("The ASCII number of " + letter + " is odd number " + asciinumber + ".");
                break;    
        }
        //if 1 or more out of 4 cases is true (remainder division by 2, 3, 5, 7)
        //display one or more messages
        if (asciinumber % 2 == 0 || asciinumber % 3 == 0 || asciinumber % 5 == 0 || asciinumber % 7 == 0)
        {
            if (asciinumber % 2 == 0)
            	System.out.println("It is a multiple of 2.");
            if (asciinumber % 3 == 0)
                System.out.println("It is a multiple of 3.");
            if (asciinumber % 5 == 0)
                System.out.println("It is a multiple of 5.");
            if (asciinumber % 7 == 0)
                System.out.println("It is a multiple of 7.");
        }
        //if not divisible by 2, 3, 5, 7, then print the following message
        else 
            System.out.println("It is none of 2, 3, 5 and 7.");
        //good habit to close scanner
		keyboard.close();
	}
}
