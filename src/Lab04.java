// PLEASE READ THE COMMENTS!!!!!
// The util folder that is inside the java folder
// has the following classes:
// ArrayList, LinkedList, Stack
// The * means that you are requesting to
// use any class in this folder.
// There are many other classes as well.

// Each time a method is called, the system creates
// an Activation Record which contains information
// about the method:
// Some of the information stored is:
// parameters, local variables, return memory address,
// return value, cpu register values (variables), and more.
// This information is then stored at the top of the stack.
// When a method ends, this information is popped from the
// stack.  Some of this information is erased including
// parameter variables and local variables.


import java.util.*;

public class Lab04
{
    // Create a Stack to hold the names of the
    // current methods that are running.
    // Your Stack reference (pointer) should
    // be called stack.
    // The stack should hold String objects.
    private Stack<String> stack = new Stack<String>();


    public static void main(String[] args)
    {
        System.out.println("Hello Method Calls!");
        System.out.println();
        System.out.println("Written by RHEA GHOSAL");
        System.out.println();

        // Create a pointer (reference to this Main object)
        // Call your reference variable m.
        Lab04 m = new Lab04();

        m.startMethod("Method 1");
        m.startMethod("Method 2");
        m.startMethod("Method 3");

        m.printStackMethods();
        System.out.println();

        m.printCurrentRunningMethod();
        System.out.println();

        m.startMethod("Method 4");
        m.startMethod("Method 5");

        m.printStackMethods();
        System.out.println();

        m.printCurrentRunningMethod();
        System.out.println();

        System.out.println(m.endMethod()); // ends the top method
        System.out.println();
        System.out.println(m.endMethod()); // ends the top method
        System.out.println();
        System.out.println(m.endMethod()); // ends the top method
        System.out.println();

        m.printStackMethods();
        System.out.println();

        m.printCurrentRunningMethod();
        System.out.println();

        System.out.println(m.endMethod()); // ends the top method
        System.out.println();
        System.out.println(m.endMethod()); // ends the top method
        System.out.println();
        System.out.println(m.endMethod()); // ends the top method
        System.out.println();

        m.printStackMethods();
        System.out.println();

        m.printCurrentRunningMethod();
        System.out.println();

    } // end of method main


    public void printCurrentRunningMethod()
    {
        // Print out the method that is currently running.
        // Do NOT remove it from the stack!!!
        // It should be the top element
        // If the program has ended (the stack is empty),
        // then print out:
        // Their is no current running method."
        // otherwise (else) print out:
        // The current running method is ??????????

        if (stack.isEmpty())
        {
            System.out.println("There is no current running method.");
        }
    else
        {
            System.out.println("The current running method is " + stack.peek() + ".");
        }

    } // end of printCurrentRunningMethod()


    public void startMethod(String nameOfMethod)
    {
        System.out.println("Added method " + nameOfMethod);
        System.out.println();

        // Push nameOfMethod onto the stack.
        stack.push(nameOfMethod);
    } // end of startMethod()


    public String endMethod()
    {
        // See if the stack is empty, and if so,
        // return the String "The stack is now Empty."
        if (stack.isEmpty())
            return "The stack is now Empty.";

        // pop the stack
        String removedMethod = stack.pop();

        return "Removed method " + removedMethod + ".";
    } // end of endMethod()


    public void printStackMethods()
    {
        System.out.println("Stack methods");
        System.out.println("=============");

        // Print out the stack of method
        // calls from the top to the bottom.
        // DO NOT remove the items!!!
        // HINT: The Stack class has a get(index) method
        // Print your stack methods here (top to bottom).
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }


        // See if the stack is empty.
        // If so, print out "The program has ended."
        if (stack.isEmpty())
        {
            System.out.println("The program has ended.");
        }

    } // end of method printStackMethods()

} // end of class Main

/*
Output:

Hello Method Calls!

Written by XXXXX XXXXX

Added method Method 1

Added method Method 2

Added method Method 3

Stack methods
=============
Method 3
Method 2
Method 1

Current running method is Method 3

Added method Method 4

Added method Method 5

Stack methods
=============
Method 5
Method 4
Method 3
Method 2
Method 1

Current running method is Method 5

Removed method Method 5

Removed method Method 4

Removed method Method 3

Stack methods
=============
Method 2
Method 1

Current running method is Method 2

Removed method Method 2

Removed method Method 1

The stack is now Empty.

Stack methods
=============
The program has ended.

There is no current running method.

*/
