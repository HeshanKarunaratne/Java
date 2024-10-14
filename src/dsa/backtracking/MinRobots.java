package dsa.backtracking;

import java.util.Arrays;

/*
MinRobots

You are given a 2D array representing a plan of a building. The array has R rows and C columns. Each field contains one of three symbols:

. represents a clean floor.
* represents a dirty floor.
# represents a wall.
Your task is to clean the dirty areas using a cleaning robot. When the robot is run in some room, it cleans the entire floor inside that room (all connected dirty tiles). The robot can move in one of four directions: up, down, left, or right. The cleaning robot can move only on dirty floor tiles and cannot move outside the area represented by the plan or through walls.

The goal is to determine the minimum number of robot runs required to clean the entire building.

Input:
A 2D array of size R x C represented by a list of strings (where R is the number of rows and C is the number of columns).
Output:
An integer representing the minimum number of robot runs required to clean all the dirty areas.

Example 1:
String[] plan = {
    ".#...",
    ".*.#.",
    ".#...",
    ".*..."
};

Output:
2

Example 2:
String[] plan = {
    "#####",
    "#***#",
    "#***#",
    "#***#",
    "#####"
};

Output:
1

Example 3:
String[] plan = {
    "#####",
    "#...#",
    "#...#",
    "#...#",
    "#####"
};

Output:
0
 */

public class MinRobots {
    private static final char CLEAN = '.';
    private static final char DIRTY = '*';
    private static final char WALL = '#';

    public static void main(String[] args) {

        String[] plan = {
                "*..*.",
                "..#..",
                ".#*#.",
                "..*..",
                ".*..*"
        };
        int minRobots = 0;
        char[][] floorPlan = new char[plan.length][plan[0].length()];

        for (int i = 0; i < plan.length; i++) {
            for (int j = 0; j < plan[0].length(); j++) {
                floorPlan[i][j] = plan[i].charAt(j);
            }
        }
        System.out.println(solution(floorPlan, minRobots, 0, 0));
    }

    public static int solution(char[][] floorPlan, int minRobots, int startX, int startY) {

        if (floorPlan == null || floorPlan.length == 0) return 0;

        boolean[][] visited = new boolean[floorPlan.length][floorPlan[0].length];
        for (int i = 0; i < floorPlan.length; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int i = startX; i < floorPlan.length; i++) {
            for (int j = startY; j < floorPlan[0].length; j++) {
                if (floorPlan[i][j] == DIRTY && !visited[i][j]) {
                    minRobots++;
                    dfs(floorPlan, visited, i, j);
                }
            }
        }
        return minRobots;
    }

    private static void dfs(char[][] floorPlan, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= floorPlan.length || j < 0 || j >= floorPlan[0].length || visited[i][j] || floorPlan[i][j] == WALL || floorPlan[i][j] == CLEAN) {
            return;
        }
        visited[i][j] = true;
        dfs(floorPlan, visited, i, j + 1);
        dfs(floorPlan, visited, i, j - 1);
        dfs(floorPlan, visited, i + 1, j);
        dfs(floorPlan, visited, i - 1, j);
    }
}

/*
When iterating through all the cells we need to make sure, that cell is not visited and dirty. If it passes then we can use a dfs on that cell

Base Case: The cell should be in correct range, cell should be not visited and cell should be dirty else it should stop
 */