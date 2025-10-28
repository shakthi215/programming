// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// Example 2:

// Input: head = [1], n = 1
// Output: []
// Example 3:

// Input: head = [1,2], n = 1
// Output: [1]


 public class removeNthFromEnd {
      int val;
      removeNthFromEnd next;
      removeNthFromEnd() {}
      removeNthFromEnd(int val) { this.val = val; }
      removeNthFromEnd(int val, removeNthFromEnd next) { this.val = val; this.next = next; }
  }
class Solution {
    public removeNthFromEnd removeNthFromEnd(removeNthFromEnd head, int n) {
        removeNthFromEnd fast = head;
        removeNthFromEnd med = head;
        removeNthFromEnd slow = head;
        while(n!=0){
            fast=fast.next;
            n--;
        }
        if(fast==null){
            head=head.next;
            return head;
        }
        while(fast!=null){
            slow=med;
            med=med.next;
            fast=fast.next;
        }
        slow.next=med.next;
        return head;
    }
}