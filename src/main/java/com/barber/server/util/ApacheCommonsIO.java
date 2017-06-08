package com.barber.server.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.log4j.Logger;


public class ApacheCommonsIO {
	private static Logger logger = Logger.getLogger(ApacheCommonsIO.class);
	

	public  void red2(String pathName) {
		long t1 = System.currentTimeMillis();
		LineIterator it = null;
		// Pattern pattern =Pattern.compile("Multiple");
		// 通配符中也要加入转移字符 (.+?)代表要查找的内容
		// Matcher matcher=pattern.matcher(s);

		try {
			it = FileUtils.lineIterator(new File(pathName), "UTF-8");
			while (it.hasNext()) {
				String line = it.nextLine();
				if (line.indexOf("Multiple") > -1 && line.matches("2017-05-12 17:41:19.946.+Multiple.+")) {
					// if(line.matches("Multiple")&&line.matches("2017-05-12
					// 17:41:19.946.+Multiple.+")){

					System.out.println(line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (it != null) {
				it.close();
			}
			long t2 = System.currentTimeMillis();
			System.out.println(">>" + (t2 - t1));
		}
	}

	public static List<String> getFileName(String filePath) {
		List<String> listpath=new ArrayList<>();
		String path = filePath; // 路径
		File f = new File(path);
		if (!f.exists()) {
			logger.debug(path + " not exists");
			return listpath;
		}
		
		File fa[] = f.listFiles();
		for (int i = 0; i < fa.length; i++) {
			File fs = fa[i];
			if (fs.isDirectory()) {
				logger.debug(fs.getName() + " [目录]");

				//System.out.println(fs.getAbsolutePath() + " [目录]");
				//getFileList(fs.getAbsolutePath()); // 获取文件绝对路径
			} else {
				logger.debug(fs.getName());
				listpath.add(fs.getName());
			}
		}
		
		return listpath;
	}

}
