class Solution {
    public int change(int amount, int[] coins) {
        Map<String, Integer> mapMemo = new HashMap<>();
        return changeRecurse(amount, coins, 0, mapMemo);
    }

    public int changeRecurse(int amount, int[] coins, int start, Map<String, Integer> mapMemo) {
        if(amount==0) return 1;
        if(amount<0) return 0;
        
        String key = amount + "," + start;
        
        if(mapMemo.containsKey(key)){
            return mapMemo.get(key);
        }

        int ways = 0;
        for (int i = start ; i < coins.length; i++) {
            ways += changeRecurse(amount-coins[i], coins, i, mapMemo);
        }
        
        mapMemo.put(key, ways);

        return ways;
    }
}
