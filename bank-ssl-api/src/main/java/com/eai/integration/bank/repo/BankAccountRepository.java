/**
 * 
 */
package com.eai.integration.bank.repo;

import org.springframework.data.repository.CrudRepository;

import com.eai.integration.bank.bo.BankAccount;

/**
 * @author Ameer Godugu
 *
 */
public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
