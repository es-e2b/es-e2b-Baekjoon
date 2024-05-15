public class Class1
{
    static void Main(string[] args)
    {
        string[] str = (Console.ReadLine()).Split();
        int total = int.Parse(str[0]);
        int prize = int.Parse(str[1]);

        string[] score = (Console.ReadLine()).Split();
        int[] num = new int[score.Length];

        for (int i = 0; i < score.Length; i++)
        {
            num[i] = int.Parse(score[i]);
        }
        Array.Sort(num);
        Array.Reverse(num);  
        Console.WriteLine(num[prize-1]);
    }
} 