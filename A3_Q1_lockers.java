package assignments;
/******************************************************
 *Assignment #3 Question #1 locker puzzle game
 *Written by: Xu Zhou Hu 40167460
 *For COMP 248 Section P-KX Fall 2020
 *
 *Every locker is closed at the beginning. Student 1 will open every one of them.
 *Student 2 will start from the second one and changes every second locker.
 *Student n will start from the nth locker and changes every nth locker.
 *This program will tell you which lockers are still open after 100 students
 *have gone through this process.
 ******************************************************/
public class A3_Q1_lockers 
{
	public static void main(String[] args) 
	{
		 //we consider a locker is closed if false and open if true
		 //the lockers are numbered 1-100, index is 0 to 100 
		 boolean[] stateoflockers = new boolean[101];
	     //all lockers from 1 to 100 are closed (0 not used)
	     for (int i=1;i<stateoflockers.length;i++)
	     {
	        stateoflockers[i] = false;
	     }
	     //student 1 opens lockers 1 to 100
	     for (int i=1;i<stateoflockers.length;i++)        
	     {
	        stateoflockers[i] = true;
	     }
	     //for students number 2 to 100
	     for (int studentnb=2;studentnb<stateoflockers.length;studentnb++)
	     {
	    	 //student 2 will change every 2nd locker starting at 2
	    	 //student n will change every nth locker starting at n
	    	 for (int n=studentnb;n<stateoflockers.length;n+=studentnb)
	         {
	    		 //only for the lockers that are changed by nth student
	    		 //if closed, it becomes open; else closed (open to closed)
	    		 if (stateoflockers[n] == false) 
	    			 stateoflockers[n] = true;
	             else stateoflockers[n] = false;	              
	         }           
	      }
	      //check the state of locker (closed if false and open if true)
	      for (int i=1;i<stateoflockers.length;i++)
	      {
	    	  //only print the open lockers, not print closed ones
	    	  if (stateoflockers[i] == true) 
	    	  {
	    		  System.out.println("Locker " + i + " is open");
	          }
	       }
	}
}


