// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package primeFactorPrinter;


import stuffBeginnersDontHaveToUnderstand.Herald;


//###
//### Wenn Sie einen eigenen TestFrame entwickeln - was ausdrücklich gut wäre,
//### dann sollten Sie den Klassennamen (mit "Refactoring") ändern
//### Z.B. in  MyAlternativeTestFrame
//###
//### Ein Nachteil des gestellten TestFrames besteht darin, dass er interaktiv ist
//### und damit für reproduzierbare Testläufe eigentlich NICHT geeignet ist.
//### "Hier" sollten Sie Tests entwickeln, die leicht reproduzierbar sind,
//### damit Sie im Falle eines gefundenen Fehlers auch (leicht) testen können, dass Sie
//###   1.) den Fehler wirklich korrigiert und
//###   2.) keine neuen Fehler bei bereits sicheren Code eingebaut
//### haben.
//###
/**
 * Your alternative TestFrame for {@link PrimeFactorPrinter}.
 * 
 * @author   (your name(s))  based on template from Michael Schaefers
 * @version  (a version number or a date)
 */
public class AlternativeTestFrameAndStarter {
    
    /**
     * method to start test
     * 
     * @param unused  is unused ;-)
     */
    public static void main( final String... unused ){
        try{
            final PrimeFactorPrinter pfp = new PrimeFactorPrinter();
            
            
            
            //VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
            // Sofern Sie kein Vorwissen haben und/oder NICHT wissen was Sie tun
            // führen Sie (bis auf die Änderung des Klassennamens)
            // KEINE Änderungen oberhalb dieser Zeilen durch
            //###
            //###
            //###
            //###   HIER kommt Ihr Code zum Testen hin ;-)
            //###
            //###                    VVVV
            //###                    VVVV
            //###                    VVVV
            //###   VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
            //###      VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
            //###         VVVVVVVVVVVVVVVVVVVVVVVVVV
            //###            VVVVVVVVVVVVVVVVVVVV
            //###               VVVVVVVVVVVVVV
            //###                  VVVVVVVV
            //###                     VV
            
            
         // Predefined test cases
            System.out.println("\n--- Testing Edge Cases ---");
            pfp.printFactorization(0);   // 0 = 0
            System.out.println("\n\n---");
            pfp.printFactorization(1);   // 1 = 1
            System.out.println("\n\n---");
            pfp.printFactorization(-15); // -15 = -1 * 3 * 5

            System.out.println("\n\n--- Testing Sample Inputs ---");
            pfp.printFactorization(12);             // 2*2*3
            System.out.println("\n\n---");
            pfp.printFactorization(768);            // 2^8 * 3
            System.out.println("\n\n---");
            pfp.printFactorization(9223372036854775807L); // 7*7*73*...*649657

            // Add more test cases as needed
            System.out.println("\n\n--- Large Numbers ---");
            pfp.printFactorization(37513856612736L);
            System.out.println("\n\n---");
            pfp.printFactorization(950052134362500L);
            
            
            
            
            
            //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
            // Sofern Sie kein Vorwissen haben und/oder NICHT wissen was Sie tun
            // führen Sie KEINE Änderungen unterhalb dieser Zeilen durch.
            //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
            //
            System.out.printf( "\n\n" );
            System.out.printf( "THIS IS THE END" );
            System.out.flush();
            
        }catch( final Throwable ex ){
            if( ! (( ex instanceof AssertionError ) || ( ex instanceof IllegalArgumentException ))){
                final StringBuilder sb = new StringBuilder( "\n" );
                sb.append( "###\n" );
                sb.append( "### Uuuupppss, was ist denn da passiert ????\n" );
                sb.append( "###\n" );
                Herald.proclaimError( sb );
            }//if
            throw( ex );
        }//try
    }//method()
    
}//class
