package com.abc.ihis.dao;

import java.util.List;

public interface IBaseDao<T> {

	T findById(Object id);

	List<T> findAll();

	long queryCount(String query);

	List<T> query(String query);

	List<T> query(String query, int start, int maxResult);

	List<T> query(String query, String[] params, Object[] values);

	List<T> query(String query, String[] params, Object[] values, int position,
			int maxResult);

	void save(T t);

	void remove(T t);

	void update(T t);
}
