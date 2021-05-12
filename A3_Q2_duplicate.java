package assignments;
/******************************************************
 *Assignment #3 Question #2 duplicate elimination
 *Written by: Xu Zhou Hu 40167460
 *For COMP 248 Section P-KX Fall 2020
 *
 *This program will ask the user for 10 number input (between 10 and 100).
 *The program will be programmed with a one-dimensional array and will be
 *initialized with -1 which indicates that the element is empty. The 
 *program will remove duplicate numbers and will display error messages
 *when the user enters an invalid number. Finally, the program will
 *print the unique values
 ******************************************************/
import java.util.Scanner;
public class A3_Q2_duplicate 
{
	public static void main(String[] args) 
	{
		//declaration and initialization of the array with -1
		int[] array=new int[10];
        for (int i=0;i<10;i++)
        {
            array[i]=-1;
        }
        //instruction for the user to input number & declare scanner
        System.out.println("Please input a value in [10,100]");
        Scanner keyboard=new Scanner(System.in);
        int number;
        //number from 1 to 10 (10 total)
        for (int i=0;i<10;i++)
        {            
        	System.out.print("value "+(i+1)+": ");
            number=keyboard.nextInt();
            	//if user enters a value less than 10 or bigger than 100, enter again
            	if (number<10 || number>100)
            	{ 
            		System.out.print("Wrong value, please input a value in [10,100]: ");
            		number=keyboard.nextInt();                
            	}
            //replace -1 by number
            array[i]=number;
        }
        System.out.println("The unique values are: ");
        int arraylength=array.length;
        //compare numbers from index 0 and 1, then 1 and 2...
        for (int i=0;i<arraylength;i++)
        {
            for (int j=i+1;j<arraylength;j++)
            {
                //check for duplicate
            	if (array[i]==array[j])
                {
                    //remove duplicate from array
            		array[j]=array[arraylength-1];
                    arraylength--;
                    j--;
                }
            }
        }
        //print unique values
        for (int i=0;i<arraylength;i++)
        {
            System.out.print(array[i]+"  ");
        }
        keyboard.close();
	}
}
