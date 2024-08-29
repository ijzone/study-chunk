package search.graph;

/**
 * DFS
 *
 * @see <a href="https://komas.tistory.com/39?category=550026">[JAVA] 알고리즘 DFS[Depth-First Search] 깊이 우선 탐색</a>
 */
public class DFS_Graph {

    static int[][] graph = {{},{2,3,8},{1,6,8},{1,5},{5,7},{3,4,7},{2},{4,5},{1,2}};
    static boolean[] visited = new boolean[graph.length];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        System.out.println("방문한 노드순서: ");
        dfs(1);
        System.out.println(sb);
    }

    public static void dfs(int x) {
        visited[x] = true;
        sb.append(x).append(" ");

        for (int i = 0; i < graph[x].length; i++) {
            if(!visited[graph[x][i]]) {
                dfs(graph[x][i]);
            }
        }
    }


}
