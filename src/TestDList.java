//--------------------------------------------------------------------
//
//  Laboratory 8                                       TestDList.java
//
//  Test program for the operations in the List ADT
//
//--------------------------------------------------------------------

import java.io.*;
    
class TestDList
{
    public static void main(String args[]) throws IOException 
    {
        DList testList = new DList( );      // Test list
        char testElement = 'x';             // List element
        char cmd;                           // Input command
        
        System.out.println("\nCommands:");
        System.out.println("  +x  : Insert x after the cursor");
        System.out.println("  -   : Remove the element marked by the cursor");
        System.out.println("  =x  : Replace the element marked by the cursor with x");
        System.out.println("  @   : Display the element marked by the cursor");
        System.out.println("  <   : Go to the beginning of the list");
        System.out.println("  >   : Go to the end of the list");
        System.out.println("  N   : Go to the next element");
        System.out.println("  P   : Go to the prior element");
        System.out.println("  C   : Clear the list");
        System.out.println("  E   : Empty list?");
        System.out.println("  F   : Full list?");
        System.out.println("  R   : Reverse the list                       " +
                           "(Inactive : In-lab Ex. 1)");
        System.out.println("  #   : Display list size and cursor position  " +
                           "(Inactive : In-lab Ex. 2)");
        System.out.println("  Q   : Quit the test program");
        System.out.println( );
        
        do
        {
            testList.showStructure( );                    // Output list
            System.out.println( );
            System.out.print("Command: ");                // Read command
            cmd = (char)System.in.read( );
            while (Character.isWhitespace(cmd))           // ignore whitespace
                cmd = (char)System.in.read();
            
            if ( cmd == '+'  ||  cmd == '=' )
            {
                testElement = (char)System.in.read();
                if (Character.isWhitespace(testElement))  // testElement is whitespace
                    System.out.print("Element to add: ");
                while (Character.isWhitespace(testElement))
                    testElement = (char)System.in.read(); // get valid testElement
            }   
            
            switch ( cmd )
            {
                case '+' :                                // insert
                    System.out.println("Insert " + testElement);
                    testList.insert(new Character(testElement));
                    break;
                    
                case '-' :                                  // remove
                    System.out.println("Remove the element marked by the cursor");
                    testList.remove();
                    break;
                    
                case '=' :                                  // replace
                    System.out.println("Replace the element marked by the cursor " +
                                       "with " + testElement);
                    testList.replace(new Character(testElement));
                    break;
                    
                case '@' :                                  // getCursor
                    System.out.println("Element marked by the cursor is " +
                                       testList.getCursor());
                    break;
                    
                case '<' :                                  // gotoBeginning
                    if ( testList.gotoBeginning() )
                        System.out.println("Go to the beginning of the list");
                    else
                        System.out.println("Failed -- list is empty");
                    break;
                    
                case '>' :                                  // gotoEnd
                    if ( testList.gotoEnd() )
                        System.out.println("Go to the end of the list");
                    else
                        System.out.println("Failed -- list is empty");
                    break;
                    
                case 'N' : case 'n' :                       // gotoNext
                    if ( testList.gotoNext() )
                        System.out.println("Go to the next element");
                    else
                        System.out.println("Failed -- either at the end of the list " +
                                           "or the list is empty");
                    break;
                    
                case 'P' : case 'p' :                       // gotoPrior
                    if ( testList.gotoPrior() )
                        System.out.println("Go to the prior element");
                    else
                        System.out.println("Failed -- either at the beginning of the " +
                                           "list or the list is empty");
                    break;
                    
                case 'C' : case 'c' :                       // clear
                    System.out.println("Clear the list");
                    testList.clear();
                    break;
                    
                case 'E' : case 'e' :                       // empty
                    if ( testList.isEmpty() )
                        System.out.println("List is empty");
                    else
                        System.out.println("List is NOT empty");
                    break;
                
                case 'F' : case 'f' :                       // full
                    if ( testList.isFull() )
                        System.out.println("List is full");
                    else
                        System.out.println("List is NOT full");
                    break;

             case 'R' : case 'r' :                   // In-lab Exercise 1
                 System.out.println("Reverse the list");
                 testList.reverse();
                 break;
//R

//#             case '#' :                              // In-lab Exercise 2
//#                 System.out.print("size = " + testList.length() + " ");
//#                 if ( !testList.isEmpty() )
//#                     System.out.println(" position = " + testList.position());
//#                 break;
                    
                case 'Q' : case 'q' :                   // Quit test program
                    break;
                    
                default :                               // Invalid command
                    System.out.println("Inactive or invalid command");
            } // switch
    
        } while ( cmd != 'Q'  &&  cmd != 'q' );
                    
    } // main
    
} // class TestDList