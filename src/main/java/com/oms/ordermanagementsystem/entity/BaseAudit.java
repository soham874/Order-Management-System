package com.oms.ordermanagementsystem.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@FieldDefaults(level = AccessLevel.PROTECTED)
public class BaseAudit {
	
	@Column(name = "CREATED_TS", updatable = false, nullable = false)
	@CreatedDate
	LocalDateTime createdTs;
	
	@Column(name = "LAST_CHANGE_TS")
	@LastModifiedDate
	LocalDateTime lastChangeTs;
	
	@Column(name = "LAST_CHANGE_USER_ID")
	@LastModifiedBy
	String lastChangeUserId;

}
