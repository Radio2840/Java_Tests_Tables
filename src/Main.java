


public class
Main {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(10);
        singleLinkedList.add(200);
        singleLinkedList.add(2137);
        singleLinkedList.add(10);
        singleLinkedList.add(9);
        singleLinkedList.add(340);
        singleLinkedList.add(5);
        singleLinkedList.remove(340);
        System.out.println(singleLinkedList.search(2137));
        singleLinkedList.display();

    }


}