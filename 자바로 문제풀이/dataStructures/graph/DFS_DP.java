package ProblemSolving;

//백준 1520 내리막길에서 쓰인
//백트래킹 + dp
public class Main {
    static int R,C;
    static int[][] maps;
    static int[][] dp;
    static int[][] dirs =new int[][]{{0,-1},{-1,0},{0,1},{1,0}};

    public static int dfs(int r,int c){
        if(r==R-1 && c==C-1) return 1;
        if(dp[r][c]!=-1) return dp[r][c];

        dp[r][c]=0;

        for(int i=0;i<4;i++){
            int nr=r,nc=c;
            nr+=dirs[i][0];
            nc+=dirs[i][1];

            if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
            if(maps[nr][nc]>= maps[r][c]) continue;
            dp[r][c]+=dfs(nr,nc);

        }
        return dp[r][c];
    }
}

