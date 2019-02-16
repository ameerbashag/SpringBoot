/**
 * 
 */
package com.eai.integration.bank.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eai.integration.bank.bo.BankAccount;
import com.eai.integration.bank.repo.BankAccountRepository;

/**
 * @author Ameer Godugu
 *
 */
public class BankAccountService {
	
	
	@Autowired
    BankAccountRepository bankAccountRepository;

    public List<BankAccount> getAllBankAccounts() {
        List<BankAccount> bankAccounts = new ArrayList<BankAccount>();
        bankAccountRepository.findAll().forEach(bankAccount -> bankAccounts.add(bankAccount));
        return bankAccounts;
    }

    public BankAccount getBankAccountById(int id) {
        return bankAccountRepository.findById(id).get();
    }

    public void saveOrUpdate(BankAccount bankAccount) {
    	bankAccountRepository.save(bankAccount);
    }

    public void delete(int id) {
    	bankAccountRepository.deleteById(id);
    }

}
