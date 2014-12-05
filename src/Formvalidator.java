import sum.komponenten.*;
import sum.kern.Farbe;
import java.util.*;

/**
 * SuM Form Validator
 * The SuM Form Validator provides a simple check
 * for the SuM textinputs.
 *
 * @author Marius Kiessling
 * @version 17.11.2014
 */
public class Formvalidator {

    final int NUMERIC_VALIDATION = 1;
    final int ALPHANUMERIC_VALIDATION = 2;
    final boolean VALID = true;
    final boolean INVALID = false;

    private boolean debugging = false;
    protected int mainValidationMode;
    List<Textfeld> elements = new ArrayList<Textfeld>();

    /**
     * This method is called on creation. The only
     * purpose is to set the main validationmode.
     * @param int mainValidationMode The main validation mode for every form field.
     * @return Nothing.
     */
    public Formvalidator(int mainValidationMode) {
        this.setMainValidationMode(mainValidationMode);
    }

    /**
     * This method registers the passed form field to
     * the fields that will be checked in the validate
     * method.
     * @param Textfeld field The form field that should be registred.
     * @return Nothing.
     */
    public void register(Textfeld field) {
        this.elements.add(field);
    }

    /**
     * This method validates all registred form fields. If no
     * field is registred the method will do nothing and return
     * an error.
     * @return boolean If error accrued return false if not true.
     */
    public boolean validate() {
        if(this.elements.size() == 0) {
            System.err.println("ERROR: No elements registred! Validation aborted!");

            return false;
        } else {
            boolean error = false;

            if(debugging == true) {
                System.out.println("Validation stareted with " + this.elements.size() + " elements and validation mode " + this.mainValidationMode + "!");
            }

            for(Textfeld currentField : this.elements){

                if(this.mainValidationMode == NUMERIC_VALIDATION) {
                    if(this.numericValidation(currentField)) {
                        error = false;
                        this.debugValidationItem(currentField, VALID);
                    } else {
                        error = true;
                        this.debugValidationItem(currentField, INVALID);
                    }
                }

                if(this.mainValidationMode == ALPHANUMERIC_VALIDATION) {
                    if(this.alphanumericValidation(currentField)) {
                        error = false;
                        this.debugValidationItem(currentField, VALID);
                    } else {
                        error = true;
                        this.debugValidationItem(currentField, INVALID);
                    }
                }
            }

            if(error == true) {
                return false;
            } else {
                return true;
            }

        }
    }

    /**
     * This method is called by the validate method if the
     * main validation mode is a numeric validation.
     * @param Textfeld field The form field that will be checked.
     */
    private boolean numericValidation(Textfeld field) {
        //Remove all Spaces
        field.setzeInhalt(field.inhaltAlsText().replaceAll("\\s+",""));

        if(field.inhaltAlsText().matches("[0-9]+")) {
            this.displayValidation(field, VALID);
            return VALID;
        } else {
            this.displayValidation(field, INVALID);
            return INVALID;
        }
    }

    /**
     * This method is called by the validate method if the
     * main validation mode is a alphanumeric validation.
     * @param Textfeld field The form field that will be checked.
     */
    private boolean alphanumericValidation(Textfeld field) {
        if(field.inhaltAlsText().length() != 0) {
            this.displayValidation(field, VALID);
            return VALID;
        } else {
            this.displayValidation(field, INVALID);
            return INVALID;
        }
    }

    /**
     * The method is called by the numeric or alphanumeric validation
     * method. It displays the results of the validation in the UI of
     * the form based on the passed variable.
     * @param Textfeld field The form field that will be changed/ colored.
     * @param boolean status The status of the passed form field.
     */
    private void displayValidation(Textfeld field, boolean status) {
        //Reset Colors
        field.setzeFarbe(Farbe.WEISS);
        field.setzeSchriftFarbe(Farbe.SCHWARZ);

        if(status == INVALID) {
            field.setzeFarbe(Farbe.ROT);
            field.setzeSchriftFarbe(Farbe.WEISS);
        }
    }

    /**
     * This method is only called if debugging is enabled and
     * prints the last validated form field and its status.
     * @param Textfeld field The form field that was checked last
     * @param boolean status The status of the passed form field.
     */
    private void debugValidationItem(Textfeld field, boolean status) {
        if(debugging == true) {
            if(status == true) {
                System.out.println("Validation Status: '" + field + "' is valid!");
            } else {
                System.err.println("Validation Status: '" + field + "' is invalid!");
            }
        }
    }

    /**
     * This method sets the debugging mode to on/ off.
     * @param boolean status The status of debugging.
     */
    public void setDebugging(boolean status) {
        this.debugging = status;
    }

    /**
     * This method returns the current mode of debugging.
     * @return boolean The mode of debugging.
     */
    public boolean getDebugging() {
        return this.debugging;
    }

    /**
     * This method sets the main validation mode to the passed
     * mode. The mode can be 1 for numeric validation and 2 for
     * alphanumeric validation.
     * @param int mainValidationMode The validation mode that will be set.
     * @return boolean Returns false if an error occurred.
     */
    public boolean setMainValidationMode(int mainValidationMode) {
        if(mainValidationMode == 1 || mainValidationMode == 2) {
            this.mainValidationMode = mainValidationMode;
            return true;
        } else {
            System.err.println("ERROR: Invalid validation mode! The validation mode was not set!");
            return false;
        }
    }

    /**
     * This method returns the main validation mode.
     * @return int The validation mode for all form fields.
     */
    public int getMainValidationMode() {
        return this.mainValidationMode;
    }

}