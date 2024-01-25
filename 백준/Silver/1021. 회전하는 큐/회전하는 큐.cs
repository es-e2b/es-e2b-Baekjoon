#nullable disable

using System;
using System.IO;

public static class Program
{
    public static void Main()
    {
        using var sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
        using var sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);

        var nm = sr.ReadLine().Split(' ').Select(Int32.Parse).ToArray();
        var n = nm[0];
        var m = nm[1];

        List<int> q=new List<int>();
        for(int i=1;i<=n;i++){
            q.Add(i);
        }
        var nl2=sr.ReadLine().Split(' ').Select(Int32.Parse).ToArray();
        int count=0;
        for(int i=0;i<m;i++){
            int now=nl2[i];
            int index = q.IndexOf(now);
            if(index<=q.Count/2)
                for(int j=0;j<index;j++){
                    q.Add(q.First());
                    q.RemoveAt(0);
                    count++;
                }
            else
                for(int j=0;j<q.Count-index;j++){
                    q.Insert(0,q.Last());
                    q.RemoveAt(q.Count-1);
                    count++;
                }
            q.RemoveAt(0);
        }
        
        sw.WriteLine(count);
    }
}