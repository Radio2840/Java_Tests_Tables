/**
 * Klasa która jest reprezętacją pojedyńczej wartości w tablicy
 * Zawieta ona pola:
 * value - wartość liczbowa dla pojedyńczego elementu tablicy
 * nextNode - wartość która jest elementem tablicy która wskazuje na następny element
 * **/


public class ListNode {
    public int value;
    ListNode nextNode;

    public ListNode(int value) {
        this.value = value;
        this.nextNode = null;
    }
}
