package Labprogram;
import java.util.Scanner;

public class BellmanFord {

    public void BellmanFordEvaluation(int source, int A[][]) {
        for (int node = 1; node <= num_ver; node++) {
            D[node] = MAX_VALUE;
        }
        D[source] = 0;// IMPORTANT
        for (int node = 1; node <= num_ver - 1; node++) // iteration of n-1 time
        {
            for (int i = 1; i <= num_ver; i++) {
                for (int j = 1; j <= num_ver; j++) {
                    if (A[i][j] != MAX_VALUE) {
                        if (D[j] > D[i] + A[i][j])
                            D[j] = D[i] + A[i][j];
                    }
                }
            }
        }
        for (int i = 1; i <= num_ver; i++) {
            for (int j = 1; j <= num_ver; j++) {
                if (A[i][j] != MAX_VALUE) {
                    if (D[j] > D[i] + A[i][j])
                        System.out.println("The Graph contains negative edge cycle");
                }
            }
        }
        for (int vertex = 1; vertex <= num_ver; vertex++) {
            System.out.println("distance of source " + source + " to " + vertex + " is " + D[vertex]);
        }
    }
    int D[]; // stores the value of all vertex
    int num_ver;
    public static final int MAX_VALUE = 999;

    public BellmanFord(int num_ver) {
        this.num_ver = num_ver;
        D = new int[num_ver + 1];
    }


    public static void main(String[] args) {
        int num_ver = 0;
        int source;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        num_ver = scanner.nextInt();
        int A[][] = new int[num_ver + 1][num_ver + 1];
        System.out.println("Enter the adjacency matrix");
        for (int i = 1; i <= num_ver; i++) {
            for (int j = 1; j <= num_ver; j++) {
                A[i][j] = scanner.nextInt();
                if (i == j) {
                    A[i][j] = 0;
                    continue; //IMP
                }
                if (A[i][j] == 0) {
                    A[i][j] = MAX_VALUE;
                }
            }
        }
        System.out.println("Enter the source vertex");
        source = scanner.nextInt();
        BellmanFord b = new BellmanFord(num_ver);
        b.BellmanFordEvaluation(source, A);
        scanner.close();
    }
}

//OUTPUT
//        Enter the number of vertices
//        5
//        Enter the adjacency matrix
//        0 6 5 999 999
//        999 0 999 -1 999
//        999 -2 0 4 3
//        999 999 999 0 3
//        999 999 999 999 0
//        Enter the source vertex
//        1
//        distance of source 1 to 1 is 0
//        distance of source 1 to 2 is 3
//        distance of source 1 to 3 is 5
//        distance of source 1 to 4 is 2
//        distance of source 1 to 5 is 5