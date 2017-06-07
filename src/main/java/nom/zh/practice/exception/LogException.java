package nom.zh.practice.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Zhaohui on 2017/2/22.
 */
public class LogException extends RuntimeException{
    public LogException(String mes){super(mes);}

    @Override
    @JsonIgnore
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }
}
