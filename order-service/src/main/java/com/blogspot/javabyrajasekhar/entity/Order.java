package com.blogspot.javabyrajasekhar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ORDER_TBL")
public class Order {

	@Id
	@GeneratedValue
	private int orderId;
	private String name;
	private int qty;
	private double price;
}
