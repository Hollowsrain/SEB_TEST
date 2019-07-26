package lt.donato.seb.test.iban_valdiation_service.iban.service.util;

public class IbanUtilsImpl implements IbanUtilsService {

    @Override
    public String trimIBAN(String iban) {
        String[] cleanCode = iban.split("\r");
        cleanCode[0] = cleanCode[0].substring(5); ///cleanCode[0] is the IBAN
        return cleanCode[0];
    }

    @Override
    public String ibanNumberAsString(String iban) {
        String[] ibanAsNumber = iban.split("");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iban.length(); i++) {
            if (Character.isLetter(iban.charAt(i))) {
                int ascii = (int) iban.charAt(i);
                ascii = ascii - 55;
                ibanAsNumber[i] = Integer.toString(ascii);
            }
        }
        for (String s : ibanAsNumber) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }



}
