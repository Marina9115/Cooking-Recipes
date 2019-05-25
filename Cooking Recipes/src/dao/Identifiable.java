package dao;

public interface Identifiable <T> {
	T getId();
	void setId(T id);
	Long getNextId();
}


