public class SolutionOptimized {

    public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {

        if(head == null) {
            return null;
        }

        // Step 1: Clone all the nodes of the given linked list
        LinkedListNode<Integer> temp = head;
        while(temp != null) {

            LinkedListNode<Integer> cloneNode = new LinkedListNode<>(temp.data);
            cloneNode.next = temp.next;
            temp.next = cloneNode;
            temp = cloneNode.next;

        }

        // Step 2: Maintain 'random' pointers in the cloned linked list
        temp = head;
        while(temp != null) {

            if(temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;

        }

        // Step 3: Separate the given linked list and the clone linked list
        //         Keeps the given linked list intact
        //         Also keep track of the head of the clone linked list
        LinkedListNode<Integer> cloneHead = head.next;

        LinkedListNode<Integer> ptrClone = head.next;
        LinkedListNode<Integer> ptrOriginal = head;

        while(ptrOriginal != null) {

            ptrOriginal.next = ptrClone.next;
            ptrOriginal = ptrOriginal.next;
            if(ptrOriginal != null) {
                ptrClone.next = ptrOriginal.next;
                ptrClone = ptrClone.next;
            }

        }

        return cloneHead;

    }

}
