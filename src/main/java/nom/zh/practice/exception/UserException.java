package nom.zh.practice.exception;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserException extends RuntimeException {
    public UserException(String mes){
        super(mes);
    }

    @Override
    @JsonIgnore
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }
}
