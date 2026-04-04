class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            int[] arr = new int[26];
            for (char ch : str.toCharArray()){
                arr[ch-'a'] += 1;
            }

            String keyStr = Arrays.toString(arr);

            map.putIfAbsent(keyStr , new ArrayList<>());
            map.get(keyStr).add(str);
        }

        System.out.println("printed map for debugging: " + map);
        //put values of map into list
        List<List<String>> res = new ArrayList<>();
        for (List<String> anagrams : map.values()) {
            res.add(anagrams);
        }
        return res;
    }
}
