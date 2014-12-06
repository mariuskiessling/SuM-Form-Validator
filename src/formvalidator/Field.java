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

    final int NUMERIC_VALIDATION = 1;
    final int ALPHANUMERIC_VALIDATION = 2;

    private Textfeld textfeld;
    private Textbereich textbereich;
    private int validationMode;
    private int type;

    public Field(Textfeld field) {
        this.textfeld = field;
    }

    public Textfeld getTextfeld() {
       return this.textfeld;
    }

    public Textbereich getTextbereich() {
        return this.textbereich;
    }



    public int getValidationMode() {
        return validationMode;
    }

    public void setValidationMode(int validationMode) {
        this.validationMode = validationMode;
    }

    public boolean isAllowComma() {
        return allowComma;
    }

    public void setAllowComma(boolean allowComma) {
        this.allowComma = allowComma;
    }

    private boolean allowComma;


}
