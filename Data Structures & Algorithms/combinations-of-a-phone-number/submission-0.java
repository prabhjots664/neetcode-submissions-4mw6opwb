class Solution {
    public List<String> letterCombinations(String digits) {
        //create digitMap: 2->{a,b,c}...
        int[] arr =  {1,2};
        Map<Character, List<Character>> digitMap = new HashMap<>();
        digitMap.put('2', List.of('a','b','c'));
        digitMap.put('3', List.of('d','e','f'));
        digitMap.put('4', List.of('g','h','i'));
        digitMap.put('5', List.of('j','k','l'));
        digitMap.put('6', List.of('m','n','o'));
        digitMap.put('7', List.of('p','q','r','s'));
        digitMap.put('8', List.of('t','u','v'));
        digitMap.put('9', List.of('w','x','y','z'));

        //call recursive methid;
        List<String> res = new ArrayList<>();
        letterCombinationsRecurse(digits, digitMap, res, "");


        return res;
    }

    private void letterCombinationsRecurse(String digits, Map<Character, List<Character>> digitMap, List<String> res, String str) {

        if(digits.isBlank()){
            if(!str.isBlank()){
                res.add(str);
            }
            return;
        }
        
        Character ch = digits.charAt(0);
        String postDigits = "";
        if(digits.length()>1){
            postDigits = digits.substring(1);
        }
        
        for (Character character : digitMap.get(ch)){
            letterCombinationsRecurse(postDigits, digitMap, res, str + character);
        }

    }
}
