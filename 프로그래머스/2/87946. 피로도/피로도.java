class Solution {  
    static boolean[] dungeonVisited;  
    static int maxDungeonCount = 0;  
  
    public int solution(int initialFatigue, int[][] dungeonList) {  
        dungeonVisited = new boolean[dungeonList.length];  
        exploreDungeons(0, initialFatigue, dungeonList);  
        return maxDungeonCount;  
    }  
      
    private void exploreDungeons(int currentCount, int remainingFatigue, int[][] dungeonList){  
        for (int i = 0; i < dungeonList.length; i++){  
            if (dungeonVisited[i] || dungeonList[i][0] > remainingFatigue) {  
                continue;  
            }  
            dungeonVisited[i] = true;  
            exploreDungeons(currentCount + 1, remainingFatigue - dungeonList[i][1], dungeonList);  
            dungeonVisited[i] = false;  
        }  
        maxDungeonCount = Math.max(maxDungeonCount, currentCount);  
    }  
}
