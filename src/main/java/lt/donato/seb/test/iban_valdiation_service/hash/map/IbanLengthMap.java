package lt.donato.seb.test.iban_valdiation_service.hash.map;

import java.util.HashMap;

public class IbanLengthMap {
    HashMap<String, Integer> capitalCities;

    public IbanLengthMap() {
        capitalCities = new HashMap<>();
        capitalCities.put("NO", 15);
        capitalCities.put("BE", 16);
        capitalCities.put("FO", 18);
        capitalCities.put("GL", 18);
        capitalCities.put("DK", 18);
        capitalCities.put("FI", 18);
        capitalCities.put("NL", 18);
        capitalCities.put("MK", 19);
        capitalCities.put("SI", 19);
        capitalCities.put("AT", 20);
        capitalCities.put("BA", 20);
        capitalCities.put("EE", 20);
        capitalCities.put("KZ", 20);
        capitalCities.put("XK", 20);
        capitalCities.put("LT", 20);
        capitalCities.put("LU", 20);
        capitalCities.put("HR", 21);
        capitalCities.put("LV", 21);
        capitalCities.put("LI", 21);
        capitalCities.put("CH", 21);
        capitalCities.put("BH", 22);
        capitalCities.put("BG", 22);
        capitalCities.put("CR", 22);
        capitalCities.put("GE", 22);
        capitalCities.put("DE", 22);
        capitalCities.put("IE", 22);
        capitalCities.put("ME", 22);
        capitalCities.put("RS", 22);
        capitalCities.put("GB", 22);
        capitalCities.put("VA", 22);
        capitalCities.put("GI", 23);
        capitalCities.put("IL", 23);
        capitalCities.put("TL", 23);
        capitalCities.put("AE", 23);
        capitalCities.put("IQ", 23);
        capitalCities.put("AD", 24);
        capitalCities.put("CZ", 24);
        capitalCities.put("MD", 24);
        capitalCities.put("PK", 24);
        capitalCities.put("RO", 24);
        capitalCities.put("SA", 24);
        capitalCities.put("SK", 24);
        capitalCities.put("ES", 24);
        capitalCities.put("SE", 24);
        capitalCities.put("TN", 24);
        capitalCities.put("VG", 24);
        capitalCities.put("PT", 24);
        capitalCities.put("ST", 25);
        capitalCities.put("IS", 25);
        capitalCities.put("TR", 26);
        capitalCities.put("FR", 27);
        capitalCities.put("GR", 27);
        capitalCities.put("IT", 27);
        capitalCities.put("MR", 27);
        capitalCities.put("MC", 27);
        capitalCities.put("SM", 27);
        capitalCities.put("AL", 28);
        capitalCities.put("AZ", 28);
        capitalCities.put("CY", 28);
        capitalCities.put("DO", 28);
        capitalCities.put("GT", 28);
        capitalCities.put("HU", 28);
        capitalCities.put("LB", 28);
        capitalCities.put("PL", 28);
        capitalCities.put("BY", 28);
        capitalCities.put("SV", 28);
        capitalCities.put("BR", 29);
        capitalCities.put("PS", 29);
        capitalCities.put("QA", 29);
        capitalCities.put("UA", 29);
        capitalCities.put("JO", 30);
        capitalCities.put("KW", 30);
        capitalCities.put("MU", 30);
        capitalCities.put("MT", 31);
        capitalCities.put("SC", 31);
        capitalCities.put("LC", 32);
        
    }

    public boolean ibanLengthValidation(String iban){
        boolean isValid;
        if ((capitalCities.get(iban.substring(0,2)).equals(iban.length()))){
            isValid = true;
        } else{
            isValid = false;
        }
    return isValid;
    }

}