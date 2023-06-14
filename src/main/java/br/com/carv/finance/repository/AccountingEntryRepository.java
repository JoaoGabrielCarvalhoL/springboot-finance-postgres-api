package br.com.carv.finance.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carv.finance.model.entity.AccountingEntry;

public interface AccountingEntryRepository extends JpaRepository<AccountingEntry, UUID> {

}
