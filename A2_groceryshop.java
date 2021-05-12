package assignments;
/******************************************************
 *Assignment #2 Question #2 Grocery Shop
 *Written by: Xu Zhou Hu 40167460
 *For COMP 248 Section P-KX Fall 2020
 *
 *This program is a grocery shop calculator. A welcome banner will be displayed. The user
 *will be asked to input the number of fruit, cheese, dairy, meat and seafood they want to
 *purchase. According to the price before discount (less than 250$, less or equal to 500$
 *or more than 500), the user will get a discount accordingly. If the user have a membership,
 *he/she will also receive points for the purchase. The total price, number of points and
 *an end message will be displayed to the user.
 ******************************************************/
import java.util.Scanner;
public class A2_groceryshop
{
	public static void main(String[] args)
	{
		//display welcome banner
		System.out.println("------------------------------------------------");
        System.out.println("          Grocery Shop Price Calculator\t");
        System.out.println("------------------------------------------------");
        System.out.println();
        //ask the user to input quantities for each item
        System.out.print("Please enter the quantities for each item in the list? ");
		Scanner keyboard = new Scanner(System.in);
		//define variables for the price of fruit, cheese, dairy, meat & seafood
		double fruit$ = keyboard.nextDouble() * 26.99;
		double cheese$ = keyboard.nextDouble() * 22.99;
        double dairy$ = keyboard.nextDouble() * 13.99;
        double meat$ = keyboard.nextDouble() * 56.99;
        double seafood$ = keyboard.nextDouble() * 38.99;
        //define variables price before discount and value of discount
        double $beforediscount = fruit$ + cheese$ + dairy$ + meat$ + seafood$;
        double discount$;
        //pointcase will be useful to determine the number of points later on, for the switch
        int pointcase;
        //we use if and else for 3 cases: less than 250$, less or equal to 500$ or more than 500
        if ($beforediscount < 250.00) 
        {
        	discount$ = ($beforediscount - seafood$) * 0.1;
        	pointcase = 1;
        } 
        else if ($beforediscount <= 500.00 && $beforediscount >= 250.00) 
        {
            discount$ = ($beforediscount - seafood$) * 0.15;
            pointcase = 1;
        } 
        else
        {
            discount$ = ($beforediscount - seafood$) * 0.2;
            pointcase = 2;
        }
        //define total price, which can be calculated by price before discount minus discount
        double total$;
        total$ = $beforediscount - discount$;
        //ask user to input if he has a membership
        System.out.print("Do you have a membership? (Y/N) ");
        char answer = keyboard.next().charAt(0);
        //after user answers, display total price
        System.out.print("The total price is $" + total$ + ". ");
        //define variable points for the nb of points the user will get
        int points = 0;
        //if user has a membership, execute the if part. if not, execute else part
        if (answer == 'Y')
        {
        	//use switch to present 2 case: if $before discount <=500, double total price
        	//to get the nb of points. else, triple the total price.
        	switch (pointcase)
        	{   
        		case 1: points = (int) Math.round(2 * total$);
        		break;
        		case 2: points = (int) Math.round(3 * total$);
        		break;	
        	}
        	//print nb of points if user has membership
        	System.out.println("You will receive " + points + " points.");
        }
        else
        {
        	System.out.println();
        	System.out.println();
        }
        //print closing message
        System.out.print("Thanks for shopping! See you next time!");
        //good habit to close scanner
        keyboard.close();
	}
}
