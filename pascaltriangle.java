import java.util.*;


class pascaltriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));

        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> dummyRow = new ArrayList<>();
            dummyRow.add(0);
            dummyRow.addAll(res.get(res.size() - 1));
            dummyRow.add(0);
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < dummyRow.size() - 1; j++) {
                row.add(dummyRow.get(j) + dummyRow.get(j + 1));
            }

            res.add(row);
        }

        return res;        
    }
}




// import java.util.*;

// class Solution {
//     public List<List<Integer>> generate(int numRows) {
//         List<List<Integer>> pascal = new ArrayList<>();

//         for (int i = 0; i < numRows; i++) {
//             List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));
            
//             for (int j = 1; j < i; j++) {
//                 int val = pascal.get(i - 1).get(j - 1) + pascal.get(i - 1).get(j);
//                 row.set(j, val);
//             }
//             pascal.add(row);
//         }
//         return pascal;
//     }
// }