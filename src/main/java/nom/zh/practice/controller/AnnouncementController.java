package nom.zh.practice.controller;

import nom.zh.practice.exception.GonggaoException;
import nom.zh.practice.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/gongGao")
public class AnnouncementController {
	 @Autowired
	 @Qualifier("announcementService")
	 private AnnouncementService announcementService;
	 /**
	  * 公告列表分页查询
	  * 创建人：赵辉
	  * 创建时间：2017-01-04
	  * @param request
	  * @param _page
	  * @param _pageSize
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/queryGongGaoPage.do")
	 @ResponseBody
	 public Map<String,Object> queryGongGaoPage(HttpServletRequest request, String _page, String _pageSize , String cnm, String vdt, String bt) throws Exception {
			 return announcementService.queryGongGaoPage(request, _page, _pageSize,bt,cnm,vdt);

	 }


	/**
	 * 根据公告ID进行删除
	 * 创建人：赵辉
	 * 创建时间：2017-01-06
	 * @param request
	 * @param nid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delByNid.do")
	@ResponseBody
	public Map<String,Object> delByNid(HttpServletRequest request,
									   String nid) throws Exception {
		return announcementService.delByNid(request, nid);
	}


	/**
	 * 根据公告ID进行查询
	 * 创建人：赵辉
	 * 创建时间：2017-01-04
	 * @param request
	 * @param nid 公告ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gongGaoByNid.do")
	@ResponseBody
	public Map<String,Object> gongGaoByNid(HttpServletRequest request,
												String nid) throws Exception {
		String uid = request.getSession().getAttribute("uid").toString();
		return announcementService.doReadGongGaoByNid( nid,uid);
	}

	//发公告
	@RequestMapping("/sendGongGao.do")
	@ResponseBody
	public Map<String, Object> sendMes(HttpServletRequest request,
									   String bt, String nr) throws Exception {
		Assert.isTrue(!StringUtils.isEmpty(bt), "标题不能为空");
		Assert.isTrue(!StringUtils.isEmpty(nr), "内容不能为空");
		return announcementService.doSendGongGao(request,bt,nr);
	}


	//查看是否有发公告的权限
	@RequestMapping("/queryButton.do")
	@ResponseBody
	public Map<String, Object> queryButton(HttpServletRequest request) throws Exception {
		return announcementService.queryButton(request);
	}


	//处理异常
	@ExceptionHandler(GonggaoException.class)
	public ResponseEntity gongGaoException(GonggaoException ee) {
		return new ResponseEntity<>(ee, HttpStatus.BAD_REQUEST);
	}

}
