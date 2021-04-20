package dao;

import java.util.List;

public interface GenericDAO<T> {
	public void insert(T t);
	public T selectById(Long id);
	public T selectByName(String nome);
	public List<T> selectAll();
	public void update(T t, Long id);
	public void delete(Long id);
}
