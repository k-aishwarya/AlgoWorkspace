package LeetCode.Contest59;

public class countPaths {

    //Not done!

    long min_time = Long.MAX_VALUE;
    int total_path = 0;

    public int countPaths(int n, int[][] roads) {
        if(roads==null|| roads.length<1) return 0;
        if(roads.length==1) return 1;
        for (int i = 0; i < roads.length; i++) {
            if (roads[i][0] == 0) {
                countPathsHelper(0, -1, 0, n, roads);
            } else if (roads[i][1] == 0) {
                countPathsHelper(roads[i][0], -1, 0, n, roads);
            }
        }
        return total_path;
    }

    static int mod(int a)
    {
        int m = 7;
        return (a%m + m) % m;
    }

    public void countPathsHelper(int cur_node, int prev_index, long cur_time, int n, int[][] roads) {
        if(cur_time>min_time) return;
        else if(cur_time==min_time){
            if(cur_node==n-1){
                total_path++;
            }
            return;
        }
        else{
            if(cur_node==n-1) {
                min_time=cur_time;
                total_path=1;
                return;
            }
            for(int i=0; i<roads.length; i++){
                if(prev_index!=i) {
                    if (roads[i][0] == cur_node) {
                        countPathsHelper(roads[i][1], i, cur_time + roads[i][2], n, roads);
                    } else if (roads[i][1] == cur_node) {
                        countPathsHelper(roads[i][0], i, cur_time + roads[i][2], n, roads);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        int n=7;
        countPaths cc = new countPaths();
        System.out.println(cc.countPaths(n,roads));
    }
}
