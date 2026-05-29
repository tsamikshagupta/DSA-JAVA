class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        q.offer(1);
        visited[1] = true;
        int moves = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == n * n) {
                    return moves;
                }
                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > n * n) {
                        break;
                    }
                    int[] pos = getCoordinates(next, n);
                    int row = pos[0];
                    int col = pos[1];
                    if (board[row][col] != -1) {
                        next = board[row][col];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private int[] getCoordinates(int num, int n) {
        int r = (num - 1) / n;
        int c = (num - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        r = n - 1 - r;
        return new int[]{r, c};
    }
}