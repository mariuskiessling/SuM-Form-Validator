/**
 * Just an example class to show the usage of the validator class.
 *
 * @author Marius Kiessling
 * @version 17.11.2014
 */

import sum.komponenten.*;
import sum.werkzeuge.*;
import sum.ereignis.*;

public class ValidatorExample extends EBAnwendung {
    // Objekte
    private Textfeld feld1;
    private Textfeld feld2;
    private Knopf knopf1;

    Formvalidator formvalidator;

    public static void main(String[] args) {
        ValidatorExample validatorExample = new ValidatorExample();
    }

    public ValidatorExample() {
        super(255, 100);

        formvalidator = new Formvalidator(1);

        feld1 = new Textfeld(23, 23, 100, 25, "");
        feld1.setzeAusrichtung(Ausrichtung.LINKS);

        feld2 = new Textfeld(139, 23, 100, 25, "");
        feld2.setzeAusrichtung(Ausrichtung.LINKS);

        knopf1 = new Knopf(62, 60, 120, 25, "Test Validation");
        knopf1.setzeBearbeiterGeklickt("knopf1Pressed");

        formvalidator.register(feld1);
        formvalidator.register(feld2);

        formvalidator.setDebugging(true);
    }

    public void knopf1Pressed() {
        formvalidator.validate();
    }

}