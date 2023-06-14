package br.com.carv.finance.model.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import br.com.carv.finance.model.enums.AccountingEntryStatus;
import br.com.carv.finance.model.enums.AccountingEntryType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AccountingEntryPutRequest(
		@NotNull
		UUID uuid,
		@NotBlank(message = "The field description cannot be empty")
		String description, 
		@NotNull(message = "The field unit price cannot be null")
		BigDecimal unitPrice, 
		@NotNull(message = "The field launched in cannot be null")
		LocalDate launchedIn, 
		@NotNull(message = "The field accounting entry type cannot be null")
		AccountingEntryType accountingEntryType, 
		@NotNull(message = "The field accounting entry type cannot be null")
		AccountingEntryStatus accountingEntryStatus) implements Serializable {

}
