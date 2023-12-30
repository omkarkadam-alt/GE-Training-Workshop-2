package workshop2_linked_list;

public class LinkedList<T> {
    
    Node<T> head;
    
    void addNode(T data){
        Node <T> newNode = new Node<T>(data);
        if(head == null){
            head = newNode;
        }else{
            Node<T> temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void display(){
        Node<T> temp = head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void reverseLinkedList(){

        if(head == null || head.getNext() == null)
            return;

        Node<T> prev = null;
        Node<T> curr = head;
        Node<T> nextNode = null;

        while(curr.next != null){

            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            
        }

        curr.next = prev;

        head = curr;
    }
}
