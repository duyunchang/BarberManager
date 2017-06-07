package nom.zh.practice.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class UserLoginFailedException extends RuntimeException {

    public UserLoginFailedException(String reason) {
        super(reason);
    }


    @Override
    @JsonIgnore
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }
}
