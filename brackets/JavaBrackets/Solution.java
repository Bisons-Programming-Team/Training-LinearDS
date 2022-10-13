import java.util.*;

public class Solution
{
  public static void main(String[] args)
  {
    // get input string
    Scanner in = new Scanner(System.in);
    System.out.print("Type in a string\n > ");
    String input = in.nextLine();
    System.out.println();
    
    // parse brackets
    ArrayDeque<Character> stack = new ArrayDeque<>();
    boolean valid = true; // assume valid until we find otherwise
    for (int i = 0; valid && i < input.length(); i++)
    {
      char curr = input.charAt(i);
      switch (curr)
      {
        case '(':
        case '[':
        case '{':
          stack.push(curr);
          break;
        case ')':
          if (stack.isEmpty() || stack.pop() != '(')
            valid = false;
          break;
        case ']':
          if (stack.isEmpty() || stack.pop() != '[')
            valid = false;
          break;
        case '}':
          if (stack.isEmpty() || stack.pop() != '{')
            valid = false;
          break;
      }
    }
    
    if (!stack.isEmpty())
      valid = false;
    
    if (valid)
      System.out.println("Correct");
    else
      System.out.println("Incorrect");
  }
}