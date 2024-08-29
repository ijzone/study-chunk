package search.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS(넓이 우선 탐색)
 *
 * @see <a href="https://komas.tistory.com/38">[JAVA] 알고리즘 BFS[Breadth-First Search] 너비 우선 탐색</a>
 */
public class BFS_Graph {

    static int[][] graph = {{},{2,3,8},{1,6,8},{1,5},{5,7},{3,4,7},{2},{4,5},{1,2}};
    static boolean[] visited = new boolean[graph.length];
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        System.out.println("방문한 노드순서: ");
        bfs(1);
        System.out.println(sb);
    }

    public static void bfs(int n) {
        q.offer(n);
        visited[n] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            sb.append(x).append(" ");

            for (int y : graph[x]) {
                if(!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }
}
