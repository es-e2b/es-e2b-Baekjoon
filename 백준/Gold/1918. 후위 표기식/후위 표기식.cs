#nullable disable
using System.Text;
public static class Program
{
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    public static void Main()
    {
        string s=sr.ReadLine();
        char[] op1={'+', '-'};
        char[] op2={'*', '/'};
        Stack<char> stack=new Stack<char>();
        for(int i=0;i<s.Length;i++)
        {
            if(op1.Contains(s[i]))
            {
                if(stack.Count==0)
                {
                    stack.Push(s[i]);
                    continue;
                }
                while(stack.Count>0)
                {
                    char top=stack.Peek();
                    if(op1.Contains(top))
                    {
                        sb.Append(stack.Pop());
                    }
                    else if(op2.Contains(top))
                    {
                        sb.Append(stack.Pop());
                    }
                    else
                    {
                        break;
                    }
                }
                stack.Push(s[i]);
            }
            else if(op2.Contains(s[i]))
            {
                if(stack.Count==0)
                {
                    stack.Push(s[i]);
                    continue;
                }
                while(stack.Count>0)
                {
                    char top=stack.Peek();
                    if(op1.Contains(top))
                    {
                        break;
                    }
                    else if(op2.Contains(top))
                    {
                        sb.Append(stack.Pop());
                    }
                    else
                    {
                        break;
                    }
                }
                stack.Push(s[i]);
            }
            else if(s[i]=='(')
            {
                stack.Push(s[i]);
            }
            else if(s[i]==')')
            {
                while(!(stack.Peek()=='('))
                {
                    sb.Append(stack.Pop());
                }
                stack.Pop();
            }
            else
            {
                sb.Append(s[i]);
            }
        }
        while(stack.Count>0)
        {
            sb.Append(stack.Pop());
        }
        sw.WriteLine(sb);
        sw.Flush();
    }
}