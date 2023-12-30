package workshop2_linked_list;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> integerLinkedList = new LinkedList<Integer>();

        integerLinkedList.addNode(1);
        integerLinkedList.addNode(2);
        integerLinkedList.addNode(3);
        integerLinkedList.display();
        
        integerLinkedList.addNode(4);

        integerLinkedList.display();

        integerLinkedList.reverseLinkedList();

        integerLinkedList.display();
    }
    
}
