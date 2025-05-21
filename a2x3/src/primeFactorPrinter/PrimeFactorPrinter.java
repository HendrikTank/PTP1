// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package primeFactorPrinter;
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Wir erinnern uns: NIEMALS verschiedene Sprachen in einem Programm mixen.
 * Oder konkreter: Entweder Code, Variablen und Kommentar in deutsch oder in englisch.
 * Es gelten die in der Vorlesung besprochenen Regeln.
 * Es lohnt sich immer, die Vorlesungsinhalte zu kennen ;-)
 * 
 * Auch ist diese Art von Kommentar KEIN guter Kommentar.
 * Wir nutzen den Kommentar "hier" für Erklärungen und Ausführungen zur
 * Aufgabenstellung. Es  gilt "hier" die Regel:
 *  o) "Kommentar" der Kommentar ist in englisch.
 *  o) "Kommentar" der die Aufgabenstellung vertieft in deutsch.
 *     Löschen Sie derartigen Kommentar vor der Abgabe.
 * 
 * Im Rahmen der Aufgabenstellung müssen Sie GUTEN Kommentar schreiben.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */


/**
 * PFP :  {@link PrimeFactorPrinter} - see task.
 * 
 * @author  (Hendrik, Christoph Tank) 
 * @version (1.0.0)
 */
public class PrimeFactorPrinter {
    
    /**
     * print factorization of given number
     * 
     * @param number the number to be factorized
     */
    public void printFactorization( long number ){
        // handling for 0 input (special case)
    	if (number == 0) {
            System.out.print("0 = 0");
            return;
        }
    	// handling for 1 input (special case)
        if (number == 1) {
            System.out.print("1 = 1");
            return;
        }
        
        // check if number is negative, if true, use absolute
        boolean isNegative = number < 0;
        long value = isNegative ? -number : number; // use conditional operator to return absolute value by negating the value variable
        
        // first console output
        System.out.print(number + " = ");

        boolean firstFactor = true; // flag for tracking first value
        
        // if neg, use -1 for first value
        if (isNegative) {
            System.out.print("-1");
            firstFactor = false;
            // if value is 1 after negation
            if (value == 1) {
                return;
            }
            System.out.print(" * ");
            firstFactor = true; // reset for remaining values (to get "-1 * x * ...)
        }

        // Handle factor 2
        while (value % 2 == 0) {
            if (firstFactor) {
                System.out.print("2");
                firstFactor = false;
            } else {
                System.out.print("*2");
            }
            value /= 2; // div value by 2 each time its a factor
        }

        // Handle odd factors
        long primeFactorCandidate = 3;
        long sqrtN = integerSquareRoot(value); // ref helper method, call with value
        while (primeFactorCandidate <= sqrtN) {
            // divisor divs value in while loop until modulo is 0
            while (value % primeFactorCandidate == 0) {
                if (firstFactor) {
                    System.out.print(primeFactorCandidate);
                    firstFactor = false;
                } else {
                    System.out.print("*" + primeFactorCandidate);
                }
                value /= primeFactorCandidate; //value = value/divider
                sqrtN = integerSquareRoot(value); // update after division
            }
            primeFactorCandidate += 2;// increment counter
            sqrtN = integerSquareRoot(value); // update for next iteration
        }// maybe do

        // Handle remaining prime factor
        if (value > 1) {
            if (firstFactor) {
                System.out.print(value);
            } else {
                System.out.print("*" + value);
            }
        }

        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        // Sofern Sie kein Vorwissen haben und/oder NICHT wissen was Sie tun
        // führen Sie KEINE! Änderungen unterhalb dieser Zeilen durch.
        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        //
        System.out.flush();
    }//method()
    
    
    
    
    
    
    
    
    
    
    // Den folgenden Code selbst müssen Sie NICHT verstehen!
    // Wichtig für Sie ist nur das Interface.
    //      long integerSquareRoot( long )
    // und der folgende JavaDoc-Kommentar, der Ihnen erklärt
    // wie Sie "integerSqrt()" nutzen.
    //
    // Programmierenanfängern wird ausdrücklich davon abgeraten, die nachfolgende Implementierung verstehen zu wollen.
    // Denn für das Verständnis sind deutlich weniger Programmierenkenntnisse, als Mathematikkenntnisse erforderlich.
    // Kurz: Anfänger können anders ihre Programmierenkenntnisse deutlich effizienter&effektiver stärken.
    // Jedoch, das Interface bzw. die Dokumentation der Funktionalität (der JavaDoc-Kommentar) ist wichtig.
    //
    // (p)/last time touched 2023_03_20 by Michael Schaefers
    /**
     * Trial-Subtraction ::= Optimiertes Intervall-Schachtelungs-Verfahren<br />
     * Für Herleitung siehe:
     *  TI4 CE oder
     *  ARM System Developer's Guide; Designing and Optimizing System Software;
     *  Andrew Sloss, Dominic Symes, Chris Wright;
     *  Chap.7.4.1, 238p<br />
     * <br />
     * 
     * Die Methode {@link #integerSqrt()} berechnet eine ganzzahlige Wurzel einer als Parameter übergebenen Zahl.
     * Der Vorteil dieser Methode gegenüber Math.sqrt() besteht darin, dass hier KEINE Rundungsfehler auftreten.
     * Auch wenn Math.sqrt() (im double-Wertebereich) "korrekte" Ergebnisse liefern sollte,
     * so können immer noch Rundungsfehler bei der Wandlung nach long auftreten.
     * <br />
     * Achtung! Das Ergebnis ist vom Typ long. Der Namensteil integer drückt nur aus, dass das berechnete Ergebnis ganzzahlig ist.<br />
     * <br />
     * Für das Ergebnis gilt:<br />
     * w = integerSqrt(x)    =>    ( (w+1)*(w+1) > x )   &&   ( w*w <= x )
     * 
     * @param value  der Wert von dem die ganzzahlige Wurzel bestimmt werden soll
     * 
     * @return die ganzzahlige Wurzel
     */
    public long integerSquareRoot( final long value ){
        if( 0 > value )  throw new IllegalArgumentException( String.format( "Parameter %d has to be positive",  value ));
        
        
        long approximation = 0;                                                 // the approximation itself
        if( value < (1L<<62) ){
            //\=> can be handled the fast way
            
            // determine msb position of approximation resp. later sqrt  resp. start position of "walking one setter"
            long tmp = value;                                                   // temporary to determine maxb position of approximation
            int currentBitPosition = 0;                                         // current bit position where setting of bit is tested
            if( 0 < tmp ){
                tmp >>>= 2;
                approximation = 1;
                while( 0 < tmp ){
                    tmp >>>= 2;
                    approximation <<= 1;
                    currentBitPosition++;
                }//while
                
                // start of actual integer square root computation
                // compute integer square root with: w = integerSqrt(x)    =>    (w+1)*(w+1) > x  &&  w*w <= x 
                long remainder = value - (approximation<<currentBitPosition);
                do{
                    final long refinement = 1L<<currentBitPosition;
                    final long trialResult =  remainder  -  (((approximation<<1) + refinement) << currentBitPosition);
                    if( 0 <= trialResult ){
                        remainder = trialResult;
                        approximation += refinement;
                    }//while
                    currentBitPosition--;
                }while( currentBitPosition >= 0 );
            }//if
            
        }else{
            //\=> Math.sqrt() is used that might result in rounding errors less or equal than +/-512
            // and further:
            //      9_223_372_024_852_248_004   =  3_037_000_498 * 3_037_000_498
            //      9_223_372_030_926_249_001   =  3_037_000_499 * 3_037_000_499
            //      9_223_372_036_854_775_807   =  Long.MAX_VALUE
            //      square-root(Long.MAX_VALUE) =  3037000499.9760496924513885
            // Hence, 
            //      9_223_372_030_926_249_001 is the last (integer) square and
            //                  3_037_000_499 is the last (integer) square root
            //      inside long range
            // if  approximation is greater than 3_037_000_498  than..
            // ..approximation must be 3_037_000_499  since square is inside "long range"
            //
            //
            // Achtung obiges ist "hier" in unserem Anwendungsfall nicht relevant,
            // da die Mantisse eines double ausreicht um die Wurzel eines long ohne Rundungsfehler aufzunehmen.
            // Im Rahmen dieser Aufgabe ist der Eingabewert/Parameter value auf den Datentyp long limitiert.
            // Es kann "hier" daher keine Rundungsfehler bei der Darstellung des Ergebnisses geben.
            // Jedoch wie funktioniert Math.sqrt() intern - können Rundungsfehler bei der internen Berechnung auftreten???
            //
            final long lastSquare = 9_223_372_030_926_249_001L;
            final long lastSquareRoot = 3_037_000_499L;                                     // lastSquare = lastSquareRoot *lastSquareRoot
            if( lastSquare <= value ){
                approximation = lastSquareRoot;                                             // SC#1 resp. special case #1
            }else{
                //\=>  value < lastSquare 
                approximation = (long)( Math.sqrt( value ));
                if( lastSquareRoot < approximation )  approximation = lastSquareRoot;       // SC#2 resp. special case #2
                final long square = approximation * approximation;
                if( square <= value ){                                                      // as result of SC#1 and SC#2 uncritical
                    //\=> incrementation of integer approximation might be necessary
                    while( (approximation+1) * (approximation+1) <= value ){                // will stop when approximation+1=lastSquareRoot as result of SC#1 and SC#2
                        approximation++;
                    }//while
                }else{
                    //\=> decrement integer approximation
                    do{
                        approximation--;
                    }while( (approximation-1) * (approximation-1) >= value );
                }//if
            }//if
        }//if
        
        return approximation;
    }//method()
    
}//class
