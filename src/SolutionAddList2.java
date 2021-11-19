/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class SolutionAddList2 {
    /**
     * @param l1: The first list.
     * @param l2: The second list.
     * @return: the sum list of l1 and l2.
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        ListNode res = null;
        ListNode a1 = l1; 
        ListNode a2 = l2;
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();

        while(a1 != null) {
            num1.add(a1.val);
            a1 = a1.next;
        }
        while(a2 != null) {
            num2.add(a2.val);
            a2 = a2.next;
        }

        ListNode prev = null;
        int over = 0;
        int i = num1.size()-1;
        int j = num2.size()-1;

        while(i >= 0 && j >= 0) {
            ListNode curr = new ListNode((num1.get(i) + num2.get(j) + over) % 10);
            over = (num1.get(i) + num2.get(j) + over) / 10;
            curr.next = prev;
        
            prev = curr;
            i--;
            j--;
        }
        while(i >= 0) {
            ListNode curr = new ListNode((num1.get(i) + over) % 10);
            over = (num1.get(i) + over) / 10;
            curr.next = prev;
        
            prev = curr;
            i--;
        }

        while(j >= 0) {
            ListNode curr = new ListNode((num2.get(j) + over) % 10);
            over = (num2.get(j) + over) / 10;
            curr.next = prev;
        
            prev = curr;
            j--;
        }
        if(over != 0) {
            ListNode curr = new ListNode(over % 10);
            curr.next = prev;
        
            prev = curr;
        }
        return prev;
    }
}