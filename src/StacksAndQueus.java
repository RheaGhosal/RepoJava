import java.util.Stack;
import java.util.Arrays;
import static java.lang.System.*;

public class StacksAndQueus // SyntaxCheckRunner
{
    public static void main(String[] args)
    {
        System.out.println("Syntax Checker");
        System.out.println();
        System.out.println("Written by Rhea Ghosal");
        System.out.println();
        System.out.println();

        SyntaxChecker test = new SyntaxChecker("(abc(*def)");
        System.out.println(test);

        test.setExpression("[{}]");
        System.out.println(test);

        test.setExpression("[{]}");
        System.out.println(test);

        test.setExpression("[");
        System.out.println(test);

        test.setExpression("[{<()>}]");
        System.out.println(test);

        test.setExpression("{{$x}}");
        System.out.println(test);

        test.setExpression("[one]{three}(four)");
        System.out.println(test);

        test.setExpression("car(cdr(a)(b)))");
        System.out.println(test);

        test.setExpression("car(cdr(a)(b))");
        System.out.println(test);
    }
}
// uncomment if you are using a separate file
// import java.util.Stack;
// import java.util.Arrays;
// import static java.lang.System.*;

class SyntaxChecker
{
    // Instance Variables (attributes, properties, fields, ...)
    private String exp;
    private Stack<Character> symbols;

    // Constructor to init your instance variables
    // (attributes, properties, fields, ...)
    public SyntaxChecker(String s)
    {

        setExpression(s);
    }

    // a setter method
    public void setExpression(String s)
    {
        // set the expression
        exp = s;

        // create the Stack that holds String objects
        symbols = new Stack<>();
    }

    public boolean checkExpression()
    {

        // Loop through your expression
        // (a String called exp)

        // use exp.substring(i,i+1) to get your String.
        // DON'T FORGET to use .equals() for Strings, not ==
        // push left symbols onto your stack

        // MAKE SURE THE STACK IS NOT EMPTY before
        // you do a pop() call.  If it is empty then
        // return false;
        // if you get a right symbol, pop your
        // stack and see if you have a matching left
        // symbol.
        // return true if all symbols are matched properly
        // and the stack is empty else return false
        // Loop through your expression (a String called exp)
        for (int i = 0; i < exp.length(); i++)
        {
            char current = exp.charAt(i);

            if (current == '(' || current == '[' || current == '{' || current == '<')
            {
                symbols.push(current);
            }
            else if (current == ')' || current == ']' || current == '}' || current == '>')
            {
                if (symbols.isEmpty())
                {
                    return false;
                }

                char top = (Character) symbols.pop();
                if ((current == ')' && top != '(') ||
                        (current == ']' && top != '[') ||
                        (current == '}' && top != '{') ||
                        (current == '>' && top != '<'))
                {
                    return false;
                }
            }
        }

        return symbols.isEmpty();
    }



    public String toString()
    {
        if (checkExpression())
            return exp + " is correct.\n";
        return exp + " is incorrect.\n";
    }
}


