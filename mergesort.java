public class mergesort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}





//in linkedlist

// import java.util.*;

// public class Main {
//     static class Node {
//         int data;
//         Node next;
//     }

//     public static Node head = null;

//     public static void append(int data) {
//         Node newnode = new Node();
//         newnode.data = data;
//         newnode.next = null;
//         if (head == null) {
//             head = newnode;
//         } else {
//             Node temp = head;
//             while (temp.next != null) {
//                 temp = temp.next;
//             }
//             temp.next = newnode;
//         }
//     }

//     // Merge two sorted linked lists
//     public static Node merge(Node l1, Node l2) {
//         Node dummy = new Node();
//         Node tail = dummy;

//         while (l1 != null && l2 != null) {
//             if (l1.data <= l2.data) {
//                 tail.next = l1;
//                 l1 = l1.next;
//             } else {
//                 tail.next = l2;
//                 l2 = l2.next;
//             }
//             tail = tail.next;
//         }

//         if (l1 != null) tail.next = l1;
//         if (l2 != null) tail.next = l2;

//         return dummy.next;
//     }

//     // Find middle and split list
//     public static Node findMiddle(Node head) {
//         if (head == null || head.next == null) return head;
//         Node slow = head, fast = head, prev = null;

//         while (fast != null && fast.next != null) {
//             prev = slow;
//             slow = slow.next;
//             fast = fast.next.next;
//         }

//         if (prev != null) prev.next = null;  // Split the list into two halves
//         return slow;
//     }

//     // Merge sort driver
//     public static Node mergeSort(Node head) {
//         if (head == null || head.next == null) return head;

//         Node mid = findMiddle(head);
//         Node left = mergeSort(head);
//         Node right = mergeSort(mid);

//         return merge(left, right);
//     }

//     public static void mergesort() {
//         head = mergeSort(head);
//     }

//     public static void display() {
//         Node temp = head;
//         while (temp != null) {
//             System.out.print(temp.data + " ");
//             temp = temp.next;
//         }
//     }

//     public static void main(String sdsd[]) {
//         Scanner s = new Scanner(System.in);
//         int n = s.nextInt();
//         for (int i = 0; i < n; i++) {
//             int val = s.nextInt();
//             append(val);
//         }
//         mergesort();
//         display();
//     }
// }
