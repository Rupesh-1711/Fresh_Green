package com.freshgreen.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CurrentUserSession {

	@Id
	@Column(unique = true)
	private Integer id;
	private String uuid;
	private LocalDateTime localDateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public CurrentUserSession(Integer id, String uuid, LocalDateTime localDateTime) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}

	
}
