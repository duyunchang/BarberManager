package nom.zh.practice.controller;

import nom.zh.practice.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 测试
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * 分页查询测试
     * @return
     * @throws Exception
     */
    @RequestMapping("/getAll")
    public Map<String, Object> getAll() throws Exception {
        return testService.queryAll();
    }
}
