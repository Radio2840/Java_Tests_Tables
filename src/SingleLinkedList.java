/**
 * class that represents a one-way list
 * It contains a field such as:
 * head - which is the beginning of the list
 * **/

public class SingleLinkedList {
    private ListNode head;

    public SingleLinkedList() {
        this.head = null;
    }
    // adding node on the end of the list
    public void add(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.nextNode != null) {
                current = current.nextNode;
            }
            current.nextNode = newNode;
        }
    }

    // displaying all elements of the list
    public void display() {
        if (head==null){
            System.out.print("[]\n");
            return;
        }
        ListNode current = head;
        System.out.print("[");
        while (current.nextNode != null) {
            System.out.print(current.value+", ");
            current = current.nextNode;
        }
        System.out.print(current.value+"]\n");
    }

    // deleting one of the nodes
    public void remove(int value) {
        if (head == null) {
            System.out.println("Tablica jest pusta");
            return;
        }
        if (head.value == value) {
            head = head.nextNode;
            return;
        }
        ListNode current = head;
        while (current.nextNode != null) {
            if (current.nextNode.value == value) {
                current.nextNode = current.nextNode.nextNode;
                return;
            }
            current = current.nextNode;
        }
    }


    // searching for value in the list
    public ListNode search(int value) {
        ListNode current = head;
        while (current.nextNode != null) {
            if (current.nextNode.value == value) {
                return current.nextNode;
            }
            current = current.nextNode;
        }
        return null;
    }
}
