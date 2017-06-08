package com.barber.server.Constants;

import java.util.HashMap;
import java.util.Map;

public class Constants {

	/**
	 * 是否已删除
	 */
	public static final int ISDELETE_YES=1;//被删除
	public static final int ISDELETE_NO=2;//未删除
	
	
	/**
	 * MESSAGE返回结果
	 */
	public static final String MSG_SUCCESS="success";//成功
	public static final String MSG_FAIL="fail";//失败
	
	
	
	

	/**
	 * 是否存在待下发任务
	 */
	public static final int ISTASK_EXIST=1;//有待下发任务
	public static final int ISTASK_NOEXIST=2;//没有待下发任务
	
	/**
	 * CODE返回结果
	 */
	public static final int CODE_SUCCESS=0;//成功
	public static final int CODE_FAIL=1;//失败
	

	
	/**
	 * 直播转码状态
	 */
	public static final int STATUS_SUCCESS=1;//可用
	public static final int STATUS_FAIL=2;//不可用
	
	/**
	 * 直播转码状态
	 */
	public static final int SERVER_YES=1;//可用
	public static final int SERVER_NO=2;//不可用

	
	/**
	 * 是否停止任务
	 */
	public static final int ISSTOP_YES=1;//需要
	public static final int ISSTOP_NO=2;//不需要
	
	/**
	 * 任务处理结果
	 */
	public static final int TASK_HANDLE_SUCCESS=1;//任务创建成功
	public static final int TASK_HANDLE_NO_SAVE=2;//存储挂载不上
	public static final int TASK_HANDLE_NO_FAIL=3;//任务创建失败
	
	
	/**
	 * source_type
	 */
	public static final String TXCDN_SOURCE_TYPE="cdn";//腾讯cdn source_type 类型
	public static final String SOURCE_TYPE="source";//源站 source_type 类型
	
	public static final String DB_CREATER="system";//数据库默认创建者
	
	/**
	 * 请求过来 文件类型 (m3u8/ts)
	 */
	public static final String fileTypeM3u8="m3u8";
	public static final String fileTypeTs="ts";
	/**
	 * 类型表示
	 */
	public static final int TXCDN_FLAG=1;//cdn 表示
	public static final int SOURCE_FLAG=2;//source 表示
	
	public static final String MAPKEY="isTask";//请求调用map
	/**
	 * 日志 请求返回状态 表示
	 */
	public static final String count_20x="200";
	public static final String count_403="403";
	public static final String count_404="404";
	
	/**
	 * 日志 文件后缀匹配
	 */
	public static final String m3u8_20x="_m3u8_20x.+";	
	public static final String m3u8_4xx="_m3u8_4xx.+";
	public static final String ts_20x="_ts_20x.+";
	public static final String ts_4xx="_ts_4xx.+";


	/**请求返回状态码**/
	public static final int SUCCESS=0;
	public static final int FAILURE=1;
	public static String FAILURE_MSG="操作失败!";
	public static String SUCCESS_MSG="操作成功!";
	
	
	public static final int FILE_NO_COMPLETE = 0; 
	public static final int FILE_COMPLETE = 1; 
	
	//文件上传方式 
	public static final int FILE_UPLOAD_FTP=1;
	public static final int FILE_UPLOAD_HTTP=2;
	
	//文件内容来源
	public static final String FILE_UPLOAD_PC="pcClient"; //pc客户端上传
	public static final String FILE_UPLOAD_CP="cp"; //cp上传
	
	
	
	public static Map<Integer,String> UPLOADCODE=new HashMap<Integer,String>();
	static{
		UPLOADCODE.put(1001, "上传用户uploader为空");
		UPLOADCODE.put(1002, "文件编号fileId为空");
		UPLOADCODE.put(1003, "文件来源不能为空");
		UPLOADCODE.put(1004, "文件名不能为空");
		UPLOADCODE.put(1005, "文件大小不能为空");
		UPLOADCODE.put(1006, "文件校验的md5不能为空");
		UPLOADCODE.put(1007, "文件块的md5不能为空");
		UPLOADCODE.put(1008, "文件块序号chunk不能为空");
		UPLOADCODE.put(1009, "文件块开始位置start不能为空");
		UPLOADCODE.put(10010, "后台报错");
		UPLOADCODE.put(10011, "上传文件chunk不完整");
		UPLOADCODE.put(10012, "上传文件查不到");
		UPLOADCODE.put(10013, "文件来源不是指定的");
		UPLOADCODE.put(10014, "上传的数据块是空的");
	}
	public interface FileUploadCode{
		public static final int UPLOADER=1001;
		public static final int FILEID=1002;
		public static final int COMEFROM=1003;
		public static final int FILENAME=1004;
		public static final int FFILESIZE=1005;
		public static final int MD5FILE=1006;
		public static final int CHUNKMD5=1007;
		public static final int CHUNK=1008;
		public static final int START=1009;
		public static final int ERROR=10010;
		public static final int LACK_CHUNK=10011;
		public static final int LACK_FILE=10012;
		public static final int SURE_COMEFROM=10013;
		public static final int CHUNK_EMPTY=10014;
	}
	
	//缓存的使用方式  0表示使用redis 1不使用redis
	public static final String IS_REDIS="0";
	
}

