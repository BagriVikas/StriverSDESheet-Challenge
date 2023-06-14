import java.util.HashMap;
import java.util.Map;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;
    LinkedListNode<T> random;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class Solution {

    public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {

        Map<LinkedListNode<Integer>, LinkedListNode<Integer>> map = new HashMap<>();

        // to traverse the given linked list
        LinkedListNode<Integer> temp = head;

        while(temp != null) {

            LinkedListNode<Integer> node = temp;
            map.put(node, new LinkedListNode<>(node.data));
            temp = temp.next;

        }

        // again traversing the given linked list
        temp = head;

        while(temp != null) {

            LinkedListNode<Integer> cloneNode = map.get(temp);
            if(temp.next != null) {
                cloneNode.next = map.get(temp.next);
            }
            if(temp.random != null) {
                cloneNode.random = map.get(temp.random);
            }

            temp = temp.next;

        }

        if(map.isEmpty()) {
            return null;
        }

        return map.get(head);

    }

}
