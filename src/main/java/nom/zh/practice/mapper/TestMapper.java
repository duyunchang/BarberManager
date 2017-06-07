package nom.zh.practice.mapper;


import java.util.List;
import java.util.Map;

public interface TestMapper {

    /**
     * 分页查询测试
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> queryAll() throws Exception;

}
