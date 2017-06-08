package com.barber.server.util;

import org.apache.log4j.Logger;

public class OSCommandUtil {
	private static final Logger LOGGER = Logger.getLogger(OSCommandUtil.class);
	
	/**
	 * <调用linux命令  并获得返回的执行结果>
	 * @param cmd  linux命令
	 * @return
	 */
	public static boolean linuxCallCmd(String cmd){
		boolean result = false;
		long startTime = System.currentTimeMillis();
		try {
			LOGGER.info("Fun[linuxCallCmd] 执行linux命令 cmd="+cmd);
			Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh","-c",cmd});
			process.waitFor();
			result = true;
		} catch (Exception e) {
			LOGGER.error("Fun[linuxCallCmd] 调用linux命令出错 {}",e);
		}
		LOGGER.info("Fun[linuxCallCmd] Exit 执行linux命令 cmd="+cmd+" 用时："+(System.currentTimeMillis()-startTime));
		return result;
	}
}
