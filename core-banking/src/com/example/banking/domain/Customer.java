package com.example.banking.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Customer {
	private final String identity;
	private String fullName;
	private List<Account> accounts = new ArrayList<>();

	public Customer(String identity, String fullName) {
		this.identity = identity;
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIdentity() {
		return identity;
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	// Overloading: Same class & method name, different signature
	// Overriding: Inherited Classes, same method name & signature
	public Optional<Account> removeAccount(int index) {
		if (index < 0 || index >= accounts.size())
			return Optional.empty();
		return Optional.of(accounts.remove(index));
	}

	public Optional<Account> removeAccount(String iban) {
		Account foundAccount = null;
		for (var account : accounts) {
			if (account.getIban().equals(iban)) {
				foundAccount = account;
				break;
			}
		}
		if (Objects.nonNull(foundAccount)) {
			accounts.remove(foundAccount);
		}
		return Optional.ofNullable(foundAccount);
	}

	public List<Account> getAccounts() {
		return Collections.unmodifiableList(accounts);
	}

	@Override
	public String toString() {
		return "Customer [identity=" + identity + ", fullName=" + fullName + ", accounts=" + accounts + "]";
	}

}
