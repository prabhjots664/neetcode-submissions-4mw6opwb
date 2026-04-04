class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();
        for (String str: strs){
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> strs = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            while(str.charAt(i)!='#'){
                sb.append(str.charAt(i));
                i++;
            }
            int strlen = Integer.parseInt(sb.toString());
            i++;//skip #

            StringBuilder strpart = new StringBuilder();
            for (int j=i; j< i+strlen; j++){
                strpart.append(str.charAt(j));
            }
            strs.add(strpart.toString());
            i=i+strlen-1;
        }
        return strs;
    }
}
