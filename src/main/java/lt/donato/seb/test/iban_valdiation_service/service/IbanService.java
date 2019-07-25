package lt.donato.seb.test.iban_valdiation_service.service;

import org.springframework.web.multipart.MultipartFile;

public interface IbanService {

    boolean isIbanValidInput(String code);

    void isIbanValidFile(MultipartFile file);

    String trimIBAN(String iban);

    String ibanToNumber(String iban);

}
