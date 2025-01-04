// Lab 03 Palindrome List of Words

// Name - FIRST LAST

// The util folder has the following classes and more!!!
// Stack, Arrays, ArrayList, LinkedList, etc.
// It also has the Queue interface.
// It also has the Scanner class.
import java.util.*;

public class Palindrome // PalinListRunner
{
    public static void main ( String[] args )
    {
        System.out.println("Palindrome List Checker");
        System.out.println();
        System.out.println("Written by RHEA GHOSAL");
        System.out.println();
        System.out.println();

        PalinList test = new PalinList("one two three two one");
        System.out.println(test.getList() + " " + (test.isPalin()?"is a palinlist.":"is not a palinlist.")+"\n");

        test = new PalinList("m o m");
        System.out.println(test.getList() + " " + (test.isPalin()?"is a palinlist.":"is not a palinlist.")+"\n");

        test = new PalinList("d a d");
        System.out.println(test.getList() + " " + (test.isPalin()?"is a palinlist.":"is not a palinlist.")+"\n");

        test = new PalinList("comp sci is sci comp");
        System.out.println(test.getList() + " " + (test.isPalin()?"is a palinlist.":"is not a palinlist.")+"\n");

        test.setList("1 2 3 4 5 one two three four five");
        System.out.println(test.getList() + " "+(test.isPalin()?"is a palinlist.":"is not a palinlist.")+"\n");

        test.setList("a b c d e f g x y z g f h");
        System.out.println(test.getList() + " "+(test.isPalin()?"is a palinlist.":"is not a palinlist.")+"\n");

        test.setList("racecar is racecar");
        System.out.println(test.getList() + " "+(test.isPalin()?"is a palinlist.":"is not a palinlist.")+"\n");

        test.setList("1 2 3 a b c c b a 3 2 1");
        System.out.println(test.getList() + " "+(test.isPalin()?"is a palinlist.":"is not a palinlist.")+"\n");

        test.setList("chicken is a chicken");
        System.out.println(test.getList() + " "+(test.isPalin()?"is a palinlist.":"is not a palinlist.")+"\n");
    }

}  // end of class Main (PalinListRunner)


// remove the comment part if you use a separate file
/*
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;OR use import java.util.*;
*/
class PalinList
{
    // Instance Variables
    // (attributes, properties, fields, global variables, ...)

    // Create a variable called list of type String
    private String list;

    // Create a variable called queue of type Queue of String
    private Queue<String> queue;

    // Create a variable called stack of type Stack of String
    private  Stack<String> stack;


    // default constructor
    public PalinList()
    {
        // call setList and pass it "I love to code code to love I"
        setList("I love to code code to Love I ");
    }


    // init constructor
    public PalinList(String list)
    {
        // call setList and pass it the list
        setList(list);
    }


    public void setList(String list)
    {
        // assign list to your instance variable also
        // called list
        this.list = list;

        // create a LinkedList that can hold String objects
        queue = new LinkedList<String>();

        // create a Stack that can hold String objects
        stack = new Stack<String>();

        // We will put the list of words into a Scanner object
        Scanner scan = new Scanner(list);

        // while scan has a next element
        while (scan.hasNext())
        {
            // get the next word from scan
            String word = scan.next();

            // add the word to the queue
          queue.add(word);

            // add the word to the stack (use push)
          stack.push(word);
        } // end of while has next

    } // end of method


    public boolean isPalin()
    {
        // while your queue is NOT empty and
        // your stack is NOT empty
        while(!queue.isEmpty() && !stack.isEmpty())
        {
            // deque your queue
            String s1 = queue.remove();

            // pop your stack
            String s2 = stack.pop();

            // see if s1 and s2 are the same
            // if so, then continue
            // else return false
            // USE .equals() because these are String objects
            if(!s1.equals(s2))
                return false;


            // They were not the same, so return ?
        } // end of while

        // What should you return ????
       return true;

    } // end of method isPalin()


    // gets the palin list with double quotes around it
    public String getList()
    {
        return "\"" + list + "\"";
    }


    // Write a toString() method
    // returns the list of words
    public String toString()
    {
       return list;
    }

} // end of class PalinList

/*
Sample Run:

Palindrome List Checker

Written by XXXXX XXXXXX


"one two three two one" is a palinlist.

"m o m" is a palinlist.

"d a d" is a palinlist.

"comp sci is sci comp" is a palinlist.

"1 2 3 4 5 one two three four five" is not a palinlist.

"a b c d e f g x y z g f h" is not a palinlist.

"racecar is racecar" is a palinlist.

"1 2 3 a b c c b a 3 2 1" is a palinlist.

"chicken is a chicken" is not a palinlist.

*/

