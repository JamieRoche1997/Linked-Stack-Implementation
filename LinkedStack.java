import java.util.EmptyStackException;

/**
 * A class of stacks whose entries are stored in a singly linked list
 *
 * @author Jing Hua Ye
 * @date Oct 26 2021
 * @version 1.0
 */
 public class LinkedStack<T> implements StackInterface<T> {
/* =============================================================================
                        HELPER CLASSES
   =============================================================================
 */

    /**
     * A class represents a node, which contains two parts - data and pointer
     * to the next node
     */
    private class Node {    //the data of a node
        private T data;
        //pointer to the next node
        private Node next;

        /**
         * To create a new node instance with a specific data and pointer of
         * the next node
         *
         * @param data the data of a specific node
         * @param next the pointer of a specific next node
         */
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        /**
         * To get the data of this node
         *
         * @return the data of this Node
         */
        public T getData() {
            return data;
        }

        /**
         * To get the pointer of the next node
         *
         * @return the pointer of the next Node
         */
        public Node getNextNode() {
            return next;
        }

        /**
         * To set the data of this node
         *
         * @param data the data of this node
         */
        public void setData(T data) {
            this.data = data;
        }

        /**
         * To set the pointer of next node
         *
         * @param nextNode the pointer of the next node
         */
        public void setNextNode(Node nextNode) {
            next = nextNode;
        }
    }

    /*==============================================================================
                            INSTANCE VARIABLES
      ==============================================================================
    */
    //Reference the first node in the chain
    private Node top;

    //the size of the stack
    private int numNodes;

/*==============================================================================
                      CONSTRUCTORS
  ==============================================================================
*/

    /**
     * To create a default stack implemented with a singly linked List
     */
    public LinkedStack() {
        this.top = null;
        //to-complete
    }
/* =============================================================================
                     INSTANCE METHODS
   =============================================================================
 */
    /* ------------------- Getters -----------------------------------------------*/

    /**
     * Count the number of entries in this stack
     *
     * @return the number of entries in this stack
     */
    public int size() {
        Node temp = top;
        int size = 0;
        while(temp != null)
        {
            size += 1;
            temp = temp.next;
        }
        return size;
        //to-complete
    }

    /* ------------------- Other methods -----------------------------------------*/

    /**
     * Detects whether this stack is empty by checking whether the first node is
     * a null pointer or not
     *
     * @return true if the stack is empty
     */
    public boolean isEmpty() {
        return top == null;
        //to-complete
    }

    /**
     * Retrieves this stack's top entry
     *
     * @return the object at the top of the stack
     * @throws EmptyStackException if the stack is empty before the operation
     */
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        return top.data;
        //to-complete
    }

    /**
     * Removes and returns this stack's top entry
     *
     * @return the object at the top of the stack
     */
    public T pop() {
        if (top == null) {
            System.out.print("\nStack Empty");
        }
        else{
            T top = peek();
            this.numNodes -= 1;
            this.top = this.top.next;
            return top;
        }
        return null;
    }
        //to-complete

    /**
     * Adds an entry to the top of this stack
     *
     * @param newEntry an object to be added to the stack
     */
    public void push(T newEntry) {
        Node newNode = new Node(newEntry, null);

        newNode.data = newEntry;

        newNode.next = top;

        top = newNode;
        //to-complete
    }

    /**
     * Removes all entries from this stack
     */
    public void clear() {
        this.top = null;
        //to-complete
    }

    /**
     * List out all entries in this stack
     */
    public void display() {
        if (top == null) {
            System.out.print("\nStack Empty");
        }
        else {
            Node temp = top;
            while (temp != null) {

                // print node data
                System.out.print(temp.data);

                // assign temp link to temp
                temp = temp.next;
                if(temp != null)
                    System.out.print(" -> ");
                else
                    System.out.println();
            }
        }
            //to-complete
    }
}
