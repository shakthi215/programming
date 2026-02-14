package zoho.allconcept;
import java.util.*;
public class example{
    // static int getindex(char ch){
    //     if(ch=='a')return 0;
    //     if(ch=='e')return 1;
    //     if(ch=='i')return 2;
    //     if(ch=='o')return 3;
    //     if(ch=='u')return 4;
    //     return -1;
    // }

    public static void main(String abs[]){
        // Scanner s=new Scanner(System.in);


//         Bitwise addition (without + or -)

        // int a=10,b=15;
        // while(b!=0){
        //     int carry=(a&b)<<1;
        //     a=a^b;
        //     b=carry;
        // }
        // System.out.print(a);

// • Dynamic island sums

        // int n = 5;
        // int[][] queries = {
        //     {1,4},
        //     {3,2},
        //     {2,3},
        //     {4,5},
        //     {3,0}
        // };
        // int[] arr=new int[n];
        // for(int q=0;q<queries.length;q++){
        //     int index=queries[q][0]-1;
        //     int value=queries[q][1];
        //     arr[index]=value;
        //     int cursum=0;
        //     int maxsum=0;
        //     for(int i=0;i<n;i++){
        //         if(arr[i]!=0){
        //             cursum=Math.max(cursum+arr[i],arr[i]);
        //             maxsum=Math.max(maxsum,cursum);
        //         }else{
        //             cursum=0;
        //         }
        //     }
        //     System.out.println(maxsum);

        // }






// • Asteroid collision scenarios


// Stack<Integer> stack = new Stack<>();

//         for (int a : asteroids) {

//             boolean destroyed = false;

//             while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {

//                 if (Math.abs(stack.peek()) < Math.abs(a)) {
//                     stack.pop(); // stack asteroid explodes
//                 }
//                 else if (Math.abs(stack.peek()) == Math.abs(a)) {
//                     stack.pop(); // both explode
//                     destroyed = true;
//                     break;
//                 }
//                 else {
//                     destroyed = true; // current explodes
//                     break;
//                 }
//             }

//             if (!destroyed) {
//                 stack.push(a);
//             }
//         }

//         int[] result = new int[stack.size()];
//         for (int i = stack.size() - 1; i >= 0; i--) {
//             result[i] = stack.pop();
//         }

//         return result;



// • Maximum subarray problems
// • Two-pointer problem
// • Tree-based logic
// • Trapping rainwater




// 2nd Round (L2 Programming) : -
//     i) Merge Intervals : https://lnkd.in/gSF7u29t

        // Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        // LinkedList<int[]> ans=new LinkedList<>();
        // for(int[] i:intervals){
        //     if(ans.isEmpty()||ans.getLast()[1]<i[0]){
        //         ans.add(i);
        //     }else{
        //         ans.getLast()[1]=Math.max(ans.getLast()[1],i[1]);
        //     }
        // }
        // return ans.toArray(new int[ans.size()][]);




// ii) No. of Islands : https://lnkd.in/gX7cbAS9

// iii) Celebrity Problem : https://lnkd.in/gq6-wjtD

// iv) Jump Game : https://lnkd.in/gkaegiXt

// v) Crayon Partitioning : 
//         Given an array of size N, where each element represents the size of a crayon, and a threshold value k, which determines the minimum allowable crayon size, return the maximum number of crayons possible after cutting each crayon larger than k


// 1️⃣ Two Sum / Combination Sum
// 🔗 https://lnkd.in/gk6qVUpR
// 2️⃣ Zoho X Pattern (Pattern Printing)
// 🔗 Similar pattern problems: https://lnkd.in/gH72msf9
// 3️⃣ Number of Islands (Graph / DFS / BFS)
// 🔗 https://lnkd.in/gPMxkVDF
// 4️⃣ String Match / Subsequence Check
// a = Alex, b = Alexuu → Output: true
// 🔗 https://lnkd.in/gkMdZ92w
// 5️⃣ Pyramid Pattern using Binomial Coefficient (Pascals Triangle)
// 🔗 https://lnkd.in/gHMU_8P7

// Question:
// 1 You are given a string S of length L. (Solved ✅)

// i First, check whether L is a perfect square without using any inbuilt functions like Math.sqrt(). If L is not a perfect square, return "Not a perfect square".
// ii If L is a perfect square, let M be its square root. Create an M x M 2D character array.
// iii Fill the 2D array row-wise with characters from S.
// iv Read the 2D array column-wise and return the resulting string.
// Input: "iegmlprioranvomg"
// Output: "iloveprogramming"

// 2 Problem Statement: (Solved ✅)
// A faulty keyboard is not working properly and behaves as follows:

// 🔹 Pressing 'r' → Reverses everything typed before it.
// 🔹 Pressing 'd' → Deletes the last character from the string.
// 🔹 Pressing 'u' → Converts the last entered word to uppercase (a word is a sequence of non-space characters).
// Input: "hello rworld rprogramming d u"
// Output: "dlrow hello PROGRAMMIN"

// 3 Problem Statement: (Solved ✅)
// You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.
// Return the array after sorting it.
 
// Example 1:
// Input: arr = [0,1,2,3,4,5,6,7,8]
// Output: [0,1,2,4,8,3,5,6,7]

// Pattern questions:

// ```
// 5 4 3 2 1
//   3 2 1
//      1
//   3 2 1 
// 5 4 3 2 1
// ```

// - Greedy stocks problem (LeetCode)
// - All palindrome substrings in a string
// - Kth element in 2 sorted arrays (without combining)
// - Intersection of intervals









        // String str="aaesdeaeeiohdufaaeeioou";
        // String word = "aeeeiiiioooauuuaeiou";
        // String word="maeiaaioaaaaeziiiihouuuzooaauuaeiugn";


        // int maxlen=0;
        // int maxstart=-1;

        // int start=0;
        // int distinct=0;
        // int lastindex=-1;

        // for(int i=0;i<word.length();i++){

        //     int curr=getindex(word.charAt(i));
        //     if(curr!=-1){

        //         if(curr<lastindex){
        //             start=i;
        //             distinct=0;
        //         }
        //         if(curr!=lastindex){
        //             distinct++;
        //         }
        //         lastindex=curr;
        //     }else{
        //         if(lastindex==4){
        //             if(distinct==5){
        //                 int len=i-start;
        //                 if(len>maxlen){
        //                     maxlen=len;
        //                     maxstart=start;
        //                 }
        //             }
        //             distinct=0;
        //             lastindex=-1;
        //         }
        //     }
        //     if(lastindex==4&&distinct==5){
        //         int len=i-start+1;
        //         if(len>maxlen){
        //             maxlen=len;
        //             maxstart=start;
        //         }
        //     }
        // }
       
        // if(maxlen==0)
        //     System.out.print("0");
        // else
        //     System.out.print(word.substring(maxstart,maxlen+maxstart));


        






        // String s="a1b2c34c3b2cb3a1d";
        // char[] arr=s.toCharArray();
        // int n=arr.length;

        // int ind=0;
        // for(int i=0;i<n;i++){
        //     char ch=arr[i];
        //     if(ch>='a'&&ch<='z'){
        //         boolean seenbefore=false;
        //         for(int j=0;j<i;j++){
        //             if(ch==arr[j]){
        //                 seenbefore=true;
        //                 break;
        //             }
        //         }
        //         if(!seenbefore){
        //             arr[ind++]=ch;
        //         }
        //     }else if(ch>='0'&&ch<='9'){
        //         boolean a=false;
        //         for(int j=i+1;j<n;j++){
        //             if(ch==arr[j]){
        //                 a=true;
        //                 break;
        //             }
        //         }
        //         if(!a)arr[ind++]=ch;
        //     }
        // }
        // for(int i=0;i<ind;i++){
        //     System.out.print(arr[i]);
        // }



        



        // in
        // t n=s.nextInt();
        // int mid=n/2;

        // for(int i=0;i<n;i++){

        //     int row=(i<=mid)?i:n-i-1;

        //     for(int k=0;k<mid-row;k++){
        //         System.out.print("  ");
        //     }
        //     // for(int j=0;j<=2*row;j++){
        //     //     if(j==0||j==2*row)System.out.print("1 ");
        //     //     else if(j%2==0)System.out.print("1 ");
        //     //     else System.out.print("* ");
        //     // }
        //     for (int j = 0; j < 2 * row + 1; j++) {
        //         if (j % 2 == 0)
        //             System.out.print("1 ");
        //         else
        //             System.out.print("* ");
        //     }
        //     System.out.println();

        // }








        // String text=s.next();
        // String pattern=s.next();
        // for(int i=0;i<text.length();i++){
        //     int t=i;
        //     int p=0;
        //     while(t<text.length()&&p<pattern.length()){
        //         char pc=pattern.charAt(p);
        //         if(p+1<pattern.length()&&pattern.charAt(p+1)=='*'){
        //             char prev=pc;
        //             while(t<text.length()&&text.charAt(t)==prev){
        //                 t++;
        //             }
        //             p+=2;
                    
        //         }else if(p+1<pattern.length()&&pattern.charAt(p+1)=='+'){
        //             char prev=pc;
        //             int count=0;
        //             while(t<text.length()&&text.charAt(t)==prev){
        //                 t++;
        //                 count++;
        //             }
        //             if(count==0)break;
        //             p+=2;

        //         }else{
        //             if(t<text.length()&&text.charAt(t)==pc){
        //                 t++;
        //                 p++;
        //             }else{
        //                 break;
        //             }
        //         }
        //     }
        //     if(p==pattern.length()){
        //         System.out.print(text.substring(i,t));
        //         break;
        //     }
        // }















        // String input=s.next();
        // int n=input.length();
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         if(i==j){
        //             System.out.print(input.charAt(i)+" ");
        //         }else if(i+j==n-1){
        //             System.out.print(input.charAt(i)+" ");
        //         }else{
        //             System.out.print("   ");
        //         }
        //     }
        //     System.out.println();
        // }



        // a1b10
        // String input=s.next();
        // int n=input.length();
        // char var=input.charAt(0);//
        // for(int i=1;i<n;i++){
        //     if(!Character.isDigit(input.charAt(i))){
        //         var=input.charAt(i);
        //     }else{
        //     int times=input.charAt(i)-'0';
        //     if(i+1<n&&Character.isDigit(input.charAt(i+1))){
        //         times=(times*10)+input.charAt(i+1)-'0';
        //         i++;
        //     }
        //     for(int j=0;j<times;j++){
        //         System.out.print(var);
        //     }
        // }
        // }




        // int n=s.nextInt();
        // int arr[]=new int[n];
        // for(int i=0;i<n;i++)arr[i]=s.nextInt();
        // System.out.println("Hello "+n);
        // for(int i=0;i<n;i++)System.out.println(arr[i]);
    }
}