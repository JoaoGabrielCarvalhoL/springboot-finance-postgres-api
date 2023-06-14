package br.com.carv.finance.model.entity;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.com.carv.finance.model.GenericEntity;
import br.com.carv.finance.model.enums.AccountingEntryStatus;
import br.com.carv.finance.model.enums.AccountingEntryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "tb_accounting_entry")
@Entity
public class AccountingEntry extends GenericEntity {
	
	@Serial
	private static final long serialVersionUID = 0L;
	
	@Column(nullable = false, length = 150)
	private String description;
	
	@Column(nullable = false, scale = 2, precision = 8)
	private BigDecimal unitPrice;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDate launchedIn;
	
	@ManyToOne
	private User user;
	
	@Enumerated(EnumType.STRING)
	private AccountingEntryType accountingEntryType;
	
	@Enumerated(EnumType.STRING)
	private AccountingEntryStatus accountingEntryStatus;
	
	public AccountingEntry() { }
	
	public AccountingEntry(String description, BigDecimal unitPrice, LocalDate launchedIn, 
			AccountingEntryType accountingEntryType, AccountingEntryStatus accountingEntryStatus, User user) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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

