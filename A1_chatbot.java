package assignments;
//--------------------------------------
//Assignment #1
//Written by: Xu Zhou Hu 40167460
//For COMP 248 Section P-KX Fall 2020
//--------------------------------------
/*This program has the purpose of chatbotting to people. A greeting message will be displayed. First, the chatbot will ask the user for his/her name. After the user imput their name,
the chatbot will say hello to their name (in uppercase and will tell the user the number of characters in their name. Then, the chatbot will ask the user for their city and will tell 
them their city name in different ways: the middle letter in upper case, the second letter in upper case, and the second to the last letter in upper case. Finally, the chatbot will
tell the user that the program has ended with an end message*/
import java.util.Scanner;
//below is the class
public class A1_chatbot 
{
	//below is the method
	public static void main(String[] args) 
	{
		//printing the welcoming message and jump one line using System.out.println(); in order to look the same as sample output
		System.out.println("        I am a chat bot");
		System.out.println("        --------------------------------");
		System.out.println();
		//imput statement
		Scanner in = new Scanner (System.in);
		/*ask the user his/her name and reply with the name in uppercase and indicate the user the number of characters
		upper case using name.toUpperCase() and number of characters using name.length()*/
	    System.out.print("-- Hi, my name is chatBot. What is your name?");
	    String name = in.next();
	    System.out.println();
	    System.out.println("-- Hello "+name.toUpperCase()+", you have "+name.length()+" characters.");
	    //ask the user for his city and set the length of the city as an integer
	    System.out.println("-- Where are you? (City name with at least 3 letters)");
	    String city = in.next();
	    int citylength = city.length();
	    //using substring to put middle letter(s) in upper case
	    city=city.toLowerCase().substring(0,citylength/2)+Character.toUpperCase(city.charAt(citylength/2))+city.toLowerCase().substring((citylength/2)+1,citylength);
	    System.out.println("-- With middle letter(s) in upper case:"+city);
	    //using substring to put second letter in upper case
	    city=city.toLowerCase().substring(0,1)+Character.toUpperCase(city.charAt(1))+city.toLowerCase().substring(2,citylength);
	    System.out.println("-- With second letter in upper case:"+city);
	    //using substring to put second to last letter in upper case
	    city=city.toLowerCase().substring(0,citylength-2)+Character.toUpperCase(city.charAt(citylength-2))+city.toLowerCase().substring(citylength-1,citylength);
	    System.out.println("-- With second to last letter in upper case:"+city);
	    //print end message
	    System.out.println("-- I am done. Byebye.");
	    in.close();
	}

}

