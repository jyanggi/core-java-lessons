package lessons.v8.oca.chapter6.exceptions_and_assertions;

public class SubClassUncheckedException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public SubClassUncheckedException() {

    }

    public SubClassUncheckedException(Exception e) {
        super(e);
    }

    public SubClassUncheckedException(String message) {
        super(message);
    }
    
    

}
