package hbcu.stay.ready.phone;

import hbcu.stay.ready.exceptions.InvalidPhoneNumberFormatException;
import hbcu.stay.ready.tools.RandomNumberFactory;


import java.util.logging.Level;
import java.util.logging.Logger;


public final class PhoneNumberFactory extends RandomNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        PhoneNumber[] phoneNumberArray = new PhoneNumber [phoneNumberCount];
        for (int i = 0; i < phoneNumberArray.length; i++){
            phoneNumberArray[i] = createRandomPhoneNumber();
        }

        return phoneNumberArray;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {

    int areaCode = createInteger(100, 999);
    int centralOfficeCode = createInteger(100, 999);
    int phoneLineCode = createInteger(1000,9999);

    return createPhoneNumberSafely(areaCode, centralOfficeCode,phoneLineCode);
    }


      //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {

        String phoneNumber = "(" + areaCode + ")" + "-"+centralOfficeCode + "-" + phoneLineCode;
        try {
            return createPhoneNumber(phoneNumber);
        }
        catch(InvalidPhoneNumberFormatException e){
            logger.log(Level.WARNING, phoneNumber+"is not a valid phone number");
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        logger.log(Level.WARNING, "Attempting to create a new PhoneNumber object with a value of "+phoneNumberString);

        PhoneNumber phoneNumber = new PhoneNumber(phoneNumberString);

       return phoneNumber;

    }
}
