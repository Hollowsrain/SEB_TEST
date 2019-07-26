package lt.donato.seb.test.iban_valdiation_service.iban.service.util;

public interface IbanUtilsService {

    String trimIBAN(String iban);

    String ibanNumberCode(String iban);

}