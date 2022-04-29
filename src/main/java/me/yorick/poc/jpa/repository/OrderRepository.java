package me.yorick.poc.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.yorick.poc.jpa.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
	
	

}
