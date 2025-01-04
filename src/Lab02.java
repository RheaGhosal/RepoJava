// Lab 02 Evaluate Postfix Expressions

// Name - FIRST LAST

// Postfix
// YOU MUST USE THE Stack class and this
// outline.

import java.util.Stack;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab02 // PostFixRunner
{
    public static void main ( String[] args )
    {
        System.out.println("Postfix Expressions");
        System.out.println();
        System.out.println("Written by Rhea Ghosal");
        System.out.println();
        System.out.println();

        PostFix test = new PostFix("2 7 + 1 2 + +");
        test.solve();
        System.out.println(test);

        test.setExpression("1 2 3 4 + + +");
        test.solve();
        System.out.println(test);

        test.setExpression("9 3 * 8 / 4 +");
        test.solve();
        System.out.println(test);

        test.setExpression("3 3 + 7 * 9 2 / +");
        test.solve();
        System.out.println(test);

        test.setExpression("9 3 / 2 * 7 9 * + 4 -");
        test.solve();
        System.out.println(test);

        test.setExpression("5 5 + 2 * 4 / 9 +");
        test.solve();
        System.out.println(test);

        test.setExpression("5 5 + 2 * 4 / 9");
        test.solve();
        System.out.println(test);

        test.setExpression("5 5 + 2 * 4 / 9 + + +");
        test.solve();
        System.out.println(test);

        test.setExpression("5 5 + 2 * 4 # 9 +");
        test.solve();
        System.out.println(test);

    } // end of method main

} // end of class Main


// uncomment if you are using a separate file
// for class PostFix
// import java.util.Stack;
// import java.util.Scanner;
// import static java.lang.System.*;

class PostFix
{
    // instance variables
    private Stack<Double> stack;

    private String expression;

    private String error;


    // default constructor
    public PostFix()
    {
        // Call your setExpression method and pass it a
        // sample expression of "2 3 +"
        setExpression("2 3 +");
    }



    // init constructor
    public PostFix(String exp)
    {
        // Call your setExpression method and pass it
        // the expression exp
        setExpression(exp);
    }


    // setter method
    public void setExpression(String exp)
    {
        // Create a Stack object that can hold Double objects.
        // Assign the memory address to your instance variable
        // called stack.
        stack = new Stack<Double>();

        // set the error variable to ""
        error = "";

        // Set your instance variable expression
        // to hold the value of exp.
        expression = exp;
    }


    public void solve()
    {
        // Create a new Scanner object to hold the
        // expression. The Scanner class has some
        // methods that will help us parse (rip apart)
        // the expression element by element.
        // Examples:
        // scan.hasNext()       - returns true or false
        // scan.hasNextInt()    - returns true or false
        // scan.hasNextDouble() - returns true or false
        //                       NOTE: If the next element can be converted to a Double.
        //                              So, it could be an integer or a double.
        // scan.next()          - returns the next element as a String
        // scan.nextInt()       - returns the next element as an int
        // scan.nextDouble()    - returns the next element as a double

        Scanner scan = new Scanner(expression);

        // while you have a next element in your expression,
        // keep going
        while(scan.hasNext())
        {

            // See if the next element can be converted to a double.
            // If it can be converted to a double,
            // push it onto the stack
            if (scan.hasNextDouble())
            {
                double x = scan.nextDouble(); // get it from scan
                stack.push(x);
            }
            else
            {
                // You must have at least 2 elements on the stack,
                // since you have to pop pop

                if (stack.size() < 2)
                {
                    error = "Error in stack size.";
                    return;
                }

                // It is an operator so 1st get it!
                String op = scan.next();

                // Now:
                // Pop the right operand
                // Pop the left operand
                // Do the OP (if else if or switch statement)
                // See the hint at the bottom!
                // Push your answer on to the Stack
                double rightOperand = stack.pop();
                double leftOperand = stack.pop();

                if (op.equals("+"))
                {
                    stack.push(leftOperand + rightOperand);
                }
                else if (op.equals("-"))
                {
                    stack.push(leftOperand - rightOperand);
                }
                else if (op.equals("*"))
                {
                    stack.push(leftOperand * rightOperand);
                }
                else if (op.equals("/"))
                {
                    if (rightOperand == 0)
                    {
                        error = "Error. Division by zero.";
                        return;
                    }
                    stack.push(leftOperand / rightOperand);
                }
                else
                {
                    error = "Error Invalid operator.";
                    return;
                }

            } // end of else

        } // end of while

        // check and see if the stack size
        // is not equal to 1
        if (stack.size() != 1)
        {
            error = "Error.  The stack size is not 1.";
        }

    } // end of method solve



    // The toString() method should always be written.
    // It returns info about the instance variables.
    // In this case, we return the expression and
    // the solution.
    public String toString()
    {
        // return your expression plus space=space plus
        // the last element (and only element) on the
        // stack.
        if (stack.size() == 1 && error.equals(""))
            return expression + " = " + stack.peek();
        else
            return expression + " = " + error;
    } // end of toString()

} // end of class Postfix

/*
Sample Run:
Postfix Expressions

Written by XXXXX XXXXXX


2 7 + 1 2 + + = 12.0
1 2 3 4 + + + = 10.0
9 3 * 8 / 4 + = 7.375
3 3 + 7 * 9 2 / + = 46.5
9 3 / 2 * 7 9 * + 4 - = 65.0
5 5 + 2 * 4 / 9 + = 14.0
5 5 + 2 * 4 / 9 = Error.  The stack size is not 1.
5 5 + 2 * 4 / 9 + + + = Error in stack size.
5 5 + 2 * 4 # 9 + = Error Invalid Operator
*/

/*
HINTS:
        // get the operator from scan
        String op = scan.next();

        if (op.equals("+"))
        {
          stack.push(leftOperand + rightOperand);
        }
        else if (????)
        {
          stack.push(??????);
        }
        else if (????)
        {
          stack.push(??????);
        }
        else if (????)
        {
          stack.push(??????);
        }
        else
        {
           error = "Error Invalid operator.";
           return;
        }



*/

