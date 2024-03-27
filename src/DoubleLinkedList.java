/**
 * Class that is representation of two-way list.
 * Field description:
 * head - field of the ListNode2 class
 * tail - field of ListNode2 class
 * **/

public class DoubleLinkedList {
    ListNode2 head=null;
    // adding new node to the two-way list.
    public void add(int value) {
        ListNode2 newNode = new ListNode2(value);
        if (head == null) {
            head = newNode;
        } else {
            ListNode2 current = head;
            while (current.nextNode != null) {
                current = current.nextNode;
            }

            newNode.previousNode=current;
            current.nextNode = newNode;
        }
    }
    // displaying all elements of the list
    public void display() {
        if (head==null){
            System.out.print("[]\n");
            return;
        }
        ListNode2 current = head;
        System.out.print("[");
        while (current.nextNode != null) {
            System.out.print(current.value+", ");
            current = current.nextNode;
        }
        System.out.print(current.value+"]\n");
    }
    // removing one element of the list
    public void remove(int value) {
        if (head.value == value) {
            head = head.nextNode;
            head.previousNode = null;
            return;
        }
        ListNode2 current = head;
        while (current.nextNode != null) {
            if (current.nextNode.value == value) {
                current.nextNode = current.nextNode.nextNode;
                current.nextNode.previousNode = current;
                return;
            }
            current = current.nextNode;
        }
    }
    // searching for value in one of the nodes in the two-way list.
    public ListNode2 search(int value) {
        ListNode2 current = head;
        while (current != null) {
            if (current.value == value) {
                return current;
            }
            current = current.nextNode;
        }
        return null;
    }
}