package assignments;
/******************************************************
 *Assignment #4 battleship
 *Written by: Xu Zhou Hu 40167460
 *For COMP 248 Section P-KX Fall 2020
 *
 *This program will be simulating a battleship game between a user and a computer. It will ask the user to input a coordinate on a 8 x 8 grid.
 *If the position is already called or if it is outside the grid, the user will be asked to input another coordinate. The user will be enter-
 *ing 6 ships and 4 grenades. The computer will be doing the same and it will randomly select the coodinate of 6 ships and 4 grenades. After 
 *the pieces are set, the game will start. Every player will have 1 turn except when a grenade is hit, then the opponent will have 2 turns. The 
 *game ends when all of ships of either human or cpu is hit. Furthermore, the game grid will be displayed. This program is used with 3 methods:
 *main, rocket and gamegrid.
 ******************************************************/
import java.util.*;
public class A4_battleship 
{
	//static variables total nb of humanships and cpu ships
	static int totalhumanships = 6;
	static int totalcpuships = 6;
	public static void main(String[] args)
	{
		//8 x 8 gameboard with an array	      
		int gamegrid[][] = new int[8][8];
		//open scanner for user input
	    Scanner keyboard = new Scanner(System.in);
	    //welcome message
	    System.out.println("Hi, let’s play Battleship!");  
	    System.out.println("");	   
	    //user will enter coordinate of 6 humanships
	    for (int i = 0; i < 6; i++) 
	    {
	    	//ask user for input
	    	System.out.print("Enter the coordinates of your ship #"+ (i+1) +": ");
	    	String coordinate = keyboard.nextLine();
	    	//works for upper & lowercase
	        coordinate = coordinate.toLowerCase();
	        //the coordinate entered will be converted to position in array
	        int column = coordinate.charAt(0) - 'a';
	        int row = Integer.parseInt(coordinate.substring(1)) - 1;	        
	        //user input outside the grid
	        while (!(row >= 0 && row < 8 && column >= 0 && column < 8)) 
	        {
	        	//ask user to enter agains
	        	System.out.println("sorry, coordinates outside the grid. try again.");
	        	System.out.print("Enter the coordinates of your ship #"+ (i+1) +": ");
	            coordinate = keyboard.nextLine();
	            coordinate = coordinate.toLowerCase();
	            column = coordinate.charAt(0) - 'a';
	            row = Integer.parseInt(coordinate.substring(1)) - 1;
	        }
	        //user input on a used coordinate
	        while (gamegrid[row][column] != 0)
	        {
	        	//ask user to enter again
	        	System.out.println("sorry, coordinates already used. try again.");
	        	System.out.print("Enter the coordinates of your ship #"+ (i+1) +": ");
	            coordinate = keyboard.nextLine();
	            coordinate = coordinate.toLowerCase();
	            column = coordinate.charAt(0) - 'a';
	            row = Integer.parseInt(coordinate.substring(1)) - 1;
	        }
	        //on the coordinate entered put a humanship
	        int humanship = 1;
	        gamegrid[row][column] = humanship;	          
	     }
	     //change line
	     System.out.println("");
	     
	     //user will enter coordinate of 4 humangrenades
	     for(int i = 0; i < 4; i++) 
	     {
	    	 //ask user enter coordinate
	    	 System.out.print("Enter the coordinates of your grenade #"+ (i+1) +": ");
	    	 String coordinate = keyboard.nextLine();
	         coordinate = coordinate.toLowerCase();
	         int column = coordinate.charAt(0) - 'a';
	         int row = Integer.parseInt(coordinate.substring(1)) - 1;	         
	         //coordinate outside grid
	         while (!(row >= 0 && row < 8 && column >= 0 && column < 8)) 
	         {
	        	 System.out.println("sorry, coordinates outside the grid. try again.");
	        	 System.out.print("Enter the coordinates of your grenade #"+ (i+1) +": ");
	             coordinate = keyboard.nextLine();
	             coordinate = coordinate.toLowerCase();
	             column = coordinate.charAt(0) - 'a';
	             row = Integer.parseInt(coordinate.substring(1)) - 1;
	         }
	         //coordinate used already
	         while (gamegrid[row][column] != 0)
	         {
	        	 System.out.println("sorry, coordinates already used. try again.");
	        	 System.out.print("Enter the coordinates of your grenade #"+ (i+1) +": ");
	             coordinate = keyboard.nextLine();
	             coordinate = coordinate.toLowerCase();
	             column = coordinate.charAt(0) - 'a';
	             row = Integer.parseInt(coordinate.substring(1)) - 1;
	         }
	         //put human grenade on the coordinate
	         int humangrenade = 3;
	         gamegrid[row][column] = humangrenade;	          
	      }	      
	      System.out.println("");
	      
	      //computer put 6 ships
	      for (int i = 0; i < 6; i++) 
	      {
	    	  //use math.random to generate coordinate
	    	  Random number = new Random();
	          int row = number.nextInt(8);
	          int column = number.nextInt(8);
	          while (gamegrid[row][column] != 0) 
	          {
	        	  row = number.nextInt(8);
	              column = number.nextInt(8);
	          }
	          //put computer ship on coordinate
	          int cpuship = 2;
	          gamegrid[row][column] = cpuship;
	      }
	      
	      //computer put 4 grenade
	      for (int i = 0; i < 4; i++) 
	      {
	          //coordinate using math.random
	    	  Random number = new Random();
	          int row = number.nextInt(8);
	          int column = number.nextInt(8);
	          while (gamegrid[row][column] != 0) 
	          {
	              row = number.nextInt(8);
	              column = number.nextInt(8);
	          }
	          //put cpu grenades on coordinate
	          int cpugrenade = 4;
	          gamegrid[row][column] = cpugrenade;
	      }
	       //message that game is ready to be played
	       System.out.println("OK, the computer placed its ships and grenades at random. Let's play.");
	       System.out.println("");
	      
	       //human start with 1 turn
	       int humanTurn = 1;
	       int cpuTurn = 0;
	       //englobe 2 situation: human turn and cpu turn
	       while(true) 
	       {
	           //human turn
	    	   while(humanTurn > 0) 
	    	   {
	               //ask user to input rocket position
	               System.out.print("position of your rocket: ");
	               //human lose turn, cpu gain turn
	               humanTurn--;
	               cpuTurn = 1;
	               //convert user entry to coordinate
	               String rocketplace = keyboard.nextLine();
	               rocketplace = rocketplace.toLowerCase();
	               int column = rocketplace.charAt(0) - 'a';
	               int row = Integer.parseInt(rocketplace.substring(1)) - 1;
	               //what if position outside grid
	               if (!(row >= 0 && row < 8 && column >= 0 && column < 8)) 
	  	           {
	            	    System.out.println("rocket outside the grid.");
	            	    System.out.print("position of your rocket: ");
	    	            rocketplace = keyboard.nextLine();
	    	            rocketplace = rocketplace.toLowerCase();
	    	            column = rocketplace.charAt(0) - 'a';
	    	            row = Integer.parseInt(rocketplace.substring(1)) - 1;	            	    
	  	           }
	               //what if position already called 5 situations (if display is s, g, S, G or *)
	               if (gamegrid[row][column] != 0 && gamegrid[row][column] != 1 && gamegrid[row][column] != 2
	  	        		 && gamegrid[row][column] != 3 && gamegrid[row][column] != 4)
	   	           {	   	       
	   	        		System.out.print("position already called.");	   	        		   	      	
	   	           }
	               //4 situation: nothing, no more h ship, no more cpu ship or hit grenade
	               int situation = rocket(gamegrid, row, column);
	               //what if no human ship left
	               if (situation == 2) 
	               {
	                   System.out.println(" Computer Win!");
	                   gameboard(gamegrid);
	                   return;	                   
	               }
	               //what if no cpu ship left
	               else if (situation == 3) 
	               {
	                   System.out.println(" You Win!");
	                   gameboard(gamegrid);
	                   return;
	               }
	               //what if user hit grenade
	               else if (situation == 1) 
	               {
	                   humanTurn = 0;
	                   cpuTurn = 2;
	               }
	               //normal situation
	               System.out.println("");
	               gameboard(gamegrid);	               
	           }
	           //cpu turn
	           while (cpuTurn > 0) 
	           {	               
	        	   System.out.print("position of my rocket: ");
	        	   //cpu lose turn, human gain turn
	               cpuTurn--;
	               humanTurn = 1;
	               //cpu choose rocket coordinate randomly
	               Random cpurocket = new Random();
	               int row = cpurocket.nextInt(8); 
	               int column = cpurocket.nextInt(8);
	               //convert column number to letter
	               char columnletter = 'H';
	               switch (column)
	               {
	               		case 0 : columnletter = 'A'; 
	               			break;
	               		case 1 : columnletter = 'B'; 
               				break;
	               		case 2 : columnletter = 'C'; 
               				break;
	               		case 3 : columnletter = 'D'; 
               				break;
	               		case 4 : columnletter = 'E'; 
               				break;
	               		case 5 : columnletter = 'F'; 
               				break;
	               		case 6 : columnletter = 'G'; 
               				break;               				
	               }
	               //computer gotta display its coordinate
	               System.out.println("" + columnletter + (row+1));
	               //computer called on a coordinate already used
	               if (gamegrid[row][column] != 0 && gamegrid[row][column] != 1 && gamegrid[row][column] != 2
	  	        		 && gamegrid[row][column] != 3 && gamegrid[row][column] != 4)
	   	           {	   	       
	   	        		System.out.print("position already called.");	   	        		   	      	
	   	           }
	               //4 situations
	               int situation = rocket(gamegrid, row, column);
	               //no more h ship left
	               if (situation == 2) 
	               {
	                   System.out.println(" Computer Win!");
	                   gameboard(gamegrid);
	                   return;
	               }
	               //no more cpu ship left
	               else if(situation == 3) 
	               {
	                   System.out.println(" You Win!");
	                   gameboard(gamegrid);
	                   return;
	               }
	               //cpu hit grenade
	               else if (situation == 1) 
	               {
	                   humanTurn = 2;
	                   cpuTurn = 0;
	               }
	               //normal situation
	               System.out.println("");
	               gameboard(gamegrid);	               
	           }		                   
	       }	       
	   }
	  
	   public static int rocket (int gamegrid[][], int row, int column) 
	   {
	       //3 situation: hit grenade, no more h ship and no more c ship
		   int situation = 0;
		   //in the battleship driver, 1 is a coordinate with human ship
	       if (gamegrid[row][column] == 1) 
	       {
	           //human ship is hit and number of h ship --
	    	   int hithship = 11;
	           gamegrid[row][column] = hithship;
	           System.out.print("human ship hit.");
	           totalhumanships--;
	       }
	       //in the battleship driver, 2 is a coordinate with cpu ship
	       else if (gamegrid[row][column] == 2) 
	       {
	    	   //hit cpu ship, cpu ship --
	    	   int hitcship = 12;
	           gamegrid[row][column] = hitcship;
	           System.out.print("computer ship hit.");
	           totalcpuships--;
	       }  
	       //in the battleship driver, 3 is a coordinate with human grenade
	       else if (gamegrid[row][column] == 3) 
	       {
	    	   int hithgrenade = 13;
	           gamegrid[row][column] = hithgrenade;
	           System.out.print("boom! human grenade.");
	           //situation 1 hit grenade, effect see driver
	           situation = 1;
	       }
	       //in the battleship driver, 4 is a coordinate with cpu grenade
	       else if (gamegrid[row][column] == 4) 
	       {	    	   
	    	   int hitcgrenade = 14;
	    	   gamegrid[row][column] = hitcgrenade;
	    	   System.out.print("boom! computer grenade.");
	    	   //situation 1 hit grenade, effect see friver
	           situation = 1;
	       }
	       //in the battleship driver, 0 represents empty cell
	       else if (gamegrid[row][column] == 0) 
	       {
	           int hitemptycell = 10;
	    	   gamegrid[row][column] = hitemptycell;
	    	   System.out.print("nothing.");
	       }
	       //situation 2 no h ship left
	       if (totalhumanships == 0)
	           situation = 2;
	       //situation 3 no c ship left
	       else if (totalcpuships == 0)
	           situation = 3;
	       return situation;
	   }
	   
	   public static void gameboard (int gamegrid[][]) 
	   {
	       //game grid with column i, row j
		   for (int i = 0; i < 8; i++) 
	       {
	           for (int j = 0; j < 8; j++) 
	           {
	               //hit human ship show uppercase s
	        	   if (gamegrid[i][j] == 11)
	                   System.out.print("s\t");
	        	   //hit cpu ship show lowercase s
	               else if (gamegrid[i][j] == 12)
	                   System.out.print("S\t");
	        	   //hit human grenade show uppercase g
	               else if (gamegrid[i][j] == 13)
	                   System.out.print("g\t");
	        	   //hit cpu grenade show lowercase g
	               else if (gamegrid[i][j] == 14)
	                   System.out.print("G\t");
	        	   //hit empty cell show star
	               else if (gamegrid[i][j] == 10)
	                   System.out.print("*\t");
	        	   //if the coordinate hasn't been hit yet
	               else
	                   System.out.print("_\t");
	           }
	           System.out.println();
	       }		   
	   }	   	
}

