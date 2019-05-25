package dao.infrastucture1;

import java.util.Collection;
import java.util.Optional;

import cooking.exceptions.EntityDoesNotExistException;
import cooking.exceptions.EntityExistsException;
import dao.Identifiable;

public interface Repository<K,V extends Identifiable<K>> {
		Optional<V> findById(K id);
		Collection<V> findAll();
		V add(V entity) throws EntityExistsException ;
		V update(V entity) throws EntityDoesNotExistException;
		Optional<V> delete(K id);
}
