import java.util.*;
class pascaltriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 0; i < rowIndex; i++) {
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int j = 1; j < row.size(); j++) {
                newRow.add(row.get(j - 1) + row.get(j));
            }
            newRow.add(1);
            row = newRow;
        }

        return row;        
    }
}



// class Solution {
//     public List<Integer> getRow(int rowIndex) {
//         // if (rowIndex==0)return Arrays.aslist(1);
//         List<List<Integer>> res=new ArrayList<>();
//         res.add(List.of(1));
//         for(int i=1;i<rowIndex+1;i++){
//             List<Integer> temp=new ArrayList<>();
//             temp.add(0);
//             temp.addAll(res.get(res.size()-1));
//             temp.add(0);

//             List<Integer> row=new ArrayList<>();
//             for(int j=0;j<temp.size()-1;j++){
//                 row.add(temp.get(j)+temp.get(j+1));
//             }
//             res.add(row);
//         }
//         return res.get(rowIndex);
//     }
// }


// class Solution {
//     public List<Integer> getRow(int rowIndex) {
//         if (rowIndex == 0) {
//             return List.of(1);
//         }

//         if (rowIndex == 1) {
//             return List.of(1, 1);
//         }

//         return getRow(rowIndex, new Integer[] { 1, 1 });
//     }

//     private List<Integer> getRow(int rowIndex, Integer[] prev) {
//         Integer[] next = new Integer[prev.length + 1];

//         int maxRight = next.length - 1;

//         next[0] = 1;
//         next[maxRight] = 1;

//         for (int i = 1; i < maxRight; i++) {
//             int j = maxRight - i;

//             if (i > j) {
//                 break;
//             }

//             if (i == j) {
//                 next[i] = prev[i - 1] + prev[i];
//                 continue;
//             }

//             if (i < j) {
//                 next[i] = prev[i - 1] + prev[i];
//                 next[j] = prev[j - 1] + prev[j];
//                 continue;
//             }
//         }

//         if (rowIndex == maxRight) {
//             return List.of(next);
//         }

//         return getRow(rowIndex, next);
//     }
// }