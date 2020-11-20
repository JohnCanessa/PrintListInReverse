import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


/**
 * This is the ImmutableListNode's API interface.
 * You should not implement it, or speculate about its implementation.
 */
interface ImmutableListNodeIn {
    public void printValue();               // print the value of this node.
    public ImmutableListNodeIn getNext();     // return the next node.
};


/**
 * Class implementation.
 * Not part of the solution!!!
 * Class part of the test scaffolding.
 */
class ImmutableListNode implements ImmutableListNodeIn {

    // **** ****
    public int val;
    public ImmutableListNode next;

    // **** constructor ****
    public ImmutableListNode(int val) {
        this.val = val;
        this.next = null;
    }

    // **** print value of node****
    @Override
    public void printValue() {
        System.out.print(this);
    }

    // **** get next node ****
    @Override
    public ImmutableListNode getNext() {
        return this.next;
    }

    // **** ****
    @Override
    public String toString() {
        return "" + val;
    }


    /**
     * Auxiliary function.
     */
    static ImmutableListNode populate(int[] arr) {

        // **** sanity checks ****
        if (arr.length == 0)
            return null;

        // **** allocate head node ****
        ImmutableListNode head = new ImmutableListNode(arr[0]);
        ImmutableListNode tail = head;

        // **** ****
        for (int i = 1; i < arr.length; i++) {

            // **** allocate node ****
            ImmutableListNode node = new ImmutableListNode(arr[i]);

            // **** insert node at tail of queue ****
            tail.next = node;

            // **** update tail ****
            tail = node;
        }

        // **** return the head of the list ****
        return head;
    }


    /**
     * The head to the queue is provided.
     * Approach using a stack.
     * 
     * Runtime: 8 ms, faster than 6.02% of Java online submissions.
     * Memory Usage: 39 MB, less than 17.14% of Java online submissions.
     */
    static void printLinkedListInReverse0(ImmutableListNode head) {

        // **** initialization ****
        Stack<ImmutableListNode> stack = new Stack<>();

        // **** push the head of the queue into the stack ****
        stack.add(head);

        // **** push all queue nodes into the stack ****
        ImmutableListNode node = head;
        while ((node = node.getNext()) != null) {
           stack.add(node);
        }

        // **** pop the stack printing the values ****
        while (!stack.isEmpty()) {
            node = stack.pop();
            node.printValue();
            System.out.print(" ");
        }
    }


    /**
     * The head to the queue is provided.
     * Recursive approach.
     * 
     * Runtime: 9 ms, faster than 6.02% of Java online submissions.
     * Memory Usage: 39 MB, less than 17.14% of Java online submissions.
     */
    static void printLinkedListInReverse1(ImmutableListNode head) {

        // **** base condition ****
        if (head == null) {
            return;
        }
        
        // **** recursive case ****
        printLinkedListInReverse1(head.getNext());

        // **** print node value ****
        head.printValue();

        // **** print separator ****
        System.out.print(" ");
    }


    /**
     * The head to the queue is provided.
     * Recursive approach.
     * No separators.
     * 
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 37.8 MB, less than 71.82% of Java online submissions.
     */
    static void printLinkedListInReverse(ImmutableListNode head) {

        // **** base case ****
        if (head == null) {
            return;
        }

        // **** recursive case ****
        printLinkedListInReverse(head.getNext());

        // **** print node value ****
        head.printValue();
    }


    /**
     * Test scaffolding
     */
    public static void main(String[] args) {

        // **** open scanner ****
        Scanner sc = new Scanner(System.in);

        // **** read line with node values ****
        String[] strs = sc.nextLine().trim().split(",");

        // **** close scanner ****
        sc.close();

        // **** ****
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }

        // ???? ????
        System.out.println("main <<< arr: " + Arrays.toString(arr));

        // **** populate the linked list ****
        ImmutableListNode head = populate(arr);

        // ???? ????
        System.out.print("main <<< head");
        for (ImmutableListNode p = head; p != null; p = p.next) {
            System.out.print(" -> " + p.toString());
        }
        System.out.println();

        // **** print linked list in reversed order ****
        System.out.print("main <<< reverse: ");
        printLinkedListInReverse0(head);
        System.out.println();

        // **** print linked list in reversed order ****
        System.out.print("main <<< reverse: ");
        printLinkedListInReverse1(head);
        System.out.println();

        // **** print linked list in reversed order ****
        System.out.print("main <<< reverse: ");
        printLinkedListInReverse(head);
        System.out.println();
    }
}
