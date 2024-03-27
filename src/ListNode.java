/**
 * A class which is a reprezition of a single value in a one-way list.
 * It contains fields:
 * value -field of numeric type
 * nextNode - field which is of type ListNode and stores the next ListNode object | default:null
 * **/


public class ListNode {
    public int value;
    ListNode nextNode;

    public ListNode(int value) {
        this.value = value;
        this.nextNode = null;
    }
}
