package pl.banking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.banking.service.BankAccountService;
import pl.banking.service.wrappers.BankAccountDto;

import javax.validation.Valid;

/**
 * Created by dpp on 5/23/17.
 */

@Controller
public class BankAccountCreationController {

    private BankAccountService bankAccountService;

    @RequestMapping (path = "/open_account", method = RequestMethod.GET)
    public String registerAccount(Model model) {
        model.addAttribute("bankAccount", new BankAccountDto());
        return "/open_account";
    }

    @RequestMapping (path = "/register", method = RequestMethod.POST)
    public String registerAccount(@Valid @ModelAttribute("bankAccount") BankAccountDto bankAccountDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/open_account";
        }
        bankAccountService.openBankAccount(bankAccountDto);
        return "redirect:/open_account";
    }

}
