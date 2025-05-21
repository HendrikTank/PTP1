// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package theLastThree;
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
 * The {@link LastThree} - see task
 * 
 * @author  Hendrik, Christoph Tank
 * @version v1.0.0
 */
public class LastThree {
    
    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    //
    // U.U. müssen Sie diesen Kommentar durch geeigneten Code ersetzen.
    // Sollte "hier" kein Code nötig sein, löschen diesen Kommentar einfach.
    //
    // Hier wäre die geeignete Stelle für mögliche 
    //      Zustandsvariablen / Exemplarvariablen = Objekt-spezifische Variablen oder
    //      (u.U. darauffolgend) einen Konstruktor,
    // sofern derartiges benötigt wird.
    // Es ist Ihre Entscheidung und sie sollte Sinn machen.
    //
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    
    // declare variables and initialize the counter variable
    // counter var initialized here to make sure printLastThree can be called at any time and return something (hint string)
    private int upto3Counter;
    private int oldest;
    private int middle;
    private int newest;
    
    /**
     * in the beginning there isn't any number known
     */
    public LastThree(){
        upto3Counter = 0;
    }//method()
    
    
    
    /**
     * print the last three numbers/values
     */
    public void printLastThree() {
        switch (upto3Counter) {
            case 0:
                System.out.println("Kein Wert");
            case 1:
                System.out.println(oldest);
            case 2:
                System.out.println(oldest + " " + middle);
            default:
                System.out.println(oldest + " " + middle + " " + newest);
        }
    }//method()
    
    /**
     * process new value
     * 
     * @param value  current value
     */
    public void processNewValue(int value) {
        // shift values each iteration
        oldest = middle;
        middle = newest;
        newest = value;
        if( upto3Counter<3 )  upto3Counter++;
    }//method()
    
}
