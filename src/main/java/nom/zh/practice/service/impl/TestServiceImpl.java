package nom.zh.practice.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import nom.zh.practice.mapper.TestMapper;
import nom.zh.practice.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService{


    @Autowired
    private TestMapper testMapper;

    /**
     * 分页查询测试
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> queryAll() throws Exception {
        //返回值
        Map<String, Object> result = new HashMap<>();

        //分页
        PageHelper.startPage(1, 2);
        List<Map<String, Object>> mapList = testMapper.queryAll();

        //总数
        PageInfo<Map<String, Object>> page = new PageInfo<>(mapList);
        long count = page.getTotal();

        result.put("data", mapList);
        result.put("count", count);

        return result;
    }
}
