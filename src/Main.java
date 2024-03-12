
class Element{
    int data;
    Element next=null;

    public Element (int data){
        this.data=data;
    }
}
class OneWayList {
    Element first=null;

    public void append(int data){
        Element new_el=new Element(data);

        if (first == null){
            first = new_el;
            return;
        }

        Element current = first;
        while (current.next!=null){
            current=current.next;
        }

        current.next = new_el;
    }

    public void remove(int data){
        if (first.data==data){
            first=first.next;
            return;
        }
        Element current = first;
        while (current.next!=null){
            if (current.next.data==data){
                current.next=current.next.next;
                return;
            }
            current=current.next;
        }
    }

    public boolean includes(int data){
        Element current = first;
        while (current != null){
            if (current.data==data){
                return true;
            }
            current=current.next;
        }
        return false;
    }

    public void show(){
        Element current = first;
        while (current != null){
            System.out.println(current.data);
            current=current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        OneWayList list = new OneWayList();

        list.append(2);
        list.append(4);
        list.append(231);
        list.show();
        System.out.println(list.includes(2));

        list.remove(2);
        list.append(5);
        list.show();
        System.out.println(list.includes(2));

    }
}