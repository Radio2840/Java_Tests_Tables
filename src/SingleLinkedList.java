public class SingleLinkedList {
    private ListNode head;

    public SingleLinkedList() {
        this.head = null;
    }

    // Funkcja która dodaje wartości do tablicy
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

    // funkcja wyświetlająca wartości w tablicy
    public void display() {
        if (head==null){
            System.out.print("[]\n");
            return;
        }
        ListNode current = head;
        System.out.print("[");
        while (current.nextNode != null) {
            System.out.print(STR."\{current.value}, ");
            current = current.nextNode;
        }
        System.out.print(STR."\{current.value}]\n");
    }

    // funkcja która usuwa wybrany element w tablicy
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

    // funkcja która wyszukuje pierwsze wystąpienie elementu i go zwraca

    public ListNode search(int value) {
        ListNode current = head;
        while (current.nextNode != null) {
            if (current.nextNode.value == value) {
                return current.nextNode;
            }
            current = current.nextNode;
        }
        System.out.println("Nie znaleziono");
        return null;
    }
}
