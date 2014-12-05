package formvalidator;

import sum.komponenten.*;

/**
 * Storage container for validation options
 * of fields.
 *
 * @author Marius Kiessling
 * @version 06.12.2014
 */
public class Field {

    Textfeld textfeld;
    Textbereich textbereich;

    public Field(Textfeld field) {
        this.textfeld = field;
    }


}
