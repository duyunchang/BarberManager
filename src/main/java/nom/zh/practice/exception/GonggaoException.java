package nom.zh.practice.exception;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class GonggaoException extends RuntimeException {
    public GonggaoException(String mes){
        super(mes);
    }

    @Override
    @JsonIgnore
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }
}
