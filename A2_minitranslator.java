package assignments;
/******************************************************
 *Assignment #2 Question #3 Mini Translator
 *Written by: Xu Zhou Hu 40167460
 *For COMP 248 Section P-KX Fall 2020
 *
 *This program understands natural language. It will analyze key words (Name, City, Country 
 *& Year). A welcome banner will be displayed. The user will be asked to input a sentence in
 *the form : Name came to City, Country in Year. This program will analyze key words and re-
 *organize the sentence into a different format: Name stay in City for X year(s). City is in 
 *Country. The while loop will be used, the program won't stop running until the user input
 *"q", which means it's possible for the user to translate several sentences. Finally, after 
 *the user press q to exit, an end message will be displayed.
 ******************************************************/
import java.util.Scanner;
public class A2_minitranslator 
{
	public static void main(String[] args)
	{
		//display welcome banner
		System.out.println("----------------------------------------------------");
        System.out.println("          Language Translator Program\t");
        System.out.println("----------------------------------------------------");
        Scanner keyboard = new Scanner(System.in);
        //create String sentence for the sentence which the user will input
        //initialize it as an empty string (for now)
        String sentence = "";        
        //create while loop which will be executed repeatedly until user exit
        //(sentence not equal to "q")
        while (sentence != "q") 
        {
            //ask user to input sentence
        	System.out.println("Please enter the input sentence (press q to exit):");           
            sentence = keyboard.nextLine();
            //use equals() method to compare strings, stop program if user enter q
            if (sentence.equals("q"))        	
                break;
            //tried to do 7 keyboard.next() but the code is messy
            //searched online on how to split sentence to words
            String indexes[] = sentence.split(" ");
            //create string name; in the sentence, the name is indexed at position 0
            String name = indexes[0];
            //create string city; index 3, and I had to take out comma
            String city = indexes[3].substring(0, indexes[3].length() - 1);
            //string country at index 4
            String country = indexes[4];
            //Integer.parseInt() to convert a string to an integer, get the nb of year
            int x = 2020 - Integer.parseInt(indexes[6].substring(0, indexes[6].length() - 1));
            //reorganize the output
            System.out.println(name + " stays in " + city + " for " + x + " years. " 
            				   + city + " is in " + country + ".");            
        }
        //after the user press q to exit, display end message
        System.out.println("Thanks for using translator program.");
        //good habit to close scanner
        keyboard.close();
	}
}
