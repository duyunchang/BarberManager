package com.barber.server.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 上传file
 * 
 * **/
@Component
public class Uploadfile {

	private static final Logger LOGGER = Logger.getLogger(Uploadfile.class);

	/**
	 * request :action对象
	 * filePathName :文件存放路径和文件名字
	 * 返回 请求时参数和值
	 * **/
	public Map<String, String> loadfile(HttpServletRequest request, String filePathName) {

		Map<String, String> map = new HashMap<String, String>();
		try {

			DiskFileItemFactory fac = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fac);
			upload.setHeaderEncoding("UTF-8");
			List<FileItem> list = upload.parseRequest(request);
			Iterator<FileItem> iterator = list.iterator();

			byte[] buffer = null;

			LOGGER.info("Service Fun[uploadFileBlock] Enter 保存上传的文件块");
			while (iterator.hasNext()) {
				FileItem item = iterator.next();
				// 获得块描述信息
				if (item.isFormField()) {
					String key = item.getFieldName();
					if ("data".equals(key)) {
						buffer = item.get();
						item.delete();
						continue;
					}
					//System.out.println(key+item.getString("UTF-8"));
					map.put(key, item.getString("UTF-8"));
				} else {
					buffer = item.get();
					item.delete();
				}
			}

			if (buffer == null || buffer.length == 0) {

				return null;
			}

			File saveFile = new File(filePathName);

			// 把数据块写到文件中
			boolean saveChunkResult = saveChunkData(0, buffer, saveFile);

			if (!saveChunkResult) {

				return null;
			}

		} catch (Exception e) {
			LOGGER.error("Controller Fun[fileUpload] 文件块上传出错：", e);
		}

		return map;

	}
	
	/**
	 * <把数据块Chunk写入文件中指定的位置>
	 * @param start
	 * @param end
	 * @param data
	 * @return
	 */
	public boolean saveChunkData(long skip,byte[] data,File file){
		LOGGER.info("Fun[saveChunkData] Enter 保存数据块数据  skip="+skip);
		boolean result = false;
		FileChannel fileChannel = null;
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file,"rw");
			fileChannel = raf.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(data.length);
			buf.put(data);
			buf.flip();
			fileChannel.position(skip);
			fileChannel.write(buf);
			fileChannel.force(false);
			buf.clear();
//			raf.seek(skip);
//			raf.write(data);
			result = true;
		} catch (Exception e) {
			result = false;
			LOGGER.error("Fun[saveChunkData] 写入数据块出错 .{}",e);
		}finally{
			try {
				if(fileChannel != null) fileChannel.close();
				if(raf != null) raf.close();
			} catch (IOException e) {
				LOGGER.error("Fun[saveChunkData] 关闭随机读写流出错 .{}",e);
			}
		}
		LOGGER.info("Fun[saveChunkData] Exit 保存数据块数据  result="+result);
		return result;
	}
}
