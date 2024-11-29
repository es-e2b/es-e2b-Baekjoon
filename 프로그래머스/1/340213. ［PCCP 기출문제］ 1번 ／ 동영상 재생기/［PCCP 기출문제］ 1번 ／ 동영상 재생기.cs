using System;

public class Solution {
    int len;
    int currentTime;
    int op_start2;
    int op_end2;
    public string solution(string video_len, string pos, string op_start, string op_end, string[] commands) {
        len=Time(video_len);
        currentTime=Time(pos);
        op_start2=Time(op_start);
        op_end2=Time(op_end);
        if(currentTime>=Time(op_start) && currentTime<Time(op_end))
        {
            currentTime=Time(op_end);
        }
        foreach(string command in commands)
        {
            Command(command);
        }
        string ss=(currentTime/60<10)?"0"+(currentTime/60).ToString():(currentTime/60).ToString();
        string mm=(currentTime%60<10)?"0"+(currentTime%60).ToString():(currentTime%60).ToString();
        string answer = ss+":"+mm;
        return answer;
    }
    private int Time(string time)
    {
        int ss=int.Parse(time.Substring(0,2));
        int mm=int.Parse(time.Substring(3,2));
        return ss*60+mm;
    }
    private void Command(string command)
    {
        switch(command)
        {
            case "next":
                currentTime+=10;
                break;
            case "prev":
                currentTime-=10;
                break;
        }
        if(currentTime<0)
        {
            currentTime=0;
        }
        if(currentTime>=len)
        {
            currentTime=len;
        }
        if(currentTime>=op_start2 && currentTime<op_end2)
        {
            currentTime=op_end2;
        }
    }
}