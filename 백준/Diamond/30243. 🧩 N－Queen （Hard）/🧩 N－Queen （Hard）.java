public class Main {

    static int n;
    static long alive, ldiag, rdiag;
    static int[] step;
    static long[] ans;

    static boolean recursive(int m) {
        if (m > n) {
            return true;
        }
        long tmp = alive & ~((ldiag >> m) | (rdiag >> (n - m)));
        for (long a; tmp != 0; tmp ^= a) {
            a = tmp & -tmp;
            alive ^= a;
            ldiag ^= a << m;
            rdiag ^= a << (n - m);
            if (recursive(m + step[m])) {
                ans[m] = a;
                return true;
            }
            alive ^= a;
            ldiag ^= a << m;
            rdiag ^= a << (n - m);
        }
        return false;
    }

    private static int read() throws Exception{
	    int c, n = System.in.read() & 15;
	    while ((c = System.in.read()) > 32)
	    	n = (n << 3) + (n << 1) + (c & 15);
	    return n;
	}
    
    public static void main(String[] args) throws Exception {
        n = read();
        if (n < 1) return;

        int[] q = new int[n];
        alive = (1L << n) - 1;
        n--;
        ans = new long[n + 1];
        step = new int[n + 1];

        for (int j = 0; j <= n; ++j) {
            int i = read();
            q[j] = i;
            if (i != 0) {
                ans[j] = 1L << (i - 1);
                alive ^= 1L << (i - 1);
                ldiag |= 1L << (i - 1 + j);
                rdiag |= 1L << (i - 1 + n - j);
            }
        }

        for (int i = 0; i <= n; ++i) {
            if (q[i] != 0) continue;
            int s = 1;
            while (i + s <= n && q[i + s] != 0) ++s;
            step[i] = s;
        }

        int init = 0;
        while (init <= n && q[init] != 0) ++init;

        boolean finished = recursive(init);
        if (!finished) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i <= n; ++i) {
            int j = 0;
            while ((1L << j) < ans[i]) ++j;
            System.out.print((j + 1) + " ");
        }
    }
}