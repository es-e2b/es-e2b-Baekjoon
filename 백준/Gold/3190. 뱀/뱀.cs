#nullable disable
using System.Text;
public static class Program
{
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    static Func<int[]> ReadIntArray=()=>Array.ConvertAll(sr.ReadLine().Split(),int.Parse);
    static Func<int> ReadInt=()=>int.Parse(sr.ReadLine());
    public static void Main()
    {
        Dummy dummy=new Dummy(ReadInt());
        int apples=ReadInt();
        while(apples-->0)
        {
            dummy.AddApple(ReadIntArray());
        }
        int rotations=ReadInt();
        while(rotations-->0)
        {
            string[] input=sr.ReadLine().Split();
            dummy.AddRotation(int.Parse(input[0]), char.Parse(input[1]));
        }
        sb.Append(dummy.play());
        sw.WriteLine(sb);
        sw.Flush();
    }
    public class Dummy
    {
        int _n;
        int _t;
        enum Direction
        {
            North, East, South, West
        }
        Direction _direction;
        LinkedList<(int y, int x)> _snake=new LinkedList<(int y, int x)>();
        Dictionary<int, char> _rotation=new Dictionary<int, char>();
        HashSet<(int y, int x)> _apple=new HashSet<(int y, int x)>();
        public Dummy(int n)
        {
            _n=n;
            _direction=Direction.East;
            _t=0;
            _snake.AddFirst((1,1));
        }
        public void AddApple(int[] coordinate)
        {
            _apple.Add((coordinate[0], coordinate[1]));
        }
        public void AddRotation(int t, char direction)
        {
            _rotation.Add(t, direction);
        }
        public (int y, int x) Go()
        {
            (int y, int x) head=_snake.First();
            switch(_direction)
            {
                case Direction.North:
                    return (head.y-1, head.x);
                case Direction.East:
                    return (head.y, head.x+1);
                case Direction.South:
                    return (head.y+1, head.x);
                default:
                    return (head.y, head.x-1);
            }
        }
        private void Rotate()
        {
            if (_rotation.ContainsKey(_t))
                {
                    char next = _rotation[_t];
                    if(next=='D')
                    {
                        switch(_direction)
                        {
                            case Direction.North:
                                _direction=Direction.East;
                                break;
                            case Direction.East:
                                _direction=Direction.South;
                                break;
                            case Direction.South:
                                _direction=Direction.West;
                                break;
                            default:
                                _direction=Direction.North;
                                break;
                        }
                    }
                    else
                    {
                        switch(_direction)
                        {
                            case Direction.North:
                                _direction=Direction.West;
                                break;
                            case Direction.East:
                                _direction=Direction.North;
                                break;
                            case Direction.South:
                                _direction=Direction.East;
                                break;
                            default:
                                _direction=Direction.South;
                                break;
                        }
                    }
                    _rotation.Remove(_t);
                }
        }
        public int play()
        {
            while(true)
            {
                _t++;
                (int y, int x) now=Go();
                if(now.y>_n||now.x>_n||now.y<=0||now.x<=0||_snake.Contains(now))
                    return _t;
                _snake.AddFirst(now);
                if(!_apple.Contains(now))
                    _snake.RemoveLast();
                else
                    _apple.Remove(now);
                Rotate();
            }
        }
    }
}