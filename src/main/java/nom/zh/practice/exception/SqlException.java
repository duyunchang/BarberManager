package nom.zh.practice.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Zhaohui on 2017/2/22.
 */
public class SqlException extends RuntimeException{
    public SqlException(String mes){super(mes);}

    @Override
    @JsonIgnore
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }
}
