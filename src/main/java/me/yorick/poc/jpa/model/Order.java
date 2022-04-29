package me.yorick.poc.jpa.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order {
	
	@Id
    private String id;
	
	private String customerId;
	private String product;
	
	private double price;
	private double amount;
	private LocalDateTime openTimestamp;
	private LocalDateTime updateTimestamp;
	private BuySell buySell;
	private OrderStatus status;
}
