//--------------------------------------------------------------------
//
//  Laboratory 8, In-lab Exercise 3               AnagramPuzzle.jshl
//
//  (Shell) Anagram puzzle
//
//  The student is to complete all missing or incomplete method 
//     implementations for this class
//
//--------------------------------------------------------------------

// Simulates a puzzle in which a player attempts to unscramble a
// set of letters to form a word.

class AnagramPuzzle
{
    // Data members
    private DList solution;         // Solution to puzzle
    private DList puzzle;           // Current puzzle configuration

    // Constructor
    public AnagramPuzzle( String answ, String init) // Construct puzzle
    {               }

    // Class methods
    public void shiftLeft( )        // Shift letter left
    {               }
    public void swapEnds( )         // Swap end letters
    {               }
    public void display( )          // Display puzzle
    {               }
    
    public boolean solved( )        
    // Returns true if a puzzle is solved. Otherwise returns false.
    {
        // Start at the beginning of the lists
//        if (                                                      )
//        {
//            // Cursor characters which must be initialized
//            // Note: since Object is returned by getCursor, it must be
//            //       cast to Character
//            Character solCh = (Character)solution.getCursor( ),
//                      puzCh = (Character)puzzle.getCursor( );
//
//            while (                                                 )
//            {
//
//
//
//            }
//
//            // must use Character.equals(Character) to determine
//            //  if solCh and puzCh contain the same value
//            //  solCh == puzCh only checks if their reference/address
//            //    (not their values/contents) are the same
//            return ( solCh.equals( puzCh ));
//        }
//        else
            return false;
    }
    
} // class AnagramPuzzle 
