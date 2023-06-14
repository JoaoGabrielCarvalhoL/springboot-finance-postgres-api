package br.com.carv.finance.model.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.carv.finance.model.enums.AccountingEntryStatus;
import br.com.carv.finance.model.enums.AccountingEntryType;

public class AccountingEntryResponse {

	private String description;
	private BigDecimal unitPrice;
	private LocalDate launchedIn;
	private UserResponse user;
	private AccountingEntryType accountingEntryType;
	private AccountingEntryStatus accountingEntryStatus;
	
	public AccountingEntryResponse() { }

	public AccountingEntryResponse(String description, BigDecimal unitPrice, LocalDate launchedIn, 
			AccountingEntryType accountingEntryType, AccountingEntryStatus accountingEntryStatus, UserResponse user) {
		this.description = description; 
		this.unitPrice = unitPrice; 
		this.launchedIn = launchedIn;
		this.accountingEntryType = accountingEntryType; 
		this.accountingEntryStatus = accountingEntryStatus; 
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public LocalDate getLaunchedIn() {
		return launchedIn;
	}

	public void setLaunchedIn(LocalDate launchedIn) {
		this.launchedIn = launchedIn;
	}

	public UserResponse getUser() {
		return user;
	}

	public void setUser(UserResponse user) {
		this.user = user;
	}

	public AccountingEntryType getAccountingEntryType() {
		return accountingEntryType;
	}

	public void setAccountingEntryType(AccountingEntryType accountingEntryType) {
		this.accountingEntryType = accountingEntryType;
	}

	public AccountingEntryStatus getAccountingEntryStatus() {
		return accountingEntryStatus;
	}

	public void setAccountingEntryStatus(AccountingEntryStatus accountingEntryStatus) {
		this.accountingEntryStatus = accountingEntryStatus;
	}

}
