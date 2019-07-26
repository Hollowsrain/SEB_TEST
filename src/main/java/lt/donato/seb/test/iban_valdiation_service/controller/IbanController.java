package lt.donato.seb.test.iban_valdiation_service.controller;

import lt.donato.seb.test.iban_valdiation_service.iban.service.util.IbanUtilsImpl;
import lt.donato.seb.test.iban_valdiation_service.service.IbanService;
import lt.donato.seb.test.iban_valdiation_service.service.IbanServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/iban")
public class IbanController {

    private IbanService ibanService = new IbanServiceImpl();
    private IbanUtilsImpl ibanUtils = new IbanUtilsImpl();

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public boolean checkSingleIban(@RequestBody() String code) {
        return ibanService.isIbanValid(ibanUtils.trimIBAN(code));
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public void checkIbanFile(@RequestParam("file") MultipartFile file) {
        ibanService.ibanValidationToFile(file);
    }

}