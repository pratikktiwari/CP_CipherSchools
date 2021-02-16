import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class PairRC {
    int r, c;

    PairRC(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class RatInAMaze {
    static void getImmediateNeighbors(char grid[][], int r, int c, int R, int C) {
        int directionVectorRow[] = { -1, 1, 0, 0 };
        int directionVectorCol[] = { 0, 0, 1, -1 };

        for (int i = 0; i < 4; i++) {
            int rr = directionVectorRow[i] + r;
            int cc = directionVectorCol[i] + c;

            if (cc < 0 || rr < 0)
                continue;
            if (rr >= R || cc >= C)
                continue;
            System.out.println(grid[rr][cc]);
        }
    }

    static void checkIfReachable(char grid[][], int r, int c, int R, int C) {
        int directionVectorRow[] = { -1, 1, 0, 0 };
        int directionVectorCol[] = { 0, 0, 1, -1 };

        Queue<PairRC> q = new LinkedList<>();
        PairRC p = new PairRC(r, c);
        HashSet<String> visited = new HashSet<>();

        int steps_taken = 0;

        q.offer(p);
        int nodes_left_in_layer = 1;
        int nodes_in_next_layer = 0;

        while (!q.isEmpty()) {
            PairRC pair = q.poll();
            r = pair.r;
            c = pair.c;

            visited.add(r + "" + c);

            for (int i = 0; i < 4; i++) {
                int rr = r + directionVectorRow[i];
                int cc = c + directionVectorCol[i];

                if (rr < 0 || cc < 0 || rr >= R || cc >= C)
                    continue;
                if (grid[rr][cc] == '#')
                    continue;
                if (visited.contains(rr + "" + cc))
                    continue;
                if (grid[rr][cc] == 'E') {
                    System.out.println("Reached E, steps: " + steps_taken);
                    return;
                }

                visited.add(rr + "" + cc);

                nodes_in_next_layer++;

                q.offer(new PairRC(rr, cc));
            }
            nodes_left_in_layer--;
            if (nodes_left_in_layer == 0) {
                nodes_left_in_layer = nodes_in_next_layer;
                nodes_in_next_layer = 0;
                steps_taken++;
            }
        }
        System.out.println("Not possible");

    }

    public static void main(String[] args) {
        // # denotes obstacles
        // . denotes path
        char grid[][] = { { 'S', '.', '.', '#', '.', '.', '.' }, { '.', '#', '.', '.', '.', '#', '.' },
                { '.', '#', '.', '.', '.', '.', '.' }, { '.', '.', '#', '#', '.', '.', '.' },
                { '#', '.', '#', 'E', '.', '#', '.' } };
        int R = 5;
        int C = 7;

        // int directionVectorRow[] = { -1, 1, 0, 0 };
        // int directionVectorCol[] = { 0, 0, 1, -1 };

        checkIfReachable(grid, 0, 0, R, C);

    }
}

// reachable
// char grid[][] = {
// { 'S', '.', '.', '#', '.', '.', '.' },
// { '.', '#', '.','.', '.', '#', '.' },
// { '.', '#', '.', '.', '.', '.', '.' },
// { '.', '.', '#', '#', '.', '.', '.' },
// { '#', '.', '#', 'E', '.', '#', '.' } };
// unreachable
// char grid[][] = { { 'S', '.', '.', '#', '.', '.', '.' }, { '.', '#', '.',
// '.', '.', '#', '.' },
// { '.', '#', '.', '.', '.', '.', '.' }, { '.', '.', '#', '#', '#', '.', '.' },
// { '#', '.', '#', 'E', '#', '#', '.' } };