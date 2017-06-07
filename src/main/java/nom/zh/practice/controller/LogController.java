package nom.zh.practice.controller;

import nom.zh.practice.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    @Qualifier("logService")
    private LogService logService;

    /**
     * 查看所有人日志
     * 创建人：赵辉
     * 创建时间：2016/12/29
     * @param type 类型
     * @param nm 姓名
     * @param dt 时间
     * @param _page 页数
     * @param _pageSize 每页的大小
     * @return 当前页数据
     */
    @RequestMapping("/queryLogPage.do")
    @ResponseBody
    public Map<String,Object> queryLogPage(HttpServletRequest request, String nm, String type, String dt, String _page, String _pageSize) throws Exception {
        String uid = request.getSession().getAttribute("uid").toString();
        String userLx = request.getSession().getAttribute("type").toString();
        return logService.queryLogPage(type,nm,dt,_page,_pageSize,uid,userLx);
    }

    /**
     * 查看个人日志
     * 创建人：赵辉
     * 创建时间：2016/12/29
     * @param type 类型
     * @param dt 时间
     * @param _page 页数
     * @param _pageSize 每页的大小
     * @return 当前页数据
     */
    @RequestMapping("/queryMyLogPage.do")
    @ResponseBody
    public Map<String,Object> queryMyLogPage(HttpServletRequest request, String type, String dt, String _page, String _pageSize) throws Exception {
        String uid = request.getSession().getAttribute("uid").toString();
        return logService.queryLogPage(type,"", dt,_page,_pageSize,uid,"");
    }



    /**
     * 通过日志id 查看一条日志
     * 创建人：赵辉
     * 创建时间：2016/12/29
     * @param id 日志id
     * @return 此id对应的数据
     */
    @RequestMapping("/queryLogById.do")
    @ResponseBody
    public List<Map<String,Object>> queryLogById(String id){
        return logService.queryLogById(id);
    }


    /**
     * 所有日志操作类型的回显
     * 创建时间：2016/12/30
     * 创建人;赵辉
     * @param request
     * @return
     */
    @RequestMapping("/getLx.do")
    @ResponseBody
    public List<Map<String,Object>> getLX(HttpServletRequest request){
        String uid = request.getSession().getAttribute("uid").toString();
        String userLx = request.getSession().getAttribute("type").toString();
        return logService.queryLx(uid,userLx);
    }

    /**
     * 个人日志操作类型的回显
     * 创建时间：2016/12/30
     * 创建人;赵辉
     * @param request
     * @return
     */
    @RequestMapping("/getMyLx.do")
    @ResponseBody
    public List<Map<String,Object>> getMLX(HttpServletRequest request){
        String uid = request.getSession().getAttribute("uid").toString();
        return logService.queryMyLx(uid);
    }

}
