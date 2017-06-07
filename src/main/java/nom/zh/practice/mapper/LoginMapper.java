package nom.zh.practice.mapper;

import java.util.List;
import java.util.Map;


public interface LoginMapper {

    List<Map<String,Object>> queryUser(String user) ;
}
