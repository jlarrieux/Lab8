//--------------------------------------------------------------------
//
//  Laboratory 8, In-lab Exercise 3            TestAnagramPuzzle.java
//
//  Test program for the operations in AnagramPuzzle
//
//--------------------------------------------------------------------

import java.io.*;

class TestAnagramPuzzle
{
    public static void main(String args[]) throws IOException 
    {
        char move;                                      // User input move
        boolean userQuit;                               // User quits puzzle

        String str1 = new String("yes");
        String str2 = new String("yse");

        AnagramPuzzle mysteryWord = new AnagramPuzzle(str1, str2);   // Puzzle
        
        // Display the initial puzzle.
        mysteryWord.display( );

        // Loop until puzzle solved or user quits
        userQuit = false;

        while ( !(mysteryWord.solved( )) && !userQuit )
        {
            System.out.print("Enter move ( L/S/Q ): ");   // Get user move
            move = (char)System.in.read( );
            while (Character.isWhitespace(move))          // ignore whitespace
                move = (char)System.in.read();
            
            switch ( move )                               // Process move
            {
                case 'L' : case 'l' :  
                    mysteryWord.shiftLeft( );  
                    break;
                case 'S' : case 's' :  
                    mysteryWord.swapEnds( );   
                    break;
                case 'Q' : case 'q' :  
                    userQuit = true;             
                    break;
                default:  
                    System.out.println("Invalid move");
            }
            mysteryWord.display( );                         // Display puzzle
        }
        if ( mysteryWord.solved( ) )
            System.out.println("Congratulations!");

    } // main
    
} // class TestAnagramPuzzle    

