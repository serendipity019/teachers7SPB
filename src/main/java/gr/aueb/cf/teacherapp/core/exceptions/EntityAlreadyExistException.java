package gr.aueb.cf.teacherapp.core.exceptions;

public class EntityAlreadyExistException extends EntityGenericException {
    private static final String DEFAULT_CODE = "AlreadyExists";

    public EntityAlreadyExistException(String code, String message) {
        super(code + DEFAULT_CODE, message);

    }
}
