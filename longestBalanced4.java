// class Solution {
//     public int longestBalanced(String s) {
//         char[] cs = s.toCharArray();
//         int x = calc1(cs);
//         int y = Math.max(calc2(cs, 'a', 'b'), Math.max(calc2(cs, 'b', 'c'), calc2(cs, 'a', 'c')));
//         int z = calc3(cs);
//         return Math.max(x, Math.max(y, z));
//     }

//     private int calc1(char[] s) {
//         int res = 0;
//         int i = 0, n = s.length;
//         while (i < n) {
//             int j = i + 1;
//             while (j < n && s[j] == s[i]) {
//                 j++;
//             }
//             res = Math.max(res, j - i);
//             i = j;
//         }
//         return res;
//     }

//     private int calc2(char[] s, char a, char b) {
//         int res = 0;
//         int i = 0, n = s.length;
//         while (i < n) {
//             while (i < n && s[i] != a && s[i] != b) {
//                 i++;
//             }
//             Map<Integer, Integer> pos = new HashMap<>();
//             pos.put(0, i - 1);
//             int d = 0;
//             while (i < n && (s[i] == a || s[i] == b)) {
//                 d += (s[i] == a) ? 1 : -1;
//                 Integer prev = pos.get(d);
//                 if (prev != null) {
//                     res = Math.max(res, i - prev);
//                 } else {
//                     pos.put(d, i);
//                 }
//                 i++;
//             }
//         }
//         return res;
//     }

//     private int calc3(char[] s) {
//         Map<Long, Integer> pos = new HashMap<>();
//         pos.put(f(0, 0), -1);

//         int[] cnt = new int[3];
//         int res = 0;

//         for (int i = 0; i < s.length; i++) {
//             char c = s[i];
//             ++cnt[c - 'a'];
//             int x = cnt[0] - cnt[1];
//             int y = cnt[1] - cnt[2];
//             long k = f(x, y);

//             Integer prev = pos.get(k);
//             if (prev != null) {
//                 res = Math.max(res, i - prev);
//             } else {
//                 pos.put(k, i);
//             }
//         }
//         return res;
//     }

//     private long f(int x, int y) {
//         return (x + 100000) << 20 | (y + 100000);
//     }
// }











// class Solution {
//     public int longestBalanced(String s) {
//         int n = s.length();
//         if (n == 0)
//             return 0;

//         char[] arr = s.toCharArray();
//         int ans = 0;

//         // 1 character case
//         ans = Math.max(ans, countOne(arr));

//         // 2 character cases (all pairs)
//         ans = Math.max(ans, countTwo('a', 'b', arr));
//         ans = Math.max(ans, countTwo('b', 'c', arr));
//         ans = Math.max(ans, countTwo('c', 'a', arr));

//         // 3 character case
//         ans = Math.max(ans, countThree(arr));

//         return ans;
//     }

//     private int countOne(char[] arr) {
//         int ans = 0;
//         char curr = arr[0];
//         int count = 0;

//         for (char val : arr) {
//             if (val == curr) {
//                 count++;
//             } else {
//                 curr = val;
//                 count = 1;
//             }
//             ans = Math.max(ans, count);
//         }
//         return ans;
//     }

//     private int countTwo(char n1, char n2, char[] arr) {
//         Map<Integer, Integer> map = new HashMap<>();
//         map.put(0, -1);

//         int sum = 0;
//         int ans = 0;

//         for (int i = 0; i < arr.length ; i++) {
//             if (arr[i] == n1) {
//                 sum++;
//             } else if (arr[i] == n2) {
//                 sum--;
//             } else {
//                 map = new HashMap<>();
//                 sum = 0;
//                 map.put(0, i);
//                 continue;
//             }

//             if (map.containsKey(sum)) {
//                 ans = Math.max(ans, i - map.get(sum));
//             } else {
//                 map.put(sum, i);
//             }
//         }

//         return ans;
//     }

//     private int countThree(char[] arr) {
//         Map<String, Integer> map = new HashMap<>();
//         map.put("0#0", -1);

//         int a = 0, b = 0, c = 0;
//         int maxLen = 0;

//         for (int i = 0; i < arr.length; i++) {
//             if (arr[i] == 'a')
//                 a++;
//             else if (arr[i] == 'b')
//                 b++;
//             else
//                 c++;

//             int diff1 = a - b;
//             int diff2 = a - c;

//             String key = diff1 + "#" + diff2;

//             if (map.containsKey(key)) {
//                 maxLen = Math.max(maxLen, i - map.get(key));
//             } else {
//                 map.put(key, i);
//             }
//         }

//         return maxLen;
//     }
// }












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

