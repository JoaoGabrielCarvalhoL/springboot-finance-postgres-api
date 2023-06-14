package br.com.carv.finance.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@MappedSuperclass
public abstract class GenericEntity implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID uuid;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime createdAt;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime updatedAt;
	
	private Boolean isActive;
	
	public UUID getUuid() {
		return this.uuid;
	}
	
	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}
	
	public LocalDateTime getUpdatedAt() {
		return this.updatedAt;
	}
	
	public Boolean getIsActive() {
		return this.isActive;
	}
	
	private void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	private void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
	private void setupCreated() {
		setCreatedAt(LocalDateTime.now());
	}
	
	@PreUpdate
	private void setupUpdated() {
		setUpdatedAt(LocalDateTime.now());
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericEntity other = (GenericEntity) obj;
		return Objects.equals(uuid, other.uuid);
	}
	
	
}
