class longestBalanced4 {
    public int longestBalanced(String s) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<s.length();j++){
                max=Math.max(max,check(s,i,j));
            }
        }
        return max;
    }
    public int check(String s,int i,int j){
        Map<Character,Integer> m=new HashMap<>();
        List<Integer> l=new ArrayList<>();
        for(int q=i;q<=j;q++){
            m.put(s.charAt(q),m.getOrDefault(s.charAt(q),0)+1);
        }
        for(Map.Entry<Character,Integer> entry:m.entrySet()){
            l.add(entry.getValue());
        }
        // if(l.size()!=0){
        int temp=l.get(0);
        for(int k=1;k<l.size();k++){
            if(temp!=l.get(k))return 0;
        }
        // }

        return s.length();
        // return l.size();
    }
}