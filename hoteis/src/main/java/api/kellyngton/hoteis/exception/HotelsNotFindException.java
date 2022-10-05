package api.kellyngton.hoteis.exception;

public class HotelsNotFindException extends Exception {

    public HotelsNotFindException(long id, String className) {
        super(className + ", com id, (" + id +"), não foi encontrado.");
    }
}

