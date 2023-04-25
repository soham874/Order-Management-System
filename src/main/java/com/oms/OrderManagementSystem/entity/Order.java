package com.oms.OrderManagementSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "OMS_ORDER_TABLE")
public class Order extends BaseAudit{

	@Id
	@Column(name = "ORDER_ID")
	Long id;
	
	@Column(name = "DESCRIPTION")
	String description;
	
	@NotNull
	@Column(name = "PRODUCT_ID")
	Long productId;
	
	@NotNull
	@Column(name = "VENDOR_ID")
	Long vendorId;
	
	@NotNull
	@Column(name = "QUANTITY")
	Integer quantity;
}
