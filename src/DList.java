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
        setup();
    }


    public DList(int size)    // Constructor: Creates an empty list, size is ignored
    {
        System.out.printf("Attempting to create an unbounded DList with a size %d. Size argument will be ignored!\n ", size);
        setup();
    }


    // Class methods
    private void setup()
    // Called by constructors only: Creates an empty list
    {
        head = null;
    }

    //----- Insert method definitions for the interface List here -----//   


    @Override
    public void insert(Object newElement) {
        DListNode now;
        if(head==null){
            head = new DListNode(newElement,null, null);
            cursor = head;
        }
        else if(head==cursor){
            now =new DListNode(newElement,cursor,cursor.getNext());
            head.setNext(now);
            cursor = now;
        }
        else {
            now = new DListNode(newElement, cursor, cursor.getNext());
            cursor.setNext(now);
            cursor = now;
        }

    }


    @Override
    public void remove() {
//        System.out.printf("Prior: %s\tCurrent: %s\t\n", cursor.getPrior().getElement(), cursor.getElement());
        if(isEmpty())System.out.println("Attempting to remove an element from an empty list!");
        if(head==cursor){
            if(cursor.getNext()!=null){
                head = cursor.getNext();
                cursor = head;
            }
            else head=null;
        }
        else {
            cursor.getPrior().setNext(cursor.getNext());
            if(cursor.getNext()==null){

                cursor= head;
            }
            else cursor = cursor.getNext();

        }

    }


    @Override
    public void replace(Object newElement) {
        if(isEmpty())System.out.println("Attempting to replace element from an empty list!");
        else cursor.setElement(newElement);

    }


    @Override
    public void clear() {
        head = null;
    }


    @Override
    public boolean isEmpty() {
        if(head==null)return true;
        else  return false;
    }


    @Override
    public boolean isFull() {
        return false;
    }


    @Override
    public boolean gotoBeginning() {
        if(isEmpty()){
            System.out.println("Attempting to go to beginning of an empty list!");
            return false;
        }
        else {
            cursor = head;
            return true;
        }
    }


    @Override
    public boolean gotoEnd() {
        if(isEmpty()){
            System.out.println("Attempting to go to end of an empty list!");
            return false;
        }
        else {
            while(cursor.getNext()!=null){
                cursor = cursor.getNext();
            }
            return true;
        }


    }


    @Override
    public boolean gotoNext() {
        if(isEmpty()){
            System.out.println("Attempting to go to next element of an empty list!");
            return false;
        }
        else if(cursor.getNext()==null) {
            System.out.println("Already at end of the list, cannot go to next element!");
            return false;
        }
        else {
            cursor = cursor.getNext();
            return true;
        }

    }


    @Override
    public boolean gotoPrior() {
        if(isEmpty()){
            System.out.println("Attempting to go to prior element of an empty list!");
            return false;
        }
        else if(cursor.getPrior()==null) {
            System.out.println("Already at beginning of the list, cannot go to prior element!");
            return false;
        }
        else {
            cursor = cursor.getPrior();
            return true;
        }
    }


    @Override
    public Object getCursor() {
        return cursor.getElement();
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
            } while (p != null);
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