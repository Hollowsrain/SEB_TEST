package lt.donato.seb.test.iban_valdiation_service.service;

import org.springframework.web.multipart.MultipartFile;

public interface IbanService {

    boolean isIbanValid(String code);

    void ibanValidationToFile(MultipartFile file);

}
