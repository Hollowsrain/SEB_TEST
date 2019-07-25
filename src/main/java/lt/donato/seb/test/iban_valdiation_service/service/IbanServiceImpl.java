package lt.donato.seb.test.iban_valdiation_service.service;

import lt.donato.seb.test.iban_valdiation_service.hash.map.IbanLengthMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class IbanServiceImpl implements IbanService {
    @Override
    public boolean isIbanValidInput(String code) {
        boolean isValid;
        IbanLengthMap ibanLengthMap = new IbanLengthMap();
        if (ibanLengthMap.ibanLengthValidation(code)){
            code = code.substring(4) + code.substring(0, 4);
            isValid = modulOperationIBAN(ibanToNumber(code));
        } else
            isValid = false;
        return isValid;
    }

    @Override
    public void isIbanValidFile(MultipartFile file) {
        File outputFile = new File("ibans/Validation_results.out");

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String completeData = new String(bytes);
                String[] ibanlist = completeData.split("\r\n");
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
                    for (String string : ibanlist) {
                        bufferedWriter.write(string + ";" + isIbanValidInput(string) + ";\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String trimIBAN(String iban) {
        String[] cleanCode = iban.split("\r");
        cleanCode[0] = cleanCode[0].substring(5); ///cleanCode[0] is the IBAN
        return cleanCode[0];
    }

    @Override
    public String ibanToNumber(String iban) {
        String ibanAsNumber[] = iban.split("");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iban.length(); i++) {
            if (Character.isLetter(iban.charAt(i))) {
                int ascii = (int) iban.charAt(i);
                ascii = ascii - 55;
                ibanAsNumber[i] = Integer.toString(ascii);
            }
        }
        for (int i = 0; i < ibanAsNumber.length; i++) {
            stringBuilder.append(ibanAsNumber[i]);
        }
        return stringBuilder.toString();
    }

    private boolean modulOperationIBAN(String iban) {
        int i = 0;
        int j = 9;
        int N = 0;
        boolean isValid = false;
        while (j < iban.length() + 8) {
            if (i == 0) {
                N = Integer.parseInt(ibanToNumber(iban).substring(i, j));
                N = N % 97;
            } else if (j < iban.length()) {
                N = Integer.parseInt(N + "" + ibanToNumber(iban).substring(i, j));
                N = N % 97;
            } else {
                N = Integer.parseInt(N + "" + ibanToNumber(iban).substring(i, iban.length()));
                N = N % 97;
            }
            if (N == 1) {
                isValid = true;
            }
            i = j;
            j += 7;
        }
        return isValid;
    }

}