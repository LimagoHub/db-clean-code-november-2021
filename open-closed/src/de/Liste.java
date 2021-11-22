package de;

public interface Liste {

    boolean moveNext();

    default boolean moveLast() {
        while(moveNext()){}
    }
}
