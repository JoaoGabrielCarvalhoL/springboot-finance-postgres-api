package br.com.carv.finance.model.entity;

import java.io.Serial;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.com.carv.finance.model.GenericEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "tb_user")
@Entity
public class User extends GenericEntity {

	@Serial
	private static final long serialVersionUID = 0L;
	
	@Column(nullable = false, length = 100)
	private String name; 
	
	@Column(nullable = false, length = 100, unique = true)
	private String email;
	
	@Column(nullable = false, length = 100, unique = true)
	private String username; 
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false, length = 11) 
	private String documentCertificatePerson;
	
	@Column(nullable = true, length = 8) 
 	private String cep; 
	
	@Column(nullable = true, length = 14)
	private String cellphone;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDate birthDate;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	private List<AccountingEntry> accountingEntrys;
	
	public User() { }
	
	public User(String name, String email, String username, String password, String documentCertificatePerson) {
		this.name = name; 
		this.email = email; 
		this.username = username; 
		this.password = password;
		this.documentCertificatePerson = documentCertificatePerson;
	}
	
	public User(String name, String email, String username, String password, String documentCertificatePerson, 
			String cep, String cellphone, LocalDate birthDate) {
		this.name = name; 
		this.email = email; 
		this.username = username; 
		this.password = password;
		this.documentCertificatePerson = documentCertificatePerson;
		this.cep = cep;
		this.cellphone = cellphone; 
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDocumentCertificatePerson() {
		return documentCertificatePerson;
	}

	public void setDocumentCertificatePerson(String documentCertificatePerson) {
		this.documentCertificatePerson = documentCertificatePerson;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public List<AccountingEntry> getAccountingEntrys() {
		return accountingEntrys;
	}
	
	public void setAccountingEntrys(List<AccountingEntry> accountingEntrys) {
		this.accountingEntrys = accountingEntrys;
	}
	
}

