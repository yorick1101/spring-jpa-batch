package me.yorick.poc.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import me.yorick.poc.jpa.model.Order;
import me.yorick.poc.jpa.repository.OrderRepository;
/**
 * Tests annotated with @DataJpaTest are transactional and roll back at the end of each test.
 * Batch operation will not work as expected if using embedded database H2
 * @author yorick
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // 使用真实的数据库
@Rollback(value = false)    //default is true, rollback after test
class OrderRepositoryTest {
	
	@Autowired
	private OrderRepository orderRepository;

	@Test
	void batchInsert() {
		int size = 10;
		List<Order> orders = OrderTestUtils.createOrders(size);
		List<Order> saved = orderRepository.saveAll(orders);
		assertEquals(size, saved.size());
	}

}
