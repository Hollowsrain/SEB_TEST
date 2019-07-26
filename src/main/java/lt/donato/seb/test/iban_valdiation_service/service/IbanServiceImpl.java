package lt.donato.seb.test.iban_valdiation_service.service;

import lt.donato.seb.test.iban_valdiation_service.hash.map.IbanLengthMap;
import lt.donato.seb.test.iban_valdiation_service.iban.service.util.IbanUtilsImpl;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IbanServiceImpl implements IbanService {
    IbanUtilsImpl ibanUtils = new IbanUtilsImpl();
    @Override
    public boolean isIbanValid(String code) {
        boolean isValid;
        IbanLengthMap ibanLengthMap = new IbanLengthMap();
        if (ibanLengthMap.ibanLengthValidation(code)){
            code = code.substring(4) + code.substring(0, 4);
            isValid = modulOperationIBAN(ibanUtils.ibanNumberAsString(code));
        } else
            isValid = false;
        return isValid;
    }

    @Override
    public void ibanValidationToFile(MultipartFile file) {
        File outputFile = new File("ibans/Validation_results.out");

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String completeData = new String(bytes);
                String[] ibanlist = completeData.split("\r\n");
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
                    for (String string : ibanlist) {
                        bufferedWriter.write(string + ";" + isIbanValid(string) + ";\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean modulOperationIBAN(String iban) {
        int i = 0;
        int j = 9;
        int N = 0;
        boolean isValid = false;
        while (j < iban.length() + 8) {
            if (i == 0) {
                N = Integer.parseInt(ibanUtils.ibanNumberAsString(iban).substring(i, j));
                N = N % 97;
            } else if (j < iban.length()) {
                N = Integer.parseInt(N + "" + ibanUtils.ibanNumberAsString(iban).substring(i, j));
                N = N % 97;
            } else {
                N = Integer.parseInt(N + "" + ibanUtils.ibanNumberAsString(iban).substring(i, iban.length()));
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