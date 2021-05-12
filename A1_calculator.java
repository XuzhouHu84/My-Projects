package assignments;
//--------------------------------------
//Assignment #1
//Written by: Xu Zhou Hu 40167460
//For COMP 248 Section P-KX Fall 2020
//--------------------------------------
/*This program has the purpose to fulfill basic arithmetic operations such as +, -, *, / of two integers. Because
division may result in a non-integer answer, the answer will not be expressed in integer but in type double.
A greeting message and an end message will be shown. Furthermore, the user will be prompted to enter two integers
and the result of those two will be calculated with the operations +, -, *, /*/
import java.util.Scanner;
//below is the class
public class A1_calculator 
{
	//below is the method
	public static void main(String[] args) 
	{
		//imput statement
		Scanner in = new Scanner (System.in);
		//print the greeting information
		System.out.println("\\------------------------------------------\\");
		System.out.println("/           Call me a calculator           /");
		System.out.println("\\------------------------------------------\\");
		//defining two integer variables a and b
		int a;
		int b;
		//ask the user to imput 2 integers
		System.out.print("Enter two integers and the second one cannot be zero:");
		a=in.nextInt();
		b=in.nextInt();
		//print +, -, *, /
		System.out.println(a+" + "+b+"="+(a+b));
		System.out.println(a+" - "+b+"="+(a-b));
        System.out.println(a+" * "+b+"="+(a*b));
        System.out.println(a+" / "+b+"="+(double)(a/b));
        //print the end message
        System.out.println("All done");
        in.close();
	}
}
