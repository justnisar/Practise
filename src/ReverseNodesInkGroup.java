class ListNode{
  int val;
  ListNode next;
  public ListNode(int val){
    this.val = val;
    next = null;
  }
}

public class ReverseNodesInkGroup {
  
  
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
 
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode result = null;
    //return result;
    int length = getListLength(head);
    int index = 0;
    while(index + k <= length){
      
      
      index += k;
    }
    return result;
  }
  
  public static void main(String[] args){
    ReverseNodesInkGroup obj = new ReverseNodesInkGroup();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    obj.printList(head);
    obj.printList(obj.reverseList(head));
  }
  
}
