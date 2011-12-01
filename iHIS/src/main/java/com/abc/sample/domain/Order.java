package com.abc.sample.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	private String orderId;

	private Float amount = 0f;// 设置默认值

	private Set<OrderItem> items = new HashSet<OrderItem>();

	@Id
	@Column(length = 32)
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Column(nullable = false)
	public Float getAmount() {

		return amount + 1000;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	// cascade表示级联操作
	// CascadeType.MERGE级联更新：若items属性修改了那么order对象保存时同时修改items里的对象。对应EntityManager的merge方法
	// CascadeType.REFRESH级联刷新：获取order对象里也同时也重新获取最新的items时的对象。对应EntityManager的refresh(object)方法有效。即会重新查询数据库里的最新数据
	// CascadeType.PERSIST级联保存：对order对象保存时也对items里的对象也会保存。对应EntityManager的presist方法
	// CascadeType.REMOVE级联删除：对order对象删除也对items里的对象也会删除。对应EntityManager的remove方法
	// FetchType.LAZY表示懒加载。对于xxxtoMany时即获得多的一方fetch的默认值是FetchType.LAZY懒加载。对于xxxtoOne时即获得一的一方fetch的默认值是FetchType.EAGER立即加载
	// mappedBy表示关系统被维护端，它的值是关系维护端维护关系的属性
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, mappedBy = "order")
	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	public void addOrderItem(OrderItem item) {
		item.setOrder(this);
		this.items.add(item);
		this.amount += item.getSellPrice();
	}
}
