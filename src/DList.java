//--------------------------------------------------------------------
//
//  Laboratory 8                                           DList.jshl
//
//  Class definitions for the circular, doubly linked list
//  implementation of the List ADT
//
//  The student is to complete all missing or incomplete method 
//     implementations for each class
//
//--------------------------------------------------------------------



// Facilitator class for the List class
class DListNode                     // A doubly linked list node
{


    // Data members
    private Object element;         // List element
    private DListNode prior,        // Reference to the previous element
            next;         // Reference to the next element


    // Constructor
    DListNode(Object elem, DListNode priorPtr, DListNode nextPtr) {
        setPrior(priorPtr);
        setNext(nextPtr);
        setElement(elem);
    }


    // Class Methods used by client class
    DListNode getNext()                    // Return reference to next element
    {
        return next;
    }


    DListNode setNext(DListNode nextVal)
    // Set reference to next element & return that reference
    {
        next = nextVal;
        return next;
    }


    DListNode getPrior()                   // Return reference to prior element
    {
        return prior;
    }


    DListNode setPrior(DListNode priorVal)
    // Set reference to prior element & return that reference
    {
        prior = priorVal;
        return prior;
    }


    Object getElement()                    // Return the element in the current node
    {
        return element;
    }


    void setElement(Object elem)
    // Set value of the element in the current node
    {
        element = elem;
    }

} // class DListNode



class DList implements List     //Circular, doubly linked list implementation of the
        //            List ADT
{


    // Data members
    private DListNode head,      // Reference to the beginning of the list
            cursor;    // Reference to current cursor position


    // Constructors & Helper Method
    public DList()             // Default constructor: Creates an empty list
    {
    }


    public DList(int size)    // Constructor: Creates an empty list, size is ignored
    {
    }


    // Class methods
    private void setup()
    // Called by constructors only: Creates an empty list
    {
    }

    //----- Insert method definitions for the interface List here -----//   


    @Override
    public void insert(Object newElement) {

    }


    @Override
    public void remove() {

    }


    @Override
    public void replace(Object newElement) {

    }


    @Override
    public void clear() {

    }


    @Override
    public boolean isEmpty() {
        return false;
    }


    @Override
    public boolean isFull() {
        return false;
    }


    @Override
    public boolean gotoBeginning() {
        return false;
    }


    @Override
    public boolean gotoEnd() {
        return false;
    }


    @Override
    public boolean gotoNext() {
        return false;
    }


    @Override
    public boolean gotoPrior() {
        return false;
    }


    @Override
    public Object getCursor() {
        return null;
    }


    public void showStructure()
    // Outputs the elements in a list. If the list is empty, outputs
    // "Empty list". This operation is intended for testing and
    // debugging purposes only.
    {
        DListNode p;   // Iterates through the list

        if (head == null)
            System.out.println("Empty list");
        else {
            p = head;
            do {
                if (p == cursor)
                    System.out.print("[" + p.getElement() + "] ");
                else
                    System.out.print(p.getElement() + " ");
                p = p.getNext();
            } while (p != head);
            System.out.println();
        }
    }


    // In-lab opertions -- not declared in interface List
    public void reverse()
    // Reverses the order of the elements in a list. The cursor does
    // not move. 
    {
    }

} // class DList