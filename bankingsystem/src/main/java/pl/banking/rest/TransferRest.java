package pl.banking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.banking.service.TransferService;
import pl.banking.service.wrappers.TransferDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/transfers")
public class TransferRest {

    private final TransferService transferService;

    @Autowired
    public TransferRest(TransferService transferService) {
        this.transferService = transferService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void makeTransfer(@RequestBody @Valid TransferDto transferDto) {
        transferService.makeTransfer(transferDto);
    }
}
