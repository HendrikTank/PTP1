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
 * @author  (your name(s)) 
 * @version (a version number or a date)
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
    

    private int count = 0;
    private int oldest;
    private int middle;
    private int newest;
    
    /**
     * in the beginning there isn't any number known
     */
    public LastThree(){
        // U.U. muss hier Code ergänzt werden.
        // ... ???
    }//method()
    
    
    
    /**
     * print the last three numbers/values
     */
    public void printLastThree() {
        if (count >= 3) {
            System.out.println(oldest + " " + middle + " " + newest);
        } else if (count == 2) {
            System.out.println(oldest + " " + middle);
        } else if (count == 1) {
            System.out.println(oldest);
        }
    }//method()
    
    /**
     * process new value
     * 
     * @param value  current value
     */
    public void processNewValue(int value) {
        if (count < 3) {
            switch (count) {
                case 0:
                    oldest = value;
                    break;
                case 1:
                    middle = value;
                    break;
                case 2:
                    newest = value;
                    break;
            }
            count++;
        } else {
            oldest = middle;
            middle = newest;
            newest = value;
        }
    }//method()
    
}
