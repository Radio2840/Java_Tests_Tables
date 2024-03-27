/**
 * Class that represents a node for a two-way list.
 * Field description:
 * value - is an int
 * previousNode - is a node of the two-way list | default: null
 * nextNode - is the node of the two-way list | default: null
 * **/

public class ListNode2 {

    public int value;
    ListNode2 previousNode = null;
    ListNode2 nextNode = null;

    public ListNode2(int value) {
        this.value = value;
    }
}
