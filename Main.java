import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Suheng on 3/28/16.
 */
public class Main {
    private static InputReader in = null;
    private static PrintWriter out = null;

    public static boolean SUBMIT = true;
    public static String NAME = "codejam";

    public static void solution() throws IOException {
        String S = in.next();
        if (S == null || S.length() == 0) {
            return;
        }

        StringBuffer sb = new StringBuffer();

        sb.append(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) < sb.charAt(0)) {
                sb.append(S.charAt(i));
            } else {
                sb.insert(0, S.charAt(i));
            }
        }
        out.println(sb.toString());
    }


    public static void main(String[] args) throws IOException {
        if (SUBMIT) {
            in = new InputReader(new FileInputStream(new File(NAME + ".in")));
            out = new PrintWriter(new BufferedWriter(new FileWriter(NAME + ".out")));
        } else {
            in = new InputReader(System.in);
            out = new PrintWriter(System.out, true);
        }

        int numTestCase = in.nextInt();
        for (int i = 1; i <= numTestCase; i++) {
            out.print("Case #" + i + ": ");
            solution();
        }


        out.close();
        System.exit(0);
    }


    static class InputReader {
        public BufferedReader bufferedReader = null;
        public StringTokenizer stringTokenizer = null;

        public InputReader(InputStream in) {
            this.bufferedReader = new BufferedReader(new InputStreamReader(in));
            this.stringTokenizer = null;
        }

        public String next() {
            while (this.stringTokenizer == null || !this.stringTokenizer.hasMoreTokens()) {
                try {
                    this.stringTokenizer = new StringTokenizer(this.bufferedReader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return this.stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(this.next());
        }
    }
}
