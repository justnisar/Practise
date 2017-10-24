
public class ListUtility {
  
  public void printList(ListNode head){
    ListNode current = head;
    while(current != null){
      System.out.print(current.val);
      if(current.next != null)
        System.out.print("->");
      current = current.next;
    }
    System.out.println();
  }
  
  public int getListLength(ListNode head){
    ListNode current = head;
    int count = 0;
    while(current != null){
      count++;
      current = current.next;
    }
    return count;
  }
  
  public ListNode reverseList(ListNode head){
    if(head == null || head.next == null)
      return head;
    ListNode prev = null;
    ListNode next = null;
    ListNode current = head;
    while(current != null){
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }
}
