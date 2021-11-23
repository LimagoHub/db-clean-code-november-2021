package de.techem.main;

import java.util.Optional;

public interface MyList<T> {
	
	void append(T t);
	Optional<T> get();
	boolean remove();
	
	default boolean clear() {
		if(isEmpty()) return false;
		while(remove()) {}
		return true;
	}
	
	boolean moveNext();
	boolean movePrev();
	boolean moveFirst() {
		if(isEmpty()) return false;
		while(movePrev());
		return true;
	}
	boolean moveLast();
	
	boolean isEmpty();
	boolean isBOL();
	boolean isEOL();

}
