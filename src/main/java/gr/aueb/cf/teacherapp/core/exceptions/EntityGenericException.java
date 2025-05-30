package gr.aueb.cf.teacherapp.core.exceptions;

public class EntityGenericException extends RuntimeException {
    private final String code;

    public EntityGenericException(String code, String message) {
        super(message);
        this.code = code;
    }
}
