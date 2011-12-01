package com.abc.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.abc.sample.dao.OrderDao;
import com.abc.sample.domain.Order;
import com.abc.sample.domain.OrderItem;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class OrderEntityTest extends AbstractTestNGSpringContextTests {	
	
	@Autowired
	private OrderDao orderDao;
	
	@Test
	public void test() {
		
		Order order = new Order();		
		order.setOrderId("200910120008");

		
		OrderItem item1 = new OrderItem();
		item1.setProductName("篮球");
		item1.setSellPrice(220f);
		order.addOrderItem(item1);
		
		OrderItem item2 = new OrderItem();
		item2.setProductName("排球");
		item2.setSellPrice(230f);		
		order.addOrderItem(item2);

		//order.getAmount();
		
		this.getOrderDao().saveOrder(order);
		
		
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	
}
