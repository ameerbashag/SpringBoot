/**
 * 
 */
package com.eai.integration.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eai.integration.bank.bo.BankAccount;
import com.eai.integration.bank.services.BankAccountService;

/**
 * @author Ameer Godugu
 *
 */

@RestController
public class BankAccountController {
	
	@Autowired
    BankAccountService bankAccountService;

    @GetMapping("/accounts")
    private List<BankAccount> getAllAccounts() {
        return bankAccountService.getAllBankAccounts();
    }

    @GetMapping("/accounts/{id}")
    private BankAccount getAccount(@PathVariable("id") int id) {
        return bankAccountService.getBankAccountById(id);
    }
    
    @PutMapping("/accounts/{id}")
    private BankAccount updateAccount(@PathVariable("id") int id, @RequestBody BankAccount bankAccount) {
        bankAccountService.saveOrUpdate(bankAccount);
        return bankAccountService.getBankAccountById(id);
    }

    @DeleteMapping("/accounts/{id}")
    private void deleteAccount(@PathVariable("id") int id) {
        bankAccountService.delete(id);
    }

    @PostMapping("/accounts")
    private int createAccount(@RequestBody BankAccount bankAccount) {
        bankAccountService.saveOrUpdate(bankAccount);
        return bankAccount.getId();
    }

}
