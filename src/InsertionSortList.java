


public class InsertionSortList {
  public ListNode insertionSortList(ListNode head) {
   if(head == null ||head.next == null)
     return head;
   ListNode helper = new ListNode(0);
   ListNode prev = helper;
   ListNode current = head;
   ListNode next = null;
   while(current != null){
     
     next = current.next;
     while(prev.next != null && prev.next.val < current.val ){
       prev = prev.next;
     }
     
     current.next = prev.next;
     prev.next = current;
     prev = helper;
     current = next;
   }
   return helper.next;
  }
  
  public void printList(ListNode head){
    ListNode current = head;
    while(current != null){
      System.out.print(current.val + "->");
      current = current.next;
    }
    System.out.println();
  }
  
  public static void main(String[] args){
    InsertionSortList obj = new InsertionSortList();
    ListNode head = new ListNode(3);
    head.next = new ListNode(1);
    head.next.next = new ListNode(4);
    head.next.next.next = new ListNode(5);
    head.next.next.next.next = new ListNode(2);
    obj.printList(obj.insertionSortList(head));
  }
  
}
